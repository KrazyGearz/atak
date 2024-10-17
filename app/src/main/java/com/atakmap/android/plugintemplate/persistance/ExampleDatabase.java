package com.atakmap.android.plugintemplate.persistance;

import android.content.Context;
import android.util.Log;

import androidx.annotation.WorkerThread;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.plugintemplate.persistance.example.ExampleDao;
import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ExampleEntity.class}, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    public abstract ExampleDao exampleDao();

    private static ExampleDatabase INSTANCE;
    private static Context applicationContext = MapView.getMapView().getContext();
    // implement migrations if needed

    @WorkerThread
    public static ExampleDatabase getDatabase() {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(applicationContext, ExampleDatabase.class, "example_db").allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    @WorkerThread
    public static void prepopulateDatabase(final ExampleDatabase db) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<ExampleEntity> exampleEntities = List.of(
                new ExampleEntity("This is displayed in a recycler view."),
                new ExampleEntity("These are also pulled from the database."),
                new ExampleEntity("We are using data binding and MVVM patterns.")
        );
        executorService.execute(() -> {
            ExampleDao exampleDao = db.exampleDao();

            Log.d("Bridge Program", Boolean.toString(exampleDao.getAll().isEmpty()) );

            if (exampleDao.getAll().isEmpty()) {
                exampleDao.insertAll(exampleEntities);
            }

        });
    }
}
