import sqlite3


def update_data(name, to_update, value):
    data_base = sqlite3.connect('data.db')
    data_base.execute(f'UPDATE People SET {to_update}={value} WHERE Name=\'{name}\'')
    data_base.commit()


def write_new(new_name):
    data_base = sqlite3.connect('data.db')
    data_base.execute(f'INSERT INTO People (Name, bpd, pam, gmz, kks, gvpi, edp, udm, mkp, ppk, mz, gmir, mmp, rgma, gmmoml, pgbk) VALUES (\'{new_name}\', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)')
    data_base.commit()

