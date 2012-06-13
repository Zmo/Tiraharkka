
package tiraharkka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author simo
 */
public class Astar
{
    private boolean[][] closedset;
    private boolean[][] opensetarray;
    private int[][][] came_from;
    private char[][] map;
    private MinHeap openset;
    private int[][] g_score;
    private int[] start;
    private int[] goal;

    public Astar(String file)
    {
        this.start = new int[2];
        this.goal = new int[2];
        readMap(file);
        this.closedset = new boolean[map.length][map[0].length];
        this.opensetarray = new boolean[map.length][map[0].length];
        this.came_from = new int[map.length][map[0].length][2];
        this.openset = new MinHeap();
        this.g_score = new int[map.length][map[0].length];
    }

    public void readMap(String filename) // lukee syötteenä annetun tiedoston sisältämän kartan ja laittaa sen char-matriisiin
    {
        File file = new File(filename);
        try
        {
            Scanner filescanner = new Scanner(file);
            int mapwidth = filescanner.nextLine().length();
            int mapheight = 1;

            while(filescanner.hasNextLine())
            {
                ++mapheight;
                filescanner.nextLine();
            }
            this.map = new char[mapwidth][mapheight];
            filescanner = new Scanner(file);

            for(int i=0; i<mapheight; i++)
            {
                char[] line = filescanner.nextLine().toCharArray();
                for(int j=0; j<mapwidth; ++j)
                {
                    this.map[j][i] = line[j];
                    if(line[j] == 'S')
                    {
                        this.start[0] = j;
                        this.start[1] = i;
                    }
                    else if(line[j] == 'G')
                    {
                        this.goal[0] = j;
                        this.goal[1] = i;
                    }
                }
            }
            for(int i=0; i<mapheight; i++) //testausta varten
            {
                for(int j=0; j<mapwidth; j++)
                {
                    System.out.print(map[j][i]);
                }
                System.out.println();
            }
            System.out.println();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Antamaasi tiedostoa ei löytynyt");
        }
    }

    private void addNode(int[] position, int offsetx, int offsety, int g, int[] goal)
    {
        int x = position[0]+offsetx;
        int y = position[1]+offsety;
        int f = heuristic(x,y,goal);
        openset.insert(g+f, x, y);
        opensetarray[x][y] = true;
        came_from[x][y][0] = position[0];
        came_from[x][y][1] = position[1];
        g_score[x][y] = g;
    }
    
    private void reconstructPath(int[] start, int[] goal)
    {
        for(int i=0; i<closedset[0].length; ++i)
        {
            for(int j=0; j<closedset.length; ++j)
            {
                if(opensetarray[j][i] == true)
                    map[j][i] = ',';
            }
        }
        int[] p = came_from[goal[0]][goal[1]];
        while(p[0] != start[0] || p[1] != start[1])
        {
            map[p[0]][p[1]] = 'o';
            p = came_from[p[0]][p[1]];
        }
        map[goal[0]][goal[1]] = 'G';

        for(int i=0; i<map[0].length; ++i)
        {
            for(int j=0; j<map.length; ++j)
            {
                System.out.print(map[j][i]);
            }
            System.out.println("");
        }
    }

    private static int heuristic(int x, int y, int[] goal)
    {
        return Math.abs(x - goal[0]) + Math.abs(y - goal[1]);
    }

    public void astar()
    {
        for(int i=0; i<closedset.length; ++i)
        {
            Arrays.fill(closedset[i], false);
            Arrays.fill(opensetarray[i], false);
            Arrays.fill(g_score[i], Integer.MAX_VALUE);
        }
        openset.insert(0, start[0], start[1]);        
        g_score[start[0]][start[1]] = 0;
        HeapNode current;
        int g;

        while(!openset.isEmpty())
        {
            current = openset.deleteMin();
            if(current.position[0] == goal[0] && current.position[1] == goal[1])
            {
                reconstructPath(start, goal);
                return;
            }
            closedset[current.position[0]][current.position[1]] = true;
            g = g_score[current.position[0]][current.position[1]];

            if(map[current.position[0]-1][current.position[1]] != 'x' && !closedset[current.position[0]-1][current.position[1]] && (!opensetarray[current.position[0]-1][current.position[1]] || g < g_score[current.position[0]-1][current.position[1]]))
                addNode(current.position, -1, 0, g, goal);
            if(map[current.position[0]][current.position[1]-1] != 'x' && !closedset[current.position[0]][current.position[1]-1] && (!opensetarray[current.position[0]][current.position[1]-1] || g < g_score[current.position[0]][current.position[1]-1]))
                addNode(current.position, 0, -1, g, goal);
            if(map[current.position[0]+1][current.position[1]] != 'x' && !closedset[current.position[0]+1][current.position[1]] && (!opensetarray[current.position[0]+1][current.position[1]] || g < g_score[current.position[0]+1][current.position[1]]))
                addNode(current.position, 1, 0, g, goal);
            if(map[current.position[0]][current.position[1]+1] != 'x' && !closedset[current.position[0]][current.position[1]+1] && (!opensetarray[current.position[0]][current.position[1]+1] || g < g_score[current.position[0]][current.position[1]+1]))
                addNode(current.position, 0, 1, g, goal);
        }

        came_from[goal[0]][goal[1]] = start;
        reconstructPath(start, goal);
        //System.out.println("Ei löytynyt reittiä");
    }
}
