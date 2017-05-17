package com.tapdevs.myapp.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.models.PlayerInfo;
import com.tapdevs.myapp.views.fragments.GamesListFragment;
import com.tapdevs.myapp.views.fragments.PlayerInfoFragment;

/**
 * Created by  Jan Shair on 17/05/2017.
 */

public class PlayerViewModel extends BaseObservable {

    private PlayerInfoFragment context;
    private PlayerInfo playerInfo;

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public PlayerViewModel(PlayerInfoFragment context, PlayerInfo playerInfo) {
        this.context=context;
        this.playerInfo = playerInfo;
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.ic_no_internet)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


}
