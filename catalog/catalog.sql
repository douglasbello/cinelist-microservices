CREATE TABLE tb_certificates(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	age VARCHAR(20) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_languages(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_genres(
    identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_platforms(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE tb_movies(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	title VARCHAR(80) NOT NULL,
	short_description VARCHAR(255),
	long_description TEXT,
	release_date DATE,
	trailer_url VARCHAR(255),
	thumbnail_url VARCHAR(255),
	certificate_identifier UUID,
	duration VARCHAR(15),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	FOREIGN KEY (certificate_identifier) REFERENCES tb_certificates (identifier)
);

CREATE TABLE tb_movies_genres(
	movie_identifier UUID NOT NULL,
	genre_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (movie_identifier, genre_identifier),
	FOREIGN KEY (movie_identifier) REFERENCES tb_movies (identifier),
	FOREIGN KEY (genre_identifier) REFERENCES tb_genres (identifier)
);

CREATE TABLE tb_movies_languages(
	movie_identifier UUID NOT NULL,
	language_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (movie_identifier, language_identifier),
	FOREIGN KEY (movie_identifier) REFERENCES tb_movies (identifier),
	FOREIGN KEY (language_identifier) REFERENCES tb_languages (identifier)
);

CREATE TABLE tb_movies_platforms(
	movie_identifier UUID NOT NULL,
	platform_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (movie_identifier, platform_identifier),
	FOREIGN KEY (movie_identifier) REFERENCES tb_movies (identifier),
	FOREIGN KEY (platform_identifier) REFERENCES tb_platforms (identifier)
);

CREATE TABLE tb_shows(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	title VARCHAR(80) NOT NULL,
	short_description VARCHAR(255),
	long_description TEXT,
	release_date DATE,
	trailer_url VARCHAR(255),
	thumbnail_url VARCHAR(255),
	certificate_identifier UUID,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	FOREIGN KEY (certificate_identifier) REFERENCES tb_certificates (identifier)
);

CREATE TABLE tb_shows_genres(
	show_identifier UUID NOT NULL,
	genre_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (show_identifier, genre_identifier),
	FOREIGN KEY (show_identifier) REFERENCES tb_shows (identifier),
	FOREIGN KEY (genre_identifier) REFERENCES tb_genres (identifier)
);

CREATE TABLE tb_shows_languages(
	show_identifier UUID NOT NULL,
	language_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (show_identifier, language_identifier),
	FOREIGN KEY (show_identifier) REFERENCES tb_shows (identifier),
	FOREIGN KEY (language_identifier) REFERENCES tb_languages (identifier)
);

CREATE TABLE tb_shows_platforms(
	show_identifier UUID NOT NULL,
	platform_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	PRIMARY KEY (show_identifier, platform_identifier),
	FOREIGN KEY (show_identifier) REFERENCES tb_shows (identifier),
	FOREIGN KEY (platform_identifier) REFERENCES tb_platforms (identifier)
);

CREATE TABLE tb_seasons(
	identifier UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	season INT NOT NULL,
	episodes INT NOT NULL,
	show_identifier UUID NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT NULL,
	FOREIGN KEY (show_identifier) REFERENCES tb_shows (identifier)
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