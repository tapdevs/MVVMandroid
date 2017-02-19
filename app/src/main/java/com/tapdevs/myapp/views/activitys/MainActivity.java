package com.tapdevs.myapp.views.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewFragment;
import android.widget.TextView;
import android.widget.Toast;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.data.remote.RetrofitHelper;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.utils.NetworkUtils;
import com.tapdevs.myapp.utils.RealmUtil;
import com.tapdevs.myapp.views.adapters.UserAdapter;
import com.tapdevs.myapp.views.fragments.BrowseProfileFragment;
import com.tapdevs.myapp.views.fragments.UsersFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

import static android.R.attr.fragment;

public class MainActivity extends BaseActivity {



    @Inject
    DataManager mDataManager;
    @Inject
    RealmUtil realm;
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
                .replace(R.id.content_frame, fragment)
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
