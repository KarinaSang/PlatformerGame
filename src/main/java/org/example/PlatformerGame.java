package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Map;

public class PlatformerGame extends GameApplication {
    private Entity player;
    private void onPlayerDied() {
        System.out.println("u suck");
        FXGL.getDialogService().showMessageBox("u died loser", () -> {
            FXGL.getGameController().exit();
        });
    }
    @Override
    protected void onUpdate(double tpf) {
        FXGL.inc("levelTime", tpf);

        if (player.getY() > FXGL.getAppHeight()) {
            onPlayerDied();
        }
    }
    protected void initUI() {
        Text scoreText = new Text("Score");
        scoreText.setFont(new Font(30));
        Text score = new Text();
        score.textProperty().bind(FXGL.getip("score").asString());
        score.setFont(new Font(30));

        FXGL.addUINode(scoreText, 30, 50);
        FXGL.addUINode(score, 120, 50);
    }
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("level", 1);
        vars.put("levelTime", 0.0);
        vars.put("score",0);
    }
    protected void initPhysics() {
        FXGL.onCollisionBegin(EntityType.PLAYER, EntityType.COIN, (player, coin) -> {
            //FXGL.getGameWorld().removeEntity(coin);
            coin.removeFromWorld();
            FXGL.inc("score", +10);
        });
    }
    protected void initInput(){
        FXGL.getInput().addAction(new UserAction("left"){
            @Override
            protected void onAction(){
                player.getComponent(PlayerComponent.class).left();
            }
            @Override
                    protected void onActionEnd(){
                player.getComponent(PlayerComponent.class).stop();
            }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("right"){
            @Override
            protected void onAction(){
                player.getComponent(PlayerComponent.class).right();
            }
            @Override
            protected void onActionEnd(){
                player.getComponent(PlayerComponent.class).stop();
            }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("jump"){
            @Override
            protected void onActionBegin(){
                player.getComponent(PlayerComponent.class).jump();
            }

        }, KeyCode.SPACE);
    }
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new GameFactory());
        FXGL.setLevelFromMap("yes.tmx");
        FXGL.getGameScene().setBackgroundRepeat("background/forest.png");

        player = FXGL.getGameWorld().spawn("player", 50, 540);
    }
    protected void initSettings(GameSettings settings) {
        settings.setWidth(30*32);
        settings.setHeight(20*32);
        settings.setTitle("Platformer Game");
    }
    public static void main(String[] args) {
        launch(args);
    }
}