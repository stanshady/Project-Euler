import java.util.*;

public class Algorithm
{

    //returns 1st n-primes
    public static int[] sieve(int n)
    {
        int[] primes = new int[n];
        //use PNT * 1.2 for length of sieve
        int[] sieve = new int[(int)(1.2*n*Math.log(n))];
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

        //fill primes
        int primeIndex = 0;
        for(int i = 0; i < sieve.length; i++)
        {
            if(primeIndex == n)
                break;
            if(sieve[i] == 0 || sieve[i] == 1)
                continue;
            primes[primeIndex] = sieve[i];
            primeIndex++;
        }
        return primes;
    }

    //returns primes < n
    public static int[] primesLessThan(int n)
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

        //count non-zero entries
        int count = 0;
        for(int num : sieve)
            if(num != 0 && num != 1)
                count++;
        int[] primes = new int[count];

        //fill primes
        int primeIndex = 0;
        for(int i = 0; i < sieve.length; i++)
        {
            if(primeIndex == n)
                break;
            if(sieve[i] == 0 || sieve[i] == 1)
                continue;
            primes[primeIndex] = sieve[i];
            primeIndex++;
        }

        return primes;
    }

    public static int binSearch(int[] nums, int key)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(nums[mid] == key)
                return mid;
            if(nums[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return - 1;
    }

    public static int[] baseArray(int n, int base)
    {
        int[] digits;
        int numDigits = 0;
        int temp = n;

        while(temp > 0)
        {
            temp /= base;
            numDigits++;       
        }
        if(numDigits == 0)
            numDigits = 1;
        digits = new int[numDigits];

        for(int i = digits.length - 1; i > -1; i--)
        {
            digits[i] = n % base;
            n /= base;
        }

        return digits;
    }

    //returns base 10 number from int[] digits
    public static int makeNum(int[] digits)
    {
        int n = 0;
        for(int i = 0; i < digits.length; i++)
            n += digits[i] * (int) Math.pow(10,digits.length - i - 1);      
        return n;
    }

    public static boolean isPandigital(long n) 
    {
        int digits = 0;
        int count = 0;
        int temp;

        while (n > 0) 
        {
            temp = digits;
            digits = digits | 1 << ((n % 10) - 1);
            if(temp == digits)         
                return false;

            count++;
            n /= 10;
        }
        return digits == (1 << count) - 1;
    }

    //big to small
    public static void perm2(int[] perm)
    {
        int N = perm.length;
        int i = N-1;
        while (perm[i - 1] <= perm[i]) {
            i = i - 1;

        }
        int j = N;
        while (perm[j - 1] >= perm[i - 1]) {
            j = j - 1;
        }
        swap(perm, i - 1, j - 1);

        i++;
        j = N;
        while (i < j) {
            swap(perm, i - 1, j - 1);
            i++;
            j--;
        }
    }

    //small to big
    public static void perm(int[] digits)
    {
        int len = digits.length;
        int i = len - 1;
        while(digits[i-1] >= digits[i])
            i--;
        int j = len;
        while(digits[j-1] <= digits[i-1])
            j--;
        swap(digits, i-1, j-1);
        i++;
        j = len;  
        while(i < j)
        {
            swap(digits, i-1, j-1);
            i++;
            j--;
        }
    }

    public static void swap(int[] digits, int i, int j)
    {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void insertionSort(int[] nums){
        for(int k = 1; k < nums.length; k++){
            int temp = nums[k];
            int n = k - 1;
            while(n >= 0 && nums[n] > temp){
                nums[n + 1] = nums[n];
                n--;
            }
            nums[n + 1] = temp;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static long factorial(int n)
    {
        if(n == 0) 
            return 1;
        else
            return n * factorial(n - 1);
    }

}
