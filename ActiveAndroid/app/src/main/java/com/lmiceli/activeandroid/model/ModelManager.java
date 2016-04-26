package com.lmiceli.activeandroid.model;

import android.util.Log;

import com.activeandroid.query.Delete;

;

/**
 * Created by lmiceli on 22/04/2016.
 */
public class ModelManager {
    private static final String TAG = "com.lmiceli.activeandroid.model.ModelManager";

    public Category createCategory() {
        // Create a category
        Category restaurants = new Category();
        restaurants.remoteId = 1;
        restaurants.name = "Restaurants";
        restaurants.save();
        return restaurants;
    }

    public Item createItem(Category category) {
        // Create an item
        Item item = new Item();
        item.remoteId = 1;
        item.category = category;
        item.name = "Outback Steakhouse";
        item.save();
        return item;
    }
//    @IntDef
    public void deleteItem1(Item item) {
        
        Log.d(TAG, "deleteItem1() called with: " + "item = [" + item + "]");
        // Deleting items
//        com.lmiceli.activeandroid.model.Item item = com.lmiceli.activeandroid.model.Item.load(com.lmiceli.activeandroid.model.Item.class, 1);
        item.delete();

    }

    public void deleteItem2(Item item) {
        new Delete().from(Item.class).where("remote_id = ?", 1).execute();
    }
}
