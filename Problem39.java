import java.util.*;

public class Problem39
{
    public static int findMax()
    {
        int max = 0;
        int ans = 0;
        for(int i = 3; i <= 1000; i++)
        {
            int temp = countTriples(i);
            if(temp > max)
            {
                ans = i;
                max = temp;
            }
        }
        return ans;
    }

    public static int countTriples(int perimeter)
    {
        List<int[]> triples = new ArrayList<int[]>();

        for(int c = 3; c <= perimeter - 2; c++)
        {
            for(int a = 1; a < c; a++)
            {
                int b = perimeter - c - a;
                if(b <= 0 || b < a)
                    continue;
                if(a*a + b*b == c*c)
                {
                    int[] temp = {a, b, c};
                    triples.add(temp);
                }
            }
        }
        return triples.size();  
    }
}

