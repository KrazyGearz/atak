package com.atakmap.android.plugintemplate.persistance.example;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "example")
public class ExampleEntity {
    @PrimaryKey
    @NonNull
    public UUID uid;

    @ColumnInfo(name = "example_name")
    public String exampleName;

    public ExampleEntity(String exampleName){
        this.uid = UUID.randomUUID();
        this.exampleName = exampleName;
    };
}
