CREATE DATABASE bancodb;

CREATE TABLE unidade
(
    sigla varchar(5) NOT NULL,
    nome varchar(60),
    areaConhecimento varchar(10),
    tipoUnidade varchar (45),

    CONSTRAINT uniPk PRIMARY KEY (sigla)

);


CREATE TABLE curso 
(
    sigla varchar(3) NOT NULL, 
    nome varchar(60),
    unidadeACD varchar(5),
  
    CONSTRAINT cursoPk PRIMARY KEY (sigla),
    CONSTRAINT cursoFk FOREIGN KEY (unidadeACD) REFERENCES unidade (sigla)
    
);

CREATE TABLE pessoa
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	emailInstitucional varchar (30),
	emailSecundario varchar (30),
	dataNascimento date,

	CONSTRAINT pessoaPk PRIMARY KEY (cpf)
	
);


CREATE TABLE aluno
(
	cpf varchar(11) NOT NULL,
	matricula varchar(11),
	siglaCurso varchar(3),

	CONSTRAINT alunoPk PRIMARY KEY (cpf),
	CONSTRAINT cpfFk FOREIGN KEY (cpf) REFERENCES pessoa(cpf),
	CONSTRAINT alunoFk FOREIGN KEY (siglaCurso) REFERENCES curso (sigla)

);



CREATE TABLE professor
(
	cpf varchar(11) NOT NULL,
	siape varchar (12),
	regimeTrabalho varchar (3),
	siglaUAC varchar(5),

	CONSTRAINT profPk PRIMARY KEY (cpf),
	CONSTRAINT cpfFk FOREIGN KEY (cpf) REFERENCES pessoa(cpf),
	CONSTRAINT profFk FOREIGN KEY (siglaUAC) REFERENCES unidade (sigla)

); 


CREATE TABLE terceirizado
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	empresa varchar (20),
	setor varchar(15),

	CONSTRAINT cpfFk FOREIGN KEY (cpf) REFERENCES pessoa(cpf),
	CONSTRAINT terceirizadoPk PRIMARY KEY (cpf)

); 

CREATE TABLE tecnico
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	siape varchar (12),
	unidadeTrabalho varchar(5),

	CONSTRAINT cpfPK PRIMARY KEY (cpf),
	CONSTRAINT cpfFk FOREIGN KEY (cpf) REFERENCES pessoa(cpf),
	CONSTRAINT unidadeTrabalhoFK FOREIGN KEY (unidadeTrabalho) REFERENCES (sigla)


);



CREATE TABLE formulario
(
	id serial NOT NULL,
	tipoRestricao varchar(12),
	dataInicial date,
	dataFinal date,

	CONSTRAINT formPK PRIMARY KEY (id),
);



CREATE TABLE respondeFormulario
(
	cpf varchar(11) NOT NULL,
	idFormulario int NOT NULL,


	CONSTRAINT respFormPk PRIMARY KEY (cpf,idFormulario),
	CONSTRAINT cpfFk FOREIGN KEY (cpf) REFERENCES pessoa(cpf),
	CONSTRAINT idFornFk FOREIGN KEY (idFormulario) REFERENCES formulario (id)



);



CREATE TABLE questoes
(
	id serial NOT NULL,
	pergunta varchar (50),

	CONSTRAINT questoesPk PRIMARY KEY (id)

);

CREATE TABLE questoesFormulario
(
	idFormulario int NOT NULL,
	idQuestoes int NOT NULL,


	CONSTRAINT QuesFormPK PRIMARY KEY (idFormulario,idQuestoes),
	CONSTRAINT idFormularioPK FOREIGN KEY (idFormulario) REFERENCES formulario (id),
	CONSTRAINT idQuestoesPK FOREIGN KEY (idQuestoes) REFERENCES questoes (id)
);

CREATE TABLE respostas
(
	id serial NOT NULL,
	idQuestao int NOT NULL,
	tipoResposta varchar (45),
	conteudo varchar (150),


	CONSTRAINT respostasPk PRIMARY KEY (id, idQuestao),
	CONSTRAINT idQuestoesFk FOREIGN KEY (idQuestao) REFERENCES questoes (id)

);







--date insert  1963-09-01



	--CONSTRAINT contaPk PRIMARY KEY (idConta,nomeAgenciaConta),
	--CONSTRAINT contaNomeAgenciaFk FOREIGN KEY (nomeAgenciaConta) REFERENCES Agencia (nome)

-- se necessario criar usuario e garantir poderes de super user use
--CREATE USER root WITH PASSWORD 'root';
--GRANT ALL PRIVILEGES ON DATABASE "bancodb" to root;
--ALTER USER root WITH SUPERUSER;
