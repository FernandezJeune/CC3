package item;
import character.Character;

/**
 * It is a special attribute for the characters which it adds some damage.
 * @author Fernandez, Jeune Vincent D.
 */
public interface Weapon {
    
    /**
     * An abstract method the requires all character to have a skill of using 
     * a weapon when implemented.
     * @param oponent
     * @return 
     */
    public int useWeapon(Character oponent);
}
