
public class Problem49
{
    public static int[] primes = trimPrimes(Algorithm.primesLessThan(10000));
    
    public static int[] findTriple()
    {
        for(int i = 0; i < primes.length; i++)
        {   
            //given in the description
            if(primes[i] == 1487 || primes[i] == 4817 || primes[i] == 8147)
                continue;
                
            for(int gap = (9999 - primes[i]) / 2; gap > 0; gap--)
            {
                if(isPrimeProgression(primes[i],gap))
                    if(contains(makePermutations(primes[i]), primes[i] + gap) &&
                    contains(makePermutations(primes[i]), primes[i] + 2*gap))
                    {   
                        System.out.print(primes[i]);
                        System.out.print(primes[i] + gap);
                        System.out.println(primes[i] + 2*gap);
                        return new int[] {primes[i], gap};
                    }
            }
        }
        return new int[] {-1,-1};
    }   

    //returns all 24 permuations of a 4 digit number
    public static int[] makePermutations(int n)
    {
        int[] indices = {0,1,2,3};
        int[] nums = Algorithm.baseArray(n,10);       
        int[] perms = new int[24];
        perms[0] = Algorithm.makeNum(nums);
        int permsIndex = 0;

        for(int i = 0; i < 23; i++)
        {
            Algorithm.perm(indices);
            permsIndex++;
            int[] temp = new int[4];

            for(int index = 0; index < indices.length; index++)
                temp[index] = nums[indices[index]];  

            perms[permsIndex] = Algorithm.makeNum(temp);            
        }

        return perms;
    }
  
    public static boolean isPrimeProgression(int prime, int gap)
    {
        return Algorithm.binSearch(primes, prime + gap) > -1 && 
        Algorithm.binSearch(primes, prime + 2*gap) > -1;
    }
    
    public static boolean contains(int[] nums, int key)
    {
        for(int n: nums)
            if (n == key)
                return true;
        return false;
    }
    
    //returns all the 4 digit primes
    public static int[] trimPrimes(int[] primes)
    {
        int startIndex = 0;
        for(int i = 0; i < primes.length; i++)
            if(startIndex == 0 && primes[i] > 1000)
                startIndex = i;

        int[] trimed = new int[primes.length - startIndex];
        for(int i = 0; i < trimed.length; i++)       
            trimed[i] = primes[i + startIndex];

        return trimed;
    }
}
