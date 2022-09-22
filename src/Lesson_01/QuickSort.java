package Lesson_01;

/**
 * QuickSort - generic for all type.
 * QuickSort is not synchronized
 *
 * Author:           ASGubin
 * Type parameters: ArrayList<T> – the type for sorting
 */
public class QuickSort {

    /**
     * sort() - sort ArrayList<T>
     * @param list is the ArrayList<T> for sorting
     */
    public static <T extends Comparable<? super T>> void sort(ArrayList<T> list) {
        // check for empty or null array
        if (list ==null || list.size()==0){
            return;
        }

        T[] array = list.toArray();
        quicksort(array, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] array, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        T pivot = array[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(array, low, j);
        if (i < high)
            quicksort(array, i, high);
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
