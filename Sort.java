
/**
 * This class contains code for different sorting algorithms which
 * including insertion sort, bubble sort and merge sort. 
 *
 * @author (Zhiyan Yu)
 * @version (9/24/2020-9/25/2020)
 */
public class Sort 
{
    /**
     * This is code for insertion sort algorithm. 
     * 
     * @param - interger array, uses for sorting.
     */
    public void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i < n; ++i){
            int key = arr[i];
            int j = i -1; 
            while(j > 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j -1; 
            }
            arr[j+1] = key; 
        }
    }
    
    /**
     * This is code for bubble sort algorithm. 
     * 
     * @param - interger array, uses for sorting. 
     */
    public void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n -i -1; j++){
                if(arr[j+1] < arr[j]){
                    //swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                }
            }
        }
    }
    
    /**
     * This is code for merge sort algorithm.
     * 
     * @param - interger array, uses for sorting; 
     * @param - integer left, represents for the number at 0;
     * @param - integer mid, represents for the number (left+right)-1; 
     * @param - integer right, represents for the number at arr.length-1;
     */
    private void merge(int arr[], int left, int mid, int right){
        //Sized of the two subarrays
        int n1 = mid - left +1;
        int n2 = right - mid;
        
        //Create temp arrays 
        // First subarray is arr[l..m] 
        // Second subarray is arr[m+1..r] 
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        //copy data to temp arrays
        for(int i = 0; i < n1; ++i){
            L[i] = arr[left + i];
        }
        
        for(int j = 0; j < n2; ++j){
            R[j] = arr[mid + j +1];
        }
        
        //initial index
        int i = 0, j =0;
        int k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++; 
            }
            k++;
        }
        
        //copy remaining elements 
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    /**
     * This is code for merge sort algorithm. 
     * 
     * @param - interger array, uses for sorting; 
     * @param - integer left, represents for the number at 0;
     * @param - integer right, represents for the number at arr.length-1;
     */
    public void mergeSort(int arr[], int left, int right){
        if(left < right){
            //find the midpoint
            int mid = (left+right)/2;
            //sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            //merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * This is code for max-heapify funtion in the heap sort algorithm.
     * Use for setting the largest number as root of the heap. 
     * 
     * @param - interger array, uses for sorting; 
     * @param - size of the heap;
     * @param - root of the heap.
     */
    private void heapify(int arr[], int size, int root){
        int largest = root;
        int left = 2*root +1;
        int right = 2*root +2;
        
        if(left < size && arr[left] > arr[largest]){
            largest = left;
        }
        
        if(right < size && arr[right] > arr[largest]){
            largest = right;
        }
        
        if(largest != root){
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, size, largest);
        }
    }
    
    /**
     * This is code for heap sort algorithm.
     * 
     * @param - integer array, uses for sorting;
     */
    public void heapSort(int arr[]){
        int n = arr.length; 
        for(int i = n/2-1; i >= 0; i--){
            heapify(arr, n, i);
        }
        
        for(int i = n-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
}
