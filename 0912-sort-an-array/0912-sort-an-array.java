class Solution {
    public int[] sortArray(int[] arr) {
        
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        return arr;
    }
   
    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void random(int arr[],int low,int high)
    {
     
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
         
        int temp1=arr[pivot]; 
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
    
    private int partition(int[] arr, int low, int high)
    {
 
        random(arr,low,high);
        int pivot = arr[high];
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            if (arr[j] < pivot) {
 
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    private void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
 
            int pi = partition(arr, low, high);
 
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}