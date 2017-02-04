package com.tapdevs.myapp.data.remote;

import com.google.gson.GsonBuilder;
import com.tapdevs.myapp.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class RetrofitHelper {

    public ApiCalls newApiCalls() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiCalls.class);
    }
}
