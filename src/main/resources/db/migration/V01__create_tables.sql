CREATE TABLE ingredient
(
    id         UUID      NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    name       VARCHAR   NOT NULL,
    type       VARCHAR   NOT NULL,
    unit       VARCHAR   NOT NULL,
    weight     INT       NOT NULL,
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

CREATE TABLE recipe_ingredient
(
    recipe_id     UUID      NOT NULL,
    ingredient_id UUID      NOT NULL,
    amount        INT       NOT NULL,
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (recipe_id, ingredient_id)
);

INSERT INTO ingredient ("id", "created_at", "updated_at", "name", "type", "unit", "weight")
VALUES
    ('01ec31c8-c33b-4b69-b27e-9db01b1ff14b', '2023-02-05 18:33:36.93346',	'2023-02-05 18:33:36.93346',	'onion',	'vegetable',	'piece',	50),
    ('05b805d5-e436-4a38-9cd3-fba8ccda6339', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'eggs',	'dairy',	'piece',	10),
    ('5365b5ce-c7f4-4831-acc9-1040ac9e81a4', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'tomatoes',	'vegetable',	'piece',	50),
    ('788380d4-d7e1-4eb3-8e43-8c7cd1d6cc12', '2023-02-05 18:35:04.00877',	'2023-02-05 18:35:04.00877',	'butter',	'dairy',	'gram',	1),
    ('88214e07-d07f-48d1-b780-8873b7e2e160', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'flour',	'pantry',	'gram',	1),
    ('95c8e816-4277-4339-a41a-a03165427654', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'potato',	'vegetable',	'piece',	25),
    ('ff4e5d48-4622-4230-9301-e545601f3be6', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'water',	'vegetable',	'gram',	1),
    ('eec7df81-d0ea-4c98-b0ad-b12f46d3075f', '2023-02-05 20:13:16.958131',	'2023-02-05 20:13:16.958131',	'sugar',	'pantry',	'gram',	1);

INSERT INTO recipe ("id", "created_at", "updated_at", "name", "cuisine")
VALUES
    ('941842bd-4716-4252-aabd-79a7bd419267',	'2023-02-05 20:13:18.871002',	'2023-02-05 20:13:18.871002',	'Franz Brötchen', 'German'),
    ('a5a14e5b-64fd-4bb8-8c4a-d17db47506de',	'2023-02-05 20:13:18.871002',	'2023-02-05 20:13:18.871002',	'Menemen',	'Turkish'),
    ('aa74a71f-2aa8-4589-8194-a848ed0b7474',	'2023-02-05 20:13:18.871002',	'2023-02-05 20:13:18.871002',	'Steak',	'American'),
    ('ff7bcc42-1d86-46df-8eb3-3d831f95b5ee',	'2023-02-05 20:13:18.871002',	'2023-02-05 20:13:18.871002',	'Omelette',	'French');

INSERT INTO recipe_ingredient ("recipe_id", "ingredient_id", "amount", "created_at", "updated_at")
VALUES
    ('a5a14e5b-64fd-4bb8-8c4a-d17db47506de', '5365b5ce-c7f4-4831-acc9-1040ac9e81a4', 2, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('a5a14e5b-64fd-4bb8-8c4a-d17db47506de', '05b805d5-e436-4a38-9cd3-fba8ccda6339', 1, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('ff7bcc42-1d86-46df-8eb3-3d831f95b5ee', '05b805d5-e436-4a38-9cd3-fba8ccda6339', 2, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('ff7bcc42-1d86-46df-8eb3-3d831f95b5ee', '788380d4-d7e1-4eb3-8e43-8c7cd1d6cc12', 30, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('941842bd-4716-4252-aabd-79a7bd419267', 'eec7df81-d0ea-4c98-b0ad-b12f46d3075f', 50, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('941842bd-4716-4252-aabd-79a7bd419267', '88214e07-d07f-48d1-b780-8873b7e2e160', 200, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' ),
    ('941842bd-4716-4252-aabd-79a7bd419267', 'ff4e5d48-4622-4230-9301-e545601f3be6', 100, '2023-02-05 20:13:18.871002', '2023-02-05 20:13:18.871002' );
