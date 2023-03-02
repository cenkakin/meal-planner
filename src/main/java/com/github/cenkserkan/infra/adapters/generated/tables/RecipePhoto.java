/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables;


import com.github.cenkserkan.infra.adapters.generated.Keys;
import com.github.cenkserkan.infra.adapters.generated.Public;
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipePhotoRecord;

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
public class RecipePhoto extends TableImpl<RecipePhotoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.recipe_photo</code>
     */
    public static final RecipePhoto RECIPE_PHOTO = new RecipePhoto();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RecipePhotoRecord> getRecordType() {
        return RecipePhotoRecord.class;
    }

    /**
     * The column <code>public.recipe_photo.recipe_id</code>.
     */
    public final TableField<RecipePhotoRecord, UUID> RECIPE_ID = createField(DSL.name("recipe_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.recipe_photo.url</code>.
     */
    public final TableField<RecipePhotoRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.recipe_photo.priority</code>.
     */
    public final TableField<RecipePhotoRecord, Integer> PRIORITY = createField(DSL.name("priority"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.recipe_photo.created_at</code>.
     */
    public final TableField<RecipePhotoRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.recipe_photo.updated_at</code>.
     */
    public final TableField<RecipePhotoRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private RecipePhoto(Name alias, Table<RecipePhotoRecord> aliased) {
        this(alias, aliased, null);
    }

    private RecipePhoto(Name alias, Table<RecipePhotoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.recipe_photo</code> table reference
     */
    public RecipePhoto(String alias) {
        this(DSL.name(alias), RECIPE_PHOTO);
    }

    /**
     * Create an aliased <code>public.recipe_photo</code> table reference
     */
    public RecipePhoto(Name alias) {
        this(alias, RECIPE_PHOTO);
    }

    /**
     * Create a <code>public.recipe_photo</code> table reference
     */
    public RecipePhoto() {
        this(DSL.name("recipe_photo"), null);
    }

    public <O extends Record> RecipePhoto(Table<O> child, ForeignKey<O, RecipePhotoRecord> key) {
        super(child, key, RECIPE_PHOTO);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<RecipePhotoRecord> getPrimaryKey() {
        return Keys.RECIPE_PHOTO_PKEY;
    }

    @Override
    public RecipePhoto as(String alias) {
        return new RecipePhoto(DSL.name(alias), this);
    }

    @Override
    public RecipePhoto as(Name alias) {
        return new RecipePhoto(alias, this);
    }

    @Override
    public RecipePhoto as(Table<?> alias) {
        return new RecipePhoto(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipePhoto rename(String name) {
        return new RecipePhoto(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipePhoto rename(Name name) {
        return new RecipePhoto(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public RecipePhoto rename(Table<?> name) {
        return new RecipePhoto(name.getQualifiedName(), null);
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
