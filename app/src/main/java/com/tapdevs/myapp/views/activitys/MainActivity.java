package com.tapdevs.myapp.views.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.views.fragments.GamesListFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {



    @Inject
    DataManager mDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        setFragment(new GamesListFragment());
    }

    @Override
    public void injectDependencies() {

    }


    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment,fragment.getClass().getSimpleName())
                .commit();
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame, fragment)
                .addToBackStack(AppConstants.PLAYER_FRAGMENT_TAG)
                .commit();
    }


}
