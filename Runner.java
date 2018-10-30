import java.util.*;
import java.math.*;

public class Runner
{

    public static void main(String[] args)
    {  
        System.out.println(Problem57.count());
    }

    public static void print2D(int[][] mat)
    {
        for(int[] arr : mat)
            System.out.println(Arrays.toString(arr));
    }  
}