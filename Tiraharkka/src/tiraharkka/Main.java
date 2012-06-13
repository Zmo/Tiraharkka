
package tiraharkka;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author simo
 */
public class Main
{
    public static int heuristic(int x, int y, int[] goal)
    {
        return Math.abs(x - goal[0]) + Math.abs(y - goal[1]);
    }

    public void astar(char[][] map, int[] start, int[] goal)
    {
        boolean[][] closedset = new boolean[map.length][map[0].length];
        int[][][] came_from = new int[map.length][map[0].length][2];

        Arrays.fill(closedset, false);
        MinHeap openset = new MinHeap();
        openset.insert(0, start[0], start[1]);
        int[][] g_score = new int[map.length][map[0].length];
        Arrays.fill(g_score, Integer.MAX_VALUE);
        g_score[start[0]][start[1]] = 0;

        HeapNode current;
        int g;

        while(!openset.isEmpty())
        {
            current = openset.deleteMin();
            if(current.position[0] == goal[0] && current.position[1] == goal[1])
                reconstructPath(map, closedset, start, goal);
            closedset[current.position[0]][current.position[1]] = true;
            g = current.key+1;

            if(current.position[0] > 0 && !closedset[current.position[0]-1][current.position[1]] || current.position[0] > 0 && g < g_score[current.position[0]-1][current.position[1]])
            {
                openset.insert(g+heuristic(current.position[0]-1, current.position[1], goal), current.position[0]-1, current.position[1]);
                came_from[current.position[0]][current.position[1]][0] = current.position[0];
                came_from[current.position[0]][current.position[1]][1] = current.position[1];
                g_score[current.position[0]-1][current.position[1]] = g;
            }
            if(current.position[1] > 0 && !closedset[current.position[0]][current.position[1]-1] || current.position[1] > 0 && g < g_score[current.position[0]][current.position[1]-1])
            {
                openset.insert(g+heuristic(current.position[0], current.position[1]-1, goal), current.position[0], current.position[1]-1);
                came_from[current.position[0]][current.position[1]][0] = current.position[0];
                came_from[current.position[0]][current.position[1]][1] = current.position[1];
                g_score[current.position[0]][current.position[1]-1] = g;
            }
            if(current.position[0] < map.length-1 && !closedset[current.position[0]+1][current.position[1]] || current.position[0] < map.length-1 && g < g_score[current.position[0]+1][current.position[1]])
            {
                openset.insert(g+heuristic(current.position[0]+1, current.position[1], goal), current.position[0]+1, current.position[1]);
                came_from[current.position[0]][current.position[1]][0] = current.position[0];
                came_from[current.position[0]][current.position[1]][1] = current.position[1];
                g_score[current.position[0]+1][current.position[1]] = g;
            }
            if(current.position[1] < map[0].length-1 && !closedset[current.position[0]][current.position[1]+1] || current.position[1] < map[0].length-1 && g < g_score[current.position[0]][current.position[1]+1])
            {
                openset.insert(g+heuristic(current.position[0], current.position[1]+1, goal), current.position[0], current.position[1]+1);
                came_from[current.position[0]][current.position[1]][0] = current.position[0];
                came_from[current.position[0]][current.position[1]][1] = current.position[1];
                g_score[current.position[0]][current.position[1]+1] = g;
            }
            
        }
        // ei löytynyt reittiä
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

    private void reconstructPath(char[][] map, boolean[][] closedset, int[] start, int[] goal)
    {
        for(int i=0; i<closedset.length; ++i)
        {
            for(int j=0; j<closedset[0].length; ++j)
            {
                if(closedset[i][j] == true)
                    map[i][j] = 'o';
            }
        }

        for(int i=0; i<map.length; ++i)
        {
            for(int j=0; j<map[0].length; ++j)
            {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

}
