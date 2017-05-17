package com.tapdevs.myapp.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.views.fragments.GamesListFragment;

/**
 * Created by  Jan Shair on 15/02/2017.
 */

public class GamesViewModel extends BaseObservable {
    private GamesListFragment context;
    private GameObject gameData;

    public GameObject getGameData() {
        return gameData;
    }

    public GamesViewModel(GamesListFragment context, GameObject gameData) {
        this.context=context;
        this.gameData = gameData;
    }


    public String getJackpotValue() {
        return context.getCurrency()+ " " +gameData.getJackpot();

    }

    public void onClickView(View view) {
        context.browseThisUser(gameData);

    }


}
