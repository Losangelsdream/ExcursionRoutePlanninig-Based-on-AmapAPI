package com.example.admin.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.services.geocoder.GeocodeSearch;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private List<RouteModel> list = null;
    private List<String> scenicSpot = new ArrayList<String>();
    private List<String> scenicSpot2 = new ArrayList<String>();
    private List<String> scenicSpot3 = new ArrayList<String>();
    private ListView listview = null;
    private RouteAdapter adapter = null;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routeshow);
        context = ThirdActivity.this;
        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();
        initData();
        listview = (ListView) findViewById(R.id.bottom_listview);
        adapter = new RouteAdapter(this, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);


    }

    private void initData()
    {
        scenicSpot.add("北京邮电大学");
        scenicSpot.add("北海公园");
        scenicSpot.add("天安门");
        scenicSpot.add("北京站");

        scenicSpot2.add("北京邮电大学");
        scenicSpot2.add("天坛公园");
        scenicSpot2.add("故宫博物馆");

        scenicSpot3.add("北京站");
        scenicSpot3.add("西单");
        scenicSpot3.add("雍和宫");


        list = new ArrayList<RouteModel>();
        list.add(new RouteModel(1, 2.5, 270,scenicSpot));
        list.add(new RouteModel(2, 3, 0,scenicSpot2));
        list.add(new RouteModel( 3,4.5, 500,scenicSpot3));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        RouteModel route_choice = list.get(position);
        ArrayList<String> route_poi = (ArrayList<String>) route_choice.getScenicSpot();
        Intent intent = new Intent(ThirdActivity.this, NavActivity.class);
        intent.putStringArrayListExtra("route_poi",route_poi);
        startActivity(intent);
    }
}
