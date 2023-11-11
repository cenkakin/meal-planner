/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables;


import com.github.cenkserkan.infra.adapters.generated.Keys;
import com.github.cenkserkan.infra.adapters.generated.Public;
import com.github.cenkserkan.infra.adapters.generated.tables.records.UserRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>public.user.id</code>.
     */
    public final TableField<UserRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("gen_random_uuid()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.user.created_at</code>.
     */
    public final TableField<UserRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.user.updated_at</code>.
     */
    public final TableField<UserRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.user.user_name</code>.
     */
    public final TableField<UserRecord, String> USER_NAME = createField(DSL.name("user_name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.user.roles</code>.
     */
    public final TableField<UserRecord, String[]> ROLES = createField(DSL.name("roles"), SQLDataType.CLOB.getArrayDataType(), this, "");

    /**
     * The column <code>public.user.password</code>.
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.user.email</code>.
     */
    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR.nullable(false), this, "");

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>public.user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    /**
     * Create a <code>public.user</code> table reference
     */
    public User() {
        this(DSL.name("user"), null);
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key) {
        super(child, key, USER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.USER_PKEY;
    }

    @Override
    public List<UniqueKey<UserRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.USER_USER_NAME_KEY, Keys.USER_EMAIL_KEY);
    }

    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    @Override
    public User as(Table<?> alias) {
        return new User(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Table<?> name) {
        return new User(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, LocalDateTime, LocalDateTime, String, String[], String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super UUID, ? super LocalDateTime, ? super LocalDateTime, ? super String, ? super String[], ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super UUID, ? super LocalDateTime, ? super LocalDateTime, ? super String, ? super String[], ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
