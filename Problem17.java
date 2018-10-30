
public class Problem17
{
    public static int numLetters()
    {
        int count = 0;
        for(int i = 1; i < 100; i++)
            count += twoDigits(i);
        for(int i = 100; i < 1000; i++)
            count += threeDigits(i);
        return count + 11;
    }
    
    public static int threeDigits(int n)
    {  
        if(n % 100 == 0)
            return digit(n/100) + 7;
        
        return digit(n/100) + 10 + twoDigits(n%100); 
    }
    
    
    public static int twoDigits(int n)
    {
        //single digit
        if(n < 10)
            return digit(n);

        //two digits
        //is teen
        if(n / 10 == 1)
            return teen(n);
            
        //not teen
        return tens(n/10) + digit(n % 10);
    }

    public static int digit(int n)
    {
        if(n == 1) return 3;
        if(n == 2) return 3;
        if(n == 3) return 5;
        if(n == 4) return 4;
        if(n == 5) return 4;
        if(n == 6) return 3;
        if(n == 7) return 5;
        if(n == 8) return 5;
        if(n == 9) return 4;
        return 0;
    }
    
    public static int teen(int n)
    {
        if(n == 11) return 6;
        if(n == 12) return 6;
        if(n == 13) return 8;
        if(n == 14) return 8;
        if(n == 15) return 7;
        if(n == 16) return 7;
        if(n == 17) return 9;
        if(n == 18) return 8;
        if(n == 19) return 8;
        return 3; //n == 10
    }
    
    public static int tens(int n)
    {
        
        if(n == 2) return 6;
        if(n == 3) return 6;
        if(n == 4) return 5;
        if(n == 5) return 5;
        if(n == 6) return 5;
        if(n == 7) return 7;
        if(n == 8) return 6;
        if(n == 9) return 6;
        return 0;
    }
}