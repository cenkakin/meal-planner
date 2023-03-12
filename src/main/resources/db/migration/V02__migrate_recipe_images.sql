CREATE TABLE recipe_image_cleaned
(
    id         UUID      NOT NULL DEFAULT gen_random_uuid(),
    recipe_id  UUID,
    url        VARCHAR   NOT NULL,
    priority   INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id)
);
CREATE INDEX recipe_image_id_index ON recipe_image_cleaned("recipe_id")
