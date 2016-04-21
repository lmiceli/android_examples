package com.lmiceli.cupboardsql.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by lmiceli on 21/04/2016.
 */
public class PracticeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cupboardTest.db";
    private static final int DATABASE_VERSION = 1;

    public PracticeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        // register our models
        cupboard().register(User.class);
        cupboard().register(Post.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // this will ensure that all tables are created
//        cupboard().withDatabase(db).dropAllTables();
        cupboard().withDatabase(db).createTables();
        // add indexes and other database tweaks in this method if you want

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this will upgrade tables, adding columns and new tables.
        // Note that existing columns will not be converted
        cupboard().withDatabase(db).upgradeTables();
        // do migration work if you have an alteration to make to your schema here

    }

    public long addItem(Entity entity){
        SQLiteDatabase db = getWritableDatabase();
        return cupboard().withDatabase(db).put(entity);
    }

    public <T extends Entity> T findById(Class<T> entityClass, long id){
        SQLiteDatabase db = getWritableDatabase();
        return cupboard().withDatabase(db).get(entityClass, id);
    }

    public <T extends Entity> boolean delete(Class<T> entityClass, long id){
        SQLiteDatabase db = getWritableDatabase();
        return cupboard().withDatabase(db).delete(entityClass, id);
    }

    public <T extends Entity> boolean deleteAll(Class<T> entityClass){
        SQLiteDatabase db = getWritableDatabase();
        return cupboard().withDatabase(db).delete(entityClass);
    }

    public <T extends Entity> List<T> getAll(Class<T> entityClass) {
        List<T> result = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
//        T item = cupboard().withDatabase(db).query(entityClass).get();
        // Get the cursor for this query
        Cursor items = cupboard().withDatabase(db).query(entityClass).getCursor();
        try {
            // Iterate Bunnys
            QueryResultIterable<T> itr = cupboard().withCursor(items).iterate(entityClass);
            for (T item : itr) {
                result.add(item);
            }
        } finally {
            // close the cursor
            items.close();
        }

        return result;
    }
}
