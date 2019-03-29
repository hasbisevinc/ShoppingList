package com.hasbis.android.roomtest.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.hasbis.android.roomtest.database.entity.Item;

import java.util.List;

import static com.hasbis.android.roomtest.database.DatabaseConfig.ITEM_TABLE;

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Item item);

    @Query("DELETE FROM "+ITEM_TABLE)
    void deleteAll();

    @Query("DELETE FROM "+ITEM_TABLE+ " WHERE id=:id")
    void delete(long id);

    @Query("SELECT * from "+ITEM_TABLE+" ORDER BY time DESC")
    LiveData<List<Item>> getAllItems();
}