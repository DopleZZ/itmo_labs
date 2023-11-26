print(*sorted([__import__('re').findall(r'[а-яА-ЯёЁ]*',i)[0] for i in open('task3_test.txt').read().split() if len(set(__import__('re').findall(r'[аеёиоуыэюя]',i))) == 1], key=len), sep='\n')
