CREATE TABLE recipe_cleaned
(
    id            UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    title         VARCHAR   NOT NULL,
    url           VARCHAR,
    fsa_fat       VARCHAR,
    fsa_salt      VARCHAR,
    fsa_saturated VARCHAR,
    fsa_sugar     VARCHAR,
    instructions  TEXT[] NOT NULL,
    energy        DOUBLE PRECISION,
    fat           DOUBLE PRECISION,
    protein       DOUBLE PRECISION,
    salt          DOUBLE PRECISION,
    saturated_fat DOUBLE PRECISION,
    sugar         DOUBLE PRECISION,
    PRIMARY KEY (id)
);
