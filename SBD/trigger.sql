CREATE FUNCTION deletarPessoa()
RETURNS TRIGGER
AS
$$
BEGIN
DELETE FROM pessoa WHERE cpf = OLD.cpf;
RETURN NULL;
END;
$$language 'plpgsql';

CREATE TRIGGER deletaAluno AFTER DELETE ON aluno FOR EACH ROW EXECUTE PROCEDURE deletarPessoa();
CREATE TRIGGER deletaProfessor AFTER DELETE ON professor FOR EACH ROW EXECUTE PROCEDURE deletarPessoa();
CREATE TRIGGER deletaTecnico AFTER DELETE ON tecnico FOR EACH ROW EXECUTE PROCEDURE deletarPessoa();
CREATE TRIGGER deletaTerceiro AFTER DELETE ON terceirizado FOR EACH ROW EXECUTE PROCEDURE deletarPessoa();

/* PENSAR SOBRE A FUNÇÃO
CREATE FUNCTION deletarSubs()
RETURNS TRIGGER
AS
$$
BEGIN
if OLD.tipo_pessoa = 'aluno' THEN
DELETE FROM aluno WHERE cpf = OLD.cpf;
ELSIF OLD.tipo_pessoa = 'professor' THEN
DELETE FROM professor WHERE cpf = OLD.cpf;
ELSIF OLD.tipo_pessoa = 'tecnico' THEN
DELETE FROM tecnico WHERE cpf = OLD.cpf;
ELSE
DELETE FROM terceirizado WHERE cpf = OLD.cpf;
END IF;
RETURN NULL;
END;
$$ language 'plpgsql';
--DROP FUNCTION deletarSubs() CASCADE;
CREATE TRIGGER deletaGer AFTER DELETE ON pessoa FOR EACH ROW EXECUTE PROCEDURE deletarSubs();

SELECT * FROM pessoa;
SELECT * FROM aluno;
DELETE FROM pessoa;
*/