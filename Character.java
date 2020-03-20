package character;
import item.Dice;

/**
 * This is the main blue print of the Character.
 * @author Bermudez, Christopher
 * @author Castano, Tome Teofilo
 * @author Decipeda, Wesley Jay
 */
public abstract class Character {
    
    static Dice dice = new Dice();
    
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int maxLife;
    protected int currentLife;
    
    /**
     * This is the default constructor method of the Character that sets the name,
     * strength, dexterity, and intelligence. As default, the maximum life of the
     * character is set to 50 and its current life is set to max life(50).
     * @param n name
     * @param s strength
     * @param d dexterity
     * @param i intelligence
     */
    public Character(String n, int s, int d, int i) {
        name = n;
        strength = s;
        dexterity = d;
        intelligence = i;
        
        maxLife = 50;
        currentLife = maxLife;
    }
    
    /**
     * This is the abstract method of the character that all character have different
     * perspective of attacks.
     * @return 
     */
    public abstract int attack();
    
    /**
     * This method sets the opponents (enemy) life to decrease depending on the 
     * amount of the damage.
     * @param damage     
     */
    public void wound(int damage) {
        currentLife -= damage;
    }
    
    /**
     * This method increases the character's life depending on the amount of the heal.
     * @param heal 
     */
    public void heal(int heal) {
        currentLife += heal;
    }
    
    /**
     * This method gets the value of the name's character.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * This method gets the value of the strength of the character.
     * @return strength
     */
    public int getStrength(){
        return strength;
    }
    
    /**
     * This method gets the value of the dexterity of the character.
     * @return dexterity 
     */
    public int getDexterity() {
        return dexterity;
    }
    
    /**
     * This method gets the value of the intelligence of the character.
     * @return intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }
    
    /**
     * This method gets the value of the current life's character.
     * @return currentLife
     */
    public int getCurrentLife(){
        return currentLife;
    }
    
    /**
     * This methods gets the value of the maximum life's character.
     * @return maxLife 
     */
    public int getMaxLife() {
        return maxLife;
    }    
    
}
