import java.util.*; 
import java.io.*;
/**
 * This is the driver of Sort class. By run the main method, this
 * program will generates a random number which decides which sorting
 * algorithms it will use. The results are the same. 
 *
 * @author (Zhiyan Yu)
 * @version (9/25/2020)
 */
public class Driver
{
    public static void main(String[] args) throws IOException{ 
        char menuChoice; 
        Scanner sc = new Scanner(System.in);
      
        Sort sort = new Sort(); 
        int r = (int) (Math.random() * 4);
        
        int[] numbers; 
        String s = " ", p = " "; 
        
        //allow user to input the length of the array
        
        System.out.print("Input the length of the array :"); 
        int num = sc.nextInt(); 
        numbers = new int[num]; 
        
        //allow user to input the array
        for(int i = 0; i < num; ++i){
            System.out.print("Input the array: ");
            numbers[i] = sc.nextInt(); 
        }
        
        //print the unsorted array
        for (int i = 0; i < num; ++i){
            System.out.print("Unsorted " + numbers[i] + " \n"); 
        }
        
        if(r == 0){
            sort.insertionSort(numbers); 
            p = "Insertion Sort: ";
        }else if(r == 1){
            sort.bubbleSort(numbers);
            p = "Bubble Sort: ";
        }else if(r == 2){
            sort.mergeSort(numbers, 0, numbers.length-1);
            p = "Merge Sort: "; 
        }else if(r == 3){
            sort.heapSort(numbers);
            p = "Heap Sort: ";
        }
        
        //Print the sorted array
        for (int i = 0; i < num; ++i){
            System.out.print(p + numbers[i] + " \n"); 
        }
        
        System.out.println("\nGood-bye!");
    }
}
