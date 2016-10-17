/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationdrawer;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * Left Drawer and Right Drawer
 */
public class LeftRightDrawerActivity extends RoboActivity {
    ActionBar actionBar;

    @InjectView(R.id.drawerlayout)
    DrawerLayout drawerlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_and_right_drawer);
        actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.show();
        drawerlayout.setScrimColor(0x00ffffff);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.left_right, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.left_drawer:
                if (!drawerlayout.isDrawerOpen(GravityCompat.START) && !drawerlayout.isDrawerOpen(GravityCompat.END)) {
                    drawerlayout.openDrawer(GravityCompat.START);
                } else if (!drawerlayout.isDrawerOpen(GravityCompat.START) && drawerlayout.isDrawerOpen(GravityCompat.END)) {
                    drawerlayout.closeDrawer(GravityCompat.END);
                    drawerlayout.openDrawer(GravityCompat.START);
                } else if (drawerlayout.isDrawerOpen(GravityCompat.START) && !drawerlayout.isDrawerOpen(GravityCompat.END)) {
                    drawerlayout.closeDrawer(GravityCompat.START);
                } else if (drawerlayout.isDrawerOpen(GravityCompat.START) && drawerlayout.isDrawerOpen(GravityCompat.END)) {
                    drawerlayout.closeDrawers();
                }
                break;
            case R.id.right_drawer:
                if (!drawerlayout.isDrawerOpen(GravityCompat.END) && !drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    drawerlayout.openDrawer(GravityCompat.END);
                } else if (!drawerlayout.isDrawerOpen(GravityCompat.END) && drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    drawerlayout.closeDrawer(GravityCompat.START);
                    drawerlayout.openDrawer(GravityCompat.END);
                } else if (drawerlayout.isDrawerOpen(GravityCompat.END) && !drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    drawerlayout.closeDrawer(GravityCompat.END);
                } else if (drawerlayout.isDrawerOpen(GravityCompat.END) && drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    drawerlayout.closeDrawers();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
