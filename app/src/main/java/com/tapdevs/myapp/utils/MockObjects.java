package com.tapdevs.myapp.utils;

import com.tapdevs.myapp.models.GameData;
import com.tapdevs.myapp.models.GameObject;
import com.tapdevs.myapp.models.PlayerInfo;

/**
 * Created by  Jan Shair on 17/05/2017.
 */

public class MockObjects {

    public static PlayerInfo mockPlayerInfo(){
        PlayerInfo playerInfo= new PlayerInfo();
        playerInfo.setName("Test");
        playerInfo.setBalance(123456);
        playerInfo.setAvatarLink("https://dl.dropboxusercontent.com/s/8a1j70z1ik3y0q8/user_avatar.png");
        return playerInfo;
    }

    public static GameObject mockGameObject(){
        GameObject gameData = new GameObject();
        gameData.setName("Test");
        gameData.setJackpot(12000);
        return gameData;
    }
}
