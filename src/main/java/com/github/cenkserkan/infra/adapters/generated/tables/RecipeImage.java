/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables;


import com.github.cenkserkan.infra.adapters.generated.Keys;
import com.github.cenkserkan.infra.adapters.generated.Public;
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeImageRecord;

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
public class RecipeImage extends TableImpl<RecipeImageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.recipe_image</code>
     */
    public static final RecipeImage RECIPE_IMAGE = new RecipeImage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RecipeImageRecord> getRecordType() {
        return RecipeImageRecord.class;
    }

    /**
     * The column <code>public.recipe_image.recipe_id</code>.
     */
    public final TableField<RecipeImageRecord, UUID> RECIPE_ID = createField(DSL.name("recipe_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.recipe_image.url</code>.
     */
    public final TableField<RecipeImageRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.recipe_image.priority</code>.
     */
    public final TableField<RecipeImageRecord, Integer> PRIORITY = createField(DSL.name("priority"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.recipe_image.created_at</code>.
     */
    public final TableField<RecipeImageRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.recipe_image.updated_at</code>.
     */
    public final TableField<RecipeImageRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private RecipeImage(Name alias, Table<RecipeImageRecord> aliased) {
        this(alias, aliased, null);
    }

    private RecipeImage(Name alias, Table<RecipeImageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.recipe_image</code> table reference
     */
    public RecipeImage(String alias) {
        this(DSL.name(alias), RECIPE_IMAGE);
    }

    /**
     * Create an aliased <code>public.recipe_image</code> table reference
     */
    public RecipeImage(Name alias) {
        this(alias, RECIPE_IMAGE);
    }

    /**
     * Create a <code>public.recipe_image</code> table reference
     */
    public RecipeImage() {
        this(DSL.name("recipe_image"), null);
    }

    public <O extends Record> RecipeImage(Table<O> child, ForeignKey<O, RecipeImageRecord> key) {
        super(child, key, RECIPE_IMAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<RecipeImageRecord> getPrimaryKey() {
        return Keys.RECIPE_IMAGE_PKEY;
    }

    @Override
    public RecipeImage as(String alias) {
        return new RecipeImage(DSL.name(alias), this);
    }

    @Override
    public RecipeImage as(Name alias) {
        return new RecipeImage(alias, this);
    }

    @Override
    public RecipeImage as(Table<?> alias) {
        return new RecipeImage(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeImage rename(String name) {
        return new RecipeImage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeImage rename(Name name) {
        return new RecipeImage(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipeImage rename(Table<?> name) {
        return new RecipeImage(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, String, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super UUID, ? super String, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super UUID, ? super String, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}