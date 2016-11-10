import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DungeonWorld here.
 *
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class DungeonWorld extends MasterWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static final int GAME_AREA = 1000;
    public static final int GAME_AREA_MIN = 250;
    Random rand = new Random();
    public static CastleWorld castleWorld;
    private MusicPlayer musicPlayer;
    public static GreenfootSound dungeonWorldSound;
    /**
     * Constructor for objects of class DungeonWorld.
     *
     */
    public DungeonWorld()
    {
        super(600, 600, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        addCameraFollower(new Link(10, 5), 0, 0);
        for(int i = 0; i < 10; i++)
        {
            addObject(new Slime(8, 3), rand.nextInt(GAME_AREA) + GAME_AREA_MIN, rand.nextInt(GAME_AREA) + GAME_AREA_MIN);
        }

        addCameraFollower(new Link(10, 5), 0, 0);

        addObject(new PlayerInfo(), 85, 15);

        //Difference between CaveWalls is 30
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 110 , i);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 110);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 1770);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 1770 , i);
        }

        addObject(new CastleEntrance(), 1500, 1500);
        quest = new Quest("Slimey!", "Slay five slimes!", 0,Slime.class);
        addObject(quest, 500, 30);
        addObject(new StigGood(10, 10), 1500, 300);
        
        //Add music
        musicPlayer = new MusicPlayer();
        dungeonWorldSound = new GreenfootSound(musicPlayer.getSound(2));
        dungeonWorldSound.play();
    }
}
