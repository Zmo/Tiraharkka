
package tiraharkka;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author simo
 */
public class Main
{
    public void Astar(char[][] map, char[] start, char[] goal)
    {

    }

    public static void readMap(String filename) // lukee syötteenä annetun tiedoston sisältämän kartan ja laittaa sen char-matriisiin
    {
        File file = new File(filename);
        try
        {
            Scanner filescanner = new Scanner(file);
            int mapwidth = filescanner.nextLine().length();
            int mapheight = 0;
            filescanner.reset();

            while(filescanner.hasNextLine())
            {
                ++mapheight;
            }
            char[][] map = new char[mapwidth][mapheight];
            //DataInputStream dis = new DataInputStream(new BufferedInputStream (new FileInputStream(file)));
            filescanner.reset();

            for(int i=0; i<mapheight; i++)
            {
                char[] line = filescanner.nextLine().toCharArray();
                map[i] = line;
            }
            for(int i=0; i<mapwidth; i++) //testausta varten
            {
                for(int j=0; j<mapheight; j++)
                {
                    System.out.println(map[i][j]);
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Antamaasi tiedostoa ei löytynyt");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        readMap("test.txt");
    }

}
