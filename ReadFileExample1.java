import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//ALSO SEE PROBLEM 22 FOR SIMPLE EXAMPLE WITH 1 STRING OUTPUT
public class ReadFileExample1 {

    private static final String FILENAME = "C:\\Users\\daniel_nagel\\Desktop\\Problem11 text.txt";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;
        String[][] mat = new String[20][20];
        
        
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            
            int r = 0, c = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                c = 0;
                for(int i = 0; i < sCurrentLine.length() - 1; i += 3)
                {
                    mat[r][c] = sCurrentLine.substring(i,i + 2);
                    c++;
                }
                r++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        
        for(String[] s : mat)
        {
            System.out.println(Arrays.toString(s));
        }
    }

}
