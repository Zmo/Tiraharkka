
package tiraharkka;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simo
 */
public class MinHeapTest {

    public MinHeapTest()
    {

    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {

    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public static int[] intoIntArray(MinHeap heap)
    {
        int[] asd = new int[heap.getHeap()[0].key+1];
        for(int i=0; i<asd.length; ++i)
        {
            asd[i] = heap.getHeap()[i].key;
        }
        return asd;
    }

    /**
     * Test of insert method, of class MinHeap.
     */
    @Test
    public void testInsert() // testataan insert-funktiota, jossa tulee samalla testattua heapify-funktio
    {
        System.out.println("insert-funktion testi");
        MinHeap instance = new MinHeap();
        instance.insert(3,0,0);
        instance.insert(6,0,0);
        instance.insert(2,0,0);
        instance.insert(4,0,0);
        instance.insert(1,0,0);
        int[] expresult = {5,1,2,3,6,4};
        int[] expresult2 = {8,1,3,2,9,43,7,2,56};
        if(Arrays.equals(intoIntArray(instance), expresult))
        {
            MinHeap instance2 = new MinHeap();
            instance2.insert(56,0,0);
            instance2.insert(2,0,0);
            instance2.insert(7,0,0);
            instance2.insert(9,0,0);
            instance2.insert(43,0,0);
            instance2.insert(2,0,0);
            instance2.insert(1,0,0);
            instance2.insert(3,0,0);
            if(Arrays.equals(expresult2, intoIntArray(instance2)))
            {
                System.out.println("Testit läpäisty");
            }
            else
                fail("Testi 2/2: odotettu tulos: "+Arrays.toString(expresult2)+", saatu tulos oli: "+Arrays.toString(intoIntArray(instance2)));
        }
        else
            fail("Testi 1/2: odotettu tulos: "+Arrays.toString(expresult)+", saatu tulos: "+Arrays.toString(intoIntArray(instance)));
    }

    /**
     * Test of deleteMin method, of class MinHeap.
     */
    @Test
    public void testDeleteMin()
    {
        System.out.println("deleteMin testi");
        MinHeap instance = new MinHeap();
        System.out.println("Lisätään alkio 2");
        instance.insert(2,0,0);
        System.out.println("Lisätään alkio 4");
        instance.insert(4,0,0);
        System.out.println("Lisätään alkio 1");
        instance.insert(1,0,0);
        System.out.println("Lisätään alkio 5");
        instance.insert(5,0,0);
        System.out.println("Lisätään alkio 3");
        instance.insert(3,0,0);
        System.out.println(Arrays.toString(intoIntArray(instance)));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 1");
        int min = instance.deleteMin().key;
        System.out.println("Saatu tulos: "+min);
        if(min!=1)
            fail("Testi epäonnistui");
        System.out.println(Arrays.toString(intoIntArray(instance)));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 2");
        min = instance.deleteMin().key;
        System.out.println("Saatu tulos: "+min);
        if(min!=2)
            fail("Test epäonnistui");
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 3");
        min = instance.deleteMin().key;
        System.out.println("Saatu tulos: "+min);
        if(min!=3)
            fail("Testi epäonnistui");
        System.out.println(Arrays.toString(intoIntArray(instance)));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 4");
        min = instance.deleteMin().key;
        System.out.println("Saatu tulos: "+min);
        if(min!=4)
            fail("Testi epäonnistui");
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 5");
        min = instance.deleteMin().key;
        System.out.println("Saatu tulos: "+min);

        System.out.println("Testi onnistui");
    }

}