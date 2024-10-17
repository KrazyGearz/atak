package com.atakmap.android.plugintemplate.persistance;

import androidx.lifecycle.LiveData;

import com.atakmap.android.plugintemplate.persistance.example.ExampleDao;
import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleRepository {
    private ExampleDao exampleDao;
    private LiveData<List<ExampleEntity>> allExamples;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public ExampleRepository(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }

    public void insert(final ExampleEntity example) {
        executorService.execute(() -> exampleDao.insert(example));
    }

    public void insertAll(final List<ExampleEntity> exampleEntities) {
        executorService.execute(() -> exampleDao.insertAll(exampleEntities));
    }

}
