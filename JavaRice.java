package character;

import item.Weapon;
import item.Armor;
/**
 * This Character has 2 powers namely Stun and Heal.
 * @author Bermudez, Christopher
 * @author Castano, Tome Teofilo
 * @author Decipeda, Wesley Jay
 */
public class JavaRice extends Character implements Weapon, Armor{
    
    protected int maxRice;
    protected int currentRice;
    
    /**
     * The Java Rice has a rice but its range will be based on the roll of the dice multiplied by 10.
     * @param n name - it is a word or a set of words which a Character referred to.
     * @param s strength - it is the state of being physically strong.
     * @param d dexterity - the skills or abilities of the Character.
     * @param i intelligence - it is the magic of the Character.
     */ 
    public JavaRice (String n, int s, int d, int i){
        super(n,s,d,i);
        this.maxRice = dice.roll()*10;
        this.currentRice = maxRice;     
    }

    /**
     * Java Rice's skill "Stun" is a powerful skill  
     * which it can stop the opponent's turn depending on the roll 
     * of the dice added with the amount given of the intelligence. 
     * If the current rice is less than or equal to 10, it will return
     * a random integer ranging from 1-6 added by the dexterity of the character
     * and the current rice will be deducted by 9.
     *
     * @return random number given by the dice modified by the dexterity
     */
    public int castStun(){
        if (currentRice >= 10) {
            currentRice -= 9;
            return dice.roll() + dexterity;   
        }else{
            return  0;
        }
    }
    
    /**
     * This increases the life of the character by a random value given by the dice
     * modified by the dexterity, it also decreases the amount of mana by 8. 
     * @return random number given by the dice modified by the dexterity
     */
    public int castHeal(){
        int Heal = dice.roll() + dexterity;
        if (currentRice >= 8) {
            currentRice -= 8;
            heal(Heal);
        }
        return Heal;
    }
    
    /**
     * This gets the maximum value of the mana of the character
     * @return maxRice
     */
    public int getMaxRice(){
        return maxRice;
    }
    
    /**
     * This gets the current mana of the character.
     * @return currentRice
     */
    public int getCurrentRice(){
        return currentRice;
    }

    /**
     * This is the normal attack of Java Rice that depends on its dexterity 
     * modified by the dice. 
     * @return dexterity modified by the dice
     */
    @Override
    public int attack() {
        return dexterity/dice.roll();
    }
    
    /**
     * This decreases the amount of the opponent by the dice modified by the strength
     * @param oponent
     * @return damage - dice modified by strength
     */
    @Override
    public int useWeapon(Character oponent) {
        int damage = dice.roll() + strength;
        oponent.wound(damage);
        return damage;
    }

    /**
     * This increases the life of the character by the dice modified by the strength
     * @return protection - dice modified by strength
     */
    @Override
    public int useArmor() {
        int protection = dice.roll() + strength;
        heal(protection);
        return protection;
    }

}
