CREATE TABLE ingredient
(
    id            UUID             NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP        NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP        NOT NULL DEFAULT NOW(),
    name          VARCHAR          NOT NULL UNIQUE,
    tags          VARCHAR[] NOT NULL,
    fat           DOUBLE PRECISION NOT NULL,
    energy        DOUBLE PRECISION NOT NULL,
    protein       DOUBLE PRECISION NOT NULL,
    saturated_fat DOUBLE PRECISION NOT NULL,
    salt          DOUBLE PRECISION NOT NULL,
    sugar         DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipe
(
    id            UUID             NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP        NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP        NOT NULL DEFAULT NOW(),
    title         VARCHAR          NOT NULL,
    url           VARCHAR          NOT NULL,
    fsa_fat       VARCHAR          NOT NULL,
    fsa_salt      VARCHAR          NOT NULL,
    fsa_saturated VARCHAR          NOT NULL,
    fsa_sugar     VARCHAR          NOT NULL,
    instructions  TEXT[] NOT NULL,
    energy        DOUBLE PRECISION NOT NULL,
    fat           DOUBLE PRECISION NOT NULL,
    protein       DOUBLE PRECISION NOT NULL,
    salt          DOUBLE PRECISION NOT NULL,
    saturated_fat DOUBLE PRECISION NOT NULL,
    sugar         DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipe_ingredient
(
    recipe_id      UUID,
    ingredient_id  UUID,
    quantity       INT NOT NULL,
    unit           VARCHAR NOT NULL,
    weight_in_gram INT NOT NULL,
    created_at     TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE recipe_image
(
    recipe_id  UUID,
    url        VARCHAR   NOT NULL,
    priority   INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, url)
);
