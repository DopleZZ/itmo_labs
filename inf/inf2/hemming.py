errors = {
    '100':0,
    '010':1,
    '110':2,
    '001':3,
    '101':4,
    '011':5,
    '111':6
}


while True:
    input_code = str(input('Введите семизначный двоичный код: '))
    if len(input_code) == 7 and set(input_code) == {'1', '0'}:
        s1=str(int(input_code[0])^int(input_code[2])^int(input_code[4])^int(input_code[6]))
        s2=str(int(input_code[1])^int(input_code[2])^int(input_code[5])^int(input_code[6]))
        s3=str(int(input_code[3])^int(input_code[4])^int(input_code[5])^int(input_code[6]))
        S=int((s1+s2+s3)[::-1],2)-1
        correct_code = (input_code[0:S]+str(1-int(input_code[S]))
                        +input_code[S+1::])
        if S<0:
            print('Код передан без ошибок')
        else:
            print(f'Ошибка в {S+1} бите, правильный код - {correct_code} \
                  \nинформационное сообщение: {correct_code[2]+correct_code[4::]}')
        break
    else:
        print('Введите правильный код')
        continue

