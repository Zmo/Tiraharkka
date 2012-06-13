
package tiraharkka;

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
}