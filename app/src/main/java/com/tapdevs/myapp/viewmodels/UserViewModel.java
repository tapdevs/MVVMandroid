package com.tapdevs.myapp.viewmodels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.fragments.UsersFragment;

/**
 * Created by  Jan Shair on 15/02/2017.
 */

public class UserViewModel extends BaseObservable {
    private UsersFragment context;
    private User user;

    public User getUser() {
        return user;
    }

    public UserViewModel(UsersFragment context, User user) {
        this.context=context;
        this.user= user;
    }



    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public View.OnClickListener onClickSave() {
        return view -> context.saveUser(user);

    }

    public View.OnClickListener onClickFvt() {
        return view -> context.makeItFvtUser((ImageButton)view,user);

    }
}
