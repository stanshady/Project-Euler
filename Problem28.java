
public class Problem28
{

    public static int sumDiags(int[][] mat)
    {
        int sum = 0;
        for(int i = 0; i < mat.length; i++)
            sum += mat[i][i] + mat[mat.length - 1 - i][i];
        return sum;
    }
    
    public static int[][] makeSpiral(int n)
    {
        int[][] mat = new int[n][n];
        int dir = 0;
        int step = n*n;
        int row = 0; int col = n-1; //start in top right corner

        while(step > 0)
        {
            //move left
            if(dir % 4 == 0)
            {
                while(true)
                {
                    mat[row][col] = step;
                    step--;
                    if(col == 0 || mat[row][col-1] != 0)
                    {
                        row++;
                        break;   
                    }      
                    col--;
                }
            }

            //down
            else if(dir % 4 == 1)
            {
                while(true)
                {
                    mat[row][col] = step;
                    step--;
                    if(row == n - 1 || mat[row + 1][col] != 0)
                    {
                        col++;
                        break;   
                    }      
                    row++;
                }
            }
            
            //right    
            else if(dir % 4 == 2)
            {
                while(true)
                {
                    mat[row][col] = step;
                    step--;
                    if(col == n - 1 || mat[row][col + 1] != 0)
                    {
                        row--;
                        break;   
                    }      
                    col++;
                }
            }    

            //up
            else //dir % 4 == 3
            {
                while(true)
                {
                    mat[row][col] = step;
                    step--;
                    if(row == 0 || mat[row - 1][col] != 0)
                    {
                        col--;
                        break;   
                    }      
                    row--;
                }
            }    
            dir++;
        }
        return mat;
    }
}