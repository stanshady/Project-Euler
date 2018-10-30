import java.util.*;
import java.io.*;

public class Problem11
{
    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Problem11 text.txt";

    private static BufferedReader br;
    private static FileReader fr;
    private static String[][] mat = new String[20][20];
    private static int max = 0;

    public static int getMax()
    {
        return max;
    }

    public static void maxRows()
    {
        for(int r = 0; r < mat.length; r++)
        {
            for(int c = 0; c < mat[0].length - 3; c++)
            {
                int temp = 1;
                for(int i = 0; i < 4; i++)
                {
                    temp *= Integer.parseInt(mat[r][c + i]);
                }
                if(temp > max)
                    max = temp;
            } 
        }
    }

    public static void maxCols()
    {
        for(int c = 0; c < mat[0].length; c++)
        {
            for(int r = 0; r < mat.length - 3; r++)
            {
                int temp = 1;
                for(int i = 0; i < 4; i++)
                {
                    temp *= Integer.parseInt(mat[r + i][c]);
                }
                if(temp > max)
                    max = temp;
            }
        }
    }

    public static void maxMainDiagonal()
    {
        for(int r = 0; r < mat.length - 3; r++)
        {
            for(int c = 0; c < mat[0].length - 3; c++)
            {
                int temp = 1;
                for(int i = 0; i < 4; i++)
                {
                    temp *= Integer.parseInt(mat[r + i][c + i]);
                }
                if(temp > max)
                    max = temp;
            }
        }
    }

    public static void maxOtherDiagonal()
    {
        for(int r = 3; r < mat.length; r++)
        {
            for(int c = 0; c < mat[0].length - 3; c++)
            {
                int temp = 1;
                for(int i = 0; i < 4; i++)
                {
                    temp *= Integer.parseInt(mat[r - i][c + i]);
                }
                if(temp > max)
                    max = temp;
            }
        }
    }

    public static String[][] readFile()
    {
        try
        {
            br = new BufferedReader(new FileReader(FILENAME));
            String sCurrentLine;

            int r = 0, c = 0;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                c = 0;
                for(int i = 0; i < sCurrentLine.length() - 1; i += 3)
                {
                    mat[r][c] = sCurrentLine.substring(i,i + 2);
                    c++;
                }
                r++;
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
        return mat;
    }
}