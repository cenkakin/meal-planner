CREATE TABLE ingredient
(
    id            UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    name          VARCHAR   NOT NULL,
    tags          VARCHAR[],
    fat           VARCHAR,
    energy        VARCHAR,
    protein       VARCHAR,
    saturated_fat VARCHAR,
    salt          VARCHAR,
    sugar         VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE recipe
(
    id            UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    title         VARCHAR,
    url           VARCHAR,
    fsa_fat       VARCHAR,
    fsa_salt      VARCHAR,
    fsa_saturated VARCHAR,
    fsa_sugar     VARCHAR,
    instructions  TEXT[],
    energy        VARCHAR,
    fat           VARCHAR,
    protein       VARCHAR,
    salt          VARCHAR,
    saturated_fat VARCHAR,
    sugar         VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE recipe_ingredient
(
    recipe_id      UUID,
    ingredient_id  UUID,
    quantity       INT,
    unit           VARCHAR,
    weight_in_gram INT,
    created_at     TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE recipe_photo
(
    recipe_id  UUID,
    url        VARCHAR,
    priority   INT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, url)
);
