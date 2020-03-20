package character;
import item.Weapon;
import item.Armor;

/**
 * This Character has 2 powers namely Lightning bolt and Heal. 
 * @author Fernandez, Jeune Vincent D.
 */
public class Wizard extends Character implements Weapon, Armor {
    
    protected int maxMagic;
    protected int currentMagic;
    
    /**
     * The Wizard has a mana but its mana will be based on the roll of the dice multiplied by 10 and adds 10. 
     * @param n name - it is a word or a set of words which a Character referred to.
     * @param s strength - it is the state of being physically strong.
     * @param d dexterity - the skills or abilities of the Character.
     * @param i intelligence - it is the magic of the Character.
     */
    public Wizard (String n, int s, int d, int i){
        super(n,s,d,i);
        this.maxMagic = dice.roll()*10+10;
        this.currentMagic = maxMagic;     
    }
    
    /**
     * Wizard's skill "Lightning Bolt" is a powerful skill  
     * which it can paralyzed the opponent depending on the roll 
     * of the dice added with the amount given of the intelligence. 
     * If the current magic is less than or equal to 5, it will return
     * a random integer ranging from 1-6 added by the intelligence of the character
     * and the current magic will be deducted by 5.
     * 
     * @return dice modified by the intelligence
     */
    public int castLightningBolt(){
        if (currentMagic >= 5){ 
            currentMagic -= 5;
            return dice.roll()+ intelligence;   
        } else {
            return  0;
        }
    }
    
    /**
     * Wizard's another skill is "Heal" which it adds the health of the character
     * based on the roll of the dice added by the intelligence of the character.
     * if the current magic is less than or equal to 8, it will return 
     * a random integer ranging 1-6 added by the intelligence of the character
     * and the current magic will be deducted by 8.
     * 
     * @return heal - dice modified by the intelligence
     */
    public int castHeal(){
        int Heal = dice.roll() + intelligence;
        if (currentMagic >= 8) {
            currentMagic -= 8;
            heal(Heal);
        }
        return Heal;
    }
    
    /**
     * This gets the maximum value of the magic (mana)
     * @return maxMagic
     */
    public int getMaxMagic(){
        return maxMagic;
    }
    
    /**
     * This gets the current value of the magic (mana)
     * @return currentMagic
     */
    public int getCurrentMagic(){
        return currentMagic;
    }

    /**
     * This is the normal attack of the Wizard
     * @return intelligence modified by the dice
     */
    @Override
    public int attack() {
        return intelligence/dice.roll();
    }

    /**
     * This decreases the life of opponent by the dice modified by the strength
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
     * @return protection - dice modified by the strength
     */
    @Override
    public int useArmor() {
        int protection = dice.roll() + strength;
        heal(protection);
        return protection;
    } 
}
