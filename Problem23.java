import java.util.*;

public class Problem23
{
    public static int sum(int[] abun)
    {
        int sum = 0;
        int n = 1;
        int i;
        
        while(n <= 28123)
        {
            i = 0;
            for(; i < abun.length; i++)
            {
                int temp = n - abun[i];
                if(temp <= 0)
                {   
                    sum += n;
                    break;
                }
                if(binSearch(temp,abun))
                    break;
            }
            if(i == abun.length)
                sum += n;
            n++;
        }
        return sum;
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

    public static int sumProperDivisors(int n)
    {
        int sum = 1;
        for(int i = 2; i * i <= n; i++)        
            if(n % i == 0)
            {
                if(i * i == n)
                    sum += i;
                else
                    sum += (i + n/i);
            }
        return sum;
    }

    public static boolean isAbun(int n)
    {
        return sumProperDivisors(n) > n;
    }

    public static int[] fillAbun()
    {
        ArrayList<Integer> abun = new ArrayList<Integer>();
        for(int i = 2; i <= 28123; i++)
            if(isAbun(i))
                abun.add(i);

        int[] result = new int[abun.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = abun.get(i);
        return result;
    }

}