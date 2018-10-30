import java.math.BigInteger;

public class Problem55
{
    public static int count()
    {
        int count = 0;
        
        for(int i = 1; i < 10000; i++)
        {
            BigInteger big = new BigInteger(Integer.toString(i));
            if(isLychrel(big))
                count++;
        }
        
        return count;
    }
    
    public static boolean isLychrel(BigInteger big)
    {
        for(int i = 0; i < 49; i++)
        {
            big = makeLychrel(big);
            if(isPalindrome(big))
                return false;
        }
        
        return true;
    }
    
    public static BigInteger makeLychrel(BigInteger big)
    {
        return big.add(new BigInteger(reverse(big.toString())));
    }
    
    public static boolean isPalindrome(BigInteger big)
    {
        String num = big.toString();
        int len = num.length();
        
        for(int i = 0; i < len/2; i++)
            if(num.charAt(i) != num.charAt(len - 1 - i))
                return false;
                
        return true;
    }
    
    public static String reverse(String str)
    {
        String rev = "";
        
        for(int i = str.length() - 1; i > -1; i--)
            rev += str.substring(i,i+1);
            
        return rev;
    }
}
