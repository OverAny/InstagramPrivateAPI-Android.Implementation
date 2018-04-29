package com.example.ortel.tagnet;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.payload.InstagramUser;


public class MainActivityOld extends FragmentActivity implements View.OnClickListener, LoginWorker.AsyncResponse, TextWatcher,
        CompoundButton.OnCheckedChangeListener {
    private Button btnConnect;
    public static String username;
    public static String password;
    public static HashMap<String, String> userInfoHashmap = new HashMap<String, String>();
    //Followers (Image and User)
    public static ArrayList<HashMap<String, String>> userInfo;
    //Following (Image and User)
    public static ArrayList<HashMap<String, String>> userInfo1;
    public static String url;
    public static String url1;

    //User
    public static InstagramUser output1;
    //Android User
    public static Instagram4Android output2;
    //Media Images
    public static List<String> output3;

    //Images
    public static ImageView i1;
    public static ImageView i2;
    public static ImageView i3;
    public static ImageView i4;
    public static ImageView i5;
    public static ImageView i6;
    public static ImageView i7;
    public static ImageView i8;
    public static ImageView i9;
    public static ImageView i10;
    public static ImageView i11;
    public static ImageView i12;

    private CheckBox rem_userpass;

    //Save credentials assistant
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public EditText username1;
    public EditText password1;

    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";
    public static ProgressDialog pd;

    LoginWorker asyncTask =new LoginWorker();
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnConnect = (Button) findViewById(R.id.btnConnect);
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //SAVE USERNAME AND PASSWORD IN APPLICATION
        username1 = (EditText)findViewById(R.id.username);
        password1 = (EditText)findViewById(R.id.password);
        rem_userpass = (CheckBox)findViewById(R.id.checkBox);

        username1.setText(sharedPreferences.getString(KEY_USERNAME,""));
        password1.setText(sharedPreferences.getString(KEY_PASS,""));

        username1.addTextChangedListener(this);
        password1.addTextChangedListener(this);
        rem_userpass.setOnCheckedChangeListener(this);
        if(sharedPreferences.getBoolean(KEY_REMEMBER, false)) {
            Log.d("Saved", String.valueOf(1));
            rem_userpass.setChecked(true);
        }else {
            Log.d("Saved", String.valueOf(2));
            rem_userpass.setChecked(false);
        }

        Log.d("OkHttp1234", String.valueOf(userInfoHashmap));
        username1 = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password);

        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);
        i4 = findViewById(R.id.i4);
        i5 = findViewById(R.id.i5);
        i6 = findViewById(R.id.i6);
        i7 = findViewById(R.id.i7);
        i8 = findViewById(R.id.i8);
        i9 = findViewById(R.id.i9);
        i10 = findViewById(R.id.i10);
        i11 = findViewById(R.id.i11);
        i12 = findViewById(R.id.i12);
        bindEventHandlers();

    }




    private void bindEventHandlers() {
        btnConnect.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        //Lower keyboard on connect button click
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        if (v == btnConnect) {

            if (!username1.getText().toString().isEmpty() && !password1.getText().toString().isEmpty()) {
                Log.d("OkHttpUsername", String.valueOf(username1.getText()));
                Log.d("OkHttpPassword", String.valueOf(password1.getText()));
                username = username1.getText().toString().toLowerCase() ;
                password = password1.getText().toString();

                //Loading Bar

                pd = ProgressDialog.show(MainActivityOld.this, "", "Loading...");
                pd.setCancelable(false);

                //Run Login Worker
                asyncTask.delegate = this;
                asyncTask.execute(username,password);


            }

        }
    }


    @Override
    public void processFinish(NewVars output) {
        //Log.d("outputmain", String.valueOf(output.getFirst()));
        final Snackbar snackbar = Snackbar.make(this.findViewById(android.R.id.content), "Check Username or Password", Snackbar.LENGTH_SHORT)
                .setAction("Action", null);
        final Snackbar snackbar1 = Snackbar.make(this.findViewById(android.R.id.content), "Connecting...", Snackbar.LENGTH_SHORT)
                .setAction("Action", null);
        if (output != null) {
            //User
            output1 = output.getFirst();
            //Followers
            userInfo = output.getSecond();
            //Followings
            userInfo1 = output.getThird();
            //Android User
            output2 = output.getFourth();
            //Recent Media
            output3 = output.getFifth();
            startActivity(new Intent(MainActivityOld.this, Tab1.class));
        } else {
            snackbar.show();
        }
        asyncTask = new LoginWorker();

    }

    @Override
    public void onResume() {
        super.onResume();
        //loadPreferences();
    }
    @Override
    public void onPause() {
        super.onPause();
        //savePreferences();

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }

    private void managePrefs(){
        if(rem_userpass.isChecked()){
            editor.putString(KEY_USERNAME, username1.getText().toString().trim());
            editor.putString(KEY_PASS, password1.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        }else{
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_PASS);//editor.putString(KEY_PASS,"");
            editor.remove(KEY_USERNAME);//editor.putString(KEY_USERNAME, "");
            editor.apply();
        }
    }
    //public String Test = userInfoHashmap.get(InstagramApp.TAG_USERNAME);
}
