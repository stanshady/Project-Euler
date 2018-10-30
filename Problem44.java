

public class Problem44
{
    
    
    public static int findDiff()
    {
        int i = 2;
        while(true)
        {
            int pentI = (i*(3*i - 1)) / 2;
            for(int j = 1; j < i; j++)
            {
                int pentJ = (j*(3*j - 1)) / 2;
                if(isPentagonal(pentI + pentJ) && isPentagonal(pentI - pentJ))
                {
                    return pentI - pentJ;
                }
            }
            i++;
        }       
    }
    
    public static boolean isPentagonal(int n)
    {
        double test = (1 + Math.sqrt(24 * n + 1))/6;
        return (int) test == test;
    }
}