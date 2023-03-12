/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables.records;


import com.github.cenkserkan.infra.adapters.generated.tables.RecipeImageCleaned;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RecipeImageCleanedRecord extends UpdatableRecordImpl<RecipeImageCleanedRecord> implements Record6<UUID, UUID, String, Integer, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.recipe_image_cleaned.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.recipe_image_cleaned.recipe_id</code>.
     */
    public void setRecipeId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.recipe_id</code>.
     */
    public UUID getRecipeId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.recipe_image_cleaned.url</code>.
     */
    public void setUrl(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.url</code>.
     */
    public String getUrl() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.recipe_image_cleaned.priority</code>.
     */
    public void setPriority(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.priority</code>.
     */
    public Integer getPriority() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.recipe_image_cleaned.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.recipe_image_cleaned.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.recipe_image_cleaned.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, UUID, String, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<UUID, UUID, String, Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.ID;
    }

    @Override
    public Field<UUID> field2() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.RECIPE_ID;
    }

    @Override
    public Field<String> field3() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.URL;
    }

    @Override
    public Field<Integer> field4() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.PRIORITY;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return RecipeImageCleaned.RECIPE_IMAGE_CLEANED.UPDATED_AT;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public UUID component2() {
        return getRecipeId();
    }

    @Override
    public String component3() {
        return getUrl();
    }

    @Override
    public Integer component4() {
        return getPriority();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public UUID value2() {
        return getRecipeId();
    }

    @Override
    public String value3() {
        return getUrl();
    }

    @Override
    public Integer value4() {
        return getPriority();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public RecipeImageCleanedRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord value2(UUID value) {
        setRecipeId(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord value3(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord value4(Integer value) {
        setPriority(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public RecipeImageCleanedRecord values(UUID value1, UUID value2, String value3, Integer value4, LocalDateTime value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RecipeImageCleanedRecord
     */
    public RecipeImageCleanedRecord() {
        super(RecipeImageCleaned.RECIPE_IMAGE_CLEANED);
    }

    /**
     * Create a detached, initialised RecipeImageCleanedRecord
     */
    public RecipeImageCleanedRecord(UUID id, UUID recipeId, String url, Integer priority, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(RecipeImageCleaned.RECIPE_IMAGE_CLEANED);

        setId(id);
        setRecipeId(recipeId);
        setUrl(url);
        setPriority(priority);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}
