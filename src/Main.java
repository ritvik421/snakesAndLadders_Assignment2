import java.util.*;

class SnakesAndLadders{

    private static final int finalPoint=100 ;
    private static final int winPoint=100 ;

//    Two Hashmaps for snakes and ladders with the first key denoting the head of the snake for the snake map
//    and the second denoting the tail of the snake, same for the ladder as well just vice versa ie first key denoting the
//    bottom of the ladder and the second key denoting the head of the ladder
    private static final Map<Integer,Integer> snakeMap = new HashMap<>() ;
    private static final Map<Integer,Integer> ladderMap = new HashMap<>() ;

    static {

        // Position of snakes
        snakeMap.put(16, 6);
        snakeMap.put(47, 26);
        snakeMap.put(49, 11);
        snakeMap.put(56, 53);
        snakeMap.put(62, 19);
        snakeMap.put(64, 60);
        snakeMap.put(87, 24);
        snakeMap.put(93, 73);
        snakeMap.put(95, 75);
        snakeMap.put(98, 78);

        //Position of ladders
        ladderMap.put(1, 38);
        ladderMap.put(4, 14);
        ladderMap.put(9, 31);
        ladderMap.put(21, 42);
        ladderMap.put(28, 84);
        ladderMap.put(36, 44);
        ladderMap.put(51, 67);
        ladderMap.put(71, 91);
        ladderMap.put(80, 100);

    }

    //Method to generate a random dice throw
    private static int rollDice(){
        Random rnd = new Random() ;

        return rnd.nextInt(6)+1 ;
    }

    public static void main(String[] args){
        Scanner scn= new Scanner(System.in) ;
        int player1Position= 0;
        int player2Position= 0 ;
        int currentPlayer=1 ;

        System.out.println("Welcome to Snakes and Ladders");

        while(player1Position<winPoint && player2Position<winPoint){
            System.out.println("Player "+currentPlayer+ " press Enter to roll the dice");
            scn.nextLine() ;
            int diceVal= rollDice() ;
            System.out.println("Player "+ currentPlayer + " rolled "+ diceVal);
            int newPosition= currentPlayer==1? player1Position+diceVal : player2Position+diceVal ;

            if(newPosition>finalPoint){
                newPosition=finalPoint-(newPosition-finalPoint) ;
            }

            if(snakeMap.containsKey(newPosition)){
                newPosition=snakeMap.get(newPosition) ;
                System.out.println("Oops!, found snake the new position for "+ currentPlayer+" is "+ newPosition);
            }
            else if(ladderMap.containsKey(newPosition)){
                newPosition=ladderMap.get(newPosition) ;
                System.out.println("Yay!, found a ladder the new position for "+ currentPlayer+" is "+ newPosition);
            }

            if(currentPlayer==1){
                player1Position=newPosition ;
            }
            else{
                player2Position=newPosition ;
            }
            System.out.println("Player "+ currentPlayer + " is at "+ newPosition);
            if(newPosition==winPoint){
                System.out.println("Congratulations "+currentPlayer+ " has won the game");
                break ;
            }
            currentPlayer=(currentPlayer==1)?2:1 ;

        }
        System.out.println("Game Over!!");

    }

}