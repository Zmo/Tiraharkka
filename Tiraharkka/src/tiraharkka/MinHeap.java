
package tiraharkka;
/**
 *
 * @author simo
 */

public class MinHeap
{
    private int[] heap;

    public MinHeap()
    {
	heap = new int[1];
	heap[0] = 0;  // säilytetään keon kokoa indeksissä 0
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

    public void heapify(int[] A, int i) // funktio järjestää parametrina annetun keon alkaen parametrina annetusta indeksistä
    {
        int l = left(i);
        int r = right(i);
        if(r <= A[0])  //tarkistetaan, että oikea lapsen indeksi ei ole suurempi kuin keon koko eli että se on olemassa
        {
            int largest;
            if(A[l] > A[r]) // katsotaan onko vasen vai oikea lapsi isompi
                largest = l;
            else
                largest = r;
            if(A[i] < A[largest])
            {
                int buffer = A[largest];
                A[largest] = A[i];
                A[i] = buffer;
                heapify(A, largest); // kutsutaan rekursiivisesti, jotta saadaan koko keko järjestykseen
            }
        }
        else if(l == A[0] && A[i] < A[l])
        {
            int buffer = A[i];
            A[i] = A[l];
            A[l] = buffer;
        }
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
}