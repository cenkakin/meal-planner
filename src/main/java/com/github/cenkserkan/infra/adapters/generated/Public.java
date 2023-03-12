/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated;


import com.github.cenkserkan.infra.adapters.generated.tables.Ingredient;
import com.github.cenkserkan.infra.adapters.generated.tables.Recipe;
import com.github.cenkserkan.infra.adapters.generated.tables.RecipeCleaned;
import com.github.cenkserkan.infra.adapters.generated.tables.RecipeImage;
import com.github.cenkserkan.infra.adapters.generated.tables.RecipeImageCleaned;
import com.github.cenkserkan.infra.adapters.generated.tables.RecipeIngredient;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.ingredient</code>.
     */
    public final Ingredient INGREDIENT = Ingredient.INGREDIENT;

    /**
     * The table <code>public.recipe</code>.
     */
    public final Recipe RECIPE = Recipe.RECIPE;

    /**
     * The table <code>public.recipe_cleaned</code>.
     */
    public final RecipeCleaned RECIPE_CLEANED = RecipeCleaned.RECIPE_CLEANED;

    /**
     * The table <code>public.recipe_image</code>.
     */
    public final RecipeImage RECIPE_IMAGE = RecipeImage.RECIPE_IMAGE;

    /**
     * The table <code>public.recipe_image_cleaned</code>.
     */
    public final RecipeImageCleaned RECIPE_IMAGE_CLEANED = RecipeImageCleaned.RECIPE_IMAGE_CLEANED;

    /**
     * The table <code>public.recipe_ingredient</code>.
     */
    public final RecipeIngredient RECIPE_INGREDIENT = RecipeIngredient.RECIPE_INGREDIENT;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Ingredient.INGREDIENT,
            Recipe.RECIPE,
            RecipeCleaned.RECIPE_CLEANED,
            RecipeImage.RECIPE_IMAGE,
            RecipeImageCleaned.RECIPE_IMAGE_CLEANED,
            RecipeIngredient.RECIPE_INGREDIENT
        );
    }
}
