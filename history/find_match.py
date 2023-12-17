import sqlite3
from data_base_read_user import read_user
from interpret_result import interpret


def find_match(name, dat):
    


    data_base = sqlite3.connect('data.db')
    cursor = data_base.cursor()
    cursor.execute(f'SELECT Name FROM People WHERE Name != \'{name}\'')
    results = cursor.fetchall()

    main_result=[]

    for user in results:
        match_result = ('0'*(len(dat)-len(read_user(user[0]))) + 
                        bin(int(dat,2)&int(read_user(user[0]),2))[2:])

        word_r = interpret(match_result)
        if len(word_r) > 0:
            main_result.append([user[0]]+word_r)

    return main_result

        



