from flask import Flask, render_template, url_for, request, session, redirect, flash
from flask_pymongo import PyMongo, MongoClient
from bson import ObjectId

import json
import bcrypt
import wikipedia
import nltk
import string
import pke
import traceback
import torch
import spacy
import random
import openai
# nltk.download('punkt')
# nltk.download('brown')
# nltk.download('wordnet')
# nltk.download('stopwords')
from nltk.tokenize import word_tokenize, sent_tokenize
from nltk.corpus import stopwords
from nltk.corpus import wordnet as wn
from flashtext import KeywordProcessor 
from transformers import T5ForConditionalGeneration,T5Tokenizer
from lmqg import TransformersQG

openai.api_key = "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"

history = []

stop_words = set(stopwords.words('english'))


app = Flask(__name__)

app.config['MONGO_DBNAME'] = 'test'
app.config['MONGO_URI'] = 'mongodb+srv://sri-siva-murugan-v:worldhello123@cluster0.9bjtndz.mongodb.net/test'

mongo = PyMongo(app)

# client = pymongo.MongoClient("mongodb+srv://sri-siva-murugan-v:<password>@cluster0.9bjtndz.mongodb.net/?retryWrites=true&w=majority")
# db = client.test


db = mongo.db.test

pagesList = []
pagesStack = []

questionsList = []
questionsStack = []
global_questions_array = []
score = []
c = 0
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

# question_model = T5ForConditionalGeneration.from_pretrained('ramsrigouthamg/t5_squad_v1')
# question_tokenizer = T5Tokenizer.from_pretrained('ramsrigouthamg/t5_squad_v1')
question_model = TransformersQG(language='en', model='lmqg/t5-small-squad-qg-ae')

# question_model = question_model.to(device)

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

# def get_question(context,answer,model,tokenizer):
#   text = "context: {} answer: {}".format(context,answer)
#   encoding = tokenizer.encode_plus(text,max_length=384, pad_to_max_length=False,truncation=True, return_tensors="pt").to(device)
#   input_ids, attention_mask = encoding["input_ids"], encoding["attention_mask"]

#   outs = model.generate(input_ids=input_ids,
#                                   attention_mask=attention_mask,
#                                   early_stopping=True,
#                                   num_beams=5,
#                                   num_return_sequences=1,
#                                   no_repeat_ngram_size=2,
#                                   max_length=72)


#   dec = [tokenizer.decode(ids,skip_special_tokens=True) for ids in outs]


#   Question = dec[0].replace("question:","")
#   Question= Question.strip()
#   return Question


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






@app.route('/', methods=['GET', 'POST'])
def index():
    if 'email' in session:
        print('email in session')
        # if 'name' in session:
        #     print(session['name'])
        return redirect(url_for('teacher_dashboard'))
        # elif 'student' in session:
        #     print('student in session')
        #     return redirect(url_for('student_dashboard'))
    # return render_template('index.html')


# @app.route('/enteras', methods=['GET', 'POST'])
# def role():
    if request.method == 'POST':
        if request.form.get('TEACHER') == 'TEACHER':
            return render_template('login.html')
        elif  request.form.get('STUDENT') == 'STUDENT':
            return render_template('studentlogin.html')
#     elif request.method == 'GET':
#         return render_template("index.html")
    
    return render_template("index.html")


@app.route('/login', methods=['GET', 'POST'])
def login():

    if 'email' in session: 
        return redirect(url_for('teacher_dashboard'))


    teachers = mongo.db.teachers
    login_teacher = teachers.find_one({'email' : request.form['email']})

    if login_teacher:
        print(request.form['password'].encode('utf-8')) #b'password'
        print(login_teacher['password'])  #b'$2b$12$hUQ.mlQ4oryRY7yl1C37rueGkA/eEZPn4BkS2zkz4XvRETRZu/Nb.'
        print(bcrypt.hashpw(request.form['password'].encode('utf-8'), login_teacher['password']))  #b'$2b$12$hUQ.mlQ4oryRY7yl1C37rueGkA/eEZPn4BkS2zkz4XvRETRZu/Nb.'
        if bcrypt.hashpw(request.form['password'].encode('utf-8'), login_teacher['password']) == login_teacher['password']:
        # # if bcrypt.hashpw(request.form['password'], login_teacher['password']) == login_teacher['password']:
            session['email'] = request.form['email']
            session['name'] = "teacher"
            return redirect(url_for('teacher_dashboard'))

    return 'Invalid email/password combination'


@app.route('/studentlogin', methods=['GET', 'POST'])
def studentlogin():

    if 'email' in session: 
        return redirect(url_for('student_dashboard'))


    students = mongo.db.students
    login_student = students.find_one({'email' : request.form['email']})

    if login_student:
        print(request.form['password'].encode('utf-8')) #b'password'
        print(login_student['password'])  #b'$2b$12$hUQ.mlQ4oryRY7yl1C37rueGkA/eEZPn4BkS2zkz4XvRETRZu/Nb.'
        print(bcrypt.hashpw(request.form['password'].encode('utf-8'), login_student['password']))  #b'$2b$12$hUQ.mlQ4oryRY7yl1C37rueGkA/eEZPn4BkS2zkz4XvRETRZu/Nb.'
        if bcrypt.hashpw(request.form['password'].encode('utf-8'), login_student['password']) == login_student['password']:
        # # if bcrypt.hashpw(request.form['password'], login_teacher['password']) == login_teacher['password']:
            session['email'] = request.form['email']
            session['name'] = 'student'
            return redirect(url_for('student_dashboard'))

    return 'Invalid email/password combination'

@app.route('/logout', methods=['POST', 'GET'])
def logout():
    session.pop('email',None)
    # print(session['teacher'])
    # session.pop('teacher', None)
    return redirect(url_for("index"))

@app.route('/register', methods=['POST', 'GET'])
def register():
    print(mongo)
    print("--")
    print(db)
    print("--")
    print(mongo.db.test)
    if request.method == 'POST':
        teachers = mongo.db.teachers
        existing_teacher = teachers.find_one({'email' : request.form['email']})

        if existing_teacher is None:
            hashpass = bcrypt.hashpw(request.form['password'].encode('utf-8'), bcrypt.gensalt())
            teachers.insert_one({'email': request.form['email'], 'username' : request.form['username'], 'password' : hashpass})
            session['email'] = request.form['email']
            session['name'] = 'teacher'
            return redirect(url_for('index'))
        
        return 'That username already exists!'

    return render_template('signup.html')


@app.route('/studentregister', methods=['POST', 'GET'])
def studentregister():
    print(mongo)
    print("--")
    print(db)
    print("--")
    print(mongo.db.test)
    if request.method == 'POST':
        students = mongo.db.students
        existing_student = students.find_one({'email' : request.form['email']})

        if existing_student is None:
            hashpass = bcrypt.hashpw(request.form['password'].encode('utf-8'), bcrypt.gensalt())
            students.insert_one({'email': request.form['email'], 'username' : request.form['username'], 'password' : hashpass})
            session['email'] = request.form['email']
            session['name'] = 'student'
            return redirect(url_for('index'))
        
        return 'That username already exists!'

    return render_template('studentsignup.html')

@app.route('/teacher_dashboard', methods=['GET', 'POST', 'DELETE'])
def teacher_dashboard():
    pagesList.clear()
    pagesStack.clear()

    questionsList.clear()
    questionsStack.clear()
    global_questions_array.clear()
    if 'email' not in session:
    # if 'email' in session:
        return redirect(url_for('index'))
    elif request.method == 'GET' and 'email'  in session:
        return render_template("teacher_dashboard.html")
    else:
        if request.form.get('CREATE LESSON') == 'CREATE LESSON':
            return redirect(url_for('create_lesson'))
        elif request.form.get('ADD PAGE') == 'ADD PAGE':
            return redirect(url_for('get_lessonnames'))
        elif request.form.get('ADD PAGE MANUALLY') == 'ADD PAGE MANUALLY':
            return redirect(url_for('manual_get_lessonnames'))
        elif request.form.get('DELETE LESSON') == 'DELETE LESSON':
            return redirect(url_for('get_lessonnames_deletion'))
        elif request.form.get('ADD PAGE') == 'ADD PAGE':
            return redirect(url_for('create_page'))
        elif request.form.get('DELETE PAGE') == 'DELETE PAGE':
            return redirect(url_for('get_lessonnames_deletion_page'))
        elif request.form.get('PREVIEW LESSON') == 'PREVIEW LESSON':
            return redirect(url_for('get_lessonname_preview_lesson'))
        elif request.form.get('VIEW EXERCISES') == 'VIEW EXERCISES':
            return redirect(url_for('get_lessonname_preview_exercise'))

@app.route('/student_dashboard', methods=['GET', 'POST', 'DELETE'])
def student_dashboard():
    pagesList.clear()
    pagesStack.clear()

    questionsList.clear()
    questionsStack.clear()
    global_questions_array.clear()
    if 'email' not in session:
    # if 'email' in session:
        return redirect(url_for('index'))
    elif request.method == 'GET' and 'email' in session:
        return render_template("student_dashboard.html")
    else:
        if request.form.get('VIEW LESSON') == 'VIEW LESSON':
            return redirect(url_for('get_lessonnames_student_view'))
        elif request.form.get('TAKE EXERCISE') == 'TAKE EXERCISE':
            return redirect(url_for('get_lessonnames_student_exercise'))

@app.route('/create_lesson', methods=['GET', 'POST'])
def create_lesson():
    if "email" not in session:
        return redirect(url_for('index'))
    elif request.method == 'GET':
        return render_template('create_lesson.html')
    else:
        back = request.referrer
        lesson_name = request.form.get('lessonname')
        teacher_email= session["email"]
        lessons = mongo.db.lessons
        existing_lesson = lessons.find_one({'teacher_email' : teacher_email, 'lesson_name': lesson_name})
        
        if existing_lesson is None:

            lessons.insert_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})
            print('lesson created successfully')
            flash('lesson created successfully')
            return redirect(url_for('teacher_dashboard'))
        
        flash('lesson name already exists')
        return render_template('create_lesson.html')
        # teacher_doc = teachers.find_one({'email' : teacher_email})
        # print(teacher_doc['email'])
        # print(teacher_doc['_id'])
        

@app.route('/get_lessonnames', methods=['POST', 'GET'])
def get_lessonnames():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])
    # print(lessonNames)
    return render_template("create_page.html", lessonNames=lessonNames)
    # return lessonNames, "200"

@app.route('/manual_get_lessonnames', methods=['POST', 'GET'])
def manual_get_lessonnames():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])
    # print(lessonNames)
    return render_template("manual_create_page.html", lessonNames=lessonNames)

@app.route('/get_lessonnames_deletion', methods=['POST', 'GET'])
def get_lessonnames_deletion():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])
    # print(lessonNames)
    return render_template("delete_lesson.html", lessonNames=lessonNames)
    # return lessonNames, "200"

@app.route('/get_lessonname_preview_lesson', methods=['POST', 'GET'])
def get_lessonname_preview_lesson():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])
    # print(lessonNames)
    return render_template("preview_lesson1.html", lessonNames=lessonNames)
    # return lessonNames, "200"

@app.route('/get_lessonname_preview_exercise', methods=['POST', 'GET'])
def get_lessonname_preview_exercise():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({})
    
    for lesson in lessons:
        lessonNames.append({"teacher_email": lesson["teacher_email"], "lesson_name": lesson['lesson_name']})
    print(type(lessonNames[0]))
    return render_template("preview_exercise1.html", lessonNames=lessonNames)

@app.route('/preview_lesson', methods=['GET', 'POST'])
def preview_lesson():
    # pagetitle = request.form['pagetitle']
    # print(pagetitle)
    lesson_name = request.form.get('lessonname')
    print(lesson_name)
    pageTitles = []
    pageContents = []
    page = {}
    lessonsCollection = mongo.db.lessons
    lesson_id = lessonsCollection.find_one({'teacher_email': session['email'],  'lesson_name': lesson_name})['_id']
    pagesCollection = mongo.db.pages
    pages = pagesCollection.find({'lesson_id': lesson_id})
    for pageTitle in pages:
        pageTitles.append(pageTitle['page_title'])
        page_content = pagesCollection.find_one({'lesson_id': lesson_id, 'page_title': pageTitle['page_title']})['page_content']
        # pageContents.append(page_content)
        page[pageTitle['page_title']] = page_content
    print(page)

    return render_template("preview_lesson2.html", pageTitles=pageTitles, page=page)

    # lesson_id = request.form['lessonid']
    # print(lesson_id)
    # print(type(ObjectId(lesson_id)))
    # del_page = pagesCollection.delete_one({'lesson_id': ObjectId(lesson_id), 'page_title': pagetitle})
    # print(del_page)
    # if (del_page==1):
    #     flash("page deleted successfully")
    # return "page deleted successfullly"

@app.route('/get_lessonnames_deletion_page', methods=['POST', 'GET'])
def get_lessonnames_deletion_page():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])
    # print(lessonNames)
    return render_template("delete_page1.html", lessonNames=lessonNames)
    # return lessonNames, "200"

@app.route('/get_pagenames_deletion_page', methods=['POST', 'GET'])
def get_pagenames_deletion_page():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lesson_name = request.form.get('lessonname')
    print(lesson_name)
    lessonsCollection = mongo.db.lessons
    lesson_id = lessonsCollection.find_one({'teacher_email': session['email'],  'lesson_name': lesson_name})['_id']
    pagesCollection = mongo.db.pages
    # print(lessonsCollection)
    pageTitles = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    pages = pagesCollection.find({'lesson_id' : lesson_id})
    for page in pages:
        pageTitles.append(page['page_title'])
    print(pageTitles)
    return render_template("delete_page2.html", pageTitles=pageTitles, lessonid=lesson_id)
   

@app.route('/questiongen', methods=['GET', 'POST'])
def questiongen():
    return render_template('questiongen.html')

@app.route('/delete_page', methods=['GET', 'POST'])
def delete_page():
    pagetitle = request.form['pagetitle']
    print(pagetitle)
    pagesCollection = mongo.db.pages
    lesson_id = request.form['lessonid']
    print(lesson_id)
    print(type(ObjectId(lesson_id)))
    del_page = pagesCollection.delete_one({'lesson_id': ObjectId(lesson_id), 'page_title': pagetitle})
    print(del_page)
    if (del_page==1):
        flash("page deleted successfully")
    return "page deleted successfullly"

@app.route('/get_lessonnames_student_view', methods=['POST', 'GET'])
def get_lessonnames_student_view():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({})
    
    for lesson in lessons:
        lessonNames.append({"teacher_email": lesson["teacher_email"], "lesson_name": lesson['lesson_name']})
    print(type(lessonNames[0]))
    return render_template("view_lesson1.html", lessonNames=lessonNames)
    # return lessonNames, "200"

@app.route('/get_lessonnames_student_exercise', methods=['POST', 'GET'])
def get_lessonnames_student_exercise():
    if "email" not in session:
        redirect(url_for('index'))
        # print('no session')
    
    lessonsCollection = mongo.db.lessons
    # print(lessonsCollection)
    lessonNames = []
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({})
    
    for lesson in lessons:
        lessonNames.append({"teacher_email": lesson["teacher_email"], "lesson_name": lesson['lesson_name']})
    print(type(lessonNames[0]))
    return render_template("student_exercise_lesson_select.html", lessonNames=lessonNames)

@app.route('/display_exercise', methods=['POST', 'GET'])
def display_exercise():
    global score
    score = []
    print("-------------------")
    lesson = request.form['lessonname']
    print(lesson)
    lesson = lesson.replace('\'', '\"')
    print(lesson)
    lesson = json.loads(lesson)
    print(type(lesson))
    lesson_name = lesson['lesson_name']
    teacher_email = lesson['teacher_email']
    person = request.form.get('person')
    print(lesson_name)
    print(teacher_email)
    lessonsCollection = mongo.db.lessons
    lesson_id = lessonsCollection.find_one({'lesson_name': lesson_name, 'teacher_email': teacher_email})['_id']
    print(lesson_id)
    questionsCollection = mongo.db.questions_main    
    questions = questionsCollection.find({'lesson_id': lesson_id})
    print(questions)

    
    

    for question in questions:
        print(question['question'])
        print(question['answer'])
        print("*****************")
        questionsList.append({'question': question['question'], 'answer': question['answer'], 'option1': question['option1'], 'option2': question['option2'], 'option3': question['option3'], 'option4': question['option4']})
    print(len(questionsList))
    questions_count = len(questionsList)
    for i in range(0, questions_count):
        score.append(0)
    if len(questionsList)>=1:
        print(questionsList)
        if (person == "student"):
            return render_template('student_exercise.html', lessonid=lesson_id, question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1 = questionsList[0]['option1'], option2= questionsList[0]['option2'], option3= questionsList[0]['option3'], option4= questionsList[0]['option4'])
        elif (person == "teacher"):
            return render_template('preview_exercise2.html', question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1 = questionsList[0]['option1'], option2= questionsList[0]['option2'], option3= questionsList[0]['option3'], option4= questionsList[0]['option4'])
    # print(pagesList)
    
    return redirect(url_for("display_question"))

@app.route('/display_question', methods=['POST', 'GET', 'PUT'])
def display_question():
    global c
    scoreCollection = mongo.db.score
    lesson_id=request.form.get('lessonid')
    answer=request.form.get("hiddenfield")
    # print(answer)
    option = request.form.get("optradio")
    print("option")
    print(option)
    # print(ObjectId(lesson_id))
    student_email = session['email']
    alreadyPresent = scoreCollection.find_one({'student_email': session['email'], 'lesson_id': (lesson_id)})
    # print(alreadyPresent)
    best_score, res=0, 0    
    # print(lesson_id)
    lesson_name = mongo.db.lessons.find_one({'_id': ObjectId(lesson_id)})['lesson_name']
    person = request.form.get('person')
    if 'email' not in session:
    # if 'email' in session:
        return redirect(url_for('index'))
    else:
        ans=request.form.get('hiddenfield') # correct answer
        if request.form.get('PREVIOUS') == 'PREVIOUS':
            if (len(questionsStack) >= 1):
                q = questionsStack.pop()
                questionsList.insert(0, q)
                c -= 1
        elif request.form.get('NEXT') == 'NEXT':            
            if (len(questionsList)>1):
                if (option == ans):
                    score[c] = 1
                else:
                    score[c] = 0
                c += 1
                q = questionsList[0]
                questionsStack.append(q)
                questionsList.pop(0)

        # print(questionsList)
        options = []
        options.append(questionsList[0]['option1'])
        options.append(questionsList[0]['option2'])
        options.append(questionsList[0]['option3'])
        options.append(questionsList[0]['option4'])
        random.shuffle(options)
        # print(len(questionsList))
        if (len(questionsList)>1):
            print("length = {0}".format(len(questionsList)))
            if (person == "student"):
                return render_template('student_exercise.html', question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1=options[0], option2=options[1], option3=options[2], option4=options[3], lessonid=lesson_id)
            elif (person == "teacher"):
                return render_template('preview_exercise2.html', question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1=options[0], option2=options[1], option3=options[2], option4=options[3])

        # elif (len(questionsList)==1):
        else: 
            for i in score:
                res+=i
            print("score={0}".format(res))
            c=0
            if (person == "student"):
                if (alreadyPresent is None):
                    print("Inside none - Already Present")
                    best_score=res
                    scoreCollection.insert_one({'student_email': student_email, 'lesson_id': lesson_id, 'best_score': best_score, 'recent_score': res})
                    
                else:
                    best_score=alreadyPresent['best_score']
                    if (res>=best_score):
                        best_score=res
                        scoreCollection.update_one({'student_email': student_email, 'lesson_id': (lesson_id)}, {"$set": {'best_score': res, 'recent_score': res}})
                    else:
                        scoreCollection.update_one({'student_email': student_email, 'lesson_id': (lesson_id)}, {"$set": {'recent_score': res}})
                
                return render_template('display_score.html', score=res, student_email=student_email, lesson_name=lesson_name, best_score=best_score)
                # return render_template('student_exercise.html', question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1=options[0], option2=options[1], option3=options[2], option4=options[3], lessonid=lesson_id)
            elif (person == "teacher"):
                return render_template('preview_exercise2.html', question=questionsList[0]['question'], answer=questionsList[0]['answer'], option1=options[0], option2=options[1], option3=options[2], option4=options[3], lessonid=lesson_id)

        
        return render_template('display_score.html', score=res, student_email=student_email, lesson_name=lesson_name, best_score=best_score)
        
        

@app.route('/display_page', methods=['POST', 'GET'])
def display_page():
    if 'email' not in session:
    # if 'email' in session:
        return redirect(url_for('index'))
    else:
        if request.form.get('PREVIOUS') == 'PREVIOUS':
            if (len(pagesStack) >= 1):
                pg = pagesStack.pop()
                pagesList.insert(0, pg)
        elif request.form.get('NEXT') == 'NEXT':
            if (len(pagesList)>1):
                pg = pagesList[0]
                pagesStack.append(pg)
                pagesList.pop(0)

        return render_template('lesson_page.html', page_title=pagesList[0]['page_title'], page_content=pagesList[0]['page_content'])
        



@app.route('/display_lesson', methods=['POST'])
def display_lesson():
    print("-------------------")
    lesson = request.form['lessonname']
    print(lesson)
    lesson = lesson.replace('\'', '\"')
    print(lesson)
    lesson = json.loads(lesson)
    print(type(lesson))
    lesson_name = lesson['lesson_name']
    teacher_email = lesson['teacher_email']
    print(lesson_name)
    print(teacher_email)
    lessonsCollection = mongo.db.lessons
    lesson_id = lessonsCollection.find_one({'lesson_name': lesson_name, 'teacher_email': teacher_email})['_id']
    pagesCollection = mongo.db.pages
    pages = pagesCollection.find({'lesson_id': lesson_id})
    for page in pages:
        pagesList.append({'page_title': page['page_title'], 'page_content': page['page_content']})
    if len(pagesList)>=1:
        return render_template('lesson_page.html', page_title=pagesList[0]['page_title'], page_content=pagesList[0]['page_content'])
    # print(pagesList)
    return redirect(url_for("display_page"))


@app.route('/view_lessons', methods=['GET', 'POST'])
def view_lessons():
    print('in view lesson function')
    return render_template('view_lesson1.html')

@app.route('/view_page', methods=['GET', 'POST'])
def view_page():
    return render_template('view_page.html')

@app.route('/create_page', methods=['GET', 'POST'])
def create_page():
    lesson_name = request.form.get('lessonname')
    print(lesson_name)
    page_title = request.form.get('pagetitle')
    print(page_title)
    teacher_email = session["email"]
    # print("teacher_email: " + teacher_email)
    lessonsCollection = mongo.db.lessons

    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])

    lesson_id = lessonsCollection.find_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})['_id']
    print(lesson_id)

    pagesCollection = mongo.db.pages
    existing_page = pagesCollection.find_one({'lesson_id' : lesson_id, 'page_title': page_title})
    messages = []
    if existing_page is None:
        for input_text, completion_text in history:
            messages.append({"role": "user", "content": input_text})
            messages.append({"role": "assistant", "content": completion_text})

        messages.append({"role": "user", "content": page_title})

        completion = openai.ChatCompletion.create(
                model="gpt-3.5-turbo",
                messages=messages
        )

        page_content = completion.choices[0].message.content
        history.append((page_title, page_content))
        # page_content = wikipedia.summary(page_title+lesson_name, sentences=4)
        pagesCollection.insert_one({'lesson_id': lesson_id, 'page_title': page_title, 'page_content': page_content})
        #return redirect(url_for('teacher_dashboard'))
        text=page_content
        imp_keywords = get_keywords(text,text)
        page_id = pagesCollection.find_one({'lesson_id': lesson_id, 'page_title': page_title})['_id']
        questions_array = []
        question_answer = question_model.generate_qa(page_content)

        for question in question_answer:
            # ques = get_question(text,answer,question_model,question_tokenizer)
            # print (ques)
            ques = question[0]
            answer = question[1]
            answer = answer.capitalize()
            if (len(answer)>1):
                tokenized = sent_tokenize(answer)
                for i in tokenized:
                
                    # Word tokenizers is used to find the words
                    # and punctuation in a string
                    wordsList = nltk.word_tokenize(i)
            
                    # removing stop words from wordList
                    wordsList = [w for w in wordsList if not w in stop_words]
            
                    #  Using a Tagger. Which is part-of-speech
                    # tagger or POS-tagger.
                    tagged = nltk.pos_tag(wordsList)
                    print(tagged)
                    for word in tagged:
                        if (word[1] == "NNP" or word[1] == "NN"):
                            dist = word[0]
                            break
                    print("dist")
                    print(dist)

            else:
                dist = answer

            # print (answer)
            # print ("\n")
            distractors=[]
            if (len(wn.synsets(dist, 'n'))>0):
                synset_to_use = wn.synsets(dist,'n')[0]
                distractors_calculated = get_distractors_wordnet(synset_to_use,dist)
                count = len(distractors_calculated)
                
                for i in range(0,3):
                    if (i+1 <= count):
                        if (len(answer)>1):
                            x = answer.replace(dist, distractors_calculated[i])
                            distractors.append(x)
                        else:
                            distractors.append(distractors_calculated[i])
                    else:
                        distractors.append("")
                print(distractors_calculated)
                print(distractors)
            else:
                distractors=["", "", ""]
                # print(distractors_calculated)
            print("\n")
            questions_beta = mongo.db.questions_beta
            questions_beta.insert_one({'lesson_id': lesson_id, 'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})
            question_id = questions_beta.find_one({'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})['_id']
            questions_array.append({'lesson_id': lesson_id, 'question_id': question_id, 'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})
        
        # temp_questions_array=questions_array
        # print(temp_questions_array)
        # questions_array.clear()
        # print(questions_array)
        global global_questions_array
        global_questions_array = list(questions_array)
        print(global_questions_array)
        print("-----")
        print(questions_array[0])
        # return render_template("create_page.html", page_content=page_content, lessonNames=lessonNames, questionsObject=questions_array[0])
        if (len(questions_array)>=1):
            return render_template("create_page.html", page_content=page_content, lessonNames=lessonNames, lesson_id=questions_array[0]['lesson_id'], page_id=questions_array[0]['page_id'], question_id=questions_array[0]['question_id'], question=questions_array[0]['question'], option1=questions_array[0]['answer'], option2=questions_array[0]['distractors'][0], option3=questions_array[0]['distractors'][1], option4=questions_array[0]['distractors'][2], answer=questions_array[0]['answer'])
        return redirect(url_for('student_dashboard'))
    return "Page title already exists"

@app.route('/manual_create_page', methods=['GET', 'POST'])
def manual_create_page():
    lesson_name = request.form.get('lessonname')
    print(lesson_name)
    page_title = request.form.get('pagetitle')
    print(page_title)
    page_content = request.form.get('pagecontent')
    teacher_email = session["email"]
    # print("teacher_email: " + teacher_email)
    lessonsCollection = mongo.db.lessons

    lessonNames = []
    # teacher_email = 'mrithusree1@gmail.com'
    teacher_email = session['email']
    print("teacher_email: " + teacher_email)
    # lessons = lessonsCollection.find({},{ "_id": 1 })
    lessons = lessonsCollection.find({'teacher_email' : teacher_email})
    for lesson in lessons:
        lessonNames.append(lesson['lesson_name'])

    lesson_id = lessonsCollection.find_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})['_id']
    print(lesson_id)

    pagesCollection = mongo.db.pages
    existing_page = pagesCollection.find_one({'lesson_id' : lesson_id, 'page_title': page_title})

    if existing_page is None:
        pagesCollection.insert_one({'lesson_id': lesson_id, 'page_title': page_title, 'page_content': page_content})
        #return redirect(url_for('teacher_dashboard'))
        text=page_content
        imp_keywords = get_keywords(text,text)
        page_id = pagesCollection.find_one({'lesson_id': lesson_id, 'page_title': page_title})['_id']
        questions_array = []

        question_answer = question_model.generate_qa(page_content)

        for question in question_answer:
            # ques = get_question(text,answer,question_model,question_tokenizer)
            # print (ques)
            ques = question[0]
            answer = question[1]
            answer = answer.capitalize()
            if (len(answer)>1):
                tokenized = sent_tokenize(answer)
                for i in tokenized:
                
                    # Word tokenizers is used to find the words
                    # and punctuation in a string
                    wordsList = nltk.word_tokenize(i)
            
                    # removing stop words from wordList
                    wordsList = [w for w in wordsList if not w in stop_words]
            
                    #  Using a Tagger. Which is part-of-speech
                    # tagger or POS-tagger.
                    tagged = nltk.pos_tag(wordsList)
                    print(tagged)
                    for word in tagged:
                        if (word[1] == "NNP" or word[1] == "NN"):
                            dist = word[0]
                            break
                    print("dist")
                    print(dist)

            else:
                dist = answer

            # print (answer)
            # print ("\n")
            distractors=[]
            if (len(wn.synsets(dist, 'n'))>0):
                synset_to_use = wn.synsets(dist,'n')[0]
                distractors_calculated = get_distractors_wordnet(synset_to_use,dist)
                count = len(distractors_calculated)
                
                for i in range(0,3):
                    if (i+1 <= count):
                        if (len(answer)>1):
                            x = answer.replace(dist, distractors_calculated[i])
                            distractors.append(x)
                        else:
                            distractors.append(distractors_calculated[i])
                    else:
                        distractors.append("")
                print(distractors_calculated)
                print(distractors)
            else:
                distractors=["", "", ""]
                # print(distractors_calculated)
            print("\n")
 

            questions_beta = mongo.db.questions_beta
            questions_beta.insert_one({'lesson_id': lesson_id, 'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})
            question_id = questions_beta.find_one({'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})['_id']
            questions_array.append({'lesson_id': lesson_id, 'question_id': question_id, 'page_id': page_id, "question": ques, "answer": answer, "distractors": distractors})
        
        # temp_questions_array=questions_array
        # print(temp_questions_array)
        # questions_array.clear()
        # print(questions_array)
        global global_questions_array
        global_questions_array = list(questions_array)
        print(global_questions_array)
        print("-----")
        print(questions_array[0])
        # return render_template("create_page.html", page_content=page_content, lessonNames=lessonNames, questionsObject=questions_array[0])
        if (len(questions_array)>=1):
            return render_template("manual_create_page.html", page_content=page_content, lessonNames=lessonNames, lesson_id=questions_array[0]['lesson_id'], page_id=questions_array[0]['page_id'], question_id=questions_array[0]['question_id'], question=questions_array[0]['question'], option1=questions_array[0]['answer'], option2=questions_array[0]['distractors'][0], option3=questions_array[0]['distractors'][1], option4=questions_array[0]['distractors'][2], answer=questions_array[0]['answer'])
        return redirect(url_for('student_dashboard'))
    return "Page title already exists"


@app.route('/add_questions', methods=['GET', 'POST'])
def add_questions():
    save = request.form.get('button')
    lesson_id = request.form.get('lesson_id')
    question_id = request.form.get('question_id')
    page_id = request.form.get('page_id')
    question = request.form.get('question')
    answer = request.form.get('answer')
    print("Answer:")
    print(answer)
    option1 = request.form.get('option1')
    option2 = request.form.get('option2')
    option3 = request.form.get('option3')
    option4 = request.form.get('option4')
    if (save=="yes"):
        print(ObjectId(lesson_id))
        print(lesson_id)
        questions_main = mongo.db.questions_main
        questions_main.insert_one({'lesson_id': ObjectId(lesson_id), 'page_id': ObjectId(page_id), "question": question, "answer": answer, "option1": option1, "option2": option2, "option3": option3, "option4": option4})
    questions_beta = mongo.db.questions_beta
    questions_beta.delete_one({'lesson_id': ObjectId(lesson_id), 'page_id': ObjectId(page_id), "question": question, "answer": answer, "option1": option1, "option2": option2, "option3": option3, "option4": option4})
    for i in global_questions_array:
        # if (i['page_id']==page_id and i['question']==question and i['answer']==answer and i['option1']==option1 and i[option2])
        if (i['question_id']==ObjectId(question_id)):
            print("match")
            global_questions_array.remove(i)

    print("*****************")
    print(save)
    print(global_questions_array)
    if (len(global_questions_array)>=1):
        questionsObject = global_questions_array[0]
        return render_template("create_page.html", lesson_id = questionsObject['lesson_id'], page_id = questionsObject['page_id'], question_id = questionsObject['question_id'], question = questionsObject['question'], option1 = questionsObject['distractors'][0], option2 = questionsObject['distractors'][1], option3 = questionsObject['distractors'][2], option4 = questionsObject['answer'], answer = questionsObject['answer'])
    return redirect(url_for('teacher_dashboard'))

@app.route('/manual_add_questions', methods=['GET', 'POST'])
def manual_add_questions():
    save = request.form.get('button')
    lesson_id = request.form.get('lesson_id')
    question_id = request.form.get('question_id')
    page_id = request.form.get('page_id')
    question = request.form.get('question')
    answer = request.form.get('answer')
    print("Answer:")
    print(answer)
    option1 = request.form.get('option1')
    option2 = request.form.get('option2')
    option3 = request.form.get('option3')
    option4 = request.form.get('option4')
    if (save=="yes"):
        print(ObjectId(lesson_id))
        print(lesson_id)
        questions_main = mongo.db.questions_main
        questions_main.insert_one({'lesson_id': ObjectId(lesson_id), 'page_id': ObjectId(page_id), "question": question, "answer": answer, "option1": option1, "option2": option2, "option3": option3, "option4": option4})
    questions_beta = mongo.db.questions_beta
    questions_beta.delete_one({'lesson_id': ObjectId(lesson_id), 'page_id': ObjectId(page_id), "question": question, "answer": answer, "option1": option1, "option2": option2, "option3": option3, "option4": option4})
    for i in global_questions_array:
        # if (i['page_id']==page_id and i['question']==question and i['answer']==answer and i['option1']==option1 and i[option2])
        if (i['question_id']==ObjectId(question_id)):
            print("match")
            global_questions_array.remove(i)

    print("*****************")
    print(save)
    print(global_questions_array)
    if (len(global_questions_array)>=1):
        questionsObject = global_questions_array[0]
        return render_template("manual_create_page.html", lesson_id = questionsObject['lesson_id'], page_id = questionsObject['page_id'], question_id = questionsObject['question_id'], question = questionsObject['question'], option1 = questionsObject['distractors'][0], option2 = questionsObject['distractors'][1], option3 = questionsObject['distractors'][2], option4 = questionsObject['answer'], answer = questionsObject['answer'])
    return redirect(url_for('teacher_dashboard'))

@app.route('/delete_lesson', methods=['GET', 'POST'])
def delete_lesson():
    if "email" not in session:
        return redirect(url_for('index'))
    elif request.method == 'GET':
        return render_template('delete_lesson.html')
    else:
        # back = request.referrer
        lesson_name = request.form.get('lessonname')
        teacher_email= session["email"]
        lessons = mongo.db.lessons
        pages = mongo.db.pages
        lesson_id = lessons.find_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})['_id']
        print(lesson_id)
        print(type(lesson_id))
        del_lesson = lessons.delete_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})
        del_pages_corresponding = pages.delete_many({'lesson_id': lesson_id})
        if (del_lesson == 1):        
            flash('Lesson deleted successfully!')
        return render_template('delete_lesson.html')
        # teacher_doc = teachers.find_one({'email' : teacher_email})
        # print(teacher_doc['email'])
        # print(teacher_doc['_id'])
    # lesson_name = request.form.get('lessonname')
    # print(lesson_name)
    # teacher_email = session["email"]
    # # print("teacher_email: " + teacher_email)
    # lessonsCollection = mongo.db.lessons
    # lesson_id = lessonsCollection.find_one({'teacher_email': teacher_email, 'lesson_name': lesson_name})['_id']
    # print(lesson_id)

    # pagesCollection = mongo.db.pages
    # existing_page = pagesCollection.find_one({'lesson_id' : lesson_id, 'page_title': page_title})

    # if existing_page is None:
    #     page_content = wikipedia.summary(page_title+lesson_name, sentences=10)
    #     pagesCollection.insert_one({'lesson_id': lesson_id, 'page_title': page_title, 'page_content': page_content})
    #     return redirect(url_for('teacher_dashboard'))
    # return "Page title already exists"

    # return render_template('delete_lesson.html')
if __name__ == '__main__':
    app.secret_key = 'mysecret'
    app.run(debug=True)

