package com.tapdevs.myapp;

import android.content.Context;
import android.util.Log;

import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.TextCheckers;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.fragments.UsersFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by  Jan Shair on 17/02/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = MyApp.class)
public class RoboelectricTest  {



    private MainActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( MainActivity.class )
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveUsersFragment() throws Exception
    {
        assertNotNull( activity.getFragmentManager().findFragmentById(R.id.content_frame));
    }
}
