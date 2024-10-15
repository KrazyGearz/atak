package com.atakmap.android.plugintemplate.persistance.example;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface ExampleDao {
    @Query("SELECT * FROM example")
    List<ExampleEntity> getAll();

    @Insert
    static void insert(ExampleEntity exampleEntity) {
    }
}
