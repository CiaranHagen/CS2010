// -------------------------------------------------------------------------
import java.util.Arrays;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *  System.arraycopy(src, oldIndex, src, newIndex, length);
     */
    static double [] removeElement(double[] a, int index) {
        System.arraycopy(a, index + 1, a, index, a.length -1 - index);
        System.out.println("Removed");
        System.out.println(Arrays.toString(a));
        return a;
    }
    
    static double [] insertElement(double[] a, int index, double c) {
        System.arraycopy(a, index, a, index + 1, a.length -1 - index);
        a[index] = c;
        System.out.println("Inserted");
        System.out.println(Arrays.toString(a));
        return a;
    }
    
    static double [] insertionSort (double a[]){
        int i = 1;
        int j = 0;
        double c;
        while (i < a.length) {
        
            /*System.out.println(i);
            System.out.println(Arrays.toString(a));
            */
            c = a[i];
            a = removeElement(a, i);//create a new array
            j = 0;
            while (j <= i) {
                if (a[j] > c | j == i) {
                    a = insertElement(a, j, c);
                    break;
                }
                j++;
            }
            i++;
        }
        return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	    int pivot = 0;
	    int pivotPos = 0;
	    double piVal = a[pivot];
	    for (int i = 1; i<a.length; i++) {
	        double x = a[i];
	        if (x<=a[pivot]) {
	            a = removeElement(a, i);
	            a = insertElement(a, 0, x);
	            pivotPos++;
	        }
	    }
	    
	    double[] b;
	    double[] c;
	    b = quicksort(System.arraycopy(a, 0, b, 0, pivotPos - 1));
	    c = quicksort(System.arraycopy(a, pivotPos, b, 0, a.length - pivotPos));
	    System.arraycopy(b, 0, a, 0, b.length - 1);
	    a = insertElement(a, a.length - 1, piVal);
	    System.arraycopy(c, 0, a, b.length, c.length - 1);
		 //todo: implement the sort
        return a;
    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
	    return a;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
	    return a;
   }//end mergeSortRecursive
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         //todo: implement the sort
        return a;
    }//end selectionsort

   


    public static void main(String[] args) {
        double a[] = {15,3,24,19,6,5,7,12,0};
        System.out.println(Arrays.toString(SortComparison.quickSort(a)));
        //System.out.println(Arrays.toString(SortComparison.insertionSort(a)));
    }

 }//end class
 
 

