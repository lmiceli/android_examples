package com.lmiceli.activeandroid.model;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 *
 * When running from android studio, create run configuration as "Android Test"
 */
public class ModelManagerTest extends ApplicationTestCase<Application> {

    private ModelManager modelManager;

    public ModelManagerTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        modelManager = new ModelManager();

    }

    public void testCreateDB() {
        Category category = modelManager.createCategory();
        assertEquals("restaurant", category.name);
//        assertEquals("restaurant", "restaurant");
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        assertTrue(db.isOpen());
//        db.close();
    }

    /*public void testDeleteDB() {
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
    }*/

}