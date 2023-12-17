from telebot import types
from data_base_read_user import read_user
from data_base_write import update_data

keyboard_main = types.InlineKeyboardMarkup()
key_find = types.InlineKeyboardButton(text='Искать🔍', callback_data='to_find')
key_change = types.InlineKeyboardButton(text='Список📋', callback_data='to_change')
keyboard_main.add(key_find,key_change)

keyboard_start = types.InlineKeyboardMarkup()
key_start = types.InlineKeyboardButton(text='Вперед!▶️', callback_data='menu')
keyboard_start.add(key_start)




keyboard_places = types.InlineKeyboardMarkup()
key_00 = types.InlineKeyboardButton(text='Большой Петергофский дворец', callback_data='btm_bpd_0')
key_10 = types.InlineKeyboardButton(text='Музей-Макет Петербурга и Пригородов', callback_data='btm_pam_0')
key_20 = types.InlineKeyboardButton(text='Заповедник "Павловск"', callback_data='btm_gmz_0')
key_30 = types.InlineKeyboardButton(text='Казанский кафедральный собор', callback_data='btm_kks_0')
key_40 = types.InlineKeyboardButton(text='Музей политической истории России', callback_data='btm_gvpi_0')
key_50 = types.InlineKeyboardButton(text='Екатерининский дворец', callback_data='btm_edp_0')
key_60 = types.InlineKeyboardButton(text='Юсуповский Дворец на Мойкe', callback_data='btm_udm_0')
key_70 = types.InlineKeyboardButton(text='Квартира А.С. Пушкина', callback_data='btm_mkp_0')
key_80 = types.InlineKeyboardButton(text='Петропавловская крепость', callback_data='btm_ppk_0')
key_90 = types.InlineKeyboardButton(text='Михайловский Замок', callback_data='btm_mz_0')
key_100 = types.InlineKeyboardButton(text='Музей истории религии', callback_data='btm_gmir_0')
key_110 = types.InlineKeyboardButton(text='Музей-Лицей А.С.Пушкина', callback_data='btm_mmp_0')
key_120 = types.InlineKeyboardButton(text='Музей Арктики и Антарктики', callback_data='btm_rgma_0')
key_130 = types.InlineKeyboardButton(text='Музей обороны и блокады Ленинграда', callback_data='btm_gmmoml_0')
key_140 = types.InlineKeyboardButton(text='Павловский Историко-Краеведческий музей', callback_data='btm_pgbk_0')

key_01 = types.InlineKeyboardButton(text='✅Большой Петергофский дворец', callback_data='btm_bpd_1')
key_11 = types.InlineKeyboardButton(text='✅Музей-Макет Петербурга и Пригородов', callback_data='btm_pam_1')
key_21 = types.InlineKeyboardButton(text='✅Заповедник "Павловск"', callback_data='btm_gmz_1')
key_31 = types.InlineKeyboardButton(text='✅Казанский кафедральный собор', callback_data='btm_kks_1')
key_41 = types.InlineKeyboardButton(text='✅Музей политической истории России', callback_data='btm_gvpi_1')
key_51 = types.InlineKeyboardButton(text='✅Екатерининский дворец', callback_data='btm_edp_1')
key_61 = types.InlineKeyboardButton(text='✅Юсуповский Дворец на Мойкe', callback_data='btm_udm_1')
key_71 = types.InlineKeyboardButton(text='✅Квартира А.С. Пушкина', callback_data='btm_mkp_1')
key_81 = types.InlineKeyboardButton(text='✅Петропавловская крепость', callback_data='btm_ppk_1')
key_91 = types.InlineKeyboardButton(text='✅Михайловский Замок', callback_data='btm_mz_1')
key_101 = types.InlineKeyboardButton(text='✅Музей истории религии', callback_data='btm_gmir_1')
key_111 = types.InlineKeyboardButton(text='✅Музей-Лицей А.С.Пушкина', callback_data='btm_mmp_1')
key_121 = types.InlineKeyboardButton(text='✅Музей Арктики и Антарктики', callback_data='btm_rgma_1')
key_131 = types.InlineKeyboardButton(text='✅Музей обороны и блокады Ленинграда', callback_data='btm_gmmoml_1')
key_141 = types.InlineKeyboardButton(text='✅Павловский Историко-Краеведческий музей', callback_data='btm_pgbk_1')

key_back = types.InlineKeyboardButton(text='Назад в меню', callback_data='menu')

def get_update(name):
    keyboard_places = types.InlineKeyboardMarkup()
    user_dat = read_user(name)
    if int(user_dat[0]):keyboard_places.add(key_01) 
    else:keyboard_places.add(key_00)

    if int(user_dat[1]):keyboard_places.add(key_11) 
    else:keyboard_places.add(key_10)

    if int(user_dat[2]):keyboard_places.add(key_21) 
    else:keyboard_places.add(key_20)

    if int(user_dat[3]):keyboard_places.add(key_31) 
    else:keyboard_places.add(key_30)

    if int(user_dat[4]):keyboard_places.add(key_41) 
    else:keyboard_places.add(key_40)

    if int(user_dat[5]):keyboard_places.add(key_51) 
    else:keyboard_places.add(key_50)

    if int(user_dat[6]):keyboard_places.add(key_61) 
    else:keyboard_places.add(key_60)

    if int(user_dat[7]):keyboard_places.add(key_71) 
    else:keyboard_places.add(key_70)

    if int(user_dat[8]):keyboard_places.add(key_81) 
    else:keyboard_places.add(key_80)

    if int(user_dat[9]):keyboard_places.add(key_91) 
    else:keyboard_places.add(key_90)

    if int(user_dat[10]):keyboard_places.add(key_101) 
    else:keyboard_places.add(key_100)
    
    if int(user_dat[11]):keyboard_places.add(key_111) 
    else:keyboard_places.add(key_110)

    if int(user_dat[12]):keyboard_places.add(key_121) 
    else:keyboard_places.add(key_120)

    if int(user_dat[13]):keyboard_places.add(key_131) 
    else:keyboard_places.add(key_130)

    if int(user_dat[14]):keyboard_places.add(key_141) 
    else:keyboard_places.add(key_140)
    
    keyboard_places.add(key_back)

    return keyboard_places



def update(name, to_update, value):
    update_data(name,to_update,not(int(value)))
    get_update(name)

    


