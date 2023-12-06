import xml.etree.ElementTree as ET
import json

xml_file = ET.parse('files/task1/shedule.xml')

out = {}
lesson_num = 1
for type_tag in xml_file.findall('lesson'):
    currect_lesson = {}
    currect_lesson["time"]=type_tag.find('time').text
    currect_lesson["title"]=type_tag.find('title').text
    currect_lesson["teacher"]=type_tag.find('teacher').text
    currect_lesson["audience"]=type_tag.find('audience').text
    out[f'lesson_{lesson_num}']=currect_lesson
    lesson_num += 1

with open("files\\task1\output1.json", 'w') as file:
    json.dump(out,file,indent=4,ensure_ascii=False)
