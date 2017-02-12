package com.tapdevs.myapp.data.remote;

import com.tapdevs.myapp.models.User;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public interface ApiCalls {

    @GET("users")
    Observable<List<User>> getUsers();

}
