package com.adriannieves.pingplugin;

import android.util.Log;

public class PingPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
