package divide_y_venceras;

import java.util.Arrays;

public class SmallerElementsCount {
    public static void main(String[] args) {

        int[] array = {5, 2, 6, 1, 3};

        int[] result = smaller(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] smaller(int[] array) {
        int n = array.length;
        int[] arrayCount = new int[n];;
        for (int i = 0; i < n -1; i++) {
            int val = array[i];
            arrayCount[i] = smallerElementsCount(array, i + 1, n - 1, val);
        }
        return arrayCount;
    }

    public static int smallerElementsCount(int[] array,int left, int right, int val) {

        if (left == right) {
            return array[left] < val ? 1 : 0;
        }

        int middle = (left + right) / 2;

        int izquierdo = smallerElementsCount(array, left, middle, val);
        int derecho = smallerElementsCount(array, middle + 1, right, val);

        return izquierdo + derecho;
    }
}
