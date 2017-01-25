package com.example.vikash.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,View.OnClickListener {

    GoogleMap g_map;
    boolean map_ready = false;

    private Button map,satellite,hybrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = (Button)findViewById(R.id.map);
        //map.setOnClickListener(this);
        satellite = (Button)findViewById(R.id.satellite);
        //satellite.setOnClickListener(this);
        hybrid = (Button)findViewById(R.id.hybrid);
        //hybrid.setOnClickListener(this);
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map.setOnClickListener(this);
        satellite.setOnClickListener(this);
        hybrid.setOnClickListener(this);
        map_ready = true;
        g_map = googleMap;
        LatLng newYork = new LatLng(40.7484,-73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        g_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.map){
            if(map_ready) {
                Toast.makeText(MainActivity.this, "Normal Map", Toast.LENGTH_SHORT).show();
                g_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        }
        if(id == R.id.satellite){
            if(map_ready) {
                Toast.makeText(MainActivity.this, "Satellite Map", Toast.LENGTH_SHORT).show();
                g_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        }
        if(id == R.id.hybrid){
            if(map_ready) {
                Toast.makeText(MainActivity.this, "Hybrid Map", Toast.LENGTH_SHORT).show();
                g_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        }
    }
}
