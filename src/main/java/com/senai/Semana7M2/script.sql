-- Criação da tabela Endereco
CREATE TABLE Endereco (
    ID BIGINT PRIMARY KEY,
    Logradouro VARCHAR(255),
    Estado VARCHAR(50),
    Cidade VARCHAR(100),
    Numero VARCHAR(10),
    CEP VARCHAR(20)
);

-- Criação da tabela Nutricionista
CREATE TABLE Nutricionista (
    ID BIGINT PRIMARY KEY,
    CRN VARCHAR(50),
    Especialidade VARCHAR(100)
);

-- Criação da tabela Paciente
CREATE TABLE Paciente (
    ID BIGINT PRIMARY KEY,
    Nome VARCHAR(255),
    DataNascimento DATE,
    CPF VARCHAR(20),
    Telefone VARCHAR(20),
    Email VARCHAR(255),
    EnderecoID BIGINT,
    FOREIGN KEY (EnderecoID) REFERENCES Endereco(ID)
);

-- Criação da tabela Consulta
CREATE TABLE Consulta (
    ID BIGINT PRIMARY KEY,
    NutricionistaID BIGINT,
    PacienteID BIGINT,
    DataConsulta DATE,
    Observacoes TEXT,
    FOREIGN KEY (NutricionistaID) REFERENCES Nutricionista(ID),
    FOREIGN KEY (PacienteID) REFERENCES Paciente(ID)
);

-- Inserção de registros na tabela Endereco
INSERT INTO Endereco (ID, Logradouro, Estado, Cidade, Numero, CEP) VALUES
(1, 'Rua A', 'SP', 'São Paulo', '100', '01001-000'),
(2, 'Avenida B', 'RJ', 'Rio de Janeiro', '200', '20001-000'),
(3, 'Rua C', 'MG', 'Belo Horizonte', '300', '30001-000');

-- Inserção de registros na tabela Nutricionista
INSERT INTO Nutricionista (ID, CRN, Especialidade) VALUES
(1, 'CRN001', 'Pediatria'),
(2, 'CRN002', 'Esportes'),
(3, 'CRN003', 'Clínica Geral');

-- Inserção de registros na tabela Paciente
INSERT INTO Paciente (ID, Nome, DataNascimento, CPF, Telefone, Email, EnderecoID) VALUES
(1, 'João Silva', '1985-06-15', '123.456.789-00', '11987654321', 'joao.silva@example.com', 1),
(2, 'Maria Souza', '1990-08-25', '987.654.321-00', '21987654321', 'maria.souza@example.com', 2),
(3, 'Carlos Pereira', '1975-12-30', '111.222.333-44', '31987654321', 'carlos.pereira@example.com', 3);

-- Inserção de registros na tabela Consulta
INSERT INTO Consulta (ID, NutricionistaID, PacienteID, DataConsulta, Observacoes) VALUES
(1, 1, 1, '2024-07-10', 'Primeira consulta.'),
(2, 2, 2, '2024-07-11', 'Consulta de retorno.'),
(3, 3, 3, '2024-07-12', 'Revisão dos exames.');

-- Atualização do telefone de um nutricionista
UPDATE Paciente SET Telefone = '21999999999' WHERE ID = 2;

-- Exclusão de um registro da tabela Consulta
DELETE FROM Consulta WHERE ID = 3;

-- Consulta para listar todos os pacientes
SELECT * FROM Paciente;
