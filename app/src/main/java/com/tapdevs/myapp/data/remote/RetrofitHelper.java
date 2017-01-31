package com.tapdevs.myapp.data.remote;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class RetrofitHelper {

    public ApiCalls newHackerNewsService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiCalls.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiCalls.class);
    }
}
