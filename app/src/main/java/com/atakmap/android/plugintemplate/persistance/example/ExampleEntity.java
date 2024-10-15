package com.atakmap.android.plugintemplate.persistance.example;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "example")
public class ExampleEntity {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "example_name")
    public String exampleName;

    public ExampleEntity(int uid, String exampleName) {

    }
}
