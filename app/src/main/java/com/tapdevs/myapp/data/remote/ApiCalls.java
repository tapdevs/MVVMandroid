package com.tapdevs.myapp.data.remote;

import com.tapdevs.myapp.models.Article;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public interface ApiCalls {

    @GET("/source/{source}")
    Observable<List<Article>> getTopStories(@Path("source") String source, @Header("Authorization") String authorization);

    @GET("users")
    String getAllUsers();

}
