import java.util.Scanner;
public class flipFlop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            solution(array);
        }
        sc.close();
    }
    public static void negateElement(int[] arr, int i) {
        arr[i] = -arr[i];
        arr[i + 1] = -arr[i + 1];

    }
    public static void solution(int[] array){
        int sum = 0;
        boolean flag = false;
        if (array.length == 2) {
            negateElement(array, 0);
            sum = array[0]+array[1];
        }
        else {
            for (int z = 0; z < array.length-1; z++) {
                if (array[z] == -1 && array[z+1] == -1) {
                    if (!flag) {
                        negateElement(array, z);
                    }
                    flag = true;
                }
                sum += array[z];
            }
            sum+=array[array.length-1];
        }
        System.out.println(sum);
    }

}
