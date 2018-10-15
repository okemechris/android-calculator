package com.example.djbabs.djbabscalculator;

import android.app.Activity;
import android.view.View;
import android.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by djbabs on 1/2/2017.
 */
public class Utils {





    public  void drawer(Activity activity){
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("me");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("okeme")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return true;
                    }
                })
                .build();
    }




}
