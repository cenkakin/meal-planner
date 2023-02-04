/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables;


import com.github.cenkserkan.infra.adapters.generated.Keys;
import com.github.cenkserkan.infra.adapters.generated.Public;
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeIngredientRecord;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RecipeIngredient extends TableImpl<RecipeIngredientRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.recipe_ingredient</code>
     */
    public static final RecipeIngredient RECIPE_INGREDIENT = new RecipeIngredient();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RecipeIngredientRecord> getRecordType() {
        return RecipeIngredientRecord.class;
    }

    /**
     * The column <code>public.recipe_ingredient.recipe_id</code>.
     */
    public final TableField<RecipeIngredientRecord, UUID> RECIPE_ID = createField(DSL.name("recipe_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.recipe_ingredient.ingredient_id</code>.
     */
    public final TableField<RecipeIngredientRecord, UUID> INGREDIENT_ID = createField(DSL.name("ingredient_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.recipe_ingredient.amount</code>.
     */
    public final TableField<RecipeIngredientRecord, Integer> AMOUNT = createField(DSL.name("amount"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.recipe_ingredient.created_at</code>.
     */
    public final TableField<RecipeIngredientRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.recipe_ingredient.updated_at</code>.
     */
    public final TableField<RecipeIngredientRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private RecipeIngredient(Name alias, Table<RecipeIngredientRecord> aliased) {
        this(alias, aliased, null);
    }

    private RecipeIngredient(Name alias, Table<RecipeIngredientRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.recipe_ingredient</code> table reference
     */
    public RecipeIngredient(String alias) {
        this(DSL.name(alias), RECIPE_INGREDIENT);
    }

    /**
     * Create an aliased <code>public.recipe_ingredient</code> table reference
     */
    public RecipeIngredient(Name alias) {
        this(alias, RECIPE_INGREDIENT);
    }

    /**
     * Create a <code>public.recipe_ingredient</code> table reference
     */
    public RecipeIngredient() {
        this(DSL.name("recipe_ingredient"), null);
    }

    public <O extends Record> RecipeIngredient(Table<O> child, ForeignKey<O, RecipeIngredientRecord> key) {
        super(child, key, RECIPE_INGREDIENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<RecipeIngredientRecord> getPrimaryKey() {
        return Keys.RECIPE_INGREDIENT_PKEY;
    }

    @Override
    public RecipeIngredient as(String alias) {
        return new RecipeIngredient(DSL.name(alias), this);
    }

    @Override
    public RecipeIngredient as(Name alias) {
        return new RecipeIngredient(alias, this);
    }

    @Override
    public RecipeIngredient as(Table<?> alias) {
        return new RecipeIngredient(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeIngredient rename(String name) {
        return new RecipeIngredient(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeIngredient rename(Name name) {
        return new RecipeIngredient(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeIngredient rename(Table<?> name) {
        return new RecipeIngredient(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super UUID, ? super UUID, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super UUID, ? super UUID, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}