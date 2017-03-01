package com.tapdevs.myapp.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by  Jan Shair on 18/02/2017.
 */

public abstract class BaseFragment extends Fragment {

    @Override public void onAttach(Context activity) {
        super.onAttach(activity);
        injectDependencies();

    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        View view=getBindingView(inflater,getFragmentLayout(),container,false);
        if(view == null) {
            view = inflater.inflate(getFragmentLayout(), container, false);
        }

        return view;
    }

    public abstract View getBindingView(LayoutInflater inflater, int fragmentLayout, ViewGroup container, boolean b);


    /**
     * Initialize any core functions
     */
    public abstract void initialize();

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
        initialize();
    }

    /**
     * Every fragment has to inflate a layout in the onCreateView method. We have added this method to
     * avoid duplicate all the inflate code in every fragment. You only have to return the layout to
     * inflate in this method when extends BaseFragment.
     */
    protected abstract int getFragmentLayout();

    /**
     * Replace every field annotated using @Inject annotation with the provided dependency specified
     * inside a Dagger module value.
     */
    protected abstract void injectDependencies() ;

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     *
     * @param view to extract each widget injected in the fragment.
     */
    private void injectViews(final View view) {
        ButterKnife.bind(this, view);
    }
}