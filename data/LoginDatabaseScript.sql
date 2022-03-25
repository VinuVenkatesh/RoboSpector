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
		('andrew.warner','Adm!nW@rn3r','admin'),
        ('aston.gale','AG!234%^&','engineer'),
        ('roma.healy','RH^&*123ly','engineer'),
        ('kiyan.calhoun','32a!a9wRR','engineer');