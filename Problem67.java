import java.io.*;
import java.util.*;

public class Problem67
{
    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Problem67.txt";

    private static BufferedReader br = null;
    private static FileReader fr = null;
    private static int[][] mat = new int[100][100];

    public static int sumPaths()
    {
        int[][] sums = new int[100][100];
        sums[mat.length - 1] = mat[mat.length - 1];

        for(int r = sums.length - 2; r >= 0; r--)
            for(int c = 0; c <= r; c++)
                sums[r][c] = mat[r][c] + Math.max(sums[r+1][c], sums[r+1][c+1]);
        return sums[0][0];
    }

    public static int[][] readFile()
    {
        try
        {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String s;
            int r = 0, c = 0;
            while((s = br.readLine()) != null)
            {
                c = 0;
                for(int i = 0; i < s.length() - 1; i += 3)
                {
                    mat[r][c] = Integer.parseInt(s.substring(i,i + 2));
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
        return mat;
    }

}