CREATE DATABASE bancodb;

CREATE TABLE unidadeAcademica
(
	siglaUA varchar(5) NOT NULL,
    nome varchar(60),
    areaConhecimento varchar(10),

    CONSTRAINT siglaUA PRIMARY KEY (siglaUA)

);


CREATE TABLE curso (
    siglaC varchar(5) NOT NULL, 
    nome varchar(60),
    unidade varchar(5),
  
    CONSTRAINT cursoPk PRIMARY KEY (siglaC),
    CONSTRAINT cursoFk FOREIGN KEY (unidade) REFERENCES unidadeAcademica (siglaUA)
    
);



	--CONSTRAINT contaPk PRIMARY KEY (idConta,nomeAgenciaConta),
	--CONSTRAINT contaNomeAgenciaFk FOREIGN KEY (nomeAgenciaConta) REFERENCES Agencia (nome)

-- se necessario criar usuario e garantir poderes de super user use
--CREATE USER root WITH PASSWORD 'root';
--GRANT ALL PRIVILEGES ON DATABASE "bancodb" to root;
--ALTER USER root WITH SUPERUSER;
