package com.shashwatrazdan.elementolibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.shashwatrazdan.elementolibrary.R;

public class Elemento extends CoordinatorLayout {

    CollapsingToolbarLayout cTLayout;
    int colorToolbar=0xFF42A5F5;
    int colorStatusBar = 0xFF1E88E5;
    Context context;
    FloatingActionButton fab;
    String toolbarTitle = "DefaultText";

    public Elemento(Context context) {
        super(context);
        init(context);
    }


    public Elemento(Context context,  AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
    public Elemento(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void initialise(Context context) {
        this.context = context;

        LayoutInflater.from(getContext()).inflate(
                R.layout.elemento, this);

        cTLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        cTLayout.setTitle(toolbarTitle);
        int transparent = 0x00000000;
        cTLayout.setExpandedTitleColor(transparent);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        int w = 10, h = 10;

        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        Bitmap bmp = Bitmap.createBitmap(w, h, conf);

        Palette.from(bmp).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                cTLayout.setContentScrimColor(colorToolbar);
                cTLayout.setStatusBarScrimColor(colorStatusBar);
            }
        });

    }

    public void setToolbarColor(int toolbarColor){
        this.colorToolbar = toolbarColor;
    }
    public void setStatusBarColor(int statusBarColor){
        this.colorStatusBar = statusBarColor;
    }

    public void setToolbarHeight(int height){
        final LinearLayout l1 = (LinearLayout) findViewById(R.id.header);
        l1.getLayoutParams().height = height;
        l1.requestLayout();
    }
    public void setHead(View v){
        LinearLayout l = (LinearLayout) findViewById(R.id.header);
        l.addView(v, 0);
    }
    public void setBody(View v){
        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.child);
        nsv.addView(v, 0);
    }
    public void setBodyWithScroll(View v){
        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.child);
        nsv.setVisibility(View.GONE);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        coordinatorLayout.addView(v);
    }


    public void setToolbarTitle(String s){
        cTLayout.setTitle(s);
    }
    public void setExpandedToolbarColor(int a, int r, int g, int b){
        cTLayout.setExpandedTitleColor(Color.argb(a,r,g,b));
    }
    public void setFABVisibility(Boolean v){
        if (v) {
            fab.setVisibility(VISIBLE);
        } else {
            fab.setVisibility(GONE);
        }
    }



}
