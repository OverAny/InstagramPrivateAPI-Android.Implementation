package com.example.ortel.tagnet;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.InstagramSearchUsernameRequest;
import dev.niekirk.com.instagram4android.requests.InstagramUserFeedRequest;
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult;
import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsernameResult;

public class GetUrls extends AsyncTask<MyTasksParams, MyTasksParams, List<String>> {
    AsyncResponse delegate = null;
    @Override
    protected void onPostExecute(List<String> result) {
        delegate.processFinish(result);
    }
    @Override
    protected List<String> doInBackground(MyTasksParams... params) {
        //User Login Information
        Instagram4Android instagram = params[0].instagram;
        //User Username
        String User = params[0].username;
            //Establish Variables
            InstagramSearchUsernameResult result1;
            InstagramFeedResult result4 = null;
            try {
                //Get Info From Username
                result1 = instagram.sendRequest(new InstagramSearchUsernameRequest((User)));
                //Get Media From Username
                result4 = instagram.sendRequest(new InstagramUserFeedRequest(result1.getUser().getPk(), "100",1L));
            } catch (IOException e) {
                e.printStackTrace();
            }
        //Establish Empty Url Links
        String urls1 = "";
        String urls2 = "";
        String urls3 = "";
        String urls4 = "";
        String urls5 = "";
        String urls6 = "";
        String urls7 = "";
        String urls8 = "";
        String urls9 = "";
        //To see if there is any medis
        if (result4 != null) {
            if (result4.getItems() != null) {
                //To see if there are Items in the media list
                if (result4.getItems().size() > 0) {
                    //Check if media is Image
                    if (result4.getItems().get(0).getImage_versions2() != null) {
                        urls1 = result4.getItems().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                    //Check if media is Video
                    else {
                        urls1 = result4.getItems().get(0).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }
                //Repeat
                if (result4.getItems().size() > 1) {

                    if (result4.getItems().get(1).getImage_versions2() != null) {
                        urls2 = result4.getItems().get(1).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls2 = result4.getItems().get(1).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }
                if (result4.getItems().size() > 2) {

                    if (result4.getItems().get(2).getImage_versions2() != null) {
                        urls3 = result4.getItems().get(2).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls3 = result4.getItems().get(2).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }
                if (result4.getItems().size() > 3) {

                    if (result4.getItems().get(3).getImage_versions2() != null) {
                        urls4 = result4.getItems().get(3).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls4 = result4.getItems().get(3).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }

                if (result4.getItems().size() > 4) {


                    if (result4.getItems().get(4).getImage_versions2() != null) {
                        urls5 = result4.getItems().get(4).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls5 = result4.getItems().get(4).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }

                if (result4.getItems().size() > 5) {

                    if (result4.getItems().get(5).getImage_versions2() != null) {
                        urls6 = result4.getItems().get(5).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls6 = result4.getItems().get(5).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }
                if (result4.getItems().size() > 6) {

                    if (result4.getItems().get(6).getImage_versions2() != null) {
                        urls7 = result4.getItems().get(6).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls7 = result4.getItems().get(6).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }

                if (result4.getItems().size() > 7) {

                    if (result4.getItems().get(7).getImage_versions2() != null) {
                        urls8 = result4.getItems().get(7).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls8 = result4.getItems().get(7).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }


                if (result4.getItems().size() > 8) {

                    if (result4.getItems().get(8).getImage_versions2() != null) {
                        urls9 = result4.getItems().get(8).getImage_versions2().getCandidates().get(0).getUrl();
                    } else {
                        urls9 = result4.getItems().get(8).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                    }
                }

            }
        }
        //Add media to the list
        final List<String> urls123 = new ArrayList<>();
            urls123.add(urls1);
            urls123.add(urls2);
            urls123.add(urls3);
            urls123.add(urls4);
            urls123.add(urls5);
            urls123.add(urls6);
            urls123.add(urls7);
            urls123.add(urls8);
            urls123.add(urls9);
            return urls123;
    }
    public interface AsyncResponse {
        //Return value as output
        void processFinish(List<String> output);
    }
}

