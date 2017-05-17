package com.tapdevs.myapp.views.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.databinding.FragmentPlayerInfoBinding;
import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.models.PlayerInfo;
import com.tapdevs.myapp.utils.DialogFactory;
import com.tapdevs.myapp.utils.GridAutofitLayoutManager;
import com.tapdevs.myapp.utils.MockObjects;
import com.tapdevs.myapp.viewmodels.PlayerViewModel;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.adapters.GamesAdapter;

import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

import static android.R.attr.data;
import static com.tapdevs.myapp.R.layout.fragment_games_list;
import static com.tapdevs.myapp.R.layout.fragment_player_info;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class PlayerInfoFragment extends BaseFragment {


    private MainActivity context;

    private CompositeDisposable mCompositeDisposable;

    private GamesAdapter mAdapter;

    private PlayerInfo playerInfo;

    @BindView(R.id.layout_offline)
    LinearLayout mOfflineContainer;

    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_error)
    TextView errorView;


    @Inject
    DataManager mDataManager;
    private FragmentPlayerInfoBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = (MainActivity) getActivity();
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public View getBindingView(LayoutInflater inflater, int fragmentLayout, ViewGroup container, boolean b) {
        binding = DataBindingUtil.inflate(
                inflater, getFragmentLayout(), container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class PlayerViewModel
        binding.setViewModel(new PlayerViewModel(this,playerInfo));
        return view;
    }

    @Override
    public void initialize() {
        setupToolbar();
        loadData();
    }

    @Override
    protected int getFragmentLayout() {
        return fragment_player_info;
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


    @OnClick(R.id.button_try_again)
    public void onTryAgainClick() {
        loadData();
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


    public void onNext(PlayerInfo value) {
        showHideOfflineLayout(false);
        hideLoadingViews();
        handleResponse(value);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onError(Throwable e) {
        String errorMessage = null;
        if (e instanceof UnknownHostException) {
            errorMessage = getString(R.string.noInternet);
        }
        showError("Error :" + errorMessage);
        hideLoadingViews();
        Timber.e("There was a problem loading playerInfo " + e);
        e.printStackTrace();
        DialogFactory.createSimpleOkErrorDialog(
                context,
                "There was a problem loading playerInfo \n " + errorMessage
        ).show();
    }

    public void onComplete() {

        hideLoadingViews();


    }

    private void loadData() {

        showHideOfflineLayout(false);
        mCompositeDisposable.add(mDataManager.getPlayer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mDataManager.getScheduler())
                .subscribe(this::onNext, this::onError, this::onComplete));

    }

    private void handleResponse(PlayerInfo playerInfo) {
        hideLoadingViews();
        this.playerInfo=playerInfo;
        setViewModel();

    }

    private void setViewModel() {
        binding.setViewModel(new PlayerViewModel(this,playerInfo));
    }


    private void hideLoadingViews() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showHideOfflineLayout(boolean isOffline) {
        mOfflineContainer.setVisibility(isOffline ? View.VISIBLE : View.GONE);
        mProgressBar.setVisibility(isOffline ? View.GONE : View.VISIBLE);
    }

    private void showError(String message) {
        showHideOfflineLayout(true);
        errorView.setText(message);
    }

}
