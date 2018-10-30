
public class Problem38
{

    public static long findLongest()
    {
        long longest = 0;
        for(int i = 1; i < 100000; i++)
        {
            int maxNumTimes = 9 / numDigits(i);
            for(int iter = 1; iter <= maxNumTimes; iter++)
            {
                long temp = makeNum(makeProducts(i,iter));
                if(Algorithm.isPandigital(temp) && temp > longest)
                    longest = temp;
            }                        
        }
        return longest;
    }

    public static int[] makeProducts(int n, int iter)
    {
        int[] products = new int[iter];
        for(int i = 0; i < iter; i++)
            products[i] = n * (i+1);
        return products;
    }

    public static int numDigits(int n)
    {
        int numDigits = 0;
        while(n > 0)
        {
            numDigits++;
            n /= 10;
        }
        return numDigits;
    }

    public static long makeNum(int[] digits)
    {
        long num = 0;
        int power = 0;
        for(int i = digits.length - 1; i > -1; i--)
        {
            num += digits[i] * Math.pow(10,power);
            power += numDigits(digits[i]);
        }
        return num;
    }

}