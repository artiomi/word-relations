CREATE TABLE if not exists word_relations(
id VARCHAR2(250) NOT NULL,
word_one VARCHAR2(250) NOT NULL,
word_two VARCHAR2(250) NOT NULL,
relation_type VARCHAR2(15) NOT NULL,
PRIMARY KEY (id)
);