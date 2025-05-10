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
        int[] arrayCount = new int[n];

        // O(n): Para cada elemento, contar cuántos elementos menores hay a su derecha
        for (int i = 0; i < n - 1; i++) {
            int val = array[i];
            // O(log n) para contar elementos menores en el subarreglo de la derecha
            arrayCount[i] = smallerElementsCount(array, i + 1, n - 1, val);
        }
        return arrayCount;
    }

    // Función recursiva para contar los elementos menores que val en el subarreglo [left, right]
    public static int smallerElementsCount(int[] array, int left, int right, int val) {

        if (left == right) {
            return array[left] < val ? 1 : 0;  // O(1)
        }

        int middle = (left + right) / 2;

        // O(log n): Divide el problema en dos partes y resuelve recursivamente
        int izquierdo = smallerElementsCount(array, left, middle, val);
        int derecho = smallerElementsCount(array, middle + 1, right, val);

        return izquierdo + derecho;  // O(1): Sumar los resultados
    }
}
