-- 1 Consulta sem nenhuma restrição
-- Quantidade de Alunos no banco;
SELECT COUNT(*) FROM aluno; 

-- 5 Consultas envolvendo 2 ou mais tabelas
-- Pessoas e seus Cursos
SELECT p.nome,a.curso FROM pessoa p INNER JOIN(aluno a INNER JOIN curso c ON c.sigla = a.curso) ON p.cpf = a.cpf;
-- Curso e Unidade Academica
SELECT c.nome,u.nome FROM curso c, unidade u WHERE c.unidade_academica = u.sigla;
--

--

--


-- 2 Consultas com funções de agregação + GROUP BY
-- Quantidade de Aluno por unidade academica
SELECT u.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN unidade u ON u.sigla = a.unidade_academica) ON p.cpf = a.cpf GROUP BY u.nome; 
-- Quantidade de Aluno por curso
SELECT c.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN curso c ON c.sigla = a.curso) ON p.cpf = a.cpf GROUP BY c.nome; 

-- 2 Consultas com funções de agregação + GROUP BY E HAVING
-- 

--
