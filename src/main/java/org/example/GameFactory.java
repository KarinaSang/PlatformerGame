package org.example;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameFactory implements EntityFactory {

    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {
        int width = data.get("width");
        int height = data.get("height");

        return FXGL.entityBuilder(data)
                .type(EntityType.PLATFORM)
                .bbox(new HitBox(BoundingShape.box(width, height)))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("coin")
    public Entity newCoin(SpawnData data) {
        int width = data.get("width");

        return FXGL.entityBuilder(data)
                .type(EntityType.COIN)
                .viewWithBBox(new Circle(width/2, width/2, width/2, Color.GOLD))
                .with(new CollidableComponent(true))
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
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setFixtureDef(new FixtureDef().friction(0.0f));

        physics.addGroundSensor(new HitBox("GROUND_SENSOR", new Point2D(128/4, 42), BoundingShape.box(1, 1)));

        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .with(physics)
                .with(new PhysicsComponent())
                .with(new PlayerComponent())
                .with(new CollidableComponent(true))
                .bbox(new HitBox(BoundingShape.box(128/4, 42)))
                .build();
        }
    }

