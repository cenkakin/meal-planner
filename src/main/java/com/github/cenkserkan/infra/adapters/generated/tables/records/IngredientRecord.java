/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables.records;


import com.github.cenkserkan.infra.adapters.generated.tables.Ingredient;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IngredientRecord extends UpdatableRecordImpl<IngredientRecord> implements Record11<UUID, LocalDateTime, LocalDateTime, String, String[], Double, Double, Double, Double, Double, Double> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.ingredient.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ingredient.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.ingredient.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ingredient.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.ingredient.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.ingredient.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.ingredient.name</code>.
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.ingredient.name</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.ingredient.tags</code>.
     */
    public void setTags(String[] value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.ingredient.tags</code>.
     */
    public String[] getTags() {
        return (String[]) get(4);
    }

    /**
     * Setter for <code>public.ingredient.fat</code>.
     */
    public void setFat(Double value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.ingredient.fat</code>.
     */
    public Double getFat() {
        return (Double) get(5);
    }

    /**
     * Setter for <code>public.ingredient.energy</code>.
     */
    public void setEnergy(Double value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.ingredient.energy</code>.
     */
    public Double getEnergy() {
        return (Double) get(6);
    }

    /**
     * Setter for <code>public.ingredient.protein</code>.
     */
    public void setProtein(Double value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.ingredient.protein</code>.
     */
    public Double getProtein() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>public.ingredient.saturated_fat</code>.
     */
    public void setSaturatedFat(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.ingredient.saturated_fat</code>.
     */
    public Double getSaturatedFat() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>public.ingredient.salt</code>.
     */
    public void setSalt(Double value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.ingredient.salt</code>.
     */
    public Double getSalt() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>public.ingredient.sugar</code>.
     */
    public void setSugar(Double value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.ingredient.sugar</code>.
     */
    public Double getSugar() {
        return (Double) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<UUID, LocalDateTime, LocalDateTime, String, String[], Double, Double, Double, Double, Double, Double> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<UUID, LocalDateTime, LocalDateTime, String, String[], Double, Double, Double, Double, Double, Double> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Ingredient.INGREDIENT.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Ingredient.INGREDIENT.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Ingredient.INGREDIENT.UPDATED_AT;
    }

    @Override
    public Field<String> field4() {
        return Ingredient.INGREDIENT.NAME;
    }

    @Override
    public Field<String[]> field5() {
        return Ingredient.INGREDIENT.TAGS;
    }

    @Override
    public Field<Double> field6() {
        return Ingredient.INGREDIENT.FAT;
    }

    @Override
    public Field<Double> field7() {
        return Ingredient.INGREDIENT.ENERGY;
    }

    @Override
    public Field<Double> field8() {
        return Ingredient.INGREDIENT.PROTEIN;
    }

    @Override
    public Field<Double> field9() {
        return Ingredient.INGREDIENT.SATURATED_FAT;
    }

    @Override
    public Field<Double> field10() {
        return Ingredient.INGREDIENT.SALT;
    }

    @Override
    public Field<Double> field11() {
        return Ingredient.INGREDIENT.SUGAR;
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
        return getName();
    }

    @Override
    public String[] component5() {
        return getTags();
    }

    @Override
    public Double component6() {
        return getFat();
    }

    @Override
    public Double component7() {
        return getEnergy();
    }

    @Override
    public Double component8() {
        return getProtein();
    }

    @Override
    public Double component9() {
        return getSaturatedFat();
    }

    @Override
    public Double component10() {
        return getSalt();
    }

    @Override
    public Double component11() {
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
        return getName();
    }

    @Override
    public String[] value5() {
        return getTags();
    }

    @Override
    public Double value6() {
        return getFat();
    }

    @Override
    public Double value7() {
        return getEnergy();
    }

    @Override
    public Double value8() {
        return getProtein();
    }

    @Override
    public Double value9() {
        return getSaturatedFat();
    }

    @Override
    public Double value10() {
        return getSalt();
    }

    @Override
    public Double value11() {
        return getSugar();
    }

    @Override
    public IngredientRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public IngredientRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public IngredientRecord value3(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public IngredientRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public IngredientRecord value5(String[] value) {
        setTags(value);
        return this;
    }

    @Override
    public IngredientRecord value6(Double value) {
        setFat(value);
        return this;
    }

    @Override
    public IngredientRecord value7(Double value) {
        setEnergy(value);
        return this;
    }

    @Override
    public IngredientRecord value8(Double value) {
        setProtein(value);
        return this;
    }

    @Override
    public IngredientRecord value9(Double value) {
        setSaturatedFat(value);
        return this;
    }

    @Override
    public IngredientRecord value10(Double value) {
        setSalt(value);
        return this;
    }

    @Override
    public IngredientRecord value11(Double value) {
        setSugar(value);
        return this;
    }

    @Override
    public IngredientRecord values(UUID value1, LocalDateTime value2, LocalDateTime value3, String value4, String[] value5, Double value6, Double value7, Double value8, Double value9, Double value10, Double value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IngredientRecord
     */
    public IngredientRecord() {
        super(Ingredient.INGREDIENT);
    }

    /**
     * Create a detached, initialised IngredientRecord
     */
    public IngredientRecord(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String[] tags, Double fat, Double energy, Double protein, Double saturatedFat, Double salt, Double sugar) {
        super(Ingredient.INGREDIENT);

        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setName(name);
        setTags(tags);
        setFat(fat);
        setEnergy(energy);
        setProtein(protein);
        setSaturatedFat(saturatedFat);
        setSalt(salt);
        setSugar(sugar);
    }
}
