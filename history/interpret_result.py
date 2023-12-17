import sqlite3


def interpret(byte_result):
    data_base = sqlite3.connect('data.db')
    cursor = data_base.cursor()

    decimal_result = [2**i*int(byte_result[i]) for i in range(len(byte_result))]
    final_result = []
    
    for id in decimal_result:
        cursor.execute(f'SELECT place FROM Places WHERE id=\'{id}\'')
       
        place = cursor.fetchall()
        if len(place)!=0:final_result.append(place[0][0])


    return final_result