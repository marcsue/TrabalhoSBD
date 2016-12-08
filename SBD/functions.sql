﻿CREATE OR REPLACE FUNCTION insereAluno(cpf VARCHAR(11), datanas DATE, email1 VARCHAR(100), email2 VARCHAR(100), tipo VARCHAR(45),mat VARCHAR(25),curso CHAR(5),uni CHAR(5))
RETURNS void AS
$$
BEGIN
INSERT INTO pessoa VALUES(cpf,datanas,email1,email2,tipo);
INSERT INTO aluno VALUES(cpf,mat,curso,uni);
END;	
$$language 'plpgsql'; 

CREATE OR REPLACE FUNCTION insereProfessor(cpf VARCHAR(11), datanas DATE, email1 VARCHAR(100), email2 VARCHAR(100), tipo VARCHAR(45), siape VARCHAR(50),regime VARCHAR(45),uni CHAR(5))
RETURNS void AS
$$
BEGIN
INSERT INTO pessoa VALUES(cpf,datanas,email1,email2,tipo);
INSERT INTO professor VALUES(cpf,siape,regime,uni);
END;	
$$language 'plpgsql'; 

CREATE OR REPLACE FUNCTION insereTecnico(cpf VARCHAR(11), datanas DATE, email1 VARCHAR(100), email2 VARCHAR(100), tipo VARCHAR(45), siape VARCHAR(50),uni CHAR(5))
RETURNS void AS
$$
BEGIN
INSERT INTO pessoa VALUES(cpf,datanas,email1,email2,tipo);
INSERT INTO tecnico VALUES(cpf,siape,uni);
END;	
$$language 'plpgsql'; 

CREATE OR REPLACE FUNCTION insereTerceirizado(cpf VARCHAR(11), datanas DATE, email1 VARCHAR(100), email2 VARCHAR(100), tipo VARCHAR(45), empresa VARCHAR(100), setor VARCHAR(50))
RETURNS void AS
$$
BEGIN
INSERT INTO pessoa VALUES(cpf,datanas,email1,email2,tipo);
INSERT INTO terceirizado VALUES(cpf,empresa,setor);
END;	
$$language 'plpgsql'; 

INSERT INTO unidade VALUES ('FACOM','Computação','exatas',0);
INSERT INTO curso VALUES ('BCC','Bacharel','FACOM');

SELECT insereAluno('33363837810','1995-01-31','gustavo-ssilva@hotmail.com',NULL,'aluno','11311bcc026','BCC','FACOM');