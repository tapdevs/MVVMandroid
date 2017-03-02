package com.tapdevs.myapp.views.activitys;

import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.views.fragments.BaseFragment;


import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private BaseActivity context;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
//        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
//        User user = new User("Test", "User");
//        binding.setUser(user);
        injectDependencies();
        injectViews();
    }



    /**
     * Create a new Dagger ObjectGraph to add new dependencies using a plus operation and inject the
     * declared one in the activity. This new graph will be destroyed once the activity lifecycle
     * finish.
     *
     * This is the key of how to use Activity scope dependency injection.
     */
    public abstract void injectDependencies() ;

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     */
    private void injectViews() {
        ButterKnife.bind(this);
    }

    /**
     * Options items selected
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
