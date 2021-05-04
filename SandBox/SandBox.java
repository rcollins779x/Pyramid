package SandBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SandBox {
    public static ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (nums.size() == 0) return null;
        else {
            int max = nums.get(0), start = 0, end = 0, sum = 0, counter = 0;

            for ( int k = 0; k < nums.size(); k++) { //Range of cells to sum
                System.out.println("i\tj\tsum\tmax\trange");
                for (int i = 0, j = k; j < nums.size(); i++, j++, sum = 0) { //Sums starting at index i until index j
                    for (int l = i; l < j+1; l++, counter++) sum += nums.get(l);
                    if(max < sum) {
                        max = sum;
                        start = i;
                        end = j;
                    }
                    System.out.println(i + "\t" + j + "\t" + sum + "\t" + max + "\t" + start + "-" + end);
                }
            }
            System.out.println(counter);
            return new ArrayList<>(nums.subList(start,end+1));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>() {{ add(-15); add(42); add(-48); add(50); add(23); add(43); add(27); add(-25); add(9); add(-30); add(-37); add(7); add(-33); add(27); add(4); }};
        HashSet<Integer> map = new HashSet<>() {{ add(0); add(3); add(4); }};
        int[] num = {10, 3, 5, 3, 9, 22, 4, 3, 1, 5, 6};
        String temp = "())";
        int[] A = { 1, 2, 3, 4, 5 };
        int sum = Arrays.stream(A).reduce(0, (x, y) -> x + y);

        System.out.println("The sum of all the array elements is " + sum);
        System.out.println("Return: " + solution(list));

    }
}
