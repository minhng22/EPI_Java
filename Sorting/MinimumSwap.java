import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwap {
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static int minimumSwap(int[] arr){
        int[] sortedArr = new int[arr.length];
        int cntSwap = 0;

        for (int i=0; i < arr.length; i++){
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> order = new HashMap<>();
        for (int k=0; k < sortedArr.length; k++){
            order.put(sortedArr[k], k);
        }

        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        for (int j= 0; j < arr.length; j++){
            if (order.get(arr[j]) != j && !visited[j]){
                int circleNode = 1;
                while (!visited[j]){
                    visited[j] = true;
                    j = order.get(arr[j]);
                    circleNode++;
                }

                cntSwap += (circleNode -1);
            }
        }
        return cntSwap;
    }

    public static void main(String args[])
    {
        int arr[] = {1,5,4,3,2};
        System.out.println(minimumSwap(arr));
    }
}
