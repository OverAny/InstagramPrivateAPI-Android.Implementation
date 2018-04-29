package com.example.ortel.tagnet;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.payload.InstagramUser;

/**
 * Created by Ortel on 4/13/18.
 */
final class MyTasksParams {
    Instagram4Android instagram;
    String username;

    MyTasksParams(Instagram4Android instagram, String username) {
        this.instagram = instagram;
        this.username = username;

    }
}
