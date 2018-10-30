import java.util.*;

public class Problem43
{
    public static int[] digits = {0,1,2,3,4,5,6,7,8,9};
    public static int[] primes = {2,3,5,7,11,13,17};
    
    public static long findSum()
    {
        long sum = 0;
        
        for(int i = 0; i < 10*9*8*7*6*5*4*3*2 - 1; i++)
        {
            if(check())
            
                sum += makeNum(0,10);                                                        
            perm();
        }        
        return sum;
    }
    
    public static boolean check()
    {
        for(int i = 1; i < 8; i++)
        {   
            if(makeNum(i,i+3) % primes[i-1] != 0)
                return false;
        }
        return true;
    }
    
    public static long makeNum(int start, int end)
    {
        long ans = 0;
        int len = end - start;
        while(start < end)
        {
            ans += digits[start] * Math.pow(10,len - 1);
            len--;
            start++;
        }
        return ans;
    }
    
    public static void perm()
    {
        int len = digits.length;
        int i = len - 1;
        while(digits[i-1] >= digits[i])
            i--;
        int j = len;
        while(digits[j-1] <= digits[i-1])
            j--;
        swap(i-1, j-1);
        i++;
        j = len;  
        while(i < j)
        {
            swap(i-1, j-1);
            i++;
            j--;
        }
    }

    public static void swap(int i, int j)
    {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}