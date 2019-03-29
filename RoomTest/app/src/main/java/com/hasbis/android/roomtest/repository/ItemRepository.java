package com.hasbis.android.roomtest.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.hasbis.android.roomtest.database.RoomDatabaseCreator;
import com.hasbis.android.roomtest.database.dao.ItemDao;
import com.hasbis.android.roomtest.database.entity.Item;

import java.util.List;

public class ItemRepository {
    private ItemDao mItemDao;
    private LiveData<List<Item>> mAllItems;

    public ItemRepository(Application application) {
        RoomDatabaseCreator db = RoomDatabaseCreator
                .getDatabase(application);
        mItemDao = db.itemDao();
        mAllItems = mItemDao.getAllItems();
    }

    public LiveData<List<Item>> getAllItems() {
        return mAllItems;
    }


    public void insert (Item item) {
        new insertAsyncTask(mItemDao).execute(item);
    }

    private static class insertAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao mAsyncTaskDao;

        insertAsyncTask(ItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Item... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
