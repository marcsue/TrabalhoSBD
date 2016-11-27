CREATE DATABASE bancodb;

CREATE TABLE unidadeAcademica
(
    siglaUAC varchar(5) NOT NULL,
    nome varchar(60),
    areaConhecimento varchar(10),

    CONSTRAINT uacPk PRIMARY KEY (siglaUAC)

);


CREATE TABLE curso 
(
    sigla varchar(3) NOT NULL, 
    nome varchar(60),
    unidadeAC varchar(5),
  
    CONSTRAINT cursoPk PRIMARY KEY (sigla),
    CONSTRAINT cursoFk FOREIGN KEY (unidadeAC) REFERENCES unidadeAcademica (siglaUAC)
    
);


CREATE TABLE unidadeAdministrativa
(
	siglaUADM varchar(5) NOT NULL,
    nome varchar(60),
    areaConhecimento varchar(10),

    CONSTRAINT siglaUADM PRIMARY KEY (siglaUADM)

);


CREATE TABLE aluno
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	emailInstitucional varchar (30),
	emailSecundario varchar (30),
	dataNascimento date,
	matricula varchar(11),
	siglaCurso varchar(3),

	CONSTRAINT alunoPk PRIMARY KEY (cpf),
	CONSTRAINT alunoFk FOREIGN KEY (siglaCurso) REFERENCES curso (sigla)

);



CREATE TABLE professor
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	emailInstitucional varchar (30),
	emailSecundario varchar (30),
	dataNascimento date,
	siape varchar (12),
	regimeTrabalho varchar (3),
	siglaUAC varchar(5),

	CONSTRAINT profPk PRIMARY KEY (cpf),
	CONSTRAINT profFk FOREIGN KEY (siglaUAC) REFERENCES unidadeAcademica (siglaUAC)

); 


CREATE TABLE terceirizado
(
	cpf varchar(11) NOT NULL,
	nome varchar(60),
	emailInstitucional varchar (30),
	emailSecundario varchar (30),
	dataNascimento date,
	empresa varchar (20),
	setor varchar(15),

	CONSTRAINT terceirizadoPk PRIMARY KEY (cpf)

); 



--date insert  1963-09-01



	--CONSTRAINT contaPk PRIMARY KEY (idConta,nomeAgenciaConta),
	--CONSTRAINT contaNomeAgenciaFk FOREIGN KEY (nomeAgenciaConta) REFERENCES Agencia (nome)

-- se necessario criar usuario e garantir poderes de super user use
--CREATE USER root WITH PASSWORD 'root';
--GRANT ALL PRIVILEGES ON DATABASE "bancodb" to root;
--ALTER USER root WITH SUPERUSER;
