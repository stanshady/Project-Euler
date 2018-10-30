
public class Problem21
{
    public static int[] nums;

    public static int sum(int n)
    {
        fillNums(n);
        int[] divOnce = new int[n];
        int[] divTwice = new int[n];

        for(int i = 1; i < nums.length; i++)
        { 
            divOnce[i] = sumDivisors(i);
            divTwice[i] = sumDivisors(divOnce[i]);
        }
        
        int sum = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == divTwice[i] && nums[i] != divOnce[i])
                sum += nums[i];
        }
        return sum;
    }

    public static void fillNums(int n)
    {
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = i;
    }

    public static int sumDivisors(int n)
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

}