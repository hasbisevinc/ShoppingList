package com.hasbis.android.roomtest.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static com.hasbis.android.roomtest.database.DatabaseConfig.ITEM_TABLE;

@Entity(tableName = ITEM_TABLE)
public class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "time")
    private long time;


    public Item(@NonNull String uuid,
                @NonNull String name,
                @NonNull String description,
                @NonNull long time) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    @NonNull
    public String getName(){
        return this.name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public long getTime() {
        return time;
    }
}
