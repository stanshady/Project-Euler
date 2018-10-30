import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Problem54
{
    private static final String FILENAME = "C:\\Users\\Shady\\Desktop\\Problem54Text.txt";
    private static BufferedReader br;
    private static FileReader fr;
    public static ArrayList<String> games = readFile();

    public static int countPlayer1Wins()
    {
        int count = 0;

        for(int i = 0; i < games.size(); i++)
            count += whoWon(i);

        return count;
    }

    //return 1 if player1 wins, 0 player2 wins
    public static int whoWon(int gameIndex)
    {
        int winner = 0;
        int[] processedHand1 = processHand(games.get(gameIndex),false);
        int[] processedHand2 = processHand(games.get(gameIndex),true);
        int score1 = handScore(processedHand1);
        int score2 = handScore(processedHand2);
        
        if(score1 > score2)
            winner = 1;
        if(score1 == score2)
            winner = tie(processedHand1, processedHand2, score1);

        return winner;
    }

    //1 player1 wins, 0 player2 wins
    public static int tie(int[] player1, int[] player2, int score)
    {
        int winner = 0;
        int[] ranks1 = new int[13];
        int[] ranks2 = new int[13];

        for(int i = 1; i < player1.length; i++)
            ranks1[player1[i]]++;
        for(int i = 1; i < player2.length; i++)
            ranks2[player2[i]]++;

        if(score == 0)
            winner = tie0(ranks1, ranks2);
        if(score == 1)
            winner = tie1(ranks1, ranks2);
        if(score == 3 || score == 6)
            winner = tie36(ranks1, ranks2);
        if(score == 4 || score == 5 || score == 8)
            winner = tie458(ranks1, ranks2);
        if(score == 7)
            winner = tie7(ranks1, ranks2);

        return winner;
    }

    public static int tie0(int[] ranks1, int[] ranks2)
    {
        for(int i = ranks1.length - 1; i > -1; i--)
        {
            if(ranks1[i] == 1 && ranks2[i] == 0)
                return 1;
            if(ranks1[i] == 0 && ranks2[i] == 1)
                return 0;
        }
        return -1;
    }

    public static int tie1(int[] ranks1, int[] ranks2)
    {
        int pair1 = 0;
        for(int i = 0; i < ranks1.length; i++)
            if(ranks1[i] == 2)
                pair1 = i;

        int pair2 = 0;
        for(int i = 0; i < ranks2.length; i++)
            if(ranks2[i] == 2)
                pair2 = i;

        if(pair1 > pair2)
            return 1;
        if(pair1 < pair2)
            return 0;

        for(int i = ranks1.length - 1; i > -1; i--)
        {
            if(ranks1[i] == 1 && ranks2[i] == 0)
                return 1;
            if(ranks1[i] == 0 && ranks2[i] == 1)
                return 0;
        }
        return -1;
    }

    public static int tie2(int[] ranks1, int[] ranks2)
    {
        int[] pairs1 = new int[2];
        int index = 0;
        for(int i = 0; i < ranks1.length; i++)
        {
            if(ranks1[i] == 2)
            {
                pairs1[index] = i;
                index++;
            }
        }

        int[] pairs2 = new int[2];
        index = 0;
        for(int i = 0; i < ranks2.length; i++)
        {
            if(ranks2[i] == 2)
            {
                pairs2[index] = i;
                index++;
            }
        }

        //check highest pair
        if(Math.max(pairs1[0],pairs1[1]) > Math.max(pairs2[0],pairs2[1]))
            return 1;
        if(Math.max(pairs1[0],pairs1[1]) < Math.max(pairs2[0],pairs2[1]))
            return 0;

        //if highest pair tie
        if(Math.min(pairs1[0],pairs1[1]) > Math.min(pairs2[0],pairs2[1]))
            return 1;
        if(Math.min(pairs1[0],pairs1[1]) < Math.min(pairs2[0],pairs2[1]))
            return 0;

        //if both pairs tie
        for(int i = ranks1.length - 1; i > -1; i--)
        {
            if(ranks1[i] == 1 && ranks2[i] == 0)
                return 1;
            if(ranks1[i] == 0 && ranks2[i] == 1)
                return 0;
        }

        return -1;
    }

    public static int tie36(int[] ranks1, int[] ranks2)
    {
        int trip1 = 0;
        for(int i = 0; i < ranks1.length; i++)
            if(ranks1[i] == 3)
                trip1 = i;

        int trip2 = 0;
        for(int i = 0; i < ranks2.length; i++)
            if(ranks2[i] == 3)
                trip2 = i;

        if(trip1 > trip2)
            return 1;
        if(trip1 < trip2)
            return 0;

        return -1;
    }

    public static int tie458(int[] ranks1, int[] ranks2)
    {
        int high1 = 0;
        for(int i = ranks1.length - 1; i > -1; i--)
            if(ranks1[i] == 1)
            {
                high1 = i;
                break;
            }

        int high2 = 0;
        for(int i = ranks2.length - 1; i > -1; i--)
            if(ranks2[i] == 1)
            {
                high2 = i;
                break;
            }

        if(high1 > high2)
            return 1;
        if(high1 < high2)
            return 0;

        return -1;
    }


    public static int tie7(int[] ranks1, int[] ranks2)
    {
        int four1 = 0;
        for(int i = 0; i < ranks1.length; i++)
            if(ranks1[i] == 4)
                four1 = i;

        int four2 = 0;
        for(int i = 0; i < ranks2.length; i++)
            if(ranks2[i] == 4)
                four2 = i;

        if(four1 >  four2)
            return 1;
        if(four1 < four2)
            return 0;

        return -1;
    }

    /*
     * returns score according to:
     * High Card = 0
     * Pair = 1
     * 2Pair = 2
     * 3Kind = 3
     * Straight = 4
     * Flush = 5
     * Full = 6
     * 4Kind = 7
     * StraighFlush = 8
     */
    public static int handScore(int[] cards)
    {
        int score = 0;
        int[] ranks = new int[13];
        int pairs = 0;
        boolean three = false;
        boolean four = false;
        boolean straightFlag = false;
        int straightCount = 0;
        boolean flush = false;
        if(cards[0] == 1)
            flush = true;

        //fill ranks
        for(int i = 1; i < cards.length; i++)
            ranks[cards[i]]++;

        //pass through ranks
        for(int i = 0; i < ranks.length; i++)
        {
            int val = ranks[i];
            
            if(val == 2)
                pairs++;
            if(val == 3)
                three = true;
            if(val == 4)
                four = true;
                
            if(!straightFlag && straightCount == 0 && val == 1)
            {
                straightFlag = true;
                straightCount++;
            }
            else if(straightFlag && val == 1)
                straightCount++;
            else
                straightFlag = false;
        }

        //assign score
        if(straightCount == 5 && flush)
            score = 8;
        else if(flush)
            score = 5;
        else if(straightCount == 5)
            score = 4;
        else if(pairs == 2)
            score = 2;
        else if(three && pairs == 1)
            score = 6;
        else if(pairs == 1)
            score = 1;
        else if(four)  
            score = 7;
        else if(three)
            score = 3;
            
        return score;
    }

    //returns an int[] size 6 where int[0] is boolean (0,1) for flush
    public static int[] processHand(String game, boolean right)
    {
        int[] hand = new int[6];
        int handIndex = 1;
        boolean flush = true;

        int i = 0;
        if(right)
            i = 15;
        int iLimit = i + 15;
        char suit = game.charAt(i + 1);

        for(; i < iLimit; i += 3)
        {
            if(game.charAt(i + 1) != suit)  
                flush = false;
             
            char rank = game.charAt(i);
            hand[handIndex] = assignValue(rank);
            handIndex++;
        }      

        if(flush)
            hand[0] = 1;

        return hand;
    }

    //returns an int [0-12] correspoding to rank
    public static int assignValue(char rank)
    {
        // subtract 2 now since 2 -> 0 (rank -> index)
        if(rank == 'A') return 12;
        if(rank == 'K') return 11;
        if(rank == 'Q') return 10;
        if(rank == 'J') return 9;
        if(rank == 'T') return 8;
        
        //-50 worked out for char to int (this includes the subtract 2)
        return Integer.valueOf(rank) - 50;
    }

    public static ArrayList<String> readFile()
    {
        ArrayList<String> hands = new ArrayList();
        String currentLine;

        try
        {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null)             
                hands.add(currentLine);          
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return hands;
    }
}
