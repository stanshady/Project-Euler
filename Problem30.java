import java.util.*;

public class Problem30
{
    public static ArrayList<Integer> ans;

    public static int findBound()
    {
        int nine = 9*9*9*9*9;
        int n = 1;
        while(n*nine > Math.pow(10,n))
            n++;
        return (int) Math.pow(10,n);
    }

    public static boolean sum5thPowers(int n)
    {
        int temp = n;
        int sum = 0;
        while(n > 0)
        {
            int dig = n % 10;
            sum += dig*dig*dig*dig*dig;
            n /= 10;
        }
        return sum == temp;
    }

    public static int findSum()
    {
        ans = new ArrayList<Integer>();
        int bound = findBound();
        for(int i = 2; i <= bound; i++)
            if(sum5thPowers(i))
                ans.add(i);
        System.out.println(ans);
        
        int sum = 0;
        for(int n : ans)
            sum += n;
        return sum;
    }

}