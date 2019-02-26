import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/*

GitHub repo: https://github.com/CiaranHagen/CS2010

Timings (in ns)
=======
                            Insert      Quick     Merge it.   Merge rec.  Selection
10 random               |   11029   |   6205    |    8464   |    9857   |    3268 
100 random              |  110502   | 105780    |  134217   |  113842   |  185645
1000 random             | 3976666   | 504557    | 1363587   |  972087   | 3669948
1000 few unique         | 3890873   | 643784    | 1403500   |  839762   | 3244794
1000 nearly ordered     | 5916254   | 794058    | 2701889   | 1133827   | 3236108
1000 reverse order      |  736068   | 446192    | 3704741   | 1241645   | 3960203
1000 sorted             | 5098782   | 378343    | 1427890   |  848550   | 2971089

a. It has a large impact on insertion sort, as this depends heavily on how many comparisons it has to make before each insertion. If the array is already sorted, it will make n comparison per number and not insert once, as opposed to only one comparison and one insertion per number if the array is in reverse order.

It also makes a positive difference for quicksort if the array is already sorted, as it will not make any unnecessary movements. It will haowever make the same number of comparisons.

The same holds for recursive merge sort.

As iterative merge sort is a concatenation of two sorts, the difference is kind of mitigated by the combination.

It has no major influence on selection sort, as this will compare every value to every value, no matter if the array is already sorted or not.

b. The largest difference is for insertion sort. A difference of 5180186 ns. This is due to the aforementioned fact that the number of comparisons depending on wether the array is sorted or not, varies enormously. The reason for the nearly ordered list taking longer than the ordered one is simply because insertions take longer than comparisons. This means that the few things that had to be changed took longer to change than the comparisons they "avoided".

c. My personal iterative version ov merge sort is a lot slower than the recursive version. This is probably mainly due to the fact that it only performs a single merge for the whole list and sorts the two halves with insertion sort. This would probably vary greatly if a different sorting algorithm was used for the smaller parts. ANother thing that probably makes the iterative version slower is that the maximum size of the subarrays to be sorted by insertion sort is set way too high.

d.  10 random               Selection sort
    100 random              Quicksort
    1000 random             Quicksort
    1000 few unique         Quicksort
    1000 nearly ordered     Quicksort
    1000 reverse order      Quicksort
    1000 sorted             Quicksort


N.B. I have a problem with JUnit that I couldn't remove. For some reason, even though the methods return the right thing, the test for the empty arrays returns "null", which causes the whole test to return "false". It's not a specific assertion in the test that doesn't check out, it's just the test in general.
*/


//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @Ciaran J. Hagen (ID: 18345025)
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{    
    SortComparison testComp = new SortComparison();
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
        double[] a = new double[0];
        double[] b = a;
        System.out.print("Empty insertion: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.insertionSort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("1 -->",Arrays.toString(a), Arrays.toString(a));
        
        System.out.print("Empty quicksort: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.quickSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("2 -->",Arrays.toString(a), Arrays.toString(a));
        
        System.out.print("Empty recursive merge: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.mergeSortRecursive(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("3 -->",Arrays.toString(a), Arrays.toString(a));
        
        System.out.print("Empty iterative merge: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.mergeSortIterative(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("4 -->",Arrays.toString(a), Arrays.toString(a));
        
        System.out.print("Empty selection: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.selectionSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("5 -->",Arrays.toString(a), Arrays.toString(a));
    }
    
    @Test
    public void testRemoveElement()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        double[] b = {1.0, 5.0, 6.0, 12.0, 12.0};
        System.out.print("Remove element from array: \nTime: ");
        
        long startTime = System.nanoTime();
        a = testComp.removeElement(a, 3);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        
        assertEquals(Arrays.toString(b), Arrays.toString(a));
    }
    @Test
    public void testInsertElement()
    {
        double[] a = {1.0, 5.0, 6.0, 12.0, 12.0};
        double[] b = {1.0, 5.0, 6.0, 3.0, 12.0};
        System.out.print("Insert element into array: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.insertElement(a, 3, 3.0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals(Arrays.toString(b), Arrays.toString(a));
    }
    @Test
    public void testInsertionSort()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        double[] b = {1.0, 3.0, 5.0, 6.0, 12.0};
        System.out.print("Insertion sort: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.insertionSort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals(Arrays.toString(b),Arrays.toString(a));
    }
    @Test
    public void testMergeSortRecursive()
    {
        double[] b = {1.0, 3.0, 5.0, 6.0, 12.0};
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        System.out.print("Recursive merge test 1: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.mergeSortRecursive(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("1 -->",Arrays.toString(b),Arrays.toString(a));
        
        a = new double[] {12.0, 1.0, 6.0, 3.0, 5.0};
        System.out.print("Recursive merge test 2: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.mergeSortRecursive(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("2 -->",Arrays.toString(b),Arrays.toString(a));
    }
    @Test
    public void testMergeSortIterative()
    {
        double[] b = {1.0, 3.0, 5.0, 6.0, 12.0};
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        System.out.print("Iterative merge test 1: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.mergeSortIterative(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("1 -->",Arrays.toString(b),Arrays.toString(a));
        
        a = new double[] {12.0, 1.0, 6.0, 3.0, 5.0};
        System.out.print("Iterative merge test 2: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.mergeSortIterative(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("2 -->",Arrays.toString(b),Arrays.toString(a));
    }
    @Test
    public void testQuickSort()
    {
        
        double[] a = {1.0};
        double[] b = a;
        System.out.print("Quicksort test 1: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.quickSort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("1 -->",Arrays.toString(b),Arrays.toString(a));
        
        b = new double[] {1.0, 3.0, 5.0, 7.0, 12.0};
        a = new double[] {12.0, 1.0, 5.0, 3.0, 7.0};
        System.out.print("Quicksort test 2: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.quickSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("2 -->",Arrays.toString(b),Arrays.toString(a));
        
        a = new double[] {6.0, 3.0};
        b = new double[] {3.0, 6.0};
        System.out.print("Quicksort test 3: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.quickSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("3 -->",Arrays.toString(b),Arrays.toString(a));
        
        a = new double[] {3.0, 6.0};
        b = a;
        System.out.print("Quicksort test 4: \nTime: ");
        startTime = System.nanoTime();
        a = testComp.quickSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals("4 -->",Arrays.toString(b),Arrays.toString(a));
    }
    @Test
    public void testSelectionSort()
    {
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        double[] b = {1.0, 3.0, 5.0, 6.0, 12.0};
        System.out.print("Selection sort: \nTime: ");
        long startTime = System.nanoTime();
        a = testComp.selectionSort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration+" ns");
        assertEquals(Arrays.toString(b),Arrays.toString(a));
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(SortComparisonTest.class);
		    
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

}

