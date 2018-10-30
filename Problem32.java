import java.util.*;

public class Problem32
{
    public static int[] digits = {1,2,3,4,5,6,7,8,9};
    public static List<Integer> products = new ArrayList<Integer>();

    public static int findProducts()
    {
        for(int i = 0; i < 362879; i++)
        {
            for(int times = 1; times < 7; times++)
            {
                for(int equals = times + 1; equals < 8; equals++)
                {
                    checkProducts(times, equals);
                }
            }
            perm();
        }
        
        int sum = 0;
        for(int n : products)
            sum += n;            
        return sum;
    }

    public static void checkProducts(int times, int equals)
    {
        int numLeft = makeNum(0,times);
        int numRight = makeNum(times, equals);
        int numEquals = makeNum(equals,9);
        if((numLeft * numRight == numEquals) && !products.contains(numEquals))
            products.add(numEquals);
    }

    public static int makeNum(int start, int end)
    {
        int ans = 0;
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