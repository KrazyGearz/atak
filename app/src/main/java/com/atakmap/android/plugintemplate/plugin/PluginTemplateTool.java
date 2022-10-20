
package com.atakmap.android.plugintemplate.plugin;

import android.content.Context;

import com.atak.plugins.impl.AbstractPluginTool;
import com.atakmap.android.plugintemplate.PluginTemplateDropDownReceiver;

import gov.tak.api.util.Disposable;

/**
 * Please note:
 *     Support for versions prior to 4.5.1 can make use of a copy of AbstractPluginTool shipped with
 *     the plugin.
 */
public class PluginTemplateTool extends AbstractPluginTool implements Disposable {

    public PluginTemplateTool(Context context) {
        super(context,
                context.getString(R.string.app_name),
                context.getString(R.string.app_name),
                context.getResources().getDrawable(R.drawable.ic_launcher),
                PluginTemplateDropDownReceiver.SHOW_PLUGIN);
    }

    @Override
    public void dispose() {
    }
}
