CREATE TABLE ingredient
(
    id            UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    name          VARCHAR   NOT NULL UNIQUE,
    tags          VARCHAR[],
    fat           DOUBLE PRECISION,
    energy        DOUBLE PRECISION,
    protein       DOUBLE PRECISION,
    saturated_fat DOUBLE PRECISION,
    salt          DOUBLE PRECISION,
    sugar         DOUBLE PRECISION,
    PRIMARY KEY (id)
);

CREATE TABLE recipe
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

CREATE INDEX title_index ON recipe ("title");

CREATE TABLE recipe_ingredient
(
    recipe_id      UUID,
    ingredient_id  UUID,
    quantity       VARCHAR          NOT NULL,
    unit           VARCHAR          NOT NULL,
    weight_in_gram DOUBLE PRECISION NOT NULL,
    created_at     TIMESTAMP        NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMP        NOT NULL DEFAULT NOW()
);

CREATE INDEX recipe_id_index ON recipe_ingredient ("recipe_id");
CREATE INDEX ingredient_id_index ON recipe_ingredient ("ingredient_id");

CREATE TABLE recipe_image
(
    recipe_id  UUID,
    url        VARCHAR   NOT NULL,
    priority   INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, url)
);
