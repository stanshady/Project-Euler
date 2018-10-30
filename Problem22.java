import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem22
{
    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Project Euler Text Files\\Problem22.txt";

    private static BufferedReader br;
    private static FileReader fr;
    private static String[] names;
    
    public static long sum()
    {
        long sum = 0;
        for(int i = 0; i < names.length; i++)
            sum += scoreName(i);
        return sum;
    }
    
    public static long scoreName(int index)
    {
        String s = names[index];
        long score = 0;
        for(int i = 0; i < s.length(); i++)
            score += s.substring(i,i+1).compareTo("A") + 1;
        return (index + 1) * score;   
    }
    
    public static String[] sort()
    {
        for(int i = 0; i < names.length - 1; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < names.length; j++)
            {
                if(names[j].compareTo(names[minIndex]) < 0)
                    minIndex = j;
            }
            String temp = names[minIndex];
            names[minIndex] = names[i];
            names[i] = temp;
        }
        return names;
    }
    
    public static String[] fillNames(String s)
    {
        int count = 0;
        int psn = 0;
        while(s.indexOf("," , psn) > -1)
        {
            count++;
            psn = s.indexOf("," , s.indexOf("," , psn)) + 1;
        }

        names = new String[count + 1];
        psn = 0;
        int i = 0;
        while(psn < s.length())
        {
            int nextQuote = s.indexOf("\"", psn + 1);
            names[i] = s.substring(psn + 1, nextQuote);
            psn = nextQuote + 2;
            i++;
        }
        return names;
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