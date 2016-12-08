-- 1 Consulta sem nenhuma restrição
-- Quantidade de Alunos no banco;
SELECT COUNT(*) FROM aluno; 

-- 5 Consultas envolvendo 2 ou mais tabelas
-- Pessoas e seus Cursos
SELECT p.nome,a.curso FROM pessoa p INNER JOIN(aluno a INNER JOIN curso c ON c.sigla = a.curso) ON p.cpf = a.cpf;
-- Curso e Unidade Academica
SELECT c.nome,u.nome FROM curso c, unidade u WHERE c.unidade_academica = u.sigla;
-- Professor e unidade academica em que ele trabalha
SELECT p.nome,u.nome FROM pessoa p INNER JOIN(professor pr INNER JOIN unidade u ON u.sigla = pr.unidade_trabalho) ON p.cpf = pr.cpf;
-- Quantidade de professores por regime de trabalho
SELECT pr.regime_trabalho,COUNT(p.nome) FROM pessoa p,professor pr WHERE p.cpf = pr.cpf GROUP BY pr.regime_trabalho;
-- Técnicos e suas unidades de trabalho
SELECT p.nome,u.nome FROM pessoa p INNER JOIN(tecnico t INNER JOIN unidade u ON u.sigla = t.unidade_trabalho) ON p.cpf = t.cpf;

-- 2 Consultas com funções de agregação + GROUP BY
-- Quantidade de Alunos por unidade academica
SELECT u.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN unidade u ON u.sigla = a.unidade_academica) ON p.cpf = a.cpf GROUP BY u.nome; 
-- Quantidade de Alunos por curso
SELECT c.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN curso c ON c.sigla = a.curso) ON p.cpf = a.cpf GROUP BY c.nome; 

-- 2 Consultas com funções de agregação + GROUP BY E HAVING
-- Quantidade de Alunos por unidade academica sendo que somente mostra se a unidade for relevante (tiver mais de um aluno)
SELECT u.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN unidade u ON u.sigla = a.unidade_academica) ON p.cpf = a.cpf GROUP BY u.nome HAVING Count(p.nome) > 1; 
-- Quantidade de Alunos por curso  sendo que somente mostra se a unidade for relevante (tiver mais de um aluno)
SELECT c.nome,COUNT(p.nome) FROM pessoa p INNER JOIN (aluno a INNER JOIN curso c ON c.sigla = a.curso) ON p.cpf = a.cpf GROUP BY c.nome HAVING Count(p.nome) > 1; 