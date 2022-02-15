package com.atakmap.android.plugintemplate.plugin.support;


import com.atak.plugins.impl.AbstractPluginLifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import com.atakmap.android.maps.MapComponent;
import com.atakmap.android.maps.MapView;
import transapps.maps.plugin.lifecycle.Lifecycle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.atakmap.coremap.log.Log;
import android.content.Context;


/**
 * Please note:
 *     Support for versions prior to 4.5.1 can make use of a copy of 
 *     AbstractPluginLifeCycle shipped with the plugin plugin template.
 */
public class AbstractPluginLifecycle extends AbstractPluginLifecycle {

   private final static String TAG = "AbstractPluginLifecycle";

   public AbstractPluginLifecycle(Context ctx) {
        super(ctx, new ());
        PluginNativeLoader.init(ctx);
    }
}

