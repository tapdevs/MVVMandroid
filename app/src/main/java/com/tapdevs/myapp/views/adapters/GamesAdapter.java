package com.tapdevs.myapp.views.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tapdevs.myapp.R;
import com.tapdevs.myapp.databinding.GameRowBinding;
import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.viewmodels.GamesViewModel;
import com.tapdevs.myapp.views.fragments.GamesListFragment;

import java.util.List;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.BindingHolder> {

    private List<GameObject> gameDataArrayList;
    private GamesListFragment context;

    public GamesAdapter(GamesListFragment context, List<GameObject> androidList) {
        this.context=context;
        gameDataArrayList = androidList;

    }

    public void setItems(List<GameObject> posts) {
        gameDataArrayList = posts;
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        GameRowBinding gameRowBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.game_row,
                parent,
                false);
        return new BindingHolder(gameRowBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {

        GameObject gameData = gameDataArrayList.get(position);
        GameRowBinding commentsHeaderBinding = (GameRowBinding) holder.binding;
        commentsHeaderBinding.setViewModel(new GamesViewModel(context, gameData));
    }

    @Override
    public int getItemCount() {
        return gameDataArrayList.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding binding;

        public BindingHolder(GameRowBinding binding) {
            super(binding.containerItem);
            this.binding = binding;
        }

    }

}
