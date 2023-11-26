#перевод из Фибоначчиевой сс в десятичную
def fib(x):
    fib =[1,2]
    for i in range(x-2):
        fib.append(fib[-1]+fib[-2])

    return fib



while True:
    number_fib = int(input('Введите число '))
    if str(number_fib).count('1') + str(number_fib).count('0') == len(str(number_fib)) and '11' not in str(number_fib):
        fib_line = fib(len(str(number_fib)))
        number_dec = 0
        ind = 0
        for i in (str(number_fib)[::-1]):
            number_dec += int(i)*fib_line[ind]
            ind+=1

        print(number_dec)
        break
    else:
        print('Введите корректное число!')
        continue

