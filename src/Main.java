public class Main {

    public static void main(String[] args){

        int[] arr = {2, 4, 9, 6, 3, 7, 5, 8, 1};
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length - 1; j++){
                    if(arr[j] > arr[j + 1]){
                        int temp = 0;
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

        // System.out.println(bubbleSort(arr));
        System.out.println(java.util.Arrays.toString(arr));
    }
}