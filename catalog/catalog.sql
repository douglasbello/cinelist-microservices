CREATE TABLE tb_certificates(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	age VARCHAR(20) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_languages(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	name VARCHAR(20) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_genres(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	name VARCHAR(40) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_platforms(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	name VARCHAR(50) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_movies(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	title VARCHAR(80) NOT NULL,
	short_description VARCHAR(255),
	long_description TEXT,
	release_date DATE,
	trailer_url VARCHAR(255),
	thumbnail_url VARCHAR(255),
	certificate_identifier UUID,
	duration VARCHAR(15),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_movies_genres(
	id SERIAL NOT NULL PRIMARY KEY,
	movie_identifier UUID NOT NULL,
	genre_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_movies_languages(
	id SERIAL NOT NULL PRIMARY KEY,
	movie_identifier UUID NOT NULL,
	genre_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_movies_platforms(
	id SERIAL NOT NULL PRIMARY KEY,
	movie_identifier UUID NOT NULL,
	platform_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_shows(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	title VARCHAR(80) NOT NULL,
	short_description VARCHAR(255),
	long_description TEXT,
	release_date DATE,
	trailer_url VARCHAR(255),
	thumbnail_url VARCHAR(255),
	certificate_identifier UUID,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_shows_genres(
	id SERIAL NOT NULL PRIMARY KEY,
	show_identifier UUID NOT NULL,
	genre_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_shows_languages(
	id SERIAL NOT NULL PRIMARY KEY,
	show_identifier UUID NOT NULL,
	language_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_shows_platforms(
	id SERIAL NOT NULL PRIMARY KEY,
	show_identifier UUID NOT NULL,
	platform_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_seasons(
	id SERIAL NOT NULL PRIMARY KEY,
	identifier UUID NOT NULL,
	season INT NOT NULL,
	episodes INT NOT NULL,
	show_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE OR REPLACE FUNCTION update_modified_column()
	RETURNS TRIGGER AS $$
	BEGIN NEW.updated_at = clock_timestamp();
	RETURN NEW;
	END;
$$ language 'plpgsql';

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_certificates FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_languages FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_genres FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_platforms FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_movies FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_movies_languages FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_movies_platforms FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_movies_genres FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_seasons FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_shows FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_shows_genres FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_shows_languages FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

CREATE TRIGGER update_modified_time BEFORE UPDATE ON tb_shows_platforms FOR EACH ROW EXECUTE PROCEDURE update_modified_column();