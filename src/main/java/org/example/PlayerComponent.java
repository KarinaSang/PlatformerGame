package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class PlayerComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel playerIdle;
    private AnimationChannel playerWalk;

    // constructor
    public PlayerComponent() {
        Image image = FXGL.image("player.png");
        playerIdle = new AnimationChannel(image, 4, 32, 42,
                Duration.seconds(1), 1, 1);
        playerWalk = new AnimationChannel(image, 4, 32, 42,
                Duration.seconds(0.66), 0, 3);
        texture = new AnimatedTexture(playerWalk);
        texture.loop();
    }

    @Override
    public void onAdded() {
//        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);
    }
}