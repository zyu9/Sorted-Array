
/**
 * Write a description of class Sort here.
 *
 * @author (Zhiyan Yu)
 * @version (9/24/2020)
 */
public class Sort
{
    int numbers[]; 
    int len = numbers.length; 
    private void insertionSort(int arr[], int n){
        n = arr.length;
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
    
    public String runAndResult(int r){
        Sort sort = new Sort();
        int i; 
        int l = len; 
        String s = " "; 
        if(r == 0){
            sort.insertionSort(numbers,len);

            for(i = 0; i < l; ++i){
               s = numbers[i] + " ";
            }
             
        }
        return s;
    }
}
