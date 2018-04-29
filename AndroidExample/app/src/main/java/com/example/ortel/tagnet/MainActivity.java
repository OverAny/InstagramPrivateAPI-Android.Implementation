package com.example.ortel.tagnet;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.HashMap;
import android.util.Log;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import static com.example.ortel.tagnet.Tab1.fab123;
import static com.example.ortel.tagnet.Tab1.fabreplace;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    View myView;
    View main = null;
    public static final String TwoT = "TwoT";
    private int mCurrRotation = 0; // takes the place of getRotation()
    private int mCurrRotation2 = 0; // takes the place of getRotation()
    public static ArrayList<HashMap<String, String>> usersInfo2 = new ArrayList<HashMap<String, String>>();
    public static ArrayList<HashMap<String, String>> usersInfo3 =  new ArrayList<HashMap<String, String>>();
    public String test = "1";
    public  TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = (View) findViewById(R.id.container) ;
        //Make window not adjust when keyboard goes up
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Custom Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Remove title
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Add section for fragment to go
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Tabs that switch fragments
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //Go back to main screen
        ImageView fab12 = findViewById(R.id.fab123);
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab123.setVisibility(View.VISIBLE);
                fabreplace.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, Tab1.class));

            }
        });

        //info bar
        final ImageView fab1 = (ImageView) findViewById(R.id.fab1);
        myView = findViewById(R.id.my_view1);
        myView.setVisibility(View.INVISIBLE);


        //Info bar listener
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Fab", String.valueOf(mCurrRotation));
                mCurrRotation %= 360;
                mCurrRotation2 %= 360;
                float fromRotation = mCurrRotation;
                float fromRotation2 = mCurrRotation2;
                final TextView text = (TextView) findViewById(R.id.textView2);
                boolean x = true;

                if(mCurrRotation == 0 || mCurrRotation == 360) {
                    float toRotation = mCurrRotation += 90;
                    float toRotation2 = mCurrRotation2 -= 360;
                    final RotateAnimation rotateAnim = new RotateAnimation(
                            fromRotation, toRotation, fab1.getWidth() / 2, fab1.getHeight() / 2);
                    rotateAnim.setDuration(200); // Use 0 ms to rotate instantly
                    rotateAnim.setFillAfter(true); // Must be true or the animation will reset
                    fab1.startAnimation(rotateAnim);
                    test = "2";
                    slideUp(myView);
                }else{
                    float toRotation = mCurrRotation -= 90;
                    final RotateAnimation rotateAnim = new RotateAnimation(
                            fromRotation, toRotation, fab1.getWidth() / 2, fab1.getHeight() / 2);
                    rotateAnim.setDuration(200); // Use 0 ms to rotate instantly
                    rotateAnim.setFillAfter(true); // Must be true or the animation will reset
                    fab1.startAnimation(rotateAnim);
                    test = "1";
                    slideDown(myView);
                 }
            }
        });
    }
    //Info bar animation (Up)
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(100);
        final ImageView fab1 = (ImageView) findViewById(R.id.fab1);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        fab1.setEnabled(false);
        main.postDelayed(new Runnable() {
            @Override
            public void run() {
                main.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                //fab1.setOnClickListener(null);
            }
        }, 100 );
        fab1.setEnabled(true);
    }
    //Info bar animation (Down)
    public void slideDown(View view){
        main.setVisibility(View.VISIBLE);
        view.setVisibility(View.GONE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(0);
        animate.setFillAfter(true);
        tabLayout.setVisibility(View.VISIBLE);
        view.startAnimation(animate);

    }








    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    public void showGenderPopup(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer, popup.getMenu());
        popup.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    //Establish Fragments
    public boolean onNavigationItemSelected(MenuItem item) {
              return true;
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){

                case 0:
                    Tab2 tab2 = new Tab2();
                    return tab2;
                case 1:
                    Tab3 tab3 = new Tab3();
                    return tab3;
                default:
                    return null;

            }
        }
        @Override
        public int getCount() {
            return 2;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Disconnect button
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this);
            builder.setMessage("Disconnect from Instagram?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    startActivity(new Intent(MainActivity.this, MainActivityOld.class));

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
    @Override
    public void onBackPressed()
    {
        //Toolbar loadingbar animation stop
        fab123.setVisibility(View.VISIBLE);
        fabreplace.setVisibility(View.GONE);
        super.onBackPressed();  // optional depending on your needs
    }

}