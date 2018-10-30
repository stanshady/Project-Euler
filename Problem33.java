import java.util.*;

public class Problem33
{
    public static List<int[]> fractions = new ArrayList<int[]>();

    public static void findFractions()
    {
        for(int numer = 10; numer < 99; numer++)
        {
            for(int denom = numer + 1; denom < 100; denom++)
            {
                if(numer % 10 == 0 && denom % 10 == 0)
                    continue;
                if(numer % 10 == denom % 10 ||
                numer % 10 == (denom / 10) ||
                (numer / 10) == denom % 10 ||
                (numer / 10) == (denom / 10))
                {
                    if(cancel(numer,denom)[0] * denom == cancel(numer,denom)[1] * numer)
                    {
                        int[] temp = {numer, denom};
                        fractions.add(temp);
                    }
                }
            }
        }   
    }

    public static int[] cancel(int numer, int denom)
    {
        int[] ans = new int[2];
        if(numer % 10 == denom % 10)
        {
            ans[0] = numer / 10;
            ans[1] = denom / 10;
        }
        else if(numer % 10 == denom / 10)
        {
            ans[0] = numer / 10;
            ans[1] = denom % 10;
        }
        else if(numer / 10 == denom % 10)
        {
            ans[0] = numer % 10;
            ans[1] = denom / 10;
        }
        else if(numer / 10 == denom / 10)
        {
            ans[0] = numer % 10;
            ans[1] = denom % 10;
        }
        return ans;
    }    

    public static int gcd(int a, int b)
    {     
        while(b != 0)
        {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static int[] simplify(int numer, int denom)
    {
        int[] ans = new int[2];
        int gcd = Math.abs(gcd(numer, denom));
        numer /= gcd;
        denom /= gcd;
        ans[0] = numer;
        ans[1] = denom;
        return ans;
    }
    
    public static int[] product()
    {
        int[] prod = {1,1};
        for(int[] n : fractions)
        {
            prod[0] *= n[0];
            prod[1] *= n[1];
        }
        return simplify(prod[0],prod[1]);
    }
}