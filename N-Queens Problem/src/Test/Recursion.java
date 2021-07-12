package Test;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        int size = 6;
        char[][] array = new char[size][];         //Dynamic Array
        Arrays.setAll(array, i -> new char[size]);

        //Initialize to char 65++
        for (int i = 0, letter = 65; i < array.length; i++)
            for (int j = 0; j < array.length; j++) array[i][j] = (char) letter++;

        print(array);
        System.out.println();
        algorithm(array);
    }

    private static void print(char[][] array) {
        for (int i = 0; i < array.length; i++, System.out.println())
            for (int j = 0; j < array.length; j++) System.out.print(array[i][j]);
    }

    private static void algorithm(char[][] array) {
        int size = array.length;
        int[] loop = {1, 2, 3, 4, 5, 6, 7};
        int[] iter = {0, 0, 0, 0, 0, 0, 0};

        for(iter[0] = 0; iter[0] < (loop[0] > size ? 1 : size); iter[0]++) {
            for (iter[1] = 0; iter[1] < (loop[1] > size ? 1 : size); iter[1]++) {
                for (iter[2] = 0; iter[2] < (loop[2] > size ? 1 : size); iter[2]++) { // iterates row 3
                    for (iter[3] = 0; iter[3] < (loop[3] > size ? 1 : size); iter[3]++) { // iterates row 4
                        for (iter[4] = 0; iter[4] < (loop[4] > size ? 1 : size); iter[4]++) { // iterates row 5
                            for (iter[5] = 0; iter[5] < (loop[5] > size ? 1 : size); iter[5]++) { // iterates row 6
                                for (iter[6] = 0; iter[6] < (loop[6] > size ? 1 : size); iter[6]++) { // iterates row 7
                                    System.out.print(" ");
                                    for(int i = 0, check = -1; i < size; i++)
                                        System.out.print(array[++check][iter[check]]);
                                }
                                if(loop[6] < size) System.out.println();
                            }
                            if(loop[5] < size) System.out.println();
                        }
                        if(loop[4] < size) System.out.println();
                    }
                    if(loop[3] < size) System.out.println();
                }
                if(loop[2] < size) System.out.println();
            }
            if(loop[1] < size) System.out.println();
        }
        System.out.println();
    }
}
