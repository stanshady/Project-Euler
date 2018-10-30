
public class Problem15
{
    
    //row + 1 by col + 1 rectangular array.
    //method only creates values in lower triangular matrix.
    public static long max(int row, int col)
    {
        long[][] mat = new long[row + 1][col + 1];
        for(int r = 0; r <= row; r++)
        {   
            for(int c = 0; c <= r; c++)
            {
                if(c == 0)
                    mat[r][c] = 1L;
                else if(r == c)
                {
                    mat[r][c] = 2 * mat[r][c - 1];
                }
                else
                    mat[r][c] = mat[r-1][c] + mat[r][c-1];
            }
        }
        return mat[row][col];
    }

    //too slow for r = c = 20
    public static long findMax(int r, int c)
    {
        if(r == 0 || c == 0)
            return 1;

        return findMax(r - 1, c) + findMax(r, c - 1);       
    }
}