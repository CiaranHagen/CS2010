import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/*
                            Insert      Quick     Merge it.   Merge rec.  Selection
10 random               | 11029     | 6205      | 8464      | 9857      | 3268 
100 random              | 110502    | 105780    | 134217    | 113842    | 185645
1000 random             | 3976666   | 504557    | 1363587   | 972087    | 3669948
1000 few unique         | 3890873   | 643784    | 1403500   | 839762    | 3244794
1000 nearly ordered     | 5916254   | 794058    | 2701889   | 1133827   | 3236108
1000 reverse order      |
1000 sorted             |

*/


//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        SortComparison testComp = new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        System.out.print("Empty insertion sort: ");
        assertEquals([], testComp.insertionSort([]));
        System.out.print("Empty quicksort: ");
        assertEquals([], testComp.quickSort([]));
        System.out.print("Empty recursive merge sort: ");
        assertEquals([], testComp.mergeSortRecursive([]));
        System.out.print("Empty iterative merge sort: ");
        assertEquals([], testComp.mergeSortIterative([]));
        System.out.print("Empty selection sort: ");
        assertEquals([], testComp.selectionSort([]));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    @Test
    public void testRemoveElement()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        assertEquals({1.0, 5.0, 6.0, 12.0, 12.0}, testComp.removeElement(a, 3));
    }
    @Test
    public void testInsertElement()
    {
        double[] a = {1.0, 5.0, 6.0, 12.0, 12.0};
        assertEquals({1.0, 5.0, 6.0, 3.0, 12.0}, testComp.removeElement(a, 3, 3.0));
    }
    @Test
    public void testInsertionSort()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        assertEquals({1.0, 3.0, 5.0, 6.0, 12.0},testComp.insertionSort(a));
    }
    @Test
    public void testMergeSortRecursive()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        assertEquals({1.0, 3.0, 5.0, 6.0, 12.0},testComp.mergeSortRecursive(a));
        double[] a = {12.0, 1.0, 6.0, 3.0, 5.0};
        assertEquals({1.0, 3.0, 5.0, 6.0, 12.0},testComp.mergeSortRecursive(a));
    }
    @Test
    public void testMergeSortIterative()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        assertEquals({1.0, 3.0, 5.0, 6.0, 12.0},testComp.mergeSortIterative(a));
        double[] a = {12.0, 1.0, 6.0, 3.0, 5.0};
        assertEquals({1.0, 3.0, 5.0, 6.0, 12.0},testComp.mergeSortIterative(a));
    }
    @Test
    public void testQuickSort()
    {
        double[] a = {1.0};
        assertEquals({1.0},testComp.quickSort(a));
        double[] a = {12.0, 1.0, 6.0, 3.0, 7.0};
        assertEquals({1.0, 3.0, 6.0, 12.0, 7.0},testComp.quickSort(a));
        double[] a = {6.0, 3.0};
        assertEquals({3.0, 6.0},testComp.quickSort(a));
        double[] a = {3.0, 6.0};
        assertEquals({3.0, 6.0},testComp.quickSort(a));
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

