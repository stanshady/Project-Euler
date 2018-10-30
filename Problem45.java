

public class Problem45
{
    public static long findTriple()
    {
        int n = 2;
        long hex = 1;
        while(true)
        {
            hex = n * (2*n - 1);
            if(isTriangle(hex) && isPentagonal(hex) && hex !=40755)
                return hex;
            n++;
        }
    }
    
    public static boolean isTriangle(long n)
    {
        double test = (-1 + Math.sqrt(8 * n + 1))/2;
        return (long) test == test;
    }
    
     public static boolean isPentagonal(long n)
    {
        double test = (1 + Math.sqrt(24 * n + 1))/6;
        return (long) test == test;
    }
}