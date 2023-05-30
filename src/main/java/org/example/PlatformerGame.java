package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class PlatformerGame extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(30*32);
        settings.setHeight(20*32);
        settings.setTitle("Platformer Game");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new GameFactory());
        FXGL.setLevelFromMap("level1_map.tmx");
        FXGL.getGameScene().setBackgroundRepeat("background/forest.png");

        Entity player = FXGL.getGameWorld().spawn("player", 50, 50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}