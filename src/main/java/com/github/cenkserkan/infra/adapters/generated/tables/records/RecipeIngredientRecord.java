/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables.records;


import com.github.cenkserkan.infra.adapters.generated.tables.RecipeIngredient;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RecipeIngredientRecord extends UpdatableRecordImpl<RecipeIngredientRecord> implements Record5<UUID, UUID, Integer, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.recipe_ingredient.recipe_id</code>.
     */
    public void setRecipeId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.recipe_ingredient.recipe_id</code>.
     */
    public UUID getRecipeId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.recipe_ingredient.ingredient_id</code>.
     */
    public void setIngredientId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.recipe_ingredient.ingredient_id</code>.
     */
    public UUID getIngredientId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.recipe_ingredient.amount</code>.
     */
    public void setAmount(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.recipe_ingredient.amount</code>.
     */
    public Integer getAmount() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.recipe_ingredient.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.recipe_ingredient.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.recipe_ingredient.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.recipe_ingredient.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return RecipeIngredient.RECIPE_INGREDIENT.RECIPE_ID;
    }

    @Override
    public Field<UUID> field2() {
        return RecipeIngredient.RECIPE_INGREDIENT.INGREDIENT_ID;
    }

    @Override
    public Field<Integer> field3() {
        return RecipeIngredient.RECIPE_INGREDIENT.AMOUNT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return RecipeIngredient.RECIPE_INGREDIENT.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return RecipeIngredient.RECIPE_INGREDIENT.UPDATED_AT;
    }

    @Override
    public UUID component1() {
        return getRecipeId();
    }

    @Override
    public UUID component2() {
        return getIngredientId();
    }

    @Override
    public Integer component3() {
        return getAmount();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdatedAt();
    }

    @Override
    public UUID value1() {
        return getRecipeId();
    }

    @Override
    public UUID value2() {
        return getIngredientId();
    }

    @Override
    public Integer value3() {
        return getAmount();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdatedAt();
    }

    @Override
    public RecipeIngredientRecord value1(UUID value) {
        setRecipeId(value);
        return this;
    }

    @Override
    public RecipeIngredientRecord value2(UUID value) {
        setIngredientId(value);
        return this;
    }

    @Override
    public RecipeIngredientRecord value3(Integer value) {
        setAmount(value);
        return this;
    }

    @Override
    public RecipeIngredientRecord value4(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public RecipeIngredientRecord value5(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public RecipeIngredientRecord values(UUID value1, UUID value2, Integer value3, LocalDateTime value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RecipeIngredientRecord
     */
    public RecipeIngredientRecord() {
        super(RecipeIngredient.RECIPE_INGREDIENT);
    }

    /**
     * Create a detached, initialised RecipeIngredientRecord
     */
    public RecipeIngredientRecord(UUID recipeId, UUID ingredientId, Integer amount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(RecipeIngredient.RECIPE_INGREDIENT);

        setRecipeId(recipeId);
        setIngredientId(ingredientId);
        setAmount(amount);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}