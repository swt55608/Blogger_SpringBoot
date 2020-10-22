INSERT INTO author (id, account, password, author_name) VALUES (101, 'tester', 'secret', 'Tester')
INSERT INTO author (id, account, password, author_name) VALUES (102, 'jack', 'jjj', 'Jack')

INSERT INTO article (id, title, contents, author_id) VALUES (201, 'tApple', 'Apple is good.', 101)
INSERT INTO article (id, title, contents, author_id) VALUES (202, 'tBanana', 'Banana is better.', 101)
INSERT INTO article (id, title, contents, author_id) VALUES (203, 'tCitrus', 'Why not try citrus...', 101)