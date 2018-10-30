import java.util.*;

public class Problem52
{
   
    public static int smallest()
    {    
        int n = 1;
        int[] digits;
        boolean found = false;
            
        while(!found)
        {
            digits = digitArray(n);          
            int i = 2;
            
            for(; i <= 6; i++)            
                if(!Arrays.equals(digits, digitArray(n * i)))
                    break;    
            
            if(i == 7)
                return n;
            
            n++;
        }
        
        return -1;
    }
    
    public static int[] digitArray(int n)
    {
        int[] ret = new int[10];
        
        while(n > 0)
        {
            ret[n % 10]++;
            n /= 10;
        }
        
        return ret;
    }
    
}
