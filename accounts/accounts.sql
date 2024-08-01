CREATE TABLE tb_users(
    identifier UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    biography VARCHAR(255) DEFAULT NULL,
	location VARCHAR(255) DEFAULT NULL,
    photo_url VARCHAR(255) DEFAULT NULL,
    birth_date DATE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL
);

CREATE OR REPLACE FUNCTION update_modified_column()
	RETURNS TRIGGER AS $$
	BEGIN NEW.updated_at = clock_timestamp();
	RETURN NEW;
	END;
$$ language 'plpgsql';

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_users FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

INSERT INTO tb_users (identifier, first_name, last_name, username, email, password, biography, location, photo_url, birth_date)
VALUES (gen_random_uuid(), 'John', 'Doe', 'johndoe', 'johndoe@example.com', 'password123', 'Biography', 'Location', 'http://example.com/photo.jpg', '1990-01-01');