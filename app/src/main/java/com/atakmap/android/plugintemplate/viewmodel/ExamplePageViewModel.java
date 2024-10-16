package com.atakmap.android.plugintemplate.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.atakmap.android.plugintemplate.persistance.example.Example;
import com.atakmap.android.plugintemplate.plugin.BR;

import java.util.List;

public class ExamplePageViewModel extends BaseObservable {

    private Example exampleModel;
    private List<Example> exampleEntries;

    public ExamplePageViewModel(Example exampleModel){
        this.exampleModel = exampleModel;
    }

    @Bindable
    public String getExampleName() {
        return exampleModel.getExampleName();
    }

    public void setExampleName(String exampleName) {
        exampleModel.setExampleName(exampleName);
        notifyPropertyChanged(BR.exampleName);
    }

    @Bindable
    public List<Example> getExampleEntries(){
        return this.exampleEntries;
    }

    public void setExampleEntries(List<Example> exampleEntries) {
        this.exampleEntries = exampleEntries;
        notifyPropertyChanged(BR.exampleEntries);
    }

    // business logic goes here for the associated model
}
