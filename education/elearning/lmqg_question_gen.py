from lmqg import TransformersQG
# initialize model
model = TransformersQG(language='en', model='lmqg/t5-small-squad-qg-ae')
# paragraph to generate pairs of question and answer
# paragraph to generate pairs of question and answer
context = "Photosynthesis is a process used by plants and other organisms to convert light energy into chemical energy that, through cellular respiraztion, can later be released to fuel the organism's activities."



# # model prediction
# question_answer = model.generate_qa(context)
# # the output is a list of tuple (question, answer)
# print(question_answer)
question_answer = model.generate_qa(context)

# the output is a list of tuple (question, answer)
print(question_answer)
print(type(question_answer[0]))
a = question_answer[0]
print(a[0])