package com.hasbis.android.roomtest.features.dashboard;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.hasbis.android.roomtest.database.entity.Item;
import com.hasbis.android.roomtest.repository.ItemRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {
    private ItemRepository mRepository;

    private LiveData<List<Item>> mAllItems;

    public DashboardViewModel (Application application) {
        super(application);
        mRepository = new ItemRepository(application);
        mAllItems = mRepository.getAllItems();
    }

    LiveData<List<Item>> getAllItems() { return mAllItems; }

    public void insert(Item item) { mRepository.insert(item); }
}
