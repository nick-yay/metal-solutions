CREATE TABLE funcionarios (
    id BIGSERIAL PRIMARY KEY,
    salario DECIMAL(10, 2) NOT NULL,
    nome VARCHAR(150) NOT NULL,
    turno VARCHAR(10) NOT NULL,  -- MANHA, TARDE, NOITE
    cpf VARCHAR(14) NOT NULL UNIQUE,
    cargo VARCHAR(100) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rh (
    funcionario_id BIGINT PRIMARY KEY,
    nivel_acesso VARCHAR(20) NOT NULL DEFAULT 'BAIXO',  -- BAIXO, INTERMEDIARIO, ALTO
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);

CREATE TABLE ajudante_geral (
    funcionario_id BIGINT PRIMARY KEY,
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);

CREATE TABLE qualificacoes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao TEXT
);

CREATE TABLE ajudante_qualificacao (
    ajudante_id BIGINT NOT NULL,
    qualificacao_id BIGINT NOT NULL,
    PRIMARY KEY (ajudante_id, qualificacao_id),
    CONSTRAINT fk_ajudante FOREIGN KEY (ajudante_id) REFERENCES ajudante_geral(funcionario_id) ON DELETE CASCADE,
    CONSTRAINT fk_qualificacao FOREIGN KEY (qualificacao_id) REFERENCES qualificacoes(id) ON DELETE CASCADE
);

CREATE TABLE ordens_producao (
    funcionario_id BIGINT PRIMARY KEY,
    descricao TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDENTE',  -- PENDENTE, EM_ANDAMENTO, CONCLUIDO, CANCELADO
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE etapas_processo (
    id BIGSERIAL PRIMARY KEY,
    ordem_producao_id BIGINT NOT NULL,
    sequencia INT NOT NULL,
    nome_etapa VARCHAR(100) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDENTE', -- PENDENTE, EM_ANDAMENTO, CONCLUIDO, CANCELADO
    inicio_etapa TIMESTAMP,
    fim_etapa TIMESTAMP,
    funcionario_id BIGINT,
    CONSTRAINT fk_ordem_producao FOREIGN KEY (ordem_producao_id) REFERENCES ordens_producao(id),
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);