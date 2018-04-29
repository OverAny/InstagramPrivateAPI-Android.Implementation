package com.example.ortel.tagnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.payload.InstagramUser;

/**
 * Created by Ortel on 4/9/18.
 */

final class NewVars {
    final InstagramUser first;
    final ArrayList<HashMap<String, String>> second;
    final ArrayList<HashMap<String, String>> third;
    final Instagram4Android fourth;
    final List<String> fifth;



    public NewVars(InstagramUser first, ArrayList<HashMap<String, String>> second, ArrayList<HashMap<String, String>> third, Instagram4Android fourth, List<String> fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public InstagramUser getFirst() {
        return first;
    }

    public ArrayList<HashMap<String, String>> getSecond() {
        return second;
    }
    public ArrayList<HashMap<String, String>> getThird() {
        return third;
    }
    public Instagram4Android getFourth() {
        return fourth;
    }
    public  List<String> getFifth(){
        return fifth;
    }

}

