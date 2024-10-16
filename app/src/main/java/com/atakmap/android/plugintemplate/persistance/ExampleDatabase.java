package com.atakmap.android.plugintemplate.persistance;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.plugintemplate.persistance.example.ExampleDao;
import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ExampleEntity.class}, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    public abstract ExampleDao exampleDao();

    private static ExampleDatabase INSTANCE;
    private static Context applicationContext = MapView.getMapView().getContext();
    // implement migrations if needed

    public static ExampleDatabase getDatabase() {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(applicationContext, ExampleDatabase.class, "example_db")
                    .build();
        }
        return INSTANCE;
    }

    public static void prepopulateDatabase(final ExampleDatabase db) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            ExampleDao exampleDao = db.exampleDao();

            Log.d("SkillBridge", Boolean.toString(exampleDao.getAll().isEmpty()) );

            if (exampleDao.getAll().isEmpty()) {
                exampleDao.insert(new ExampleEntity( "an example"));
            }

        });
    }
}
