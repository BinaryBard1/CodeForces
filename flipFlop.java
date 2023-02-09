//https://codeforces.com/contest/1778/problem/A

/*A. Flip Flop Sum
time limit per test1 second
memory limit per test256 megabytes
input standard input
output standard output
You are given an array of n
 integers a1,a2,…,an
. The integers are either 1
 or −1
. You have to perform the following operation exactly once on the array a
:

Choose an index i
 (1≤i<n
) and flip the signs of ai
 and ai+1
. Here, flipping the sign means −1
 will be 1
 and 1
 will be −1
.
What is the maximum possible value of a1+a2+…+an
 after applying the above operation?

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤500
). Description of the test cases follows.

The first line of each test case contains a single integer n
 (2≤n≤105
), the length of the array a
.

The next line contains n
 integers a1,a2,…,an
 (ai=1
 or ai=−1
).

The sum of n
 over all cases doesn't exceed 105
.

Output
For each test case, print the maximum possible sum of the array a
 you can get in a separate line.

Example
inputCopy
4
5
-1 1 1 -1 -1
5
1 1 -1 -1 -1
2
1 1
4
1 -1 -1 1
outputCopy
3
3
-2
4
Note
In the first case, we can choose index 4
 and flip the signs of a4
 and a5
. After this operation, the sum will be −1+1+1+1+1=3
. We can't make the sum larger than this.

In the third case, the only option is to choose the index 1
.

*/
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
    public static boolean isSameValues(int[] array) {
        if (array.length == 0) {
            return false;
        }

        int firstValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != firstValue) {
                return false;
            }
        }
        return true;
    }

    public static void solution(int[] array){
        int sum = 0;
        boolean flag = false;
        if (array.length == 2) {
            negateElement(array, 0);
            sum = array[0]+array[1];
        }
        else if (isSameValues(array)) {
            negateElement(array, 0);
            for (int i : array) {
                sum += i;
            }

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
