import telebot
import bot_keyboards
import data_base_write
from data_base_read_user import read_user
from find_match import find_match


bot = telebot.TeleBot('6918942734:AAFrH47noFlQ7c6U4B4-MTSbZmGOYIJ-UH0')


@bot.message_handler(content_types=['text'])
def get_text_messages(message):
    if message.from_user.username:
        match message.text:
            case "/start":
                try:
                    data_base_write.write_new(message.from_user.username)
                    bot.send_message(message.from_user.id, text='Привет! Я бот History unites для поиска собеседников на исторические темы. Скорее выбирай свои любиме места в меню и начинай поиск новых друзей!', reply_markup=bot_keyboards.keyboard_start)
                except:
                    bot.send_message(message.from_user.id, text='Кажется я уже знаю тебя! Используй кнопку или команду /menu для перехода в меню!', reply_markup=bot_keyboards.keyboard_start)

            case "/menu":
                bot.send_message(message.from_user.id, text='А вот и меню! Используй "поиск", чтобы найти себе друзей, или "список", чтобы редактировать список посещенных мест!' , reply_markup=bot_keyboards.keyboard_main)

    else:
        bot.send_message(message.from_user.id, text='Упс! Кажется у вас не уставновлено имя пользвоателя! Это обязательный пункт для функционирвоания бота!')


@bot.callback_query_handler(func=lambda call: True)
def callback_worker(call):
    match call.data:
        case "to_find":
            match = find_match(call.from_user.username,read_user(call.from_user.username))

            if len(match) == 0:
                bot.send_message(call.from_user.id, text='Ой, похоже, что я не знаю людей, с которыми у тебя совпадают интересы :(')
            else:
                for unit in match:
                    user = unit[0]
                    places=''
                    for i in unit[1:]:places+=(i+'\n')
                    bot.send_message(call.from_user.id, text=f'{call.from_user.username}, у тебя с @{user} есть общие места:\n {places}')

        case "to_change":
            bot.edit_message_text(chat_id=call.message.chat.id, message_id=call.message.message_id, 
                                  text="Давайте узнаем, где вы были!", reply_markup=bot_keyboards.get_update(call.from_user.username))
        case "menu":
                bot.edit_message_text(chat_id=call.message.chat.id, message_id=call.message.message_id, 
                                  text='А вот и меню! Используй "поиск", чтобы найти себе друзей, или "список", чтобы редактировать список посещенных мест!' , reply_markup=bot_keyboards.keyboard_main)

        case _:
            btm=call.data.split('_')
            bot_keyboards.update(call.from_user.username,btm[1],btm[2])
            bot.edit_message_text(chat_id=call.message.chat.id, message_id=call.message.message_id, 
                                  text="Давайте узнаем, где вы были!", reply_markup=bot_keyboards.get_update(call.from_user.username))


bot.polling(none_stop=True, interval=0)