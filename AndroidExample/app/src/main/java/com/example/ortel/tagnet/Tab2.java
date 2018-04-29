package com.example.ortel.tagnet;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static com.example.ortel.tagnet.MainActivity.usersInfo2;
import static com.example.ortel.tagnet.MainActivity.usersInfo3;
import static com.example.ortel.tagnet.MainActivityOld.userInfo;
import static com.example.ortel.tagnet.RelationShipAdapter.usersInfo;

public class Tab2 extends Fragment{
    private static ProgressBar pd;
    private SearchView sv;
    private List<String> where = new ArrayList<String>();
    private ListView lvRelationShipAllUser;
    private View test;
    private ArrayList<HashMap<String, String>> usersInfoOne = new ArrayList<HashMap<String, String>>();
    private RelationShipAdapter adapter2;
    private static Context context;
    private static View pd1;
    public static ImageView MainImage;
    public static TextView MainText;
    public static ImageView onei;
    public static ImageView twoi;
    public static ImageView threei;
    public static ImageView fouri;
    public static ImageView fivei;
    public static ImageView sixi;
    public static ImageView seveni;
    public static ImageView eighti;
    public static ImageView ninei;
    public static View popup123;
    public static View maincintent;
    public static FloatingActionButton fabbs;
    private static View rootView;
    View Divider;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_blank_fragment_two, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        popup123 = (View) rootView.findViewById(R.id.my_view);
        popup123.setVisibility(View.GONE);
        maincintent = (View) rootView.findViewById(R.id.main_content);
        MainImage = (ImageView) rootView.findViewById(R.id.ImageProfile);
        usersInfoOne = userInfo;

        fabbs = (FloatingActionButton) rootView.findViewById(R.id.fabbs);
        fabbs.setVisibility(View.GONE);
        fabbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup123.setVisibility(View.GONE);
                fabbs.setVisibility(View.GONE);
                maincintent.setVisibility(View.VISIBLE);
                NoMediastop();



            }
        });
        Picasso.with(context)
                .load(R.drawable.profile)
                .into(MainImage);
        //MainImage = (ImageView) rootView.findViewById(R.id.ImageProfile);
        MainText = (TextView) rootView.findViewById(R.id.Username);
        adapter2 = new RelationShipAdapter(getContext(),userInfo,usersInfoOne);

        Divider = (View) rootView.findViewById(R.id.test1);

        sv=(SearchView) rootView.findViewById(R.id.search);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                Log.d("OkHttpNList", "here.1");

                adapter2.getFilter().filter(text);

                return false;
            }
        });

        lvRelationShipAllUser = (ListView) rootView.findViewById(R.id.lvRelationShip);
        lvRelationShipAllUser = (ListView) rootView.findViewById(R.id.lvRelationShip);
        lvRelationShipAllUser.setDividerHeight(0);
        test = (View) rootView.findViewById(R.id.test2);
        test.setY(1372);

         onei = (ImageView) rootView.findViewById(R.id.onei);
         twoi = (ImageView) rootView.findViewById(R.id.twoi);
         threei = (ImageView) rootView.findViewById(R.id.threei);
         fouri = (ImageView) rootView.findViewById(R.id.fouri);
         fivei = (ImageView) rootView.findViewById(R.id.fivei);
         sixi = (ImageView) rootView.findViewById(R.id.sixi);
         seveni = (ImageView) rootView.findViewById(R.id.seveni);
         eighti = (ImageView) rootView.findViewById(R.id.eighti);
         ninei = (ImageView) rootView.findViewById(R.id.ninei);



        setImageGridAdapter();


        return rootView;
    }

    private void setImageGridAdapter() {
        Log.d("MyApp","test123 ");
        final Holder holder = new Holder();
        lvRelationShipAllUser.setAdapter(adapter2);
        lvRelationShipAllUser.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l  ) {
                Log.d("MyApp","test1");
                //Picasso.with(context)
                //        .load(userInfo.get(i).get("image"))
                 //        .into(MainImage);
            }
        });
    }

    public static void set(int i){
        Log.d("MyApp","test1");
        popup123.setVisibility(View.VISIBLE);
        Picasso.with(context)
                .load(usersInfo.get(i).get("image"))
                .into(MainImage);
        MainText.setText(usersInfo.get(i).get("username"));
        maincintent.setVisibility(View.GONE);
        fabbs.setVisibility(View.VISIBLE);

    }
    public static void load(){
        pd = (ProgressBar) rootView.findViewById(R.id.Ind);
        pd.setVisibility(View.VISIBLE);
    }
    public static void stop(){
        pd.setVisibility(View.INVISIBLE);

    }
    public static void NoMediaload(){
        pd1 = (View) rootView.findViewById(R.id.NoMedia);
        pd1.setVisibility(View.VISIBLE);

    }
    public static void NoMediastop(){
        pd1 = (View) rootView.findViewById(R.id.NoMedia);
        pd1.setVisibility(View.INVISIBLE);

    }
    private class Holder {
        private ImageView ivPhoto;
        private TextView tvFullName;
        private TextView tvFullName1;
        private Button button;

    }
}


