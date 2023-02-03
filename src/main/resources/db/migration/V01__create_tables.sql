CREATE TABLE ingredient
(
    id         UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    name       VARCHAR   NOT NULL,
    type       VARCHAR   NOT NULL,
    unit       VARCHAR   NOT NULL,
    weight     VARCHAR   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipe
(
    id         UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    name       VARCHAR   NOT NULL,
    cuisine    VARCHAR   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipe_ingredients
(
    recipe_id     UUID      NOT NULL,
    ingredient_id UUID      NOT NULL,
    count         INT       NOT NULL,
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, ingredient_id)
);
