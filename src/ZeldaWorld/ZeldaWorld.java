import greenfoot.*;
import java.util.*;

/**
 * 
 * @author EASV2016 Group 12
 */
public class ZeldaWorld extends ScrollWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static final int GAME_AREA = 1000;
    public static final int GAME_AREA_MIN = 250;
    public static DungeonWorld dungeonWorld;
    public static CastleWorld castleWorld;
    private Random rand;
    private static Character link;
    private int ratKill;
    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(600, 600, 1, GAME_WIDTH, GAME_HEIGHT);
        rand = new Random();
        //Add worlds
        dungeonWorld = new DungeonWorld();
        castleWorld = new CastleWorld();
        //Create objects
        createObjects();
        //Add main player
        link = new Link(10, 5);
        addCameraFollower(link, 0, 0);
        //Create the player information
        addObject(new PlayerInfo(), 85, 15);
        //Create bosses
        
        //Create enemies
        createEnemies();
        //Create quest
        //TODO ALH: Add real quest
        addObject(new Quest("Rats!", "Slay five rats!", "0 of 5"), 500, 30);
        ratKill = 0;

    }

    /**
     *Create the objects
     */
    private void createObjects() {
        //Top wall
        for(int i = GAME_AREA_MIN; i < GAME_WIDTH - GAME_AREA_MIN; i += 210)
        {
            addObject(new Wall(), i , GAME_AREA_MIN - 60);
        }
        addObject(new WallWithEntrance(), 500, GAME_AREA_MIN - 60);
        //Left side wall
        for(int i = 350; i < GAME_WIDTH - GAME_AREA_MIN; i += 150)
        {
            addObject(new Wall(), 100, i);
        }
        //Buttom side wall
        for(int i = GAME_AREA_MIN; i < GAME_WIDTH - GAME_AREA_MIN; i += 210)
        {
            addObject(new Wall(), i , GAME_WIDTH - GAME_AREA_MIN);
        }
        //Right side wall
        for(int i = 350; i < GAME_WIDTH - GAME_AREA_MIN; i += 150)
        {
            addObject(new Wall(), GAME_WIDTH - 180, i);
        }
        //Add rocks
        for (int i = 0; i < 10; i++) {
            addObject(new Rock(), rand.nextInt(GAME_AREA) + GAME_AREA_MIN, rand.nextInt(GAME_AREA) + GAME_AREA_MIN);
        }
        addObject(new Dungeon(), 600, 600);
    }

    /**
     *Create the Enemies
     */
    private void createEnemies() {
        for (int i = 0; i < 10; i++) {
            addObject(new Rat(5, 1), rand.nextInt(GAME_AREA) + GAME_AREA_MIN, rand.nextInt(GAME_AREA) + GAME_AREA_MIN);
        }
    }

    /**
     * Get the current character
     */
    public static Character getPlayer() {
        return link;
    }
}