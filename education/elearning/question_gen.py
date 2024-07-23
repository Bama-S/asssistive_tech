import nltk
import string
import pke
import traceback
import torch
import spacy
# nltk.download('punkt')
# nltk.download('brown')
# nltk.download('wordnet')
# nltk.download('stopwords')
from nltk.corpus import stopwords
from nltk.corpus import wordnet as wn
from nltk.tokenize import sent_tokenize
from flashtext import KeywordProcessor 
from transformers import T5ForConditionalGeneration,T5Tokenizer


device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

def get_nouns_multipartite(content):
    out=[]
    try:
        nlp = spacy.load('en_core_web_sm')
        extractor = pke.unsupervised.MultipartiteRank()
        # extractor = pke.unsupervised.SingleRank()
        extractor.load_document(input=nlp(content),language='en', normalization=None)
        #not contain punctuation marks or stopwords as candidates.
        pos = {'PROPN','NOUN', 'ADJ'}
        #pos = {'PROPN','NOUN'}
        stoplist = list(string.punctuation)
        stoplist += ['-lrb-', '-rrb-', '-lcb-', '-rcb-', '-lsb-', '-rsb-']
        stoplist += stopwords.words('english')
        # extractor.candidate_selection(pos=pos, stoplist=stoplist)
        extractor.candidate_selection(pos=pos)
        # 4. build the Multipartite graph and rank candidates using random walk,
        #    alpha controls the weight adjustment mechanism, see TopicRank for
        #    threshold/method parameters.
        extractor.candidate_weighting(alpha=1.1,
                                      threshold=0.75,
                                      method='average')
        keyphrases = extractor.get_n_best(n=15)
        

        for val in keyphrases:
            out.append(val[0])
    except:
        out = []
        traceback.print_exc()

    return out 


def get_keywords(originaltext,summarytext):
  keywords = get_nouns_multipartite(originaltext)
  keyword_processor = KeywordProcessor()
  for keyword in keywords:
    keyword_processor.add_keyword(keyword)

  keywords_found = keyword_processor.extract_keywords(summarytext)
  keywords_found = list(set(keywords_found))

  important_keywords =[]
  for keyword in keywords:
    if keyword in keywords_found:
      important_keywords.append(keyword)

  return important_keywords

text = """Photosynthesis is a process used by plants and other organisms to convert light energy into chemical energy that, through cellular respiration, can later be released to fuel the organism's activities. Some of this chemical energy is stored in carbohydrate molecules, such as sugars and starches, which are synthesized from carbon dioxide and water – hence the name photosynthesis, from the Greek phōs (φῶς), "light", and synthesis (σύνθεσις), "putting together". Most plants, algae, and cyanobacteria perform photosynthesis; such organisms are called photoautotrophs. Photosynthesis is largely responsible for producing and maintaining the oxygen content of the Earth's atmosphere, and supplies most of the energy necessary for life on Earth.Although photosynthesis is performed differently by different species, the process always begins when energy from light is absorbed by proteins called reaction centers that contain green chlorophyll (and other colored) pigments/chromophores. In plants, these proteins are held inside organelles called chloroplasts, which are most abundant in leaf cells, while in bacteria they are embedded in the plasma membrane. In these light-dependent reactions, some energy is used to strip electrons from suitable substances, such as water, producing oxygen gas. The hydrogen freed by the splitting of water is used in the creation of two further compounds that serve as short-term stores of energy, enabling its transfer to drive other reactions: these compounds are reduced nicotinamide adenine dinucleotide phosphate (NADPH) and adenosine triphosphate (ATP), the "energy currency" of cells."""
imp_keywords = get_keywords(text,text)

question_model = T5ForConditionalGeneration.from_pretrained('ramsrigouthamg/t5_squad_v1')
question_tokenizer = T5Tokenizer.from_pretrained('ramsrigouthamg/t5_squad_v1')
question_model = question_model.to(device)

def get_question(context,answer,model,tokenizer):
  text = "context: {} answer: {}".format(context,answer)
  encoding = tokenizer.encode_plus(text,max_length=384, pad_to_max_length=False,truncation=True, return_tensors="pt").to(device)
  input_ids, attention_mask = encoding["input_ids"], encoding["attention_mask"]

  outs = model.generate(input_ids=input_ids,
                                  attention_mask=attention_mask,
                                  early_stopping=True,
                                  num_beams=5,
                                  num_return_sequences=1,
                                  no_repeat_ngram_size=2,
                                  max_length=72)


  dec = [tokenizer.decode(ids,skip_special_tokens=True) for ids in outs]


  Question = dec[0].replace("question:","")
  Question= Question.strip()
  return Question


def get_distractors_wordnet(syn,word):
    distractors=[]
    word= word.lower()
    orig_word = word
    if len(word.split())>0:
        word = word.replace(" ","_")
    hypernym = syn.hypernyms()
    # print(hypernym)
    if len(hypernym) == 0: 
        return distractors
    for item in hypernym[0].hyponyms():
        name = item.lemmas()[0].name()
        #print ("name ",name, " word",orig_word)
        if name == orig_word:
            continue
        name = name.replace("_"," ")
        name = " ".join(w.capitalize() for w in name.split())
        if name is not None and name not in distractors:
            distractors.append(name)
    return distractors


for answer in imp_keywords:
  ques = get_question(text,answer,question_model,question_tokenizer)
  print (ques)
  answer = answer.capitalize()
  print (answer)
  print ("\n")
  if (len(wn.synsets(answer, 'n'))>0):
    synset_to_use = wn.synsets(answer,'n')[0]
    distractors_calculated = get_distractors_wordnet(synset_to_use,answer)
    print(distractors_calculated)
  else:
    distractors_calculated=["", "", ""]
    print(distractors_calculated)
  print("\n")
