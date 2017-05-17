package com.tapdevs.myapp;

import android.content.Context;

import com.tapdevs.myapp.models.PlayerInfo;
import com.tapdevs.myapp.utils.MockObjects;
import com.tapdevs.myapp.viewmodels.PlayerViewModel;
import com.tapdevs.myapp.views.fragments.PlayerInfoFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by  Jan Shair on 17/05/2017.
 */

@RunWith(RobolectricTestRunner.class)
public class PlayerInfoModelTest {

    private PlayerViewModel playerViewModel;
    private PlayerInfo playerInfo;
    private PlayerInfoFragment playerInfoFragment;

    @Before
    public void setUp() {
        playerInfoFragment= new PlayerInfoFragment();
        startFragment( playerInfoFragment );
        assertNotNull( playerInfoFragment );
        playerInfo = MockObjects.mockPlayerInfo();
        playerViewModel = new PlayerViewModel(playerInfoFragment, playerInfo);
    }

    @Test
    public void shouldGetNameText() throws Exception {
        assertEquals(playerViewModel.getPlayerInfo().getName(), playerInfo.getName());
    }

    @Test
    public void shouldGetBalanceText() throws Exception {
        assertEquals(playerViewModel.getPlayerInfo().getBalance(), playerInfo.getBalance());
    }

    @Test
    public void shouldGetAvatarLinkText() throws Exception {
        assertEquals(playerViewModel.getPlayerInfo().getAvatarLink(), playerInfo.getAvatarLink());
    }

}
