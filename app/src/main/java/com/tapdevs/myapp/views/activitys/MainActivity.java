package com.tapdevs.myapp.views.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.data.RealmDataManager;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.views.fragments.UsersFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {



    @Inject
    DataManager mDataManager;
    @Inject
    RealmDataManager realm;
    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(new UsersFragment());
    }

    @Override
    public void injectDependencies() {
        context=this;
        MyApp.get(context).getNetComponent().inject(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_view_on_github:
                //TODO: Add github link
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                .addToBackStack(AppConstants.BROWSE_FRAGMENT_TAG)
                .commit();
    }


}
