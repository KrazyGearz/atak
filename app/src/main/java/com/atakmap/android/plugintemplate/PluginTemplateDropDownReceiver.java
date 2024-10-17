
package com.atakmap.android.plugintemplate;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.plugintemplate.pages.ExamplePage;
import com.atakmap.android.plugintemplate.persistance.ExampleDatabase;
import com.atakmap.android.plugintemplate.persistance.ExampleRepository;
import com.atakmap.android.plugintemplate.persistance.example.Example;
import com.atakmap.android.plugintemplate.plugin.R;
import com.atakmap.android.dropdown.DropDown.OnStateListener;
import com.atakmap.android.dropdown.DropDownReceiver;

import com.atakmap.android.plugintemplate.viewmodel.ExamplePageViewModel;
import com.atakmap.coremap.log.Log;

import java.util.UUID;

public class PluginTemplateDropDownReceiver extends DropDownReceiver implements
        OnStateListener {

    public static final String TAG = PluginTemplateDropDownReceiver.class
            .getSimpleName();

    public static final String SHOW_PLUGIN = "com.atakmap.android.plugintemplate.SHOW_PLUGIN";
    private final View templateView;
    private final Context pluginContext;

    /**************************** CONSTRUCTOR *****************************/

    public PluginTemplateDropDownReceiver(final MapView mapView,
            final Context context) {
        super(mapView);
        this.pluginContext = context;

        // Remember to use the PluginLayoutInflator if you are actually inflating a custom view
        // In this case, using it is not necessary - but I am putting it here to remind
        // developers to look at this Inflator
        templateView = PluginLayoutInflater.inflate(context,
                // R.layout.main_layout, null);
                R.layout.example_list, null);

    }

    /**************************** PUBLIC METHODS *****************************/

    public void disposeImpl() {
    }

    /**************************** INHERITED METHODS *****************************/

    @Override
    public void onReceive(Context context, Intent intent) {

        final String action = intent.getAction();
        if (action == null)
            return;

        if (action.equals(SHOW_PLUGIN)) {

            ExampleRepository exampleRepository = new ExampleRepository(ExampleDatabase.getDatabase().exampleDao());
            ExampleDatabase.prepopulateDatabase(ExampleDatabase.getDatabase());

            ExamplePageViewModel exampleVM = new ExamplePageViewModel(new Example(UUID.randomUUID(), "This is an example"));

            View examplePage = new ExamplePage(pluginContext, exampleVM).getView();

            Log.d(TAG, "showing plugin drop down");
            showDropDown(examplePage, HALF_WIDTH, FULL_HEIGHT, FULL_WIDTH,
                    HALF_HEIGHT, false, this);
        }
    }

    @Override
    public void onDropDownSelectionRemoved() {
    }

    @Override
    public void onDropDownVisible(boolean v) {
    }

    @Override
    public void onDropDownSizeChanged(double width, double height) {
    }

    @Override
    public void onDropDownClose() {
    }

}
