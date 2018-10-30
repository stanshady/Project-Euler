
public class Problem4
{
    
    public static int findMax()
    {
        int max = 0;
        for(int i = 100; i < 999; i++)
        {
            for(int j = i; j < 999; j++)
            {
                if(isPal(i * j) && i * j > max)
                    max = i * j;
            }
        }
        return max;
    }
    
    public static boolean isPal(int n)
    {
        //make backwards
        String backwards = "";
        int temp = n;
        while(temp > 0)
        {
            backwards += temp % 10;
            temp /= 10;
        }
        int back = Integer.parseInt(backwards);
        
        //check for palindrome
        temp = n;
        while(temp > 0)
        {
            if(temp % 10 != back % 10)
                return false;
            else
            {
                temp /= 10;
                back /= 10;
            }
        }
        return true;
    }
}