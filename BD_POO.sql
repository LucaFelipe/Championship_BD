CREATE USER usuario WITH PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE postgres TO usuario;

CREATE TABLE Organizador (
    id serial PRIMARY KEY,
    nomeEvento VARCHAR(100),
    nome VARCHAR(100),
    CPF VARCHAR(11),
    idade INT
);

CREATE TABLE Participante (
    id serial PRIMARY KEY,
    nome VARCHAR(100),
    CPF VARCHAR(11),
    idade INT,
	qtdVitoria INT,
    idOrganizador INT REFERENCES Organizador(id)
);

CREATE TABLE Partida (
    id serial PRIMARY KEY,
    idOrganizador INT REFERENCES Organizador(id),
    idParticipante1 INT REFERENCES Participante(id),
    idParticipante2 INT REFERENCES Participante(id)
);

CREATE TABLE Classificacao (
    id serial PRIMARY KEY,
    posicao INT,
    idParticipante INT REFERENCES Participante(id),
    idOrganizador INT REFERENCES Organizador(id)
);
