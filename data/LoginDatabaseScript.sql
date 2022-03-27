CREATE DATABASE IF NOT EXISTS login;
USE login;

CREATE TABLE login (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    PRIMARY KEY (id));

INSERT INTO login(username,password,role)
	VALUES
		('andrew.Warner','Adm!nW@rn3r','admin'),
        ('aston.Gale','AG!234%^&','engineer'),
        ('roma.Healy','RH^&*123ly','engineer'),
        ('kiyan.Calhoun','32a!a9wRR','engineer');