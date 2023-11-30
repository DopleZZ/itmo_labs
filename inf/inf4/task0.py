def brackets(raw):
    raw = raw[raw.find('>')+1::]
    raw = raw[:raw.find('<')]
    return raw

source = open("files\\task0\shedule.xml", encoding='UTF-8').readlines()
out={}
lesson_number = 1
for i in range(2,len(source)-1,6):
    out[f'lesson_{lesson_number}'] = {'time':brackets(source[i+1]),'title':brackets(source[i+2]),'teacher':brackets(source[i+3]),'audience':brackets(source[i+4])}
    lesson_number +=1

json_file = open("files\\task0\output.json", 'a', encoding='UTF-8')
json_file.write('{\n')
for lesson in out:
    json_file.write(f'"{lesson}":')
    json_file.write('{\n')
    for element in out[lesson]:
        com = '' if element == 'audience'  else  ','    
        json_file.write(f'\t"{element}":"{out[lesson][element]}"{com}\n')
    com = '' if lesson == 'lesson_4' else ','
    json_file.write('}'+com+'\n')
json_file.write('}')
json_file.close()
