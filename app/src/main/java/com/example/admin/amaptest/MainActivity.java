package com.example.admin.amaptest;

import android.os.health.UidHealthStats;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

public class MainActivity extends FragmentActivity implements LocationSource {

    private AMap aMap;
    private UiSettings mUiSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);
        //mMap.setMapType(AMap.MAP_TYPE_NIGHT);
        aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
        aMap.setTrafficEnabled(true);
        mUiSetting = aMap.getUiSettings();
        mUiSetting.setCompassEnabled(true);
        aMap.setLocationSource(this);
        mUiSetting.setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
        mUiSetting.setScaleControlsEnabled(true);
        mUiSetting.setZoomGesturesEnabled(false);


        aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(39.977290, 116.337000),
                6,
                30,
                0)
        ));

    }

    @Override
    public void activate(OnLocationChangedListener listener) {

    }

    @Override
    public void deactivate() {

    }
}