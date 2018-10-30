import java.util.*;

public class Problem41
{
    //31622 ~ sqrt(999999999)
    public static int[] primes = Algorithm.primesLessThan(31622);

    public static int findLargest()
    {
        int[] pandigitals;
        int testNum = 0;
        int numDigits = 9;

        while(numDigits > 0)
        {
            pandigitals = new int[numDigits];
            for(int i = 0; i < numDigits; i++)
                pandigitals[numDigits - 1 - i] = i + 1;

            for(int i = 0; i < Algorithm.factorial(numDigits) - 1; i++)
            {
                testNum = makeNum(pandigitals);
                if(isPrime(testNum))          
                    return testNum;             
                else
                    Algorithm.perm2(pandigitals);
            }
            numDigits--;
        }
        return -1;
    }

    public static int makeNum(int[] digits)
    {
        int num = 0;
        int exp = 0;

        for(int i = digits.length - 1; i > -1; i--)
        {
            num += digits[i] * (int) Math.pow(10,exp);
            exp++;
        }
        return num;
    }

    public static boolean isPrime(int n)
    {
        int i = 0;
        while(i < primes.length && primes[i] * primes[i] < n)
        {
            if(n % primes[i] == 0)
                return false;
            i++;
        }
        return true;
    }

}
