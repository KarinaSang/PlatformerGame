package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class PlatformerGame extends GameApplication {
    private Entity player;
    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new GameFactory());
        FXGL.setLevelFromMap("level1_map.tmx");
        FXGL.getGameScene().setBackgroundRepeat("background/forest.png");

        player = FXGL.getGameWorld().spawn("player", 50, 50);
    }


    protected void initSettings(GameSettings settings) {
        settings.setWidth(30*32);
        settings.setHeight(20*32);
        settings.setTitle("Platformer Game");
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).left();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stop();

            }
        }, KeyCode.A);
        FXGL.getInput().addAction(new UserAction("right") {
                @Override
                protected void onAction () {
                    player.getComponent(PlayerComponent.class).right();
                }

                @Override
                protected void onActionEnd () {
                    player.getComponent(PlayerComponent.class).stop();
                }
            }, KeyCode.D);
        FXGL.getInput().addAction(new UserAction("jump") {
                 @Override
                 protected void onAction() {
                    player.getComponent(PlayerComponent.class).jump();
                 }

                 @Override
                 protected void onActionEnd() {
                     player.getComponent(PlayerComponent.class).stop();
                 }
            }, KeyCode.SPACE);

    }
    public static void main(String[] args) {
        launch(args);
    }
}