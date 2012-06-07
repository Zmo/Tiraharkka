
package tiraharkka;

import java.util.Arrays;

/**
 *
 * @author simo
 */

public class MinHeap
{
    private int[] heap;
    private int size;

    public MinHeap()
    {
	this.heap = new int[1];
	this.heap[0] = 0;
        this.size=1;
    }

    public int[] getHeap()
    {
        return this.heap;
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
        if(r <= this.heap[0])
        {
            int smallest;
            if(this.heap[l] < this.heap[r])
                smallest = l;
            else
                smallest = r;
            if(this.heap[i] > this.heap[smallest])
            {
                int buffer = this.heap[smallest];
                this.heap[smallest] = this.heap[i];
                this.heap[i] = buffer;
                heapify(smallest);
            }
        }
        else if(l == this.heap[0] && this.heap[i] > this.heap[l])
        {
            int buffer = this.heap[i];
            this.heap[i] = this.heap[l];
            this.heap[l] = buffer;
        }
    }

    public void insert(int k) // funktio lisää kekoon parametrina annetun alkion ja järjestää sitten keon heapify-funktiolla
    {
        if(this.heap[0]==this.size-1)
        {
            this.size = this.heap[0]*2+2;
            this.heap = Arrays.copyOf(this.heap, this.size);
        }

        int i = this.heap[0]+1;
        while(i>1 && this.heap[parent(i)] > k)
        {
            this.heap[i] = this.heap[parent(i)];
            i = parent(i);
        }
        this.heap[i] = k;
        this.heap[0] = this.heap[0]+1;
    }

    public int deleteMin() // funktio poistaa keon pienimmän alkion, järjestää loput keosta heapify-funktiollaja palauttaa sitten poistetun alkion
    {
        if(this.heap[0]>0)
        {
            int min = this.heap[1];
            this.heap[1] = this.heap[this.heap[0]];
            this.heap[this.heap[0]] = 0;
            this.heap[0] = this.heap[0]-1;
            heapify(1);
            return min;
        }
        else
            return -9999;
    }
}/*
public class MinHeap
{
    private int[] heap;

    public MinHeap()
    {
	heap = new int[1];
	heap[0] = 0;
    }

    public int[] getHeap()
    {
        return this.heap;
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

    public int[] heapify(int[] A, int i) // funktio järjestää parametrina annetun keon alkaen parametrina annetusta indeksistä
    {
        int l = left(i);
        int r = right(i);
        if(r <= A[0])
        {
            int smallest;
            if(A[l] < A[r])
                smallest = l;
            else
                smallest = r;
            if(A[i] > A[smallest])
            {
                int buffer = A[smallest];
                A[smallest] = A[i];
                A[i] = buffer;
                heapify(A, smallest);
            }
        }
        else if(l == A[0] && A[i] < A[l])
        {
            int buffer = A[i];
            A[i] = A[l];
            A[l] = buffer;
        }
        return A;
    }

    public void insert(int[] A, int k) // funktio lisää kekoon parametrina annetun alkion ja järjestää sitten keon heapify-funktiolla
    {
        A[0] = A[0]+1;
        int i = A[0];
        while(i>1 && A[parent(i)] < k)
        {
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = k;
    }

    public int deleteMin(int[] A) // funktio poistaa keon pienimmän alkion, järjestää loput keosta heapify-funktiollaja palauttaa sitten poistetun alkion
    {
        int min = A[1];
        A[1] = A[A[0]];
        A[0] = A[0]-1;
        heapify(A, 1);
        return min;
    }
}*/