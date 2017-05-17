package com.tapdevs.myapp.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.tapdevs.myapp.R;
import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.utils.AppConstants;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BrowseProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseProfileFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    @BindView(R.id.webview)
    WebView webView;

    // TODO: Rename and change types of parameters
    private GameData gameDataObject;


    public BrowseProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param gameDataObject Parameter 1.
     * @return A new instance of fragment BrowseProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrowseProfileFragment newInstance(GameData gameDataObject) {
        BrowseProfileFragment fragment = new BrowseProfileFragment();
        Bundle args = new Bundle();
//        args.putParcelable(AppConstants.USER_OBJECT_PARCELABLE_KEY, gameDataObject);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gameDataObject = getArguments().getParcelable(AppConstants.USER_OBJECT_PARCELABLE_KEY);
        }
    }


    @Override
    public View getBindingView(LayoutInflater inflater, int fragmentLayout, ViewGroup container, boolean b) {
        return null;
    }

    @Override
    public void initialize() {
        webView.loadUrl(gameDataObject.getCurrency());
        webView.getSettings().setJavaScriptEnabled(true);

    }



    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_browse_profile;
    }

    @Override
    protected void injectDependencies() {

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
