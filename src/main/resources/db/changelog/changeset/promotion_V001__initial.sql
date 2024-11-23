CREATE TABLE updates (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    updates_count bigint NOT NULL
);