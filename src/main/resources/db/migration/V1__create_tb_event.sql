CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    identificador VARCHAR(50) NOT NULL UNIQUE,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NOT NULL,
    location VARCHAR(200) NOT NULL,
    organizer VARCHAR(150) NOT NULL,
    enumtype VARCHAR(30) NOT NULL
);