import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Problem42
{
    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Project Euler Text Files\\Problem42.txt";
    private static BufferedReader br;
    private static FileReader fr;
    
    public static String[] words;
    public static int[] triNums;
    
    public static int makeTriNums()
    {
        words = fillWords(readFile());
        
        //First part is to populate triNums
        int maxLen = 0;
        for(String s: words)
            maxLen = Math.max(maxLen, s.length());
        
        int maxTri = 26*maxLen;
        int maxN = 1;
        int count = 0;
        while((maxN*(maxN + 1))/2 < maxTri)
        {
            maxN++;
            count++;
        }
        
        triNums = new int[count];
        for(int i = 0; i < count; i++)
            triNums[i] = (i+1)*(i+2)/2;
        //Now triNums is populated
        
        int countAns = 0;
        for(String s: words)
        {
            int value = wordValue(s);
            if(contains(triNums,value))
                countAns++;
        }
        return countAns;
    }
    
    public static int wordValue(String str)
    {
        int sum = 0;
        for(int i = 0; i < str.length(); i++)
        {
            sum += str.substring(i,i+1).compareTo("A") + 1;
        }
        return sum;
    }
    
    public static String[] fillWords(String s)
    {
        int count = 0;
        int psn = 0;
        while(s.indexOf("," , psn) > -1)
        {
            count++;
            psn = s.indexOf("," , s.indexOf("," , psn)) + 1;
        }

        words = new String[count + 1];
        psn = 0;
        int i = 0;
        while(psn < s.length())
        {
            int nextQuote = s.indexOf("\"", psn + 1);
            words[i] = s.substring(psn + 1, nextQuote);
            psn = nextQuote + 2;
            i++;
        }
        return words;
    }
    
    public static boolean contains(int[] nums, int key)
    {
        for(int i: nums)
            if(i == key)
                return true;
        return false;
    }
    
    public static String readFile()
    {
        String str = "";
        try
        {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            str = br.readLine();

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
        return str;
    }
}