package com.atakmap.android.plugintemplate.pages;

import android.content.Context;
import android.view.View;

import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.plugintemplate.plugin.R;
import com.atakmap.android.plugintemplate.plugin.databinding.ExampleListBinding;
import com.atakmap.android.plugintemplate.view.adapters.ExampleListAdapter;
import com.atakmap.android.plugintemplate.viewmodel.ExamplePageViewModel;

public class ExamplePage {
    public final ExampleListBinding binding;

    public ExamplePage(Context context, ExamplePageViewModel viewModel){
        binding = ExampleListBinding.bind(PluginLayoutInflater.inflate(context, R.layout.example_list, null));
        binding.setViewmodel(viewModel);
        ExampleListAdapter exampleListAdapter = new ExampleListAdapter(viewModel);
        binding.exampleListRecycler.setAdapter(exampleListAdapter);
    }


    public View getView() { return this.binding.getRoot();}

    public ExamplePageViewModel getViewModel() { return this.binding.getViewmodel();}
}
