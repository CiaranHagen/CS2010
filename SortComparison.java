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
	    double[] b = new double[pivotPos];
	    double[] c = new double[a.length - pivotPos];
	    System.arraycopy(a, 0, b, 0, pivotPos);
	    System.arraycopy(a, pivotPos+1, c, 0, a.length - pivotPos-1);
	    
	    if (a.length != b.length) {
	        b = quickSort(b);
	    }
	    if (c.length != a.length) {
	        c = quickSort(c);
	    }
	    System.out.println(Arrays.toString(a));
	    System.out.println(Arrays.toString(b));
	    System.out.println(Arrays.toString(c));
	    System.arraycopy(b, 0, a, 0, b.length);
	    System.out.println(Arrays.toString(a));
	    System.out.print("PP: ");
	    System.out.println(pivotPos);
	    System.out.println(piVal);
	    System.out.print("Pivot: ");
	    a = insertElement(a, pivotPos, piVal);
	    System.arraycopy(c, 0, a, pivotPos+1, c.length);
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
    	System.out.print("Init a:");
    	System.out.println(Arrays.toString(a));
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
	        System.out.print("Bad a:");
	        System.out.println(Arrays.toString(a));
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
                System.out.println(pos);
                System.out.println(i);
	            System.out.println(j);
	            System.out.println(bi);
	            System.out.println(cj);
                System.out.println(Arrays.toString(a));
	        }
        } 
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
        double a[] = {15,3,24,19,6,5,7,12,0};
        System.out.println(Arrays.toString(SortComparison.selectionSort(a)));
        //System.out.println(Arrays.toString(SortComparison.insertionSort(a)));
    }

 }//end class
 
 

