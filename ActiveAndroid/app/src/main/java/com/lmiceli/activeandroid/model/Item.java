package com.lmiceli.activeandroid.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by lmiceli on 24/04/2016.
 */
@Table(name = "Items")
public class Item extends Model {
    // This is the unique id given by the server
    @Column(name = "remote_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public long remoteId;
    // This is a regular field
    @Column(name = "Name")
    public String name;
    // This is an association to another activeandroid model
    @Column(name = "Category", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Category category;

    // Make sure to have a default constructor for every ActiveAndroid model
    public Item() {
        super();
    }

    public Item(int remoteId, String name, Category category) {
        super();
        this.remoteId = remoteId;
        this.name = name;
        this.category = category;
    }

    public static List<Item> getAll(Category category) {
        // This is how you execute a query
        return new Select()
                .from(Item.class)
                .where("Category = ?", category.getId())
                .orderBy("Name ASC")
                .execute();
    }

}
