
public class Problem24
{
    public static int[] digits = {0,1,2,3,4,5,6,7,8,9};
    
    //i and j represent/point to the values to their left
    public static int[] perm(int n)
    {
        int len = digits.length;
        int count = 0;

        while(count < n - 1)
        {
            int i = len - 1;
            //Finds first misorder
            while(digits[i-1] >= digits[i])
                i--;

            int j = len;
            //Finds smallest value greater than misorder
            while(digits[j-1] <= digits[i-1])
                j--;

            swap(i-1, j-1);

            i++;
            j = len;
            //Reverses all remaining values to the right of the misorder
            //(which are guaranteed to be in decreasing order)
            while(i < j)
            {
                swap(i-1, j-1);
                i++;
                j--;
            }
            count++;
        }
        return digits;
    }

    public static void swap(int i, int j)
    {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}