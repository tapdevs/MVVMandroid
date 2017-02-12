package com.tapdevs.myapp.views.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.TextView;
import android.widget.Toast;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.data.remote.RetrofitHelper;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.NetworkUtils;
import com.tapdevs.myapp.views.adapters.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainActivity context;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_error)
    TextView errorView;

    private CompositeDisposable mCompositeDisposable;

    private UserAdapter mAdapter;

    private ArrayList<User> mAndroidArrayList;
    private ApiCalls apiCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiCalls= MyApp.get(context).getNetComponent().provideApiInterface();
        mCompositeDisposable = new CompositeDisposable();
        initRecyclerView();
        checkInternetAndMakeCall();

    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void checkInternetAndMakeCall() {

        if(NetworkUtils.checkInternet(context)){


            hideError();
            mCompositeDisposable.add(apiCalls.getUsers()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse,this::handleError));

        }else {
            showError(getString(R.string.noInternet));
        }
    }
    private void handleResponse(List<User> androidList) {

        mAndroidArrayList = new ArrayList<>(androidList);
        mAdapter = new UserAdapter(context,mAndroidArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void handleError(Throwable error) {

        showError("Error "+error.getLocalizedMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
    private void showError(String message) {
        mRecyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        errorView.setText(message);
    }

    private void hideError() {
        mRecyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){

        }else {
            super.onBackPressed();
        }
    }
}
