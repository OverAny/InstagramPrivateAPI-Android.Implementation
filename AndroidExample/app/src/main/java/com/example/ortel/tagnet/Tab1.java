package com.example.ortel.tagnet;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Objects;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import static com.example.ortel.tagnet.MainActivityOld.output1;
import static com.example.ortel.tagnet.MainActivityOld.output3;


public class Tab1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private int gotted;
    public static ArrayList<HashMap<String, String>> usersInfoTwo = new ArrayList<HashMap<String, String>>();
    Context context = Tab1.this;
    public static ImageView fab123;
    public static ProgressBar fabreplace;
    private ArrayList<HashMap<String, String>> usersInfo = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        //Plus Icon
        fab123 = findViewById(R.id.fab);
        fab123.setVisibility(View.VISIBLE);

        //Plus Icon Loadingbar
        fabreplace = findViewById(R.id.fabreplace);
        fabreplace.setVisibility(View.GONE);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
         ImageView i1 = findViewById(R.id.i1);
         ImageView i2 = findViewById(R.id.i2);
         ImageView i3 = findViewById(R.id.i3);
         ImageView i4 = findViewById(R.id.i4);
         ImageView i5 = findViewById(R.id.i5);
         ImageView i6 = findViewById(R.id.i6);
         ImageView i7 = findViewById(R.id.i7);
         ImageView i8 = findViewById(R.id.i8);
         ImageView i9 = findViewById(R.id.i9);
         ImageView i10 =findViewById(R.id.i10);
         ImageView i11 =findViewById(R.id.i11);
         ImageView i12 =findViewById(R.id.i12);
        LinearLayout Grid=findViewById(R.id.Grid);
        Grid.setVisibility(View.VISIBLE);

        //Set Users Recent Media
        if (!Objects.equals(output3.get(0), "")) {
            Picasso.with(context)
                    .load(output3.get(0))
                    .fit().centerCrop()
                    .into(i1);
        }
        if (!Objects.equals(output3.get(1), "")) {
            Picasso.with(context)
                    .load(output3.get(1))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i2);
        }
        if (!Objects.equals(output3.get(2), "")) {

            Picasso.with(context)
                    .load(output3.get(2))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i3);
        }
        if (!Objects.equals(output3.get(3), "")) {

            Picasso.with(context)
                    .load(output3.get(3))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i4);
        }
        if (!Objects.equals(output3.get(4), "")) {


            Picasso.with(context)
                    .load(output3.get(4))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i5);
        }
        if (!Objects.equals(output3.get(5), "")) {

            Picasso.with(context)
                    .load(output3.get(5))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i6);
        }
        if (!Objects.equals(output3.get(6), "")) {

            Picasso.with(context)
                    .load(output3.get(6))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i7);
        }
        if (!Objects.equals(output3.get(7), "")) {

            Picasso.with(context)
                    .load(output3.get(7))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i8);
        }
        if (!Objects.equals(output3.get(8), "")) {
            Picasso.with(context)
                    .load(output3.get(8))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i9);

        }
        if (!Objects.equals(output3.get(9), "")) {
            Picasso.with(context)
                    .load(output3.get(9))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i10);

        }
        if (!Objects.equals(output3.get(10), "")) {
            Picasso.with(context)
                    .load(output3.get(10))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i11);

        }
        if (!Objects.equals(output3.get(11), "")) {
            Picasso.with(context)
                    .load(output3.get(11))
                    //.fit().centerCrop()
                    .fit().centerCrop()

                    .into(i12);

        }

        //If no media, set the no media screen
        if (Objects.equals(output3.get(0), "") && Objects.equals(output3.get(1), "") && Objects.equals(output3.get(2), "") && Objects.equals(output3.get(3), "") && Objects.equals(output3.get(4), "") && Objects.equals(output3.get(5), "") && Objects.equals(output3.get(6), "") && Objects.equals(output3.get(7), "") && Objects.equals(output3.get(8), "") && Objects.equals(output3.get(9), "") && Objects.equals(output3.get(10), "") && Objects.equals(output3.get(11), "")){
            Grid.setVisibility(View.GONE);
        }

        //Drawer Layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set User Image
        ImageView profile = (ImageView) findViewById(R.id.imageprofile);
        Picasso.with(Tab1.this)
                .load(output1.getProfile_pic_url())
                .into(profile);

        //Set Username
        TextView TvUsername = (TextView) findViewById(R.id.tvUserName);
        //Set FullName
        TextView tvFullname = (TextView) findViewById(R.id.tvFullName);
        //Set Number of Followers
        TextView tvFollowers = (TextView) findViewById(R.id.tvNoOfFollowers);
        //Set Number of Followings
        TextView tvFollowering = (TextView) findViewById(R.id.tvNoOfFollowing);
        TvUsername.setText(output1.getUsername());
        tvFullname.setText(output1.getFull_name());
        tvFollowers.setText(Integer.toString(output1.getFollower_count()));
        tvFollowering.setText(Integer.toString(output1.getFollowing_count()));

        //Set Plus Icon to go to follower/following screen
        fab123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab123.setVisibility(View.GONE);
                fabreplace.setVisibility(View.VISIBLE);
                startActivity(new Intent(Tab1.this, MainActivity.class));

            }
        });

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(
                    Tab1.this);
            builder.setMessage("Disconnect from Instagram?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    startActivity(new Intent(Tab1.this, MainActivityOld.class));

                                }
                            })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    dialog.cancel();
                                }
                            });
            final AlertDialog alert = builder.create();
            alert.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

