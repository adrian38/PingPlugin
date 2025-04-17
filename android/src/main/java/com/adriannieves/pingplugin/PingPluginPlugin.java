// package com.adriannieves.pingplugin;

// import com.getcapacitor.JSObject;
// import com.getcapacitor.Plugin;
// import com.getcapacitor.PluginCall;
// import com.getcapacitor.PluginMethod;
// import com.getcapacitor.annotation.CapacitorPlugin;

// @CapacitorPlugin(name = "PingPlugin")
// public class PingPluginPlugin extends Plugin {

//     private PingPlugin implementation = new PingPlugin();

//     @PluginMethod
//     public void echo(PluginCall call) {
//         String value = call.getString("value");

//         JSObject ret = new JSObject();
//         ret.put("value", implementation.echo(value));
//         call.resolve(ret);
//     }
// }


package com.adriannieves.pingplugin;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;

import java.net.InetAddress;

@CapacitorPlugin(name = "PingPlugin")
public class PingPluginPlugin extends Plugin {

    @PluginMethod
    public void ping(PluginCall call) {
        String ip = call.getString("ip");

        if (ip == null) {
            call.reject("IP address is required");
            return;
        }

        try {
            InetAddress inet = InetAddress.getByName(ip);
            boolean reachable = inet.isReachable(1000); // timeout 1s

            com.getcapacitor.JSObject result = new com.getcapacitor.JSObject();
            result.put("alive", reachable);

            call.resolve(result);
        } catch (Exception e) {
            call.reject("Ping failed: " + e.getMessage());
        }
    }
}
