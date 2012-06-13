
package tiraharkka;

import java.util.Arrays;

/**
 *
 * @author simo
 */

public class MinHeap
{
    private HeapNode[] heap;
    private int size;

    public MinHeap()
    {
	this.heap = new HeapNode[64];
	this.heap[0].key = 0;
        this.size=64;
    }

    public int left(int i) // palauttaa parametrina annetun alkion vasemman lapsen
    {
        return i*2;
    }

    public int right(int i) // palauttaa parametrina annetun alkion oikeanpuoleisen lapsen
    {
        return i*2+1;
    }

    public int parent(int i) // palauttaa parametrina annetun alkion vanhemman
    {
        return i/2;
    }

    public void heapify(int i) // funktio järjestää keon alkaen parametrina annetusta indeksistä
    {
        int l = left(i);
        int r = right(i);
        if(r <= this.heap[0].key)
        {
            int smallest;
            if(this.heap[l].key < this.heap[r].key)
                smallest = l;
            else
                smallest = r;
            if(this.heap[i].key > this.heap[smallest].key)
            {
                int buffer = this.heap[smallest].key;
                this.heap[smallest] = this.heap[i];
                this.heap[i].key = buffer;
                heapify(smallest);
            }
        }
        else if(l == this.heap[0].key && this.heap[i].key > this.heap[l].key)
        {
            int buffer = this.heap[i].key;
            this.heap[i].key = this.heap[l].key;
            this.heap[l].key = buffer;
        }
    }

    public void insert(int k, int x, int y) // funktio lisää kekoon parametrina annetun alkion ja järjestää sitten keon heapify-funktiolla
    {
        if(this.heap[0].key==this.size-1)
        {
            this.size = this.heap[0].key*2;
            this.heap = Arrays.copyOf(this.heap, this.size);
        }

        int i = this.heap[0].key++;
        while(i>1 && this.heap[parent(i)].key > k)
        {
            this.heap[i] = this.heap[parent(i)];
            i = parent(i);
        }
        this.heap[i].key = k;
        this.heap[i].position[0] = x;
        this.heap[i].position[1] = y;
    }

    public HeapNode deleteMin() // funktio poistaa keon pienimmän alkion, järjestää loput keosta heapify-funktiollaja palauttaa sitten poistetun alkion
    {
        if(this.heap[0].key>0)
        {
            HeapNode min = this.heap[1];
            this.heap[1] = this.heap[this.heap[0].key];
            this.heap[this.heap[0].key].key = 0;
            this.heap[0].key = this.heap[0].key-1;
            heapify(1);
            return min;
        }
        else
            return null;
    }

    public boolean isEmpty()
    {
        if(heap[0].key == 0)
            return true;
        else
            return false;
    }
}