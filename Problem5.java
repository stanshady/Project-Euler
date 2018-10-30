

public class Problem5
{
    
    public static int findMin()
    {
        int min = 0;
        int i = 20;
        while(true)
        {
            if(isDiv20(i))
                return i;
            i++;
        }
    }
    
    public static boolean isDiv20(int n)
    {
        for(int i = 2; i <= 20; i++)
        {
            if(n % i != 0)
                return false;
        }
        return true;
    }
}