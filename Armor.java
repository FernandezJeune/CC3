package item;

/**
 * It is a special attribute for the characters will gain an additional strength.
 * @author Fernandez, Jeune
 */
public interface Armor {
    
    /**
     * An abstract method that requires all character to have the skill to use the armor
     * when implemented.
     * @return 
     */
    public int useArmor();
    
}
