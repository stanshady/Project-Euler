
public class Problem50
{  
    public static int[] primes = Algorithm.primesLessThan(1000000);
    
    public static int findMax()
    {
        int maxIndex = 0;
        int maxLen = -1;
        
        for(int i = 0; i < primes.length; i++)
        {
            int temp = maxLength(primes[i]);
            
            if(temp > maxLen)
            {
                maxIndex = i;
                maxLen = temp;
            }
        }
        
        return primes[maxIndex];
    }
    
    public static int maxLength(int n)
    {
        int max = 1;
        
        for(int i = 0; primes[i] < n; i++)
        {
            int temp = sumLength(n,i);
            max = Math.max(temp,max);
        }
        
        return max;
    }
    
    public static int sumLength(int n, int index)
    {
        int sum = primes[index];
        int len = 1;
        
        while(n >= sum && index < primes.length)
        {
            if(n == sum)
                return len;
                
            len++;
            index++;
            sum += primes[index];
        }
        
        return -1;
    }
    
}
