package com.adriannieves.pingplugin;
import android.util.Log;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginMethod;

import org.json.JSONException;

import java.net.InetAddress;

@CapacitorPlugin(name = "PingPlugin")
public class PingPlugin extends Plugin {

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
        String hostname = inet.getCanonicalHostName(); // aquí sacamos el nombre

        com.getcapacitor.JSObject result = new com.getcapacitor.JSObject();
        result.put("alive", reachable);
        result.put("hostname", hostname);

        call.resolve(result);
    } catch (Exception e) {
        call.reject("Ping failed: " + e.getMessage());
    }
}

}
