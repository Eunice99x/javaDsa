import java.util.Arrays;

public class Main {
    public static void main(String[] args){
      int[] arr = {5, 3, 8, 4, 2, 7};
      for(int i = 1; i < arr.length; i++){
        int tmp = arr[i];
        int j = i - 1;

        while(j >= 0 && arr[j] > tmp){
          arr[j+1] = arr[j];
          j--;
        }
        arr[j+1] = tmp;
      }; 

      System.out.println(Arrays.toString(arr));
    }
}