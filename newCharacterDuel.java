import java.util.Scanner;

public class newCharacterDuel {
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String args[]){
        
        Wizard player1 = new Wizard("Wizard",12,10,18);
        JavaRice player2 = new JavaRice("Java Rice", 5,17,18);
        
        int pick, round = 1, move, roundStun = 0, stunCounter = 0;
        boolean stun = false;
        
        System.out.println(player1.getName() + " vs " + player2.getName());
        
        while(true){
            
            System.out.println("\nRound " + round);
            round++;
            System.out.println("\t\tHealth Status:\tMana Status: \n"
                    + player1.getName() + ": \t" + player1.getCurrentLife() + "\t\t" + player1.getCurrentMagic() + "\n"
                    + player2.getName() + ": \t" + player2.getCurrentLife() + "\t\t" + player2.getCurrentRice() + "\n");
            
            
            if (stun) {
                
                System.out.print(player1.getName() + " got stunned, ");
                if (roundStun == stunCounter - 1) {
                    System.out.println("Stun has been disolved, you will be granted access your next round");
                    stun = false;
                    stunCounter = 0;
                    
                } else {
                    System.out.println(roundStun - stunCounter + " rounds to go");
                    stunCounter++;
                }
                
            } else {
                
                pick = getUserRequest(player1,stun);
                
                switch(pick){
                    case 1:
                        move = player1.attack();
                        player2.wound(move);
                        System.out.println(player1.getName() + " attacks " + player2.getName() +" at "+ move + " damage\n");
                        break;
                    case 2:
                        if (stun) {
                            System.out.println("Cannot use skill");
                        } else {
                            move = player1.castLightningBolt();
                            player2.wound(move);
                            System.out.println(player1.getName() + " casts lightning bolt to " + player2.getName() +" "+  move + " damage!\n");
                        }
                        break;
                    case 3:
                        move = player1.castHeal();
                        player1.heal(move);
                        System.out.println(player1.getName() + " used " + move + " heal\n" );
                        break;
                }
            }
            
            if (checkWinner(player1, player2)) {
                break;
            }
            
            pick = getUserRequest(player2,stun);
            
            switch(pick){
                case 1:
                    move = player1.attack();
                    player1.wound(move);
                     System.out.println(player2.getName() + " attacks " + player1.getName() +" at "+ move + " damage\n");
                    break;
                case 2:
                    
                    if (stun) {
                        System.out.println("Cannot Use Skill");
                    } else {
                        move = player2.castStun();
                        player1.wound(move);
                        
                        stun = true;
                        roundStun = player2.dice.roll();
                        System.out.println(player2.getName() + " casts stuns to " + player1.getName() +" "+ move + " damage! and " + roundStun + " rounds");
                    }
                    
                    break;
                   
                case 3:
                    move = player2.castHeal();
                    player2.heal(move);
                    System.out.println(player2.getName() + " used " + move + "heal\n" );
                    break;
            }
            
            if (checkWinner(player1, player2)) {
                break;
            }
        }
    }
    
    public static boolean checkWinner(Character player1, Character player2){
        
        if (player1.getCurrentLife() == player2.getCurrentLife()) {
            System.out.println("Draw! \n"
                + player1.getName() + "'s health is: " + player1.getCurrentLife() + "\n"
                + player2.getName() + "'s health is: " + player2.getCurrentLife());
                return true;
                
        } else if (player2.getCurrentLife() <= 0) {
            System.out.println("\n" + player1.getName() + " wins!\n"
                + player1.getName() + "'s health is: " + player1.getCurrentLife() + "\n"
                + player2.getName() + "'s health is: " + player2.getCurrentLife());
                return true;

        } else if (player1.getCurrentLife() <= 0){
            System.out.println("\n" + player2.getName() + " wins!\n"
                + player1.getName() + "'s health is: " + player1.getCurrentLife() + "\n"
                + player2.getName() + "'s health is: " + player2.getCurrentLife());
                return true;
        }
        
        return false;
    }
    
    public static int getUserRequest(Character player, boolean stun){
        
        System.out.println(player.getName() +"'s Pick: ");
        if (stun) {
            System.out.println("Choose: Attack, Heal  ");
        } else {
            System.out.println("Choose: Attack, Magic, Heal");
        }
        System.out.print("Choice: ");
        
        String choice= input.nextLine();
        choice = choice.toLowerCase();

            if ("attack".equals(choice)) {
                return 1;
            } else if ("magic".equals(choice)) {
                return 2;
            } else if ("heal".equals(choice)){
                return 3;
            }
            
        System.out.println("Your choice is not yet available, please try again");
        getUserRequest(player, stun);
   
        return 0;
    }
    
}
