CREATE TABLE "user"
(
    id         UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    user_name  VARCHAR   NOT NULL UNIQUE,
    roles       TEXT[]   NOT NULL,
    password   VARCHAR   NOT NULL,
    email      VARCHAR   NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
CREATE INDEX email_index ON "user" ("id");

CREATE TABLE calendar
(
    id          UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    user_id     UUID      NOT NULL,
    "date"      DATE,
    "recipe_id" UUID,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
);
CREATE INDEX date_index ON calendar("date")