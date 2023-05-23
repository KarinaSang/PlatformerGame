package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.texture.ScrollingView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.image;

public class GameFactory implements EntityFactory {
    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.PLATFORM)
                .build();
    }

    @Spawns("coin")
    public Entity newCoin(SpawnData data) {
        int width = data.get("width");

        return FXGL.entityBuilder(data)
                .type(EntityType.COIN)
                .view(new Circle(width/2, width/2, width/2, Color.GOLD))
                .build();
    }

    @Spawns("door")
    public Entity newDoor(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.DOOR)
                .build();
    }

    @Spawns("npc")
    public Entity newNPC(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.NPC)
                .build();
    }

    @Spawns("river")
    public Entity newRiver(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.RIVER)
                .build();
    }



}
