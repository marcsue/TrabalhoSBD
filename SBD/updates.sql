--Operação de inserção (No caso utilizando uma stored procedure)
SELECT insereAluno('15363987810','Thomas Aquino','1961-06-16','thomas@globlo.com',NULL,'aluno','11311BCC050','BCC','FACOM');


--Remoção neste caso vale a pena lembrar que todas as pessoas, sendo ela aluno, professor, etc, ao serem removidas elas devem também ser removidas do banco de pessoas
--Neste caso foi criado um trigger para tratar disso, então todas as remoções aqui já são de mais de uma tabela.
DELETE FROM aluno WHERE nome = 'Jose';
DELETE FROM tecnico WHERE nome = 'Alex';
DELETE FROM professor WHERE cpf = '62345678901';

UPDATE pessoa SET nome = 'José Lemes' WHERE nome = 'Jose';
UPDATE unidade SET nome = 'Faculdade de Computação' WHERE sigla = 'FACOM';
UPDATE aluno SET curso = (SELECT sigla FROM curso WHERE nome = 'Bacha. em Sistema da Inf.') WHERE curso = 'BCC'
