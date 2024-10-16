package com.atakmap.android.plugintemplate.persistance.example;

import java.util.UUID;

public class Example {

    private final UUID exampleID;
    private String exampleName;

    public Example(UUID exampleID, String exampleName) {
        this.exampleID = exampleID;
        this.exampleName = exampleName;

    }

    public String getExampleName() {
        return exampleName;
    }

    public UUID getExampleID() {
        return exampleID;
    }

    public void setExampleName(String exampleName){
        this.exampleName = exampleName;
    }
}
