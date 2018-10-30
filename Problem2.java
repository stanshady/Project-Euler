

public class Problem2
{
    
    public static int findSum(int n)
    {
        int sum = 0;
        int f1 = 0;
        int f2 = 1;
        while(f2 < n)
        {
            if(f2 % 2 == 0)
                sum += f2;
            int temp = f2;
            f2 += f1;
            f1 = temp;     
        }
        return sum;
    }
}