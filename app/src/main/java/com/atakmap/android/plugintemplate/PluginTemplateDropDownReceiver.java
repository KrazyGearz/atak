
package com.atakmap.android.plugintemplate;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.atakmap.coremap.maps.coords.GeoPoint;

import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.plugintemplate.plugin.R;
import com.atakmap.android.dropdown.DropDown.OnStateListener;
import com.atakmap.android.dropdown.DropDownReceiver;
import android.widget.Button;

import com.atakmap.coremap.log.Log;

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
                R.layout.main_layout, null);

        Button b = templateView.findViewById(R.id.panToZoom);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        GeoPoint gp;

                        gp = new GeoPoint(38.91370, -104.98415, 7694);
                        mapView.getMapController().panZoomTo(gp, 0.00005d,
                                false);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        gp = new GeoPoint(47.39838, 8.54375, 1744);
                        mapView.getMapController().panZoomTo(gp, 0.00005d,
                                false);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        gp = new GeoPoint(38.91370, -104.98415, 7694);
                        mapView.getMapController().panZoomTo(gp, 0.00005d,
                                false);

                    }
                });
                t.start();
            }
        });

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

            Log.d(TAG, "showing plugin drop down");
            showDropDown(templateView, HALF_WIDTH, FULL_HEIGHT, FULL_WIDTH,
                    HALF_HEIGHT, false);
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
