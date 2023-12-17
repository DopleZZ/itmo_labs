import sqlite3

def read_user(name):
     data_base = sqlite3.connect('data.db')
     cursor = data_base.cursor()
     cursor.execute(f'SELECT * FROM People WHERE Name=\'{name}\'')
     results = list(cursor.fetchall()[0])
     
     user_dat = ''
     for i in results[1:]: user_dat+=str(i)

     return (user_dat)
