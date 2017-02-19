package com.tapdevs.myapp.views.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.data.RealmDataManager;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.utils.DialogFactory;
import com.tapdevs.myapp.utils.NetworkUtils;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.adapters.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import static com.tapdevs.myapp.R.layout.fragment_users;

/**
 * Created by  Jan Shair on 15/02/2017.
 */

public class UsersFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    private MainActivity context;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;


    private CompositeDisposable mCompositeDisposable;

    private UserAdapter mAdapter;

    private ArrayList<User> users;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    

    @BindView(R.id.layout_offline)
    LinearLayout mOfflineContainer;

    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_error)
    TextView errorView;


    @Inject DataManager mDataManager;
    @Inject
    RealmDataManager realm;

   

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=(MainActivity)getActivity();
        mCompositeDisposable = new CompositeDisposable();
        users = new ArrayList<>();
        mAdapter = new UserAdapter(this, users);
    }



    @Override
    public void initialize() {
        if(realm != null && realm.getRealm().isClosed()){
            realm.initRealm();
        }
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        setupToolbar();
        setupRecyclerView();
        loadUsersIfNetworkConnected();
    }

    @Override
    protected int getFragmentLayout() {
        return fragment_users;
    }

    @Override
    protected void injectDependencies() {
        MyApp.get(getActivity()).getNetComponent().inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

    @Override
    public void onRefresh() {
        mCompositeDisposable.clear();
        if (mAdapter != null) mAdapter.setItems(new ArrayList<User>());

        loadUsersIfNetworkConnected();
    }

    @OnClick(R.id.button_try_again)
    public void onTryAgainClick() {
        loadUsersIfNetworkConnected();
    }

    private void setupToolbar() {
        context.setSupportActionBar(mToolbar);
        ActionBar actionBar = context.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(R.string.app_name);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }


    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mAdapter.setItems(users);
        mRecyclerView.setAdapter(mAdapter);
    }


    public void onNext(List<User> value) {
        showHideOfflineLayout(false);
        hideLoadingViews();
        handleResponse(value);
        realm.saveUserObjects(value);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        realm.getRealm().close();
    }

    public void onError(Throwable e) {
        handleError(e);
        hideLoadingViews();
        Timber.e("There was a problem loading users " + e);
        e.printStackTrace();
        DialogFactory.createSimpleOkErrorDialog(
                context,
                "There was a problem loading users " + e
        ).show();
    }

    public void onComplete() {

        hideLoadingViews();


    }
    private void loadUsersIfNetworkConnected() {

        if(NetworkUtils.checkInternet(context)){


            showHideOfflineLayout(false);
            mCompositeDisposable.add(mDataManager.getUserList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::onNext, this::onError,this::onComplete));
        }else {
            List<User> allOfflineUsers= realm.getAllUsers();
            if (allOfflineUsers.size() > 0) {
                handleResponse(realm.getAllUsers());
            }else {
                showError(getString(R.string.noInternet));
            }

        }
    }

    private void handleResponse(List<User> androidList) {
        hideLoadingViews();
        users = new ArrayList<>(androidList);
        mAdapter = new UserAdapter(this,users);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void handleError(Throwable error) {

        showError("Error "+error.getLocalizedMessage());
    }


    private void hideLoadingViews() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void showHideOfflineLayout(boolean isOffline) {
        mOfflineContainer.setVisibility(isOffline ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(isOffline ? View.GONE : View.VISIBLE);
        mProgressBar.setVisibility(isOffline ? View.GONE : View.VISIBLE);
        hideLoadingViews();
    }

    private void showError(String message) {
        showHideOfflineLayout(true);
        errorView.setText(message);
    }


    public void browseThisUser(User user) {
        BrowseProfileFragment browseProfileFragment=new BrowseProfileFragment();
        Bundle args= new Bundle();
        args.putParcelable(AppConstants.USER_OBJECT_PARCELABLE_KEY,user);
        browseProfileFragment.setArguments(args);

        context.addFragment(browseProfileFragment);
    }
}
