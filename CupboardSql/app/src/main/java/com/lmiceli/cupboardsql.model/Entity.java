package com.lmiceli.cupboardsql.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by lmiceli on 21/04/2016.
 */
public class Entity {
    protected Long _id; // for cupboard
    protected Long createdOn;
    private static String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);

    public Entity() {
        createdOn = Calendar.getInstance().getTimeInMillis();
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getCreatedOnString() {
        return sdf.format(createdOn);
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }
}
