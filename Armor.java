package item;

/**
 * It is a special attribute for the characters will gain an additional strength.
 * @author Bermudez, Christopher
 * @author Castano, Tome Teofilo
 * @author Decipeda, Wesley Jay
 */
public interface Armor {
    
    /**
     * An abstract method that requires all character to have the skill to use the armor
     * when implemented.
     * @return 
     */
    public int useArmor();
    
}
