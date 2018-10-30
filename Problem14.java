
public class Problem14
{
    public static long findMax(long n)
    {
        long max = 1;
        long num = 1;
        for(long i = 1; i < n; i++)
        {
            long temp = len(i);
            if(temp > max)
            {
                max = temp;
                num = i;
            }
        }
        return num;
    }

    public static long len(long n)
    {
        long count = 1;
        while(n != 1)
        {
            if(n % 2 == 0)
                n /= 2;
            else
                n = 3*n + 1;
            count++;
        }
        return count;
    }
}