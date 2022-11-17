
package com.atakmap.android.plugintemplate.plugin;

import android.content.Context;

import com.atak.plugins.impl.PluginContextProvider;
import com.atakmap.android.maps.MapComponent;
import com.atakmap.android.plugintemplate.PluginTemplateMapComponent;

import gov.tak.api.plugin.IPlugin;
import gov.tak.api.plugin.IServiceController;
import transapps.maps.plugin.tool.ToolDescriptor;

public class PluginTemplate implements IPlugin {

    IServiceController serviceController;
    PluginTemplateTool tool;
    PluginTemplateMapComponent pluginMapComponent;
    Context pluginContext;

    public PluginTemplate(IServiceController serviceController) {
        this.serviceController = serviceController;
        final PluginContextProvider ctxProvider = serviceController
                .getService(PluginContextProvider.class);
        if (ctxProvider != null)
            pluginContext = ctxProvider.getPluginContext();
    }

    @Override
    public void onStart() {

        pluginMapComponent = new PluginTemplateMapComponent();
        tool = new PluginTemplateTool(pluginContext);

        serviceController.registerComponent(ToolDescriptor.class, tool);
        serviceController.registerComponent(MapComponent.class,
                pluginMapComponent);
    }

    @Override
    public void onStop() {
        serviceController.unregisterComponent(ToolDescriptor.class, tool);
        serviceController.unregisterComponent(MapComponent.class,
                pluginMapComponent);

    }
}
