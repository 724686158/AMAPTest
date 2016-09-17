package com.example.admin.amaptest;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity {

    private AMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
    }
}