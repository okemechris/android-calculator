package com.example.djbabs.djbabscalculator;

import java.util.ArrayList;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;


public class GridMenu extends Activity {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        //set grid view item
        Bitmap timeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_access_time_black_24dp);
        Bitmap massIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_build_24dp);
        Bitmap weight = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_notifications_black_24dp);

        gridArray.add(new Item(timeIcon,"Root of equation"));




        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {
                launchIntent(position);
                Toast.makeText(getApplicationContext(),gridArray.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public  void launchIntent(int position){
        switch (position) {
            case 0:
                Intent k = new Intent(getApplicationContext(), RootOfEquation.class);
                k.putExtra("id", position);
                startActivity(k);
                break;

            default:
                break;
        }



    }



    }



