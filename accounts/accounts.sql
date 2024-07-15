CREATE TABLE tb_users(
    pk INT NOT NULL PRIMARY KEY,
    identifier UUID NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    biography VARCHAR(255) DEFAULT NULL,
    photo_url VARCHAR(255) DEFAULT NULL,
    birth_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    updated_at TIMESTAMP DEFAULT NULL,
)