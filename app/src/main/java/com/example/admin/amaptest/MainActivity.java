package com.example.admin.amaptest;

import android.graphics.Color;
import android.os.health.UidHealthStats;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
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

        LatLng latLng = new LatLng(37.26, 116.16);
        final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("HOME").snippet("this is my home"));
        AMap.OnMarkerClickListener listener = new AMap.OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(MainActivity.this, "This is my hometown", Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        //绑定标注点击事件
        aMap.setOnMarkerClickListener(listener);

        AMap.OnMarkerDragListener dragListener = new AMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                marker.setTitle("Dont DRAG START");
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                marker.setTitle("Dont DRAG");
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                marker.setTitle("Dont DRAG END");
            }
        };
        //绑定标记拖拽事件
        aMap.setOnMarkerDragListener(dragListener);



        //信息窗点击事件AMap.OnInfoWindowClickListener
        AMap.OnInfoWindowClickListener windowListener = new AMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker.setTitle("don touch it");

            }
        };
        //绑定信息窗绑定事件
        /*aMap.setOnInfoWindowClickListener(windowListener);
        aMap.addPolygon(new PolygonOptions().addAll(Rect(new LatLng(
                31.238068, 121.501654), 1, 1)).strokeColor(Color.RED).strokeWidth(2));
        /*PolygonOptions options = new PolygonOptions();
        int numPoints = 400;
        float semiHorizontalAxis = 5f;
        float semVerticalAxis = 2.5f;
        double phase = 2 * Math.PI / numPoints;
        for (int i = 0; i <= numPoints; i++)
        {
            options.add(new LatLng((SyncStateContract.Constants.BEIJING.latitude) + semiHorizontalAxis
            * Math.sin(i * phase), SyncStateContract.Constants.BEIJING.latitude + semiHorizontalAxis
            *Math.cos(i * phase)));
        }
        //绘制一个椭圆
        polygon*/




    }

    @Override
    public void activate(OnLocationChangedListener listener) {

    }

    @Override
    public void deactivate() {

    }
}