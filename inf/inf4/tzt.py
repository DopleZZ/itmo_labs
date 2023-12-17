source = open('files/task2/shedule.xml', encoding='UTF-8').readlines()
strg = ''
for i in source[2:-1]: strg+=i
strg = strg.replace('</lesson>','').split('<lesson>')
a=[]
out={}
lesson_num=1
#print(strg)
for i in range(1,len(strg)):
    b=strg[i].split("\n\t\t")
    day={}
    #print(strg[i].split("\n\t\t"))
    for j in range(1, len(b)):
        
        tag = b[j][1:b[j].find('>')]
        element = b[j][b[j].find('>')+1::]
        element = element[:element.find('<')]

        day[tag]=element
   

    out[f'lesson_{lesson_num}'] = day
    lesson_num+=1

json_file = open("files\\task0\output.json", 'a', encoding='UTF-8')
json_file.write('{\n')
count_days=len(out.keys())
i=1
for lesson in out:
    json_file.write(f'"{lesson}":')
    json_file.write('{\n')
    count_keys=len(out[lesson].keys())
    j=1
    for element in out[lesson]:
        
        com1 = '' if j==count_keys else  ','    
        json_file.write(f'\t"{element}":"{out[lesson][element]}"{com1}\n')
        j+=1
    com2 = '' if i == count_days else ','
    json_file.write('}'+com2+'\n')
    i+=1
json_file.write('}')
json_file.close()

