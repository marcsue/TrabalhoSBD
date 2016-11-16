# TrabalhoSBD
Trabalho Final
Considerando o tema base abaixo, elabore novos requisitos para esse banco,
de forma a atender as especificações do Projeto
Sistema de Consulta de Opiniões
Requisitos: Pessoas podem realizar e emitir sua opinião por meio de sistema eletrônico
Das pessoas são armazenados: Nome, CPF, E-Mail Institucional, E-Mail Secundário, Data
Nascimento.
Uma pessoa pode ser professor, aluno, técnico terceirizado. As pessoas participam do sistema
por meio de respostas as questões presentes nos formulários
Professores: SIAPE, Unidade Acadêmica, Regime de Trabalho(Dedicação exclusiva, 20hrs e
40hrs)
Alunos: Nro de Matricula e Curso.
Técnicos: SIAPE e Unidade Administrativa ou Acadêmica.
Terceirizados: Empresa e Setor Atuação(Segurança, Limpeza, etc).
Unidades Acadêmicas: Sigla char(5), Nome e Área de Conhecimento(Exatas, Humanas e
Biológicas).
Curso: Sigla, Nome. Todo curso está vinculado a uma unidade acadêmica.
Unidade Administrativa: Sigla e Nome.
Questões: Descrição da pergunta, ID e possíveis respostas.
Respostas: Id, resposta em formato de texto, falso, verdadeiro, sim, não, abstenção e múltipla
escolha. Nas questões de múltipla escolha podemos escolher uma ou mais opções.
Formulário: Formulário é um conjunto de questões e possui um ID, um nome e a pessoa que o
criou. Um formulário pode ser restrito dependendo do tipo de pessoa que responde o
formulário. Exemplo respondido por professores e alunos, só por aluno, etc.O formulário
possui uma data inicial e uma data final para ser respondido.
Informações sobre o Projeto
O projeto deve conter os seguintes itens:
1 Projeto Conceitual (Modelo Entidade-Relacionamento)
Essa seção deve exibir o esquema conceitual (ou seja, o modelo entidaderelacionamento)
para o problema do “mundo real”, de acordo com a descrição
do problema realizada na Seção 3.
Obs.1: Certifique-se de que o esquema conceitual realmente reflete as
características do sistema sendo modelado. Questões importantes tais como
chaves primárias, atributos de relacionamento, restrições de cardinalidade e de
participação e hierarquias de especialização/generalização devem ser
cuidadosamente verificadas.
Obs.2: O diagrama do esquema conceitual deve seguir, obrigatoriamente, a
mesma notação utilizada nos slides do professor.
2 Projeto Lógico (Modelo Relacional)
Nessa seção deve ser identificado o conjunto de relações que especificam o
banco de dados relacional a ser implementado. Para tanto, deve ser realizado
o mapeamento do esquema conceitual apresentado na Seção 1 para o modelo
relacional.
O mapeamento realizado deve estar de acordo com as regras de mapeamento
discutidas em aula. Em diversas situações, mais do que uma regra de
mapeamento pode ser aplicada ao mesmo conceito, nessas situações discuta
a opção adotada (o porquê, quais eram as outras alternativas e quais as
vantagens da opção adotada). Inclua todas as indicações de restrições de
integridade.
3 Normalização
Essa seção deve, para cada uma das relações especificadas na seção anterior,
identificar se elas encontram-se ou não na 3ª Forma Normal Para tanto, devem
ser realizadas as seguintes tarefas:
• Especificação das dependências funcionais relevantes para o problema.
As dependências funcionais são baseadas na semântica do problema e, 
portanto, devem ser definidas tendo a semântica como princípio, e não as
relações já definidas no esquema lógico;
• Normalização das relações de acordo com as dependências funcionais
definidas.
o Para cada relação a ser normalizada: (i) identifique quais as
dependências funcionais que se aplicam sobre a relação; (ii) justifique
porque a relação não se encontra na forma normal em questão; e (iii)
normalize a relação, especificando as relações originadas;
o Para as relações já normalizadas deve-se mostrar que elas já se
encontram na forma normal desejada.
4 Especificação de Consultas em Álgebra Relacional
(OPCIONAL)
Nessa seção devem ser especificadas dez (10) consultas, as quais devem ser
representadas em álgebra relacional. Será avaliada a utilidade da consulta
frente aos requisitos descritos.
• Antes de cada consulta deve haver uma breve descrição textual da
consulta;
• Pelo menos 5 consultas devem envolver duas ou mais tabelas;
• Pelo menos 2 consultas devem envolver funções de agregação
(COUNT, SUM, MIN, MAX, AVG) com agrupamento (GROUP BY).
5 Implementação do Banco de Dados
Essa seção deve apresentar:
• Criação do Banco de Dados: o script comentado, com os comandos
SQL para a criação do banco de dados, de acordo com o esquema
lógico, para ser executado no PostgreSQL;
• Alimentação Inicial do Banco de Dados: script comentado, com os
comandos SQL para a alimentação inicial do banco de dados, com no
mínimo 5 tuplas por tabela, para ser executado no PostgreSQL;
• Atualização do Banco de Dados: script documentado para ser
executado no PostgreSQL, com os comandos SQL para a atualização
do banco de dados, com operações de:
o inserção (1 operação);
o remoção (3 operações, sendo que pelo menos 1 deve exigir
remoções em mais de uma tabela);
o atualização (3 operações, sendo que pelo menos 1 delas deve
obter o(s) novo(s) valor(es) a serem armazenados a partir de
consulta(s) a outra(s) tabela(s)).
OBS 1. Quando um banco de dados é criado, as tabelas não possuem
instâncias, ou seja, as tabelas estão vazias. Verifiquem que, de acordo com as 
dependências existentes entre os tipos-entidade, algumas tabelas devem ser
povoadas antes do que outras tabelas.
6 Especificação de Consultas em SQL
 Essa seção deve apresentar script documentado, com os comandos para
representar em SQL as consultas escritas em Álgebra Relacional no item
anterior.
Nessa seção devem ser especificadas dez (10) consultas Será avaliada a
utilidade da consulta frente aos requisitos descritos.
• Antes de cada consulta deve haver uma breve descrição textual da
consulta;
• Pelo menos 5 consultas devem envolver duas ou mais tabelas;
• Pelo menos 2 consultas devem envolver funções de agregação
(COUNT, SUM, MIN, MAX, AVG) com agrupamento (GROUP BY).
• Pelo menos 2 consultas devem envolver funções de agregação
(COUNT, SUM, MIN, MAX, AVG) com agrupamento (GROUP BY) e
HAVING
6 Criar um aplicativo para acessar o banco utilizando sua linguagem de
programação de preferência.
Critérios de Avaliação
A presença de todos os integrantes do grupo no desenvolvimento é obrigatória.
O professor poderá descontar nota dos integrantes que não participarem de
cada etapa.
