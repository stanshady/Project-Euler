
public class Problem19
{
    private static int weekday = 2; //tuesday
    private static int year = 1901;
    private static final int[] FIRSTS = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    private static final int[] FIRSTS_LEAPS = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};;

    public static int count()
    {
        int count = 0;
        while(year <= 2000)
        {
            if(year % 4 == 0)
                count += checkLeap();
            else
                count += check();
            year++;
        }	
        return count;
    }

    public static int check()
    {
        int count = 0;	
        for(int i = 0; i < FIRSTS.length; i++)
            if((weekday + FIRSTS[i]) % 7 == 0)
                count++;
        weekday += 365;
        weekday %= 7;
        return count;

    }

    public static int checkLeap()
    {
        int count = 0;
        for(int i = 0; i < FIRSTS_LEAPS.length; i++)
            if((weekday + FIRSTS_LEAPS[i]) % 7 == 0)
        count++;
        weekday += 366;
        weekday %= 7;
        return count;
    }
}