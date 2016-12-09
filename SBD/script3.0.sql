﻿-- MySQL Script generated by MySQL Workbench
-- 07/12/2016 22:50:31
-- Model: ModeloTrabalho    Version: 1.1
--
-- Alunos:
-- Gustavo de Souza Silva
-- Guilherme de Souza Silva
-- Marc Sué
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
--DROP SCHEMA public CASCADE
--CREATE SCHEMA public
-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pessoa (
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(100),
  data_nascimento DATE,
  emaili VARCHAR(100),
  emails VARCHAR(100) NULL,
  tipo_pessoa VARCHAR(45),
  CONSTRAINT pk_pessoa PRIMARY KEY (cpf)
);


-- -----------------------------------------------------
-- Table `mydb`.`formulario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS formulario (
  id SERIAL NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  cpf_criador VARCHAR(11) NOT NULL,
  tipo_restricao INT,
  data_inicial DATE,
  data_final DATE,
  CONSTRAINT form_pk PRIMARY KEY (id),
  CONSTRAINT fk_criador FOREIGN KEY (cpf_criador) REFERENCES pessoa(cpf)	
);


-- -----------------------------------------------------
-- Table `mydb`.`texto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS texto (
  id SERIAL NOT NULL,
  id_form INT NOT NULL,
  pergunta VARCHAR(300),
  CONSTRAINT texto_pk PRIMARY KEY (id),
  CONSTRAINT fk_texto FOREIGN KEY (id_form) REFERENCES formulario(id)
);


-- -----------------------------------------------------
-- Table `mydb`.`mult`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mult (
  id SERIAL NOT NULL,
  id_form INT NOT NULL,
  pergunta VARCHAR(300),
  CONSTRAINT mult_pk PRIMARY KEY (id),
  CONSTRAINT fk_mult FOREIGN KEY (id_form) REFERENCES formulario(id)
);


-- -----------------------------------------------------
-- Table `mydb`.`unidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS unidade (
  sigla CHAR(5) NOT NULL,
  nome VARCHAR(100) ,
  areaconhecimento VARCHAR(100),
  tipo_unidade INT NOT NULL,
  CONSTRAINT uni_pk PRIMARY KEY (sigla)
 );


-- -----------------------------------------------------
-- Table `mydb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS curso (
  sigla CHAR(5) NOT NULL,
  nome VARCHAR(100),
  unidade_academica CHAR(5) NOT NULL,
  CONSTRAINT curso_pk PRIMARY KEY (unidade_academica, sigla),
  CONSTRAINT curso_fk FOREIGN KEY (unidade_academica) REFERENCES unidade(sigla)
);

-- -----------------------------------------------------
-- Table `mydb`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS aluno (
  cpf VARCHAR(11) NOT NULL,
  nro_matricula VARCHAR(25),
  curso CHAR(5) NOT NULL,
  unidade_academica CHAR(5) NOT NULL,
  CONSTRAINT aluno_pk PRIMARY KEY (cpf),
  CONSTRAINT cpf_fk FOREIGN KEY (cpf) REFERENCES pessoa (cpf),
  CONSTRAINT curso_fk FOREIGN KEY (curso,unidade_academica) REFERENCES curso (sigla,unidade_academica)
);


-- -----------------------------------------------------
-- Table `mydb`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS professor (
  cpf VARCHAR(11) NOT NULL,
  siape VARCHAR(50),
  regime_trabalho VARCHAR(45),
  unidade_trabalho CHAR(5),
  CONSTRAINT prof_pk PRIMARY KEY (cpf),
  CONSTRAINT cpf_fk FOREIGN KEY (cpf) REFERENCES pessoa (cpf),
  CONSTRAINT unidade_fk FOREIGN KEY (unidade_trabalho) REFERENCES unidade (sigla)
);


-- -----------------------------------------------------
-- Table `mydb`.`tecnico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tecnico (
  cpf VARCHAR(11) NOT NULL,
  siape VARCHAR(50),
  unidade_trabalho CHAR(5) ,
  CONSTRAINT tec_pk PRIMARY KEY (cpf),
  CONSTRAINT cpf_fk FOREIGN KEY (cpf) REFERENCES pessoa (cpf),
  CONSTRAINT unidade_fk FOREIGN KEY (unidade_trabalho) REFERENCES unidade (sigla)
);


-- -----------------------------------------------------
-- Table `mydb`.`terceirizado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS terceirizado (
  cpf VARCHAR(11) NOT NULL,
  empresa VARCHAR(100),
  setor VARCHAR(45),
  CONSTRAINT terc_pk PRIMARY KEY (cpf),
  CONSTRAINT cpf_fk FOREIGN KEY (cpf) REFERENCES pessoa (cpf)
);


-- -----------------------------------------------------
-- Table `mydb`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS item (
  id SERIAL NOT NULL,
  id_questao INT NOT NULL,
  descri VARCHAR(150),
  CONSTRAINT item_pk PRIMARY KEY (id),
  CONSTRAINT item_fk FOREIGN KEY (id_questao) REFERENCES mult (id)
);


-- -----------------------------------------------------
-- Table `mydb`.`qtexto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS qtexto (
  id_texto INT NOT NULL,
  id_form INT NOT NULL,
  CONSTRAINT pk_qtexto PRIMARY KEY (id_texto, id_form),
  CONSTRAINT fk_texto FOREIGN KEY (id_texto) REFERENCES texto (id),
  CONSTRAINT fk_form FOREIGN KEY (id_form) REFERENCES formulario (id)
);


-- -----------------------------------------------------
-- Table `mydb`.`qmult`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS qmult (
  id_mult INT NOT NULL,
  id_item INT NOT NULL,
  id_form INT NOT NULL,
  CONSTRAINT pk_qmult PRIMARY KEY (id_mult, id_item, id_form),
  CONSTRAINT fk_mult FOREIGN KEY (id_mult) REFERENCES mult (id),
  CONSTRAINT fk_form FOREIGN KEY (id_form) REFERENCES formulario (id),
  CONSTRAINT fk_item FOREIGN KEY (id_item) REFERENCES item (id)
);


-- -----------------------------------------------------
-- Table `mydb`.`rtexto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rtexto (
  id_texto INT NOT NULL,
  id_form INT NOT NULL,
  cpf_pessoa VARCHAR(11) NOT NULL,
  resposta VARCHAR(300) NOT NULL,
  CONSTRAINT rtexto_pk PRIMARY KEY (id_texto, cpf_pessoa, id_form),
  CONSTRAINT fk_qtexto FOREIGN KEY (id_texto , id_form) REFERENCES qtexto (id_texto , id_form),
  CONSTRAINT fk_cpf FOREIGN KEY (cpf_pessoa) REFERENCES pessoa (cpf)
);


-- -----------------------------------------------------
-- Table `mydb`.`rmult`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rmult (
  id_mult INT NOT NULL,
  id_item INT NOT NULL,
  id_form INT NOT NULL,
  cpf_pessoa VARCHAR(45) NOT NULL,
  CONSTRAINT rmult_pk PRIMARY KEY (id_mult, id_item, id_form, cpf_pessoa),
  CONSTRAINT fk_mult FOREIGN KEY (id_mult,id_item,id_form) REFERENCES qmult (id_mult,id_item,id_form),
  CONSTRAINT fk_pessoa FOREIGN KEY (cpf_pessoa) REFERENCES pessoa (cpf)
);

