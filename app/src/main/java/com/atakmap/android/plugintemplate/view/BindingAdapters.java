package com.atakmap.android.plugintemplate.view;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.ListAdapter;

import com.atakmap.android.plugintemplate.persistance.example.Example;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("listExamples")
    public static void setExampleListEntries(RecyclerView recyclerView, List<Example> entries){
        ListAdapter adapter = (ListAdapter) recyclerView.getAdapter();
        adapter.submitList(entries);
    }
}
