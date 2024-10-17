package com.atakmap.android.plugintemplate.view;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.ListAdapter;

import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("exampleEntries")
    public static void setExampleListEntries(RecyclerView recyclerView, List<ExampleEntity> entries){
        ListAdapter adapter = (ListAdapter) recyclerView.getAdapter();
        adapter.submitList(entries);
    }
}
