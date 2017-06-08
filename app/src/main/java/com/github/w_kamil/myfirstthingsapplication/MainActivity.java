package com.github.w_kamil.myfirstthingsapplication;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logIPaddress();
    }

    private void logIPaddress() {
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
        int ipInInt = Integer.reverseBytes(wm.getConnectionInfo().getIpAddress());
        byte[] ipInByteArray = BigInteger.valueOf(ipInInt).toByteArray();
        try {
            String ip = InetAddress.getByAddress(ipInByteArray).getHostAddress();
            Log.v("Local IP address", ip);
        } catch (UnknownHostException e) {
            Log.v("Local IP address", " - Unable to get host address.");
        }
    }
}
