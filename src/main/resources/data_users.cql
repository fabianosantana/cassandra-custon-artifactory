CREATE KEYSPACE test WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
USE test;

CREATE TABLE users (
id INT PRIMARY KEY,
first_name TEXT,
last_name TEXT
);
INSERT INTO users (id, first_name, last_name) VALUES (1, 'Bob', 'Moore');
INSERT INTO users (id, first_name, last_name) VALUES (2, 'Brian', 'Nelson');
INSERT INTO users (id, first_name, last_name) VALUES (3, 'Anthony', 'Parker');
INSERT INTO users (id, first_name, last_name) VALUES (4, 'Kevin', 'Collins');
INSERT INTO users (id, first_name, last_name) VALUES (5, 'Jeff', 'Wilson');
INSERT INTO users (id, first_name, last_name) VALUES (6, 'Mark', 'Taylor');
INSERT INTO users (id, first_name, last_name) VALUES (7, 'John', 'Baker');
INSERT INTO users (id, first_name, last_name) VALUES (8, 'Laura', 'Carter');