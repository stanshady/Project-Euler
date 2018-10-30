
public class Problem12
{

    public static int findMax(int numDiv)
    {
        int n = 1;
        while(countDivisors((int)(n * (n + 1) / 2)) < numDiv)
        {
            n++;
        }
        return (int)(n * (n + 1) / 2);
    }
    
    public static int countDivisors(int n)
    {
        if(n == 1)
            return 1;

        int count = 0;
        for(int i = 1; i * i <= n; i++)
        {
            if(n % i == 0)
                count += 2;
        }
        return count;
    }
}