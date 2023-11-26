import re
eyes=[':',';','X','8','=','[']
nose=['-','<','-{','<{']
mouth=['(',')','O','|','\\','/','P']
regexp=f'{eyes[408301%6]}{nose[408301%4]}{mouth[408301%7]}'

file = open('task1_test.txt')
source = file.readlines()
count = 0 

for line in source:
    if len(re.findall(regexp,line)) >0:
        print(len(re.findall(regexp,line)))

print(count)
#print(re.findall(regexp,line) for line in source)
