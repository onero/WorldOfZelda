import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerInfo extends Actor
{
    private static final Color textColor = Color.BLACK;
    private static final String HEALTH_PREFIX = "Health: ";
    private static final String DAMAGE_PREFIX = "Damage: ";
    
    /**
     * Create a new the player info.
     */
    public PlayerInfo()
    {
        setImage(new GreenfootImage(150, 32));
        GreenfootImage image = getImage();
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }
    
    /**
     * Draw the image.<p>
     */
    private final void updateImage()
    {
        getImage().clear();
        GreenfootImage health = new GreenfootImage(HEALTH_PREFIX + Link.getHealth(), 16, textColor, null);
        //TODO ALH: We need to add the damage from link to the output like the health
        GreenfootImage damage = new GreenfootImage(DAMAGE_PREFIX, 16, textColor, null);
        getImage().drawImage(health, 1, 1);
        getImage().drawImage(damage, 1, 15);
    }
}