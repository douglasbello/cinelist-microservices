CREATE TABLE tb_occupations(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	name VARCHAR(255),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_cast(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	first_name VARCHAR(70) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	birth_date DATE,
	photo_url VARCHAR(255),
	occupation_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	FOREIGN KEY (occupation_identifier) REFERENCES tb_occupations (identifier)
)

CREATE OR REPLACE FUNCTION update_modified_column()
	RETURNS TRIGGER AS $$
	BEGIN NEW.updated_at = clock_timestamp();
	RETURN NEW;
	END;
$$ language 'plpgsql';

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_occupations FOR EACH ROW EXECUTE PROCEDURE update_modified_column()

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_cast FOR EACH ROW EXECUTE PROCEDURE update_modified_column()