
public class Problem27
{

    public static int[] maxLen(int[] primes)
    {
        int max = 0, aMax = 0, bMax = 0;
        for(int a = -1000; a <= 1000; a++)
            for(int b = -1000; b <= 1000; b++)
            {
                int n = 0;                
                while(n < 1000 && binSearch(n*n + a*n + b, primes))                                                               
                    n++;
                    
                if(n > max)
                {
                    max = n;
                    aMax = a;
                    bMax = b;
                }
            }

        int[] result = {aMax, bMax};
        return result;
    }

    //returns all primes less than n
    public static int[] primes(int n)
    {
        int[] sieve = new int[n];
        for(int i = 0; i < sieve.length; i++)
            sieve[i] = i;

        //run sieve
        for(int i = 2; i < sieve.length; i++)
        {
            if(sieve[i] == 0)
                continue;
            for(int j = 2*i; j < sieve.length; j += i)
                sieve[j] = 0; 
        }

        //count how many primes
        int count = 0;
        for(int i = 0; i < sieve.length; i++) 
            if(sieve[i] > 1)
                count++;

        //fill primes        
        int[] primes = new int[count];
        int primeIndex = 0;
        for(int i = 0; i < sieve.length; i++)
        {
            if(sieve[i]  > 1)
            {    
                primes[primeIndex] = sieve[i];
                primeIndex++;
            }
        }
        return primes;
    } 

    public static boolean binSearch(int key, int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(nums[mid] == key)
                return true;

            if(nums[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}