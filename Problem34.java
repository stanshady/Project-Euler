public class Problem34
{

    public static int sum()
    {
        int sum = 0;
        int check = 0;
        //Use 9!*7 = 2540160 b/c x(9!)-10^x = 0, x = 6.3
        for(int i = 3; i < 2540160; i++)
        {
            check = sumDigits(i);
            if(check == i)
                sum += check;
        }
        return sum;
    }

    public static int sumDigits(int n)
    {
        int sum = 0;
        int digit = n % 10;
        while(n > 0)
        {
            sum += factorial(digit);
            n /= 10;
            digit = n % 10;
        }
        return sum;
    }

    public static int factorial(int n)
    {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }

}