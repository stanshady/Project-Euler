
public class Problem36
{

    public static int sum()
    {
        int sum = 0;
        for(int i = 1; i < 1000000; i++)
        {
            if(isPalindrome(baseArray(i,2)) == true &&
            isPalindrome(baseArray(i,10)) == true)
                sum += i;
        }
        return sum;
    }
    
    public static boolean isPalindrome(int[] digits)
    {
        int leftIndex = 0;
        int rightIndex = digits.length - 1;
        while(leftIndex <= rightIndex)
        {
            if(digits[leftIndex] != digits[rightIndex])
                return false;
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static int[] baseArray(int n, int base)
    {
        int numDigits = 0;
        int temp = n;
        
        while(temp > 0)
        {
            temp /= base;
            numDigits++;       
        }
        if(numDigits == 0)
            numDigits = 1;
            
        int[] digits = new int[numDigits];
        for(int i = digits.length - 1; i > -1; i--)
        {
            digits[i] = n % base;
            n /= base;
        }
      
        return digits;
    }
}
