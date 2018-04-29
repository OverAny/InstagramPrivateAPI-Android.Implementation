package com.example.ortel.tagnet;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.InstagramGetUserFollowersRequest;
import dev.niekirk.com.instagram4android.requests.InstagramGetUserFollowingRequest;
import dev.niekirk.com.instagram4android.requests.InstagramSearchUsernameRequest;
import dev.niekirk.com.instagram4android.requests.InstagramUserFeedRequest;
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult;
import dev.niekirk.com.instagram4android.requests.payload.InstagramGetUserFollowersResult;
import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsernameResult;
import dev.niekirk.com.instagram4android.requests.payload.InstagramUser;
import dev.niekirk.com.instagram4android.requests.payload.InstagramUserSummary;

import static com.example.ortel.tagnet.MainActivityOld.pd;


@SuppressWarnings("deprecation")
public class LoginWorker extends AsyncTask<String, String, NewVars> {
    AsyncResponse delegate = null;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected NewVars doInBackground(String... params) {
        //Username and Password
        String username = params[0];
        String password = params[1];

        //Login
        Instagram4Android instagram = Instagram4Android.builder().username(username).password(password).build();
        instagram.setup();
        try {
            instagram.login();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (instagram.isLoggedIn()) {
            //User id
            Long id = instagram.getUserId();
            //Info from username
            InstagramSearchUsernameResult result = null;
            //Get followers and followings
            InstagramGetUserFollowersResult result2 = null;
            InstagramGetUserFollowersResult result3 = null;

            try {
                result = instagram.sendRequest(new InstagramSearchUsernameRequest(username));
                result2 = instagram.sendRequest(new InstagramGetUserFollowersRequest((id)));
                result3 = instagram.sendRequest(new InstagramGetUserFollowingRequest((id)));



            } catch (IOException e) {
                e.printStackTrace();
            }
            //User
            InstagramUser user = result.getUser();
            //Followers
            ArrayList<HashMap<String, String>> usersInfo = new ArrayList<>();
            //Followings
            ArrayList<HashMap<String, String>> usersInfo1 = new ArrayList<>();
            //Get followers
            List<InstagramUserSummary> List = result2.getUsers();
            //Get followings
            List<InstagramUserSummary> List1 = result3.getUsers();

            //Add followers image and username to list
            for (int data_i = 0; data_i < List.size(); data_i++) {
                HashMap<String, String> hashMap = new HashMap<>();

                InstagramUserSummary list = List.get(data_i);
                String username1 = list.getUsername();
                //list.
                String image1 = list.getProfile_pic_url();
                hashMap.put("username",
                        username1);
                hashMap.put("image",
                        image1);
                usersInfo.add(hashMap);
            }

            //Add followings image and username to list
            for (int data_i = 0; data_i < List1.size(); data_i++) {
                HashMap<String, String> hashMap = new HashMap<>();
                InstagramUserSummary list1 = List1.get(data_i);
                String username1 = list1.getUsername();
                String image1 = list1.getProfile_pic_url();
                hashMap.put("username",
                        username1);
                hashMap.put("image",
                        image1);
                usersInfo1.add(hashMap);
            }

            //Get Users Media
            InstagramFeedResult result41 = null;
            try {
                //request user media
                result41 = instagram.sendRequest(new InstagramUserFeedRequest(instagram.getUserId(), "100",1L));

            } catch (IOException e) {
                e.printStackTrace();
            }

            //Get first media item
            String urls1 = "";
            if (result41.getItems() != null)
            if(result41.getItems().size() > 0) {
                //Check if media is Image
                if (result41.getItems().get(0).getImage_versions2() != null) {
                    urls1 = result41.getItems().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }

                //Check if media is Video
                else {
                    urls1 = result41.getItems().get(0).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }

            //REPEAT

            String urls2 = "";
            if(result41.getItems().size() > 1) {

                if (result41.getItems().get(1).getImage_versions2() != null) {
                    urls2 = result41.getItems().get(1).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls2 = result41.getItems().get(1).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls3 = "";
            if(result41.getItems().size() > 2) {

                if (result41.getItems().get(2).getImage_versions2() != null) {
                    urls3 = result41.getItems().get(2).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls3 = result41.getItems().get(2).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls4 = "";
            if(result41.getItems().size() > 3) {

                if (result41.getItems().get(3).getImage_versions2() != null) {
                    urls4 = result41.getItems().get(3).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls4 = result41.getItems().get(3).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls5 = "";

            if(result41.getItems().size() > 4) {


                if (result41.getItems().get(4).getImage_versions2() != null) {
                    urls5 = result41.getItems().get(4).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls5 = result41.getItems().get(4).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls6 = "";

            if(result41.getItems().size() > 5) {

                if (result41.getItems().get(5).getImage_versions2() != null) {
                    urls6 = result41.getItems().get(5).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls6 = result41.getItems().get(5).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls7 = "";
            if(result41.getItems().size() > 6) {

                if (result41.getItems().get(6).getImage_versions2() != null) {
                    urls7 = result41.getItems().get(6).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls7 = result41.getItems().get(6).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }

            String urls8 = "";
            if (result41.getItems().size()> 7) {

                if (result41.getItems().get(7).getImage_versions2() != null) {
                    urls8 = result41.getItems().get(7).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls8 = result41.getItems().get(7).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls9 = "";


            if (result41.getItems().size()> 8) {

                if (result41.getItems().get(8).getImage_versions2() != null) {
                    urls9 = result41.getItems().get(8).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls9 = result41.getItems().get(8).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls10 = "";


            if (result41.getItems().size()> 9) {

                if (result41.getItems().get(9).getImage_versions2() != null) {
                    urls10 = result41.getItems().get(9).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls10 = result41.getItems().get(9).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls11 = "";


            if (result41.getItems().size()> 10) {

                if (result41.getItems().get(10).getImage_versions2() != null) {
                    urls11= result41.getItems().get(10).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls11 = result41.getItems().get(10).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }
            String urls12 = "";


            if (result41.getItems().size()> 11) {

                if (result41.getItems().get(11).getImage_versions2() != null) {
                    urls12= result41.getItems().get(11).getImage_versions2().getCandidates().get(0).getUrl();
                } else {
                    urls12 = result41.getItems().get(11).getCarousel_media().get(0).getImage_versions2().getCandidates().get(0).getUrl();
                }
            }

            //Add media to the list
            final List<String> urls123 =new ArrayList<String>();
            urls123.add(urls1);
            urls123.add(urls2);
            urls123.add(urls3);
            urls123.add(urls4);
            urls123.add(urls5);
            urls123.add(urls6);
            urls123.add(urls7);
            urls123.add(urls8);
            urls123.add(urls9);
            urls123.add(urls10);
            urls123.add(urls11);
            urls123.add(urls12);

            //Stop loading bar
            pd.dismiss();

            return new NewVars(user, usersInfo, usersInfo1, instagram, urls123);


        }
        //Stop loading bar
        pd.dismiss();
        return null;

    }

    @Override
    protected void onPostExecute(NewVars result) {
        delegate.processFinish(result);
    }

    public interface AsyncResponse {
        //Return value as output
        void processFinish(NewVars output);
    }
}

