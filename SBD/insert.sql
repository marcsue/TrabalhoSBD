-- UNIDADE
INSERT INTO unidade VALUES('FACOM', 'Facul. de Comp.','Exatas',1);
INSERT INTO unidade VALUES('FAMAT', 'Facul. de Matem.','Exatas',1);
INSERT INTO unidade VALUES('PROGR', 'Pro Reitoria de Graducao','',2);
INSERT INTO unidade VALUES('FEELT', 'Facul. de Eng. Elét.','Exatas',1);
INSERT INTO unidade VALUES('PROPO', 'Pro Reitoria de Pos Graducao','',2);

--CURSO
INSERT INTO curso VALUES('BCC','Bacha. em Cienc. da Comp.','FACOM');
INSERT INTO curso VALUES('LMA','Lincenciatura em Matematica','FAMAT');
INSERT INTO curso VALUES('BEE','Bacha. em Eng. Eletrica','FEELT');
INSERT INTO curso VALUES('BEM','Bacha. em Eng. Mecanica','FEELT');
INSERT INTO curso VALUES('BSI','Bacha. em Sistema da Inf.','FACOM');


--ALUNOS
INSERT INTO pessoa VALUES(12345678901,'Jose','1961-06-16','jose@gmail.com','jose@hotmail.com','aluno');
INSERT INTO pessoa VALUES(22345678901,'Joao','1981-05-15','joao@gmail.com','joao@hotmail.com','aluno');
INSERT INTO pessoa VALUES(32345678901,'Maria','1991-01-01','jose@gmail.com','jose@hotmail.com','aluno');
INSERT INTO pessoa VALUES(42345678901,'Joana','1995-05-12','jose@gmail.com','jose@hotmail.com','aluno');
INSERT INTO pessoa VALUES(52345678901,'Mariana','1987-03-14','jose@gmail.com','jose@hotmail.com','aluno');

INSERT INTO aluno VALUES(12345678901,'11411bcc022','BCC','FACOM') ;
INSERT INTO aluno VALUES(22345678901,'11411bsi021','BSI','FACOM') ;
INSERT INTO aluno VALUES(32345678901,'11411lma012','LMA','FAMAT') ;
INSERT INTO aluno VALUES(42345678901,'11411bcc014','BCC','FACOM') ;
INSERT INTO aluno VALUES(52345678901,'11411bsi001','BSI','FACOM') ;


--PROFESSORES
INSERT INTO pessoa VALUES(62345678901,'Mauro','1979-06-16','mauro@gmail.com','mauro@hotmail.com','professor');
INSERT INTO pessoa VALUES(72345678901,'Marcos','1978-05-16','marcos@gmail.com','marcos@hotmail.com','professor');
INSERT INTO pessoa VALUES(82345678901,'Mario','1989-03-30','mario@gmail.com','mario@hotmail.com','professor');
INSERT INTO pessoa VALUES(92345678901,'Mariano','1985-12-12','mariano@gmail.com','mariano@hotmail.com','professor');
INSERT INTO pessoa VALUES(02345678901,'Marc','1971-02-13','marc@gmail.com','marc@hotmail.com','professor');

INSERT INTO professor VALUES (62345678901,'11211','20H','FACOM');
INSERT INTO professor VALUES (72345678901,'11231','40H','FACOM');
INSERT INTO professor VALUES (82345678901,'11341','DEX','FAMAT');
INSERT INTO professor VALUES (92345678901,'11451','DEX','FACOM');
INSERT INTO professor VALUES (02345678901,'11561','20H','FAMAT');


--TECNICOS
INSERT INTO pessoa VALUES(11145678901,'Alex','1986-08-18','alex@gmail.com','alex@hotmail.com','tecnico');
INSERT INTO pessoa VALUES(11245678901,'Alexia','1978-05-06','alexia@gmail.com','alexia@hotmail.com','tecnico');
INSERT INTO pessoa VALUES(11345678901,'Andre','1991-04-13','andre@gmail.com','andre@hotmail.com','tecnico');
INSERT INTO pessoa VALUES(11445678901,'Amanda','1992-08-19','amanda@gmail.com','amanda@hotmail.com','tecnico');
INSERT INTO pessoa VALUES(11545678901,'Ana','1923-02-11','ana@gmail.com','ana@hotmail.com','tecnico');

INSERT INTO tecnico VALUES (11145678901,'11211','FACOM');
INSERT INTO tecnico VALUES (11245678901,'11231','FACOM');
INSERT INTO tecnico VALUES (11345678901,'11341','FAMAT');
INSERT INTO tecnico VALUES (11445678901,'11451','FACOM');
INSERT INTO tecnico VALUES (11545678901,'11561','FAMAT');


--TERCEIRIZADOS
INSERT INTO pessoa VALUES(11645678901,'Bruno','1979-04-23','bruno@gmail.com','bruno@hotmail.com','terceirizado');
INSERT INTO pessoa VALUES(11745678901,'Bruna','1982-03-02','bruna@gmail.com','bruna@hotmail.com','terceirizado');
INSERT INTO pessoa VALUES(11845678901,'Brenner','1992-05-06','brenner@gmail.com','brenner@hotmail.com','terceirizado');
INSERT INTO pessoa VALUES(11945678901,'Carlos','1993-01-12','carlos@gmail.com','carlos@hotmail.com','tercerizado');
INSERT INTO pessoa VALUES(11045678901,'Carla','1969-04-11','carla@gmail.com','carla@hotmail.com','terceirizado');

INSERT INTO terceirizado VALUES (11645678901,'LimpeBem','limpeza');
INSERT INTO terceirizado VALUES (11745678901,'LimpeBem','limpeza');
INSERT INTO terceirizado VALUES (11845678901,'TudoSeguro','seguranca');
INSERT INTO terceirizado VALUES (11945678901,'LimpeBem','limpeza');
INSERT INTO terceirizado VALUES (11045678901,'TudoSeguro','seguranca');


