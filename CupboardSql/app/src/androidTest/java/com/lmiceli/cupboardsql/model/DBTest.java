package com.lmiceli.cupboardsql.model;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.test.ApplicationTestCase;

/**
 *
 * When running from android studio, create run configuration as "Android Test"
 */
public class DBTest extends ApplicationTestCase<Application> {

    private PracticeDatabaseHelper dbHelper;

    public DBTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dbHelper = new PracticeDatabaseHelper(mContext);

    }

    public void testCreateDB() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();
    }

    public void testDeleteDB() {
        assertTrue("Database should be deleted", mContext.deleteDatabase(PracticeDatabaseHelper.DATABASE_NAME));
        assertFalse("Database can't be deleted twice", mContext.deleteDatabase(PracticeDatabaseHelper.DATABASE_NAME));
    }

    public void testAddUser(){
        User user = getUser("Pepe");
        dbHelper.addItem(user);
        long userId = user.get_id().longValue();
        assertEquals("Pepe", dbHelper.findById(User.class, userId).getUserName());
    }
    public void testDeleteUser(){
        User user = getUser("Pepe");
        dbHelper.addItem(user);
        long userId = user.get_id().longValue();
        dbHelper.delete(User.class, userId);
        assertNull("Pepe", dbHelper.findById(User.class, userId));
    }

    @NonNull
    private User getUser(String name) {
        User user = new User();
        user.setUserName(name);
        user.setProfilePictureUrl("unimportant");
        return user;
    }

}