package functions;

import java.io.IOException;
import java.util.*;

import company.Company;
import player.Player;
// import java.lang.*;

public class Function {
    Player player = new Player();
    Company company = new Company();

    public int welcome() {
        System.out.println("\n\n\n\t\t\t\t\tWelcome TO\n");
        System.out.println("\t\t\t\t  Monopoly Stock Exchange\n\n");

        return 0;
    }

    public int instructions() {
        System.out.println(" Welcome to Monopoly Stock Exchange Game");
        System.out.println(" Here are the rules of the game");
        System.out.println(
                "  1.This is a 3 player  modern stock trading game designed to be hassle-free and fun at every corner. ");
        System.out.println(
                "  2.Goal of this game is to become the first player to have more than Rs.20000 and win this ultimate stock market battle.The player will be declared bankrupt once he reaches Rs0.");
        System.out.println(
                "  3.This game has 12 blocks that start at 1 which is |GO|. Collect Rs.2000 every time the player passes 1(GO).  Players will have an option to move maximum of 3 blocks at a time. ");
        System.out.println(
                "  4.Land on fthe blocks numbered 2,5,6,8,10,11 to buy the company mentioned on the respective block by purchasing its shares. ");
        System.out.println(
                "  5.If a player lands on any of these |Company Block| which is owned by another player, the share value of that company will increase accordingly and the company owner will collect ‘service rent’ from that player. ");
        System.out.println(
                "  6.Blocks numbered 3,8 are the |Trading blocks|. Here players can trade and transfer their shares. ");
        System.out.println(
                "  7.If a player lands on block 4, they are caught in ‘Shortlisting Fraud’, pay fine of Rs.500 to the bank. ");
        System.out.println(
                "  8.If a player lands on block 7, they face an |Income Tax Raid|, the share value of all the companies that player own will decrease by 5% along with a fine of Rs.200 to the bank. ");
        System.out.println("  9.Get lucky with a |Chance Card| every time the player lands on block 12. ");
        System.out.println(
                " 10.The players will have an option to sell their share anytime during the course of the game.");
        System.out.println(
                " 11. Please note when a player is out of money and decides to sell his shares, he will have to sell all his shares.");

        return 0;
    }

    public int board() {
         System.out.println("                                                          \t" +"________________________________________________________________                                                                                 ");
         System.out.println("  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \t" +"                                                      ");
         System.out.println(" |            |             |             |              |\t" +"         "+ player.getPlayerName(1));
         System.out.println(" |     1.     |      2.     |      3.     |      4.      |\t" +"    current balance     :- "+ player.getPlayerCurrentBal(1));
         System.out.println(" |     GO     |   Amazon    |    Stock    |   Short      |\t" +"    companies owned     :- "+  );
         System.out.println(" |            |             |    Market   |   Listing    |\t" +"    shared owned        :- "+   );
         System.out.println(" |            |             |             |   Fraud      |\t" +"                                                               ");
         System.out.println(" |_ _ _ _ _ _ |_ _ _ _ _ _ _| _ _ _ _ _ _ |_ _ _ _ _ _ _ |\t" +"________________________________________________________________                                                               ");
         System.out.println(" |            |                           |              |\t" +"                                                            ");
         System.out.println(" |    12.     |                           |      5.      |\t" +"          "+ player.getPlayerName(2));
         System.out.println(" |   Chance   |                           |    Tesla     |\t" +"    current balance     :- "+ player.getPlayerCurrentBal(2));
         System.out.println(" |            |                           |              |\t" +"    companies owned     :- "+     );
         System.out.println(" |_ _ _ _ _ _ |                           | _ _ _ _ _ _ _|\t" +"    shared owned        :- "+     );
         System.out.println(" |            |                           |              |\t" +"                                                                   ");
         System.out.println(" |     11.    |                           |      6.      |\t" +"_________________________________________________________________                                                             ");
         System.out.println(" |  Facebook  |                           |   Micorsoft  |\t" +"                                                                   ");
         System.out.println(" |            |                           |              |\t" +"          "+ player.getPlayerName(3));
         System.out.println(" |_ _ _ _ _ _ | _ _ _ _ _ _ _ _ _ _ _ _ _ |_ _ _ _ _ _ _ |\t" +"    current balance     :- "+ player.getPlayerCurrentBal(3));
         System.out.println(" |            |              |            |              |\t" +"    companies owned     :- "+  );
         System.out.println(" |     10.    |      9.      |     8.     |      7.      |\t" +"    shared owned        :- "+   );
         System.out.println(" |    ISRO    |    Google    |   Stock    |    Income    |\t" +"                                                              ");
         System.out.println(" |            |              |   Market   |   Tax Raid   |\t" +"_________________________________________________________________                                                                    ");
         System.out.println(" |            |              |            |              |\t" +"                                                                                ");
         System.out.println(" |_ _ _ _ _ _ |_ _ _ _ _ _ _ |_ _ _ _ _ _ |_ _ _ _ _ _ _ |\t" +"                                                                             ");
         System.out.println("                                                          \t" +""     ); 
  
        return 0;
    }

    public String chance() {
        String[] chanceName = { "Hostile takeover attempt - pay lawyer 1000",
                "Your least expensive ticket -pay 5 times share price to bank and inc",
                "Your most expensive ticket - pay 2 times share price to bak and inc",
                "Go to trading allowed counter , pass go (nearest trading counter)." };
        Random random = new Random();
        int randomNumber = random.nextInt(chanceName.length);
        String s = chanceName[randomNumber];
        System.out.println(s);
        return s;
    }

    public void quit() {
        System.out.println("You Lose the game");
        System.out.println("Better Luck Next Time!");
    }

    public void winner() {
        System.out.println("Congratulations You Have Won The Game");
    }

    public void promptEnterKey() {

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int dice(int p) {
        int die = (int) (3.0 * Math.random()) + 1;
        int currentPosition = player.getPlayerCurrentPosition(p);
        currentPosition = currentPosition + die;
        player.setPlayerCurrentPosition(currentPosition, p);
        resetPostion(player.getPlayerCurrentPosition(p), p);
        // System.out.println("Now you are on "+player.getPlayerCurrentPosition(p));
        return die;
    }

    public int resetPostion(int currentPosition, int p) { // this function is to repeat the cycle to go to block 1 after
                                                          // block 12
        if (currentPosition > 12) {
            currentPosition = currentPosition - 12;
            player.setPlayerCurrentPosition(currentPosition, p);
            go(p);
        } else {
            player.setPlayerCurrentPosition(currentPosition, p);
        }
        return 0;
    }

    public int go(int p) {
        player.setPlayerCurrentBal(player.getPlayerCurrentBal(p) + 2000, p);
        // System.out.println("Your current balance is "+
        // player.getPlayerCurrentBal(p));
        return 0;
    }

    public void updateServiceRent(int n) {
        float currentRent = company.getCompanyServiceRent(n);
        currentRent = (float) (currentRent + 0.1 * currentRent);
        company.setCompanyServiceRent(currentRent, n);
    }

    public int sell(int i) {
        if (player.getPlayerSharesOwned(i, 2) > 0) {
            if (company.getCompanyOwner(2) != i) {
                int shareNum = player.getPlayerSharesOwned(i, 2);
                int owner = company.getCompanyOwner(2);
                float shareBal = (player.getPlayerSharesOwned(i, 2)) * (company.getCompanySharePrice(2));
                player.setPlayerCurrentBal(player.getPlayerCurrentBal(i) + shareBal, i);
                player.setPlayerSharesOwned(i, 2, 0);

                if (player.getPlayerCurrentBal(owner) > shareBal) {
                    player.setPlayerSharesOwned(owner, 2, player.getPlayerSharesOwned(owner, 2) + shareNum);
                    player.setPlayerCurrentBal(player.getPlayerCurrentBal(owner) - shareBal, owner);
                } else {
                    bankRupt(player.getPlayerName(owner));
                }
            }
        }
        return 0;
    }

    public int bankRupt(String gareeb) {
        System.out.println(" We are sorry to inform you that your current balance is 0 .");
        System.out.println(gareeb + " dont even have any stocks to sell .");
        System.out.println(gareeb + " lost the game ");
        System.out.println(" GAME OVER");

        System.exit(0);
        return 0;
    }

    String mnc;

    public String company(int c) {
        if (c == 1) {
            mnc = "Amazon";
        } else if (c == 4) {
            mnc = "Tesla";
        } else if (c == 5) {
            mnc = "Microsoft";
        } else if (c == 8) {
            mnc = "Google";
        } else if (c == 9) {
            mnc = "ISRO";
        } else if (c == 10) {
            mnc = "Facebook";
        }
        return mnc;
    }

    public void taxraid() {
        System.out.println("For each company pay 200");
        System.out.println("Price decrease of your company’s share by 5%");
        // list of companies of person having tax raid
        // taxraid=no. of companies*200
        // update current balance=Current Balance-taxraid
        // update current share balance=95*Current Share Balance/100
        // System.out.println(current balance)
        // System.out.println(current share balance)

    }

    public void fraud() {
        // System.out.println("Pay rs.500 to bank")
        // System.out.println(Price decrease of the company you own by 20%);
        // list of companies owned by user
        // current balance=current balance-500
        // updated shares of companies owned=4/5*shares of companies owned //it is only
        // applicable to those shares whose companany is owned by the user
    }

    public int excessBalance(int p) {
        if (player.getPlayerCurrentBal(p) >= 20000) {
            System.out.println("Since your current balance is more than 20000,So you won");
            winner();
        }
        return 0;
    }



    public int stockMarket() {
        int count = 0;

        System.out.println(" You have arrived at the stockmarket ");
        System.out.println(" Here you can buy stocks of the companies already owned .");
        // not applicable if no company is owned by anyone if statement
        if (count == 0) {
            System.out.println(" shares of any company are not available");
        } else {
            System.out.println(" Stocks are available of :- ");
            // list of the companies owned by everyplayer
            // Scanner sc= new Scanner(System.in)
            System.out.println(" "); // ya fir unka number input lena ha
            // String userName = sc.nextLine();

            // Scanner number = new Scanner(System.in)
            System.out.println(" How many shares do you want to buy "); //
            // int number1 = number.nextInt();
            // sharePrice(number1)
            // cost = number1 * getSharePrice //or we can call function BUY here
            // system.out.println("cost the player has to pay is"); //to update all this
            // System.out.println(cost);

            // currentBalance update krna ha dono players ka
            // NoofShares update
        }
        return 0;
    }
}
