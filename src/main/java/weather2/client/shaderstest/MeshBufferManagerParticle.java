package weather2.client.shaderstest;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by corosus on 25/05/17.
 */
public class MeshBufferManagerParticle {

    //for prebuffering allowed max
    public static int numInstances = 50000;

    private static HashMap<TextureAtlasSprite, InstancedMeshParticle> lookupParticleToMesh = new HashMap<>();

    public static void setupMeshForParticle(TextureAtlasSprite sprite) {

        //drawn in order of a U shape starting top left
        float[] positions = null;

        /*positions = new float[]{
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f
        };*/

        positions = new float[]{
                0.4619355201721193F,0.46193552017211914F,-3.462473154067993F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                0.46193552017211925F,0.461935520172119F,-3.462473154067993F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                0.46193552017211925F,0.461935520172119F,-3.462473154067993F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                0.46193552017211925F,0.4619355201721193F,-3.462473154067993F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                0.4619355201721193F,0.46193552017211914F,-3.462473154067993F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                0.4619355201721193F,0.46193552017211914F,-3.462473154067993F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                0.46193552017211903F,0.4619355201721193F,-3.462473154067993F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                0.46193552017211925F,0.4619355201721193F,-3.462473154067993F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                0.46193552017211925F,0.4619355201721193F,-3.462473154067993F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                0.461935520172119F,0.46193552017211914F,-3.462473154067993F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                0.46193552017211903F,0.4619355201721193F,-3.462473154067993F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                0.46193552017211903F,0.4619355201721193F,-3.462473154067993F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                0.46193552017211903F,0.461935520172119F,-3.462473154067993F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                0.461935520172119F,0.46193552017211914F,-3.462473154067993F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                0.461935520172119F,0.46193552017211914F,-3.462473154067993F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                0.46193552017211925F,0.461935520172119F,-3.462473154067993F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                0.46193552017211903F,0.461935520172119F,-3.462473154067993F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                0.46193552017211903F,0.461935520172119F,-3.462473154067993F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                1.9617563486099239F,0.46193552017211914F,-3.0600118507347247F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                1.2119355201721191F,1.7607944542865819F,-3.0600118507347247F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                -0.2880644798278804F,1.760794454286582F,-3.0600118507347247F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                -1.962114810943603F,0.4619355201721193F,-3.0600118507347247F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                1.2119355201721191F,-1.761152916620261F,-3.0600118507347247F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                -0.2880644798278813F,-1.7611529166202606F,-3.0600118507347247F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                3.060370074649825F,0.46193552017211914F,-1.9621148109436035F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                1.7607944542865825F,2.7122938632965083F,-1.9621148109436035F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                -1.7611529166202609F,2.712293863296509F,-1.9621148109436035F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,-1.9621148109436035F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                1.7607944542865825F,-2.7119356393814082F,-1.9621148109436035F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                -1.7611529166202626F,-2.711935639381408F,-1.9621148109436035F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                3.462114691734314F,0.46193552017211914F,0.46193552017211914F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                1.9617563486099248F,3.060370074649825F,0.46193552017211914F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                -1.9621148109436028F,3.060370074649825F,0.46193552017211914F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                -3.462473154067993F,0.46193552017211953F,0.46193552017211914F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                1.9617563486099248F,-3.0600118507347247F,0.46193552017211914F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                -1.9621148109436048F,-3.060011850734724F,0.46193552017211914F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                3.060370074649825F,0.46193552017211914F,1.9617563486099239F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                1.7607944542865828F,2.712293863296509F,1.9617563486099239F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                -1.761152916620261F,2.7122938632965092F,1.9617563486099239F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                -3.0600118507347247F,0.4619355201721195F,1.9617563486099239F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                1.7607944542865828F,-2.7119356393814087F,1.9617563486099239F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                -1.7611529166202629F,-2.711935639381408F,1.9617563486099239F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                0.4619355201721193F,0.46193552017211914F,3.462114691734314F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                0.4619355201721193F,0.46193552017211914F,3.462114691734314F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                0.46193552017211925F,0.461935520172119F,3.462114691734314F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                0.46193552017211925F,0.4619355201721193F,3.462114691734314F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                0.46193552017211925F,0.4619355201721193F,3.462114691734314F,
                1.9617563486099239F,0.46193552017211914F,3.060370074649825F,
                0.4619355201721193F,0.46193552017211914F,3.462114691734314F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                0.46193552017211903F,0.4619355201721193F,3.462114691734314F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                0.46193552017211903F,0.4619355201721193F,3.462114691734314F,
                1.2119355201721191F,1.7607944542865819F,3.060370074649825F,
                0.46193552017211925F,0.4619355201721193F,3.462114691734314F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                0.461935520172119F,0.46193552017211914F,3.462114691734314F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                0.461935520172119F,0.46193552017211914F,3.462114691734314F,
                -0.2880644798278804F,1.760794454286582F,3.060370074649825F,
                0.46193552017211903F,0.4619355201721193F,3.462114691734314F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                0.46193552017211903F,0.461935520172119F,3.462114691734314F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                0.46193552017211903F,0.461935520172119F,3.462114691734314F,
                -1.962114810943603F,0.4619355201721193F,3.060370074649825F,
                0.461935520172119F,0.46193552017211914F,3.462114691734314F,
                1.2119355201721191F,-1.761152916620261F,3.060370074649825F,
                0.46193552017211925F,0.461935520172119F,3.462114691734314F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                0.46193552017211925F,0.461935520172119F,3.462114691734314F,
                -0.2880644798278813F,-1.7611529166202606F,3.060370074649825F,
                0.46193552017211903F,0.461935520172119F,3.462114691734314F
        };

        Random rand = new Random(5);

        /*positions = new float[]{
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f
        };

        positions = new float[]{
                -rand.nextFloat(), rand.nextFloat(), 0.0f,
                -rand.nextFloat(), -rand.nextFloat(), 0.0f,
                rand.nextFloat(), -rand.nextFloat(), 0.0f,
        };*/

        int count = 9 * 30;
        count = positions.length;

        int triangles = positions.length / 3;

        /*positions = new float[count];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = rand.nextFloat() - 0.5F;
        }*/

        /*positions = new float[]{
                0.461935520172121F,0.46193552017211914F,-30.462652325630188F,
                15.460143923759457F,0.46193552017211914F,-26.444310177765033F,
                0.4619355201721201F,0.46193552017211753F,-30.462652325630188F
        };*/

        float[] texCoords = null;

        texCoords = new float[]{
                sprite.getU0(), sprite.getV0(),
                sprite.getU0(), sprite.getV1(),
                sprite.getU1(), sprite.getV1()
        };

        texCoords = new float[count];
        for (int i = 0; i < texCoords.length; i++) {
            if (i % 6 == 0) {
                texCoords[i] = sprite.getU0();
            } else if (i % 6 == 1) {
                texCoords[i] = sprite.getV0();
            } else if (i % 6 == 2) {
                texCoords[i] = sprite.getU0();
            } else if (i % 6 == 3) {
                texCoords[i] = sprite.getV1();
            } else if (i % 6 == 4) {
                texCoords[i] = sprite.getU1();
            } else if (i % 6 == 5) {
                texCoords[i] = sprite.getV1();
            }

        }

        int[] indices = new int[] {
                0, 1, 3, 3, 1, 2
        };

        indices = new int[positions.length / 3];
        for (int i = 0; i < positions.length / 3; i++) {
            indices[i] = i;
        }

        /*indices = new int[] {
                0, 1, 3, 3, 1, 2
        };*/

        InstancedMeshParticle mesh = new InstancedMeshParticle(positions, texCoords, indices, numInstances);

        if (!lookupParticleToMesh.containsKey(sprite)) {
            lookupParticleToMesh.put(sprite, mesh);
        } else {
            System.out.println("WARNING: duplicate entry attempt for particle sprite, adding anyways: " + sprite);
            lookupParticleToMesh.put(sprite, mesh);
        }
    }

    public static void cleanup() {
        for (Map.Entry<TextureAtlasSprite, InstancedMeshParticle> entry : lookupParticleToMesh.entrySet()) {
            entry.getValue().cleanup();
        }
        lookupParticleToMesh.clear();
    }

    public static InstancedMeshParticle getMesh(TextureAtlasSprite sprite) {
        return lookupParticleToMesh.get(sprite);
    }

    public static void setupMeshForParticleIfMissing(TextureAtlasSprite sprite) {
        if (sprite == null) return;
        if (!lookupParticleToMesh.containsKey(sprite)) {
            setupMeshForParticle(sprite);
        }
    }
}