import re
import json

source = open('files\\task2\shedule.xml', encoding='UTF-8').readlines()
strg = ''
for i in source[2:-1]: strg+=i
strg = strg.replace('</lesson>','').split('<lesson')
out={}
a=[]
lesson_num = 1
for day in strg:
    lesson_list = re.findall(r'<([a-z]*)>(.*)</\1>',day)
    print(lesson_list)
    currect_day = {}
    for elmnt in lesson_list:
        tag, content = elmnt
        currect_day[tag]=content
    out[f'lesson_{lesson_num}'] = currect_day
    lesson_num+=1

with open('files\\task2\output2.json', 'w') as file:
    json.dump(out,file,indent=4,ensure_ascii=False)

