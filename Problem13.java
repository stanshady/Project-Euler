import java.util.*;
import java.io.*;
import java.math.*;

public class Problem13
{
    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Problem13.txt";
    private static BufferedReader br; 
    private static FileReader fr;
    private static String[] nums;

    public static BigInteger sum()
    {
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < nums.length; i++)
        {
            BigInteger temp = new BigInteger(nums[i]);
            sum = sum.add(temp);
        }
        return sum;
    }

    public static String[] readFile()
    {
        try
        {
            nums = new String[100];
            br = new BufferedReader(new FileReader(FILENAME));
            String sCurrentLine;

            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                nums[i] = sCurrentLine;
                i++;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } 
            catch (IOException ex)
            {

                ex.printStackTrace();

            }
        }
        return nums;
    }
}