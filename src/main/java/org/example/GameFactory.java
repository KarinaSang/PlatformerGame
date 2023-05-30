package org.example;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

public class GameFactory implements EntityFactory {

    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.PLATFORM)
                .build();
    }

    @Spawns("coin")
    public Entity newCoin(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.COIN)
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
