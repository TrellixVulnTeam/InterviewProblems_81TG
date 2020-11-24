package data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem01_01_Java {

    public static void main(String[] args) {
        int[] arr = getInputArray();
        int[] product = GetProductOfAllOtherElements(arr);
        System.out.println("Given: " + Arrays.toString(arr) + ", Solution: " + Arrays.toString(product));
    }

    public static int[] getInputArray() {
        System.out.println("Enter integers for the input array.  Enter `q` when done.");

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> input = new ArrayList<Integer>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt())
                input.add(scanner.nextInt());
            if (scanner.hasNext("q"))
                break;
        }

        return input.stream().mapToInt(i -> i).toArray();
    }

    public static int[] GetProductOfAllOtherElements(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left,1);
        Arrays.fill(right, 1);

        for(int i=0; i<length; i++) {
            if(i > 0)
                left[i] = left[i-1]*arr[i-1];
            int j = length - i - 1;
            if(j < length -1)
                right[j] = right[j+1]*arr[j+1];
        }

        for(int i=0; i<length; i++) {
            left[i] = left[i]*right[i];
        }

        return left;
    }
}
