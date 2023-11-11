/*
 * This file is generated by jOOQ.
 */
package com.github.cenkserkan.infra.adapters.generated.tables.records;


import com.github.cenkserkan.infra.adapters.generated.tables.User;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record7<UUID, LocalDateTime, LocalDateTime, String, String[], String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.user.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.user.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.user.user_name</code>.
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.user.user_name</code>.
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.user.roles</code>.
     */
    public void setRoles(String[] value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.user.roles</code>.
     */
    public String[] getRoles() {
        return (String[]) get(4);
    }

    /**
     * Setter for <code>public.user.password</code>.
     */
    public void setPassword(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.user.password</code>.
     */
    public String getPassword() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.user.email</code>.
     */
    public void setEmail(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.user.email</code>.
     */
    public String getEmail() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, LocalDateTime, LocalDateTime, String, String[], String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, LocalDateTime, LocalDateTime, String, String[], String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return User.USER.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return User.USER.UPDATED_AT;
    }

    @Override
    public Field<String> field4() {
        return User.USER.USER_NAME;
    }

    @Override
    public Field<String[]> field5() {
        return User.USER.ROLES;
    }

    @Override
    public Field<String> field6() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<String> field7() {
        return User.USER.EMAIL;
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
        return getUserName();
    }

    @Override
    public String[] component5() {
        return getRoles();
    }

    @Override
    public String component6() {
        return getPassword();
    }

    @Override
    public String component7() {
        return getEmail();
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
        return getUserName();
    }

    @Override
    public String[] value5() {
        return getRoles();
    }

    @Override
    public String value6() {
        return getPassword();
    }

    @Override
    public String value7() {
        return getEmail();
    }

    @Override
    public UserRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UserRecord value3(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public UserRecord value5(String[] value) {
        setRoles(value);
        return this;
    }

    @Override
    public UserRecord value6(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value7(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord values(UUID value1, LocalDateTime value2, LocalDateTime value3, String value4, String[] value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String userName, String[] roles, String password, String email) {
        super(User.USER);

        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setUserName(userName);
        setRoles(roles);
        setPassword(password);
        setEmail(email);
    }
}
