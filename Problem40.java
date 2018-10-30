
public class Problem40
{

    public static int product()
    {
        int[] digits = makeDigits();
        int prod = 1;
        for(int i = 0; i <= 6; i++)
            prod *= digits[(int) Math.pow(10,i) - 1];
        return prod;           
    }
    
    public static int[] makeDigits()
    {
        int[] champernowne = new int[1000000];
        int index = 0;
        int n = 1;
        
        while(index < champernowne.length)
        {
            int[] digits = Algorithm.baseArray(n, 10);
            
            if(index + digits.length >= champernowne.length)
            {
                for(int i = 0; index < champernowne.length; i++)
                {
                    champernowne[index] = digits[i];
                    index++;
                } 
            }
            else
            {
                for(int i = 0; i < digits.length; i++)
                {
                    champernowne[index] = digits[i];
                    index++;
                }
            }
            n++;
        }

        return champernowne;
    }
}