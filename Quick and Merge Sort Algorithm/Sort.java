import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sort {
    void merge(List<Integer> arrayval, int low, int middle, int high){
        int forl1 = middle - low + 1; // total count of left side of middle 
        int forr1 = high - middle; // total count of right side of middle
        int left[] = new int [forl1]; // dummy arrays of size forl1 and forr1
        int right[] = new int [forr1];
        for(int i=0; i<forl1; ++i) // fill the left array by copying data
            left[i] = arrayval.get(low + i); 
        for(int j=0; j<forr1; ++j) // fill the right array by copying data
            right[j] = arrayval.get(middle + 1 + j);
        int i=0,j=0,k=low;
        
        while (i < forl1 && j < forr1){  // comparing and setting values accordingly // merge the dummy arrays
			if (left[i] <= right[j]) { 
                arrayval.set(k, left[i]); 
				i++; 
			} 
			else{ 
                arrayval.set(k, right[j]);
				j++; 
			} 
			k++; 
        } 
        while (i < forl1){ // copy remaining elements if any for left[]
            arrayval.set(k, left[i]);
			i++; k++; 
		} 
        while (j < forr1){ // copy remaining elements if any for right[]
            arrayval.set(k, right[j]);
            j++; k++; 
		} 
    }
    int quicksort(List<Integer> arrayval, int low, int high){
        int pivotele = arrayval.get(high); // last point as pivot pt.
        int i = low - 1; // index of smaller element
        for(int j=low; j<high; j++){
            if(arrayval.get(j) <= pivotele){ // if current element is smaller than pivot then swap it
                i++;
                int swaptemp = arrayval.get(i);
                arrayval.set(i, arrayval.get(j));
                arrayval.set(j, swaptemp);
                
            }
        }
        int temp = arrayval.get(i+1); // swap a[i+1] and a[high] i.e. pivot
        arrayval.set(i+1, arrayval.get(high));
        arrayval.set(high, temp);
        return i + 1;
    }
    void sort(List<Integer> arrayval, int low, int high, int sort_type) { 
        if (low < high) { 
            if(sort_type == 1){      // to identify which type of sorting algorithm it is
                int middle = (low + high)/2; // dividing into half
                sort(arrayval, low, middle, sort_type);  // recurssion process for solving first and second halves
                sort(arrayval, middle+1, high, sort_type); 
                merge(arrayval, low, middle, high); // merging function
            }
            else if(sort_type == 2){
                int middle = quicksort(arrayval, low, high); // quicksort function to perform sorting
                sort(arrayval, low, middle - 1, sort_type); // recurssion process i.e. sort elements before partition and after partition
                sort(arrayval, middle+1, high, sort_type); 
            }
        }
    } 
    void printoutput(List<Integer> arrayval){ // to print sorted array as a output
        int size=arrayval.size();
        for (int i=0; i<size; ++i){ 
            if(i%20 == 0)
                System.out.println();
            System.out.print(arrayval.get(i)+" "); 
        }
    }
    public static void main(String[] args) { 
        Sort program_sort = new Sort();
        int sort_type, input_type, input_len, input_value, predefined_type;
        List<Integer> arr_values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Which Algorithm would you like to proceed with ?\n1. Merge Sort\n2. Quick Sort");
        sort_type = sc.nextInt();
        System.out.println("How would you like to have a input ? \n1. User Defined\n2. Predefined");
        input_type = sc.nextInt();
        if(input_type == 1){ //to generate the case on input type
            System.out.println("Enter the length of the array:");
            input_len = sc.nextInt(); // store the user input value
            System.out.print("Enter Input Values Keeping space between different input values:");
            for (int i = 0; i < input_len; i++)
                arr_values.add(sc.nextInt());   
        } // multiple values store within the arraylist
        else if(input_type == 2){
            System.out.println("Please choose a predefined length sorted array for Best case performance:\n1. 1000 integers\n2. 1500 integers\n3. 2000 integers");
            input_value = sc.nextInt();
            switch(input_value){ // in order to identify what number of array input we have to generate
                case 1:
                    input_value = 1000;
                    break;
                case 2:
                    input_value = 1500;
                    break;
                case 3:
                    input_value = 2000;
                    break;
            }
            for (int i = 1; i <= input_value; i++)
                arr_values.add(i);
        }
        long starttime = System.nanoTime(); // start time of performing algorithm
        program_sort.sort(arr_values, 0, arr_values.size() - 1, sort_type); // calling sort function to start the sorting process
        System.out.println("Array sorted:");  
        long endtime = System.nanoTime(); // end time of performing algorithm
        long totaltime = TimeUnit.NANOSECONDS.toMillis(endtime) - TimeUnit.NANOSECONDS.toMillis(starttime); // total time taken by algorithm for sorting
        program_sort.printoutput(arr_values); // calling print function
        System.out.println("\n\nTime taken by the algorithm running above is: "+totaltime+" ms");
    }
}