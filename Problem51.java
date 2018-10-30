import java.util.*;

public class Problem51
{
    public static int[] primes = Algorithm.sieve(1000000);

    public static void find8()
    {
        int n = 1;
        boolean found = false;
        
        while(!found)
        {
            if(maxChain(n) == 8)
                found = true;    
            n++;
        }
    }

    //finds the max chain length for n over all subset variations (combinations)
    public static int maxChain(int n)
    {
        int numDigits = 0;
        int temp = n;
        while(temp > 0)
        {
            numDigits++;
            temp /= 10;
        }

        int max = 0;
        int iter = 1;
        //uses binary as boolean array of subset variations (combinations)
        while(iter < Math.pow(2, numDigits))
        {
            int check = countChain(n, makeIndices(iter, numDigits));
            if(check > max)
                max = check;
            iter++;
        }

        return max;
    }

    //counts how many primes using digits 0-9 in given indices
    public static int countChain(int n, int[] indices)
    {
        int[] nums = Algorithm.baseArray(n,10);
        int count = 0;
        
        for(int digit = 0; digit < 10; digit++)
        {
            for(int i = 0; i < indices.length; i++)
            {
                if(indices[i] == 1)
                    nums[i] = digit;
            }
             //nums[0] != 0 so makeNums has same number of digits as n
            if(nums[0] != 0 && Algorithm.binSearch(primes,makeNum(nums)) > -1)
                count++;
        }
        
        if(count == 8)
            System.out.println(countChainDetails(n,indices));
            
        return count;
    }
    
    //for printing out the chain and for the final answer
    public static int countChainDetails(int n, int[] indices)
    {
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        int[] nums = Algorithm.baseArray(n,10);
        
        for(int digit = 0; digit < 10; digit++)
        {
            for(int i = 0; i < indices.length; i++)
            {
                if(indices[i] == 1)
                    nums[i] = digit;
            }
            
            if(nums[0] != 0 && Algorithm.binSearch(primes,makeNum(nums)) > -1)
                ansList.add(makeNum(nums));
        }
        
        System.out.println(ansList);
        return ansList.get(0);
    }

    //make indices based on binary number with numDigits binary digits
    public static int[] makeIndices(int iter, int numDigits)
    {
        int[] indices = new int[numDigits];
        int[] temp = Algorithm.baseArray(iter,2);
        //copy temp into indices
        for(int i = 0; i < temp.length; i++)
            indices[indices.length - 1 - i] = temp[temp.length - 1 - i];
        return indices;
    }

    //returns base 10 number from int[] digits
    public static int makeNum(int[] digits)
    {
        int n = 0;
        for(int i = 0; i < digits.length; i++)
            n += digits[i] * (int) Math.pow(10,digits.length - i - 1);      
        return n;
    }

}
