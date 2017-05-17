package com.tapdevs.myapp;

import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.utils.MockObjects;
import com.tapdevs.myapp.viewmodels.GamesViewModel;
import com.tapdevs.myapp.viewmodels.PlayerViewModel;
import com.tapdevs.myapp.views.fragments.GamesListFragment;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by  Jan Shair on 18/05/2017.
 */

public class GameDataModelTest {

    private GamesViewModel gamesViewModel;
    private GameObject gameObject;
    private GamesListFragment gamesListFragment;

    @Before
    public void setUp() {
        gamesListFragment = new GamesListFragment();
        startFragment(gamesListFragment);
        assertNotNull(gamesListFragment);
        gameObject = MockObjects.mockGameObject();
        gamesViewModel = new GamesViewModel(gamesListFragment, gameObject);
    }

    @Test
    public void shouldGetNameText() throws Exception {
        assertEquals(gamesViewModel.getGameData().getName(), gameObject.getName());
    }

    @Test
    public void shouldGetJackpotText() throws Exception {
        assertEquals(gamesViewModel.getGameData().getJackpot(), gameObject.getJackpot());
    }

}
