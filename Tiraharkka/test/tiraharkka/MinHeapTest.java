
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

    /**
     * Test of heapify method, of class MinHeap.
     */
    //@Test
    /*public void testHeapify()
    {
        System.out.println("heapify");
        int[] A = {3,2,1,3};
        MinHeap instance = new MinHeap();
        instance.heap = {1};
        instance.heapify(1);
        int[] expresult = {3,1,2,3};
        if(Arrays.equals(result, expresult))
        {
            System.out.println("herp");/*
            int[] B = {5,5,6,2,1,3};
            int[] expresult2 = {5,1,2,5,6,3};
            int[] result2 = instance.heapify(B,1);
            if(Arrays.equals(result2, expresult2))
            {
                System.out.println("Success!");
                return;
            }
            else
                fail("Odotettu tulos: "+Arrays.toString(expresult2)+", saatu tulos: "+Arrays.toString(result2));
        }
        else
            fail("Odotettu tulos: "+Arrays.toString(expresult)+", saatu tulos: "+Arrays.toString(result));
    }*/

    /**
     * Test of insert method, of class MinHeap.
     */
    @Test
    public void testInsert() // testataan insert-funktiota, jossa tulee samalla testattua heapify-funktio
    {
        System.out.println("insert-funktion testi");
        MinHeap instance = new MinHeap();
        instance.insert(3);
        instance.insert(6);
        instance.insert(2);
        instance.insert(4);
        instance.insert(1);
        int[] expresult = {5,1,2,3,6,4,0,0};
        int[] expresult2 = {8,1,3,2,9,43,7,2,56,0,0,0,0,0,0,0};
        if(Arrays.equals(instance.getHeap(), expresult))
        {
            MinHeap instance2 = new MinHeap();
            instance2.insert(56);
            instance2.insert(2);
            instance2.insert(7);
            instance2.insert(9);
            instance2.insert(43);
            instance2.insert(2);
            instance2.insert(1);
            instance2.insert(3);
            if(Arrays.equals(expresult2, instance2.getHeap()))
            {
                System.out.println("Testit läpäisty");
            }
            else
                fail("Testi 2/2: odotettu tulos: "+Arrays.toString(expresult2)+", saatu tulos oli: "+Arrays.toString(instance2.getHeap()));
        }
        else
            fail("Testi 1/2: odotettu tulos: "+Arrays.toString(expresult)+", saatu tulos: "+Arrays.toString(instance.getHeap()));
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
        instance.insert(2);
        System.out.println("Lisätään alkio 4");
        instance.insert(4);
        System.out.println("Lisätään alkio 1");
        instance.insert(1);
        System.out.println("Lisätään alkio 5");
        instance.insert(5);
        System.out.println("Lisätään alkio 3");
        instance.insert(3);
        System.out.println(Arrays.toString(instance.getHeap()));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 1");
        int min = instance.deleteMin();
        System.out.println("Saatu tulos: "+min);
        if(min!=1)
            fail("Testi epäonnistui");
        System.out.println(Arrays.toString(instance.getHeap()));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 2");
        min = instance.deleteMin();
        System.out.println("Saatu tulos: "+min);
        if(min!=2)
            fail("Test epäonnistui");
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 3");
        min = instance.deleteMin();
        System.out.println("Saatu tulos: "+min);
        if(min!=3)
            fail("Testi epäonnistui");
        System.out.println(Arrays.toString(instance.getHeap()));
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 4");
        min = instance.deleteMin();
        System.out.println("Saatu tulos: "+min);
        if(min!=4)
            fail("Testi epäonnistui");
        System.out.println("Poistetaan pienin alkio, odotettu tulos: 5");
        min = instance.deleteMin();
        System.out.println("Saatu tulos: "+min);

        System.out.println("Testi onnistui");
    }

}