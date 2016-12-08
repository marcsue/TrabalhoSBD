﻿CREATE FUNCTION deletarPessoa()
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
