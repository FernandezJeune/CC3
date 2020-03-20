
public class TestCharacter {
    
    public static void main(String args[]){
        
        Character player1 = new Character("Jeune",18,25,10);
        Character player2 = new Character("Wyli", 10,25,20);
        
        int round = 1;
        boolean gameOver = false;
        int temp;
        
        while (!gameOver){
            
            System.out.println("\nRound " + round + "\n");
            round++;
            
            System.out.println(player1.getName() + ": " + player1.getCurrentLife());
            System.out.println(player2.getName() + ": " + player2.getCurrentLife()); 
            temp = player1.attack();            
            System.out.println(player1.getName() + " attacks " + player2.getName() + ": " + temp);
            player2.wound(temp);
            temp = player2.attack();
            System.out.println(player2.getName() + " attacks " + player1.getName() + ": " + temp);
            player1.wound(temp);
            
            if (round == 4) {
                
                if (player1.getCurrentLife() == player2.getCurrentLife()) {
                    System.out.println("\nDraw!");
                    System.out.println(player1.getName() + ""
                            + "'s health is: " + player1.getCurrentLife());
                    System.out.println(player2.getName() + "'s health is: " + player2.getCurrentLife());
           
                    } else if(player1.getCurrentLife() <= player2.getCurrentLife()){
                        System.out.println("\n" + player2.getName() + " wins!\n");
                        System.out.println(player1.getName() + "'s health is: " + player1.getCurrentLife());
                        System.out.println(player2.getName() + "'s health is: " + player2.getCurrentLife());                
               
                    } else if (player2.getCurrentLife() <= player1.getCurrentLife()) {
                        System.out.println("\n" + player1.getName() + " wins!\n");
                        System.out.println(player1.getName() + "'s health is: " + player1.getCurrentLife());
                        System.out.println(player2.getName() + "'s health is: " + player2.getCurrentLife());                  
                    }
                
                gameOver = true;
            
            }
            
          //  System.out.println("\nFinal Health: \n"+ player1.getName() + " " + player1.getCurrentLife() +
          //                      "\n" + player2.getName() + " " + player2.getCurrentLife() );
        }
        
    }
    
}
