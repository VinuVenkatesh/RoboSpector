CREATE DATABASE IF NOT EXISTS inspectionresult;
USE inspectionresult;

CREATE TABLE result (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    severity INT NOT NULL,
    PRIMARY KEY (id));

INSERT INTO result(name,severity)
	VALUES
		('911 immediate assistance required',99),
        ('Acceptable',1),
        ('Minor wear',2),
        ('Major wear',3),
        ('On-site inspection required',4);
