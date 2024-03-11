CREATE TABLE "nicknames" (
  "id" serial UNIQUE PRIMARY KEY,
  "nick_text" text,
  "description" text
);

CREATE TABLE "people" (
  "person_id" serial UNIQUE PRIMARY KEY,
  "name" text,
  "nickname" integer UNIQUE,
  "age" integer CONSTRAINT wrong_age CHECK ("age" > 0),
  FOREIGN KEY ("nickname") REFERENCES nicknames ("id")
);

CREATE TABLE "title" (
  "owner_id" integer,
  "title_text" varchar,
  FOREIGN KEY ("owner_id") REFERENCES "people" ("person_id")
);





CREATE TABLE "words" (
  "id_words" serial UNIQUE PRIMARY KEY,
  "word" text
);

CREATE TABLE "memories" (
  "id_memories" serial UNIQUE PRIMARY KEY,
  "words_id" integer,
  FOREIGN KEY ("words_id") REFERENCES "words" ("id_words")
);


CREATE TABLE "memHelper" (
  "owner_id" integer,
  "mem_id" integer,
  PRIMARY KEY ("owner_id", "mem_id"),
  FOREIGN KEY ("owner_id") REFERENCES "people" ("person_id"),
  FOREIGN KEY ("mem_id") REFERENCES "memories" ("id_memories")
);

INSERT INTO "nicknames"(nick_text, description) VALUES
('Соколиный глаз', 'Попал в бабку пакетом с водой'),
('Фигурист', 'Упал на льду и сломал ногу');

INSERT INTO "people"(name, nickname) VALUES 
('Петя', 1),
('Вася',2) RETURNING person_id;


INSERT INTO "title"(owner_id, title_text) VALUES
(1, 'Король'),
(2, 'Шут');

INSERT INTO "words"(word) VALUES
('Чайник'),
('Кружка');




INSERT INTO "memories"(words_id) VALUES
(1),
(2);

INSERT INTO "memHelper"(owner_id, mem_id) VALUES
(1,1),
(1,2),
(2,2);



