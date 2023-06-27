package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.Required;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

@Required(PhysicsComponent.class)
public class PlayerComponent extends Component {
    private AnimatedTexture texture;
    private AnimationChannel playerIdle;
    private AnimationChannel playerWalk;


    private PhysicsComponent physics;

    private int jumps = 2;

    public PlayerComponent() {
        Image image = FXGL.image("player.png");
        playerIdle = new AnimationChannel(image, 4, 32, 42, Duration.seconds(1), 1, 1);
        playerWalk = new AnimationChannel(image, 4, 32, 42, Duration.seconds(0.66), 0, 3);
        texture = new AnimatedTexture(playerIdle);
        texture.loop();

        }

    public void left() {
        entity.setScaleX(-1);
        physics.setVelocityX(-150);
    }

    public void right() {
        entity.setScaleX(1);
        physics.setVelocityX(150);
    }

    public void stop() {
        physics.setVelocityX(0);
    }

    public void jump() {
        if (physics.isOnGround()) {
            jumps = 2;
        }
        if (jumps == 0) {
            return;
        }

        physics.setVelocityY(-300);
        jumps--;
    }
    @Override
    public void onUpdate(double tpf) {
        if (physics.isMovingX()) {
            if (texture.getAnimationChannel() != playerWalk) {
                texture.loopAnimationChannel(playerWalk);
            }
        }
            else {
                texture.loopAnimationChannel(playerIdle);
        }
    }
    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(texture);
    }
}




