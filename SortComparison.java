// -------------------------------------------------------------------------
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

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
        return a;
    }
    
    static double [] insertElement(double[] a, int index, double c) {
        System.arraycopy(a, index, a, index + 1, a.length -1 - index);
        a[index] = c;
        return a;
    }
    
    static double [] insertionSort (double a[]){
        int i = 1;
        int j = 0;
        double c;
        while (i < a.length) {
            c = a[i];
            a = removeElement(a, i);
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
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        if (a.length == 1) {
            return a;
        }
        else if (a.length == 0) {
            return a;
        }
        
	    int pivot = a.length/2;
	    int pivotPos = pivot;
	    double piVal = a[pivot];
	    int i = 0;
	    while (i<pivotPos) {
	        double x = a[i];
	        if (x > piVal) {
	            a = removeElement(a, i);
	            a = insertElement(a, pivotPos, x);
	            pivotPos--;
	        }
	        else {
	            i++;
	        }
	        
	    }
	    i = pivotPos+1;
	    while (i<a.length) {
	        double x = a[i];
	        if (x<=piVal) {
	            a = removeElement(a, i);
	            a = insertElement(a, pivotPos, x);
	            pivotPos++;
	        }
	        i++;
	    }
	    if (a.length == 2) {
            return a;
        }
	    double[] b = new double[pivotPos];
	    double[] c = new double[a.length - pivotPos-1];
	    System.arraycopy(a, 0, b, 0, pivotPos);
	    System.arraycopy(a, pivotPos+1, c, 0, a.length - pivotPos-1);
	    
	    b = quickSort(b);
	    c = quickSort(c);
	    
	    System.arraycopy(b, 0, a, 0, b.length);
	    a = insertElement(a, pivotPos, piVal);
	    System.arraycopy(c, 0, a, pivotPos+1, c.length);
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
        if (a.length == 1) {
    	    return a;
    	}
        else {
            int middle = a.length/2;
        
            double[] b = new double[middle];
            double[] c = new double[a.length - middle];
            
            System.arraycopy(a, 0, b, 0, middle);
            System.arraycopy(a, middle, c, 0, a.length - middle);
	        b = insertionSort(b);
	        c = insertionSort(c);
	        int i = 0;
	        int j = 0;
	        int pos = -1;
	        while (i<b.length | j<c.length) {
	            pos++;
	            
	            double bi = 0;
	            double cj = 0;
	            boolean tryB = true;
	            boolean tryC = true;
	            
	            if (i == b.length) {
	                bi = b[i-1];
	                tryB = false;
	            } else {
	                bi = b[i];
	            }
	            if (j == c.length) {
	                cj = c[j-1];
	                tryC = false;
	            } else {
	                cj = c[j];
	            }
                if (((bi <= cj) | (tryC == false)) & (tryB == true)) {
                    a[pos] = bi;
                    i++;
                }
                else if (((cj < bi) | (tryB == false)) & (tryC == true)) {
                    a[pos] = cj;
                    j++;
                }
	        }
        }
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
    	if (a.length == 1) {
    	    return a;
    	}
        else {
            int middle = a.length/2;
        
            double[] b = new double[middle];
            double[] c = new double[a.length - middle];
            
            System.arraycopy(a, 0, b, 0, middle);
            System.arraycopy(a, middle, c, 0, a.length - middle);
            b = mergeSortRecursive(b);
	        c = mergeSortRecursive(c);
	        
	        int i = 0;
	        int j = 0;
	        int pos = -1;
	        while (i<b.length | j<c.length) {
	            pos++;
	            
	            double bi = 0;
	            double cj = 0;
	            boolean tryB = true;
	            boolean tryC = true;
	            
	            if (i == b.length) {
	                bi = b[i-1];
	                tryB = false;
	            } else {
	                bi = b[i];
	            }
	            if (j == c.length) {
	                cj = c[j-1];
	                tryC = false;
	            } else {
	                cj = c[j];
	            }
                if (((bi <= cj) | (tryC == false)) & (tryB == true)) {
                    a[pos] = bi;
                    i++;
                }
                else if (((cj < bi) | (tryB == false)) & (tryC == true)) {
                    a[pos] = cj;
                    j++;
                }
	        }
        } 
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

         for (int i = 0; i<a.length; i++) {
            int test = i;
            for (int j = i+1; j<a.length; j++) {
                if (a[j]<a[test]) {
                    test = j;
                }
            }
            double inter = a[test];
            a[test] = a[i];
            a[i] = inter;
         }
        return a;
    }//end selectionsort

    public static void main(String[] args) {
    
        double[] a = {1.0, 5.0, 6.0, 3.0, 12.0};
        System.out.println(Arrays.toString(SortComparison.selectionSort(a)));
        //The commented stuff was to run the timing tests.
        
        /*
        double[] a = new double[1000];
        try {
            BufferedReader br = new BufferedReader(new FileReader("./numbersSorted1000.txt"));
            try {
                String line = br.readLine();
                int count = 0;
                while (line != null) {
                    double x = Double.parseDouble(line);
                    a[count] = x;;
                    line = br.readLine();
                    count++;
                }
            } finally {
                br.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(a));
        
        System.out.println("Insertion sort: ");
        long startTime = System.nanoTime();
        SortComparison.insertionSort(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
        
        System.out.println("Quicksort: ");
        startTime = System.nanoTime();
        SortComparison.quickSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration);
        
        System.out.println("Merge sort i.: ");
        startTime = System.nanoTime();
        SortComparison.mergeSortIterative(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration);
        
        System.out.println("Merge sort r.: ");
        startTime = System.nanoTime();
        SortComparison.mergeSortRecursive(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration);
        
        System.out.println("Selection sort: ");
        startTime = System.nanoTime();
        SortComparison.selectionSort(a);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(duration);
        */
        
    }

 }//end class
 
 

