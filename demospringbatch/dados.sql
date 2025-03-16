-- Criar os schemas
CREATE SCHEMA IF NOT EXISTS schema1;
CREATE SCHEMA IF NOT EXISTS schema2;

-- Criar as tabelas no schema1
CREATE TABLE IF NOT EXISTS schema1.status_oferta (
    id_status_oferta INT PRIMARY KEY,
    descricao_status_oferta VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS schema1.oferta (
    id_oferta UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    descricao VARCHAR(255) NOT NULL,
    id_status_oferta INT REFERENCES schema1.status_oferta(id_status_oferta) ON DELETE CASCADE
);

-- Criar as tabelas no schema2
CREATE TABLE IF NOT EXISTS schema2.status_oferta (
    id_status_oferta INT PRIMARY KEY,
    descricao_status_oferta VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS schema2.oferta (
    id_oferta UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    descricao VARCHAR(255) NOT NULL,
    id_status_oferta INT REFERENCES schema2.status_oferta(id_status_oferta) ON DELETE CASCADE
);

-- ==============================
-- Inserir dados no schema1
-- ==============================

-- Inserir dados na tabela status_oferta no schema1
INSERT INTO schema1.status_oferta (id_status_oferta, descricao_status_oferta)
VALUES
    (1, 'ATIVO'),
    (2, 'INATIVO'),
    (3, 'EXPIRADO');

-- Inserir dados na tabela oferta no schema1
INSERT INTO schema1.oferta (descricao, id_status_oferta)
VALUES
    ('Oferta A schema1', 1),
    ('Oferta B schema1', 2),
    ('Oferta C schema1', 3),
    ('Oferta D schema1', 1),
    ('Oferta E schema1', 2),
    ('Oferta F schema1', 3);

-- ==============================
-- Inserir dados no schema2
-- ==============================

-- Inserir dados na tabela status_oferta no schema2
INSERT INTO schema2.status_oferta (id_status_oferta, descricao_status_oferta)
VALUES
    (1, 'ATIVO'),
    (2, 'INATIVO'),
    (3, 'EXPIRADO');

-- Inserir dados na tabela oferta no schema2
INSERT INTO schema2.oferta (descricao, id_status_oferta)
VALUES
    ('Oferta A schema2', 1),
    ('Oferta B schema2', 2),
    ('Oferta C schema2', 3),
    ('Oferta D schema2', 1),
    ('Oferta E schema2', 2),
    ('Oferta F schema2', 3);
