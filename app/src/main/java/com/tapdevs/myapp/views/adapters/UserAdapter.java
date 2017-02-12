package com.tapdevs.myapp.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.models.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> userArrayList;
    private Activity context;

    public UserAdapter(Activity context, ArrayList<User> androidList) {
        this.context=context;
        userArrayList = androidList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        User user=userArrayList.get(position);
        holder.mTvName.setText(user.getLogin());
        holder.mTVURL.setText(user.getHtml_url());
        Glide.with(context)
                .load(user.getAvatar_url())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mAvatar);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_name) TextView mTvName;
        @BindView(R.id.tv_url) TextView mTVURL;
        @BindView(R.id.iv_avatar)
        ImageView mAvatar;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
