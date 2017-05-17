package com.tapdevs.myapp.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.views.fragments.UsersFragment;

/**
 * Created by  Jan Shair on 15/02/2017.
 */

public class UserViewModel extends BaseObservable {
    private UsersFragment context;
    private GameObject gameData;

    public GameObject getGameData() {
        return gameData;
    }

    public UserViewModel(UsersFragment context, GameObject gameData) {
        this.context=context;
        this.gameData = gameData;
    }



    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.ic_no_internet)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }



    public void onClickView(View view) {
        context.browseThisUser(gameData);

    }


}
