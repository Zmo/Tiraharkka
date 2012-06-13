
package tiraharkka;

import java.util.Arrays;

/**
 *
 * @author simo
 */
public class HeapNode
{
    public int key;
    public int[] position;

    public HeapNode(int k, int x, int y)
    {
        this.key = k;
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
    }

    public void copyFrom(HeapNode x)
    {
        this.key = x.key;
        this.position = Arrays.copyOf(x.position, x.position.length);
    }
}