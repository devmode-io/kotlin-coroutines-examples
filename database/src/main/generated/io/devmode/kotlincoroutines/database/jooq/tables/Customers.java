/*
 * This file is generated by jOOQ.
 */
package io.devmode.kotlincoroutines.database.jooq.tables;


import io.devmode.kotlincoroutines.database.jooq.Keys;
import io.devmode.kotlincoroutines.database.jooq.Public;
import io.devmode.kotlincoroutines.database.jooq.tables.records.CustomersRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class Customers extends TableImpl<CustomersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.customers</code>
     */
    public static final Customers CUSTOMERS = new Customers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomersRecord> getRecordType() {
        return CustomersRecord.class;
    }

    /**
     * The column <code>public.customers.id</code>.
     */
    public final TableField<CustomersRecord, String> ID = createField(DSL.name("id"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.customers.first_name</code>.
     */
    public final TableField<CustomersRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.customers.last_name</code>.
     */
    public final TableField<CustomersRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.CLOB.nullable(false), this, "");

    private Customers(Name alias, Table<CustomersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customers(Name alias, Table<CustomersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    public Customers(String alias) {
        this(DSL.name(alias), CUSTOMERS);
    }

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    public Customers(Name alias) {
        this(alias, CUSTOMERS);
    }

    /**
     * Create a <code>public.customers</code> table reference
     */
    public Customers() {
        this(DSL.name("customers"), null);
    }

    public <O extends Record> Customers(Table<O> child, ForeignKey<O, CustomersRecord> key) {
        super(child, key, CUSTOMERS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<CustomersRecord> getPrimaryKey() {
        return Keys.CUSTOMERS_PKEY;
    }

    @Override
    public Customers as(String alias) {
        return new Customers(DSL.name(alias), this);
    }

    @Override
    public Customers as(Name alias) {
        return new Customers(alias, this);
    }

    @Override
    public Customers as(Table<?> alias) {
        return new Customers(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customers rename(String name) {
        return new Customers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customers rename(Name name) {
        return new Customers(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customers rename(Table<?> name) {
        return new Customers(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
