package com.hasbis.android.roomtest.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.hasbis.android.roomtest.database.dao.ItemDao;
import com.hasbis.android.roomtest.database.entity.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class RoomDatabaseCreator extends RoomDatabase {
    public abstract ItemDao itemDao();

    private static volatile RoomDatabaseCreator INSTANCE;

    public static RoomDatabaseCreator getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabaseCreator.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseCreator.class, "database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}