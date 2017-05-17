package com.tapdevs.myapp.data.remote;

import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.models.PlayerInfo;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public interface ApiCalls {

    @GET("2ewt6r22zo4qwgx/gameData.json")
    Observable<GameData> getUsers();

    @GET("5zz3hibrxpspoe5/playerInfo.json")
    Observable<PlayerInfo> getPlayer();
}
