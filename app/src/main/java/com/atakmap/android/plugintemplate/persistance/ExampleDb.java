package com.atakmap.android.plugintemplate.persistance;

import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;
import com.atakmap.database.DatabaseIface;
import com.atakmap.database.impl.DatabaseImpl;

class ExampleDb {

    private DatabaseIface db = DatabaseImpl.openOrCreate("example_db");

    public void createTables() {
        db.execute("CREATE TABLE log ()", new String[]{ExampleEntity.class.toString()});
    }
}
