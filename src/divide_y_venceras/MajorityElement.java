package divide_y_venceras;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        // O(n): Copia el arreglo original en 'sorted'
        int[] sorted = Arrays.copyOf(nums, nums.length);

        // Array.sort() internamente usa Dual-Pivot Quicksort el cual utiliza Divide y vencerás
        // O(n log n): Ordena el arreglo usando Arrays.sort(), lo cual tiene una complejidad de O(n log n)
        Arrays.sort(sorted);

        System.out.println(Arrays.toString(sorted));

        int middle = sorted.length / 2;
        int possible = sorted[middle];
        int count = 0;

        // O(n): Recorre el arreglo ordenado para contar cuántas veces aparece el 'possible'
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == possible) {
                count++;
            }
        }

        // Si 'possible' aparece más de la mitad de las veces, es el elemento mayoritario
        if (count > nums.length / 2) {
            return possible;  // O(1)
        } else {
            return -1;  // Si no hay mayoría, retorna -1
        }
    }

}
