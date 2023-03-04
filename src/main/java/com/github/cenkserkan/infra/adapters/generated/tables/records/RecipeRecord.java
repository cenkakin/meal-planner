/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables.records;


import com.github.cenkserkan.infra.adapters.generated.tables.Recipe;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RecipeRecord extends UpdatableRecordImpl<RecipeRecord> implements Record16<UUID, LocalDateTime, LocalDateTime, String, String, String, String, String, String, String[], Double, Double, Double, Double, Double, Double> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.recipe.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.recipe.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.recipe.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.recipe.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.recipe.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.recipe.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.recipe.title</code>.
     */
    public void setTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.recipe.title</code>.
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.recipe.url</code>.
     */
    public void setUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.recipe.url</code>.
     */
    public String getUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.recipe.fsa_fat</code>.
     */
    public void setFsaFat(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.recipe.fsa_fat</code>.
     */
    public String getFsaFat() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.recipe.fsa_salt</code>.
     */
    public void setFsaSalt(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.recipe.fsa_salt</code>.
     */
    public String getFsaSalt() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.recipe.fsa_saturated</code>.
     */
    public void setFsaSaturated(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.recipe.fsa_saturated</code>.
     */
    public String getFsaSaturated() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.recipe.fsa_sugar</code>.
     */
    public void setFsaSugar(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.recipe.fsa_sugar</code>.
     */
    public String getFsaSugar() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.recipe.instructions</code>.
     */
    public void setInstructions(String[] value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.recipe.instructions</code>.
     */
    public String[] getInstructions() {
        return (String[]) get(9);
    }

    /**
     * Setter for <code>public.recipe.energy</code>.
     */
    public void setEnergy(Double value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.recipe.energy</code>.
     */
    public Double getEnergy() {
        return (Double) get(10);
    }

    /**
     * Setter for <code>public.recipe.fat</code>.
     */
    public void setFat(Double value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.recipe.fat</code>.
     */
    public Double getFat() {
        return (Double) get(11);
    }

    /**
     * Setter for <code>public.recipe.protein</code>.
     */
    public void setProtein(Double value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.recipe.protein</code>.
     */
    public Double getProtein() {
        return (Double) get(12);
    }

    /**
     * Setter for <code>public.recipe.salt</code>.
     */
    public void setSalt(Double value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.recipe.salt</code>.
     */
    public Double getSalt() {
        return (Double) get(13);
    }

    /**
     * Setter for <code>public.recipe.saturated_fat</code>.
     */
    public void setSaturatedFat(Double value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.recipe.saturated_fat</code>.
     */
    public Double getSaturatedFat() {
        return (Double) get(14);
    }

    /**
     * Setter for <code>public.recipe.sugar</code>.
     */
    public void setSugar(Double value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.recipe.sugar</code>.
     */
    public Double getSugar() {
        return (Double) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<UUID, LocalDateTime, LocalDateTime, String, String, String, String, String, String, String[], Double, Double, Double, Double, Double, Double> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<UUID, LocalDateTime, LocalDateTime, String, String, String, String, String, String, String[], Double, Double, Double, Double, Double, Double> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Recipe.RECIPE.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Recipe.RECIPE.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Recipe.RECIPE.UPDATED_AT;
    }

    @Override
    public Field<String> field4() {
        return Recipe.RECIPE.TITLE;
    }

    @Override
    public Field<String> field5() {
        return Recipe.RECIPE.URL;
    }

    @Override
    public Field<String> field6() {
        return Recipe.RECIPE.FSA_FAT;
    }

    @Override
    public Field<String> field7() {
        return Recipe.RECIPE.FSA_SALT;
    }

    @Override
    public Field<String> field8() {
        return Recipe.RECIPE.FSA_SATURATED;
    }

    @Override
    public Field<String> field9() {
        return Recipe.RECIPE.FSA_SUGAR;
    }

    @Override
    public Field<String[]> field10() {
        return Recipe.RECIPE.INSTRUCTIONS;
    }

    @Override
    public Field<Double> field11() {
        return Recipe.RECIPE.ENERGY;
    }

    @Override
    public Field<Double> field12() {
        return Recipe.RECIPE.FAT;
    }

    @Override
    public Field<Double> field13() {
        return Recipe.RECIPE.PROTEIN;
    }

    @Override
    public Field<Double> field14() {
        return Recipe.RECIPE.SALT;
    }

    @Override
    public Field<Double> field15() {
        return Recipe.RECIPE.SATURATED_FAT;
    }

    @Override
    public Field<Double> field16() {
        return Recipe.RECIPE.SUGAR;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component3() {
        return getUpdatedAt();
    }

    @Override
    public String component4() {
        return getTitle();
    }

    @Override
    public String component5() {
        return getUrl();
    }

    @Override
    public String component6() {
        return getFsaFat();
    }

    @Override
    public String component7() {
        return getFsaSalt();
    }

    @Override
    public String component8() {
        return getFsaSaturated();
    }

    @Override
    public String component9() {
        return getFsaSugar();
    }

    @Override
    public String[] component10() {
        return getInstructions();
    }

    @Override
    public Double component11() {
        return getEnergy();
    }

    @Override
    public Double component12() {
        return getFat();
    }

    @Override
    public Double component13() {
        return getProtein();
    }

    @Override
    public Double component14() {
        return getSalt();
    }

    @Override
    public Double component15() {
        return getSaturatedFat();
    }

    @Override
    public Double component16() {
        return getSugar();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value3() {
        return getUpdatedAt();
    }

    @Override
    public String value4() {
        return getTitle();
    }

    @Override
    public String value5() {
        return getUrl();
    }

    @Override
    public String value6() {
        return getFsaFat();
    }

    @Override
    public String value7() {
        return getFsaSalt();
    }

    @Override
    public String value8() {
        return getFsaSaturated();
    }

    @Override
    public String value9() {
        return getFsaSugar();
    }

    @Override
    public String[] value10() {
        return getInstructions();
    }

    @Override
    public Double value11() {
        return getEnergy();
    }

    @Override
    public Double value12() {
        return getFat();
    }

    @Override
    public Double value13() {
        return getProtein();
    }

    @Override
    public Double value14() {
        return getSalt();
    }

    @Override
    public Double value15() {
        return getSaturatedFat();
    }

    @Override
    public Double value16() {
        return getSugar();
    }

    @Override
    public RecipeRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public RecipeRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public RecipeRecord value3(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public RecipeRecord value4(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public RecipeRecord value5(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public RecipeRecord value6(String value) {
        setFsaFat(value);
        return this;
    }

    @Override
    public RecipeRecord value7(String value) {
        setFsaSalt(value);
        return this;
    }

    @Override
    public RecipeRecord value8(String value) {
        setFsaSaturated(value);
        return this;
    }

    @Override
    public RecipeRecord value9(String value) {
        setFsaSugar(value);
        return this;
    }

    @Override
    public RecipeRecord value10(String[] value) {
        setInstructions(value);
        return this;
    }

    @Override
    public RecipeRecord value11(Double value) {
        setEnergy(value);
        return this;
    }

    @Override
    public RecipeRecord value12(Double value) {
        setFat(value);
        return this;
    }

    @Override
    public RecipeRecord value13(Double value) {
        setProtein(value);
        return this;
    }

    @Override
    public RecipeRecord value14(Double value) {
        setSalt(value);
        return this;
    }

    @Override
    public RecipeRecord value15(Double value) {
        setSaturatedFat(value);
        return this;
    }

    @Override
    public RecipeRecord value16(Double value) {
        setSugar(value);
        return this;
    }

    @Override
    public RecipeRecord values(UUID value1, LocalDateTime value2, LocalDateTime value3, String value4, String value5, String value6, String value7, String value8, String value9, String[] value10, Double value11, Double value12, Double value13, Double value14, Double value15, Double value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RecipeRecord
     */
    public RecipeRecord() {
        super(Recipe.RECIPE);
    }

    /**
     * Create a detached, initialised RecipeRecord
     */
    public RecipeRecord(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String title, String url, String fsaFat, String fsaSalt, String fsaSaturated, String fsaSugar, String[] instructions, Double energy, Double fat, Double protein, Double salt, Double saturatedFat, Double sugar) {
        super(Recipe.RECIPE);

        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setTitle(title);
        setUrl(url);
        setFsaFat(fsaFat);
        setFsaSalt(fsaSalt);
        setFsaSaturated(fsaSaturated);
        setFsaSugar(fsaSugar);
        setInstructions(instructions);
        setEnergy(energy);
        setFat(fat);
        setProtein(protein);
        setSalt(salt);
        setSaturatedFat(saturatedFat);
        setSugar(sugar);
    }
}
