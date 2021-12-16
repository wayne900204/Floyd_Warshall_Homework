import java.util.*;

public class test {
    //
//5
//
// 0 1 -1 1 5
// 9 0 3 2 -1
// -1 -1 0 4 -1
// -1 -1 2 0 3
// 3 -1 -1 -1 0
    //point to point
    static int[][] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr2[][] = new int[n][n];                //calculate
        path = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = sc.nextInt();
                path[i][j] = -1;// 初始 -1
            }
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (arr2[i][k] == -1 || arr2[k][j] == -1) continue;
                    else
                        arr2[i][j] = min_route(arr2[i][j], arr2[i][k] + arr2[k][j], i, j, k);
                }
        System.out.printf("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr2[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        System.out.printf("-------------DEBUG PATH-------------\n");
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", path[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("-------------加分題-------------\n");
        System.out.printf("輸入兩點:");
// ex 5 ,3 代表 v5, v3 的意思
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;

        if (a >= n || b >= n) {
            System.out.printf("BREAK");
        } else {
            System.out.printf("v%d,", a + 1);
            routeNode(a, b);
            System.out.printf("v%d", b + 1);
        }
    }

    static int min_route(int a, int b, int i, int j, int k) {
        if (a <= b && a >= 0) return a;
        else {
            path[i][j] = k;
            return b;
        }
    }

    static void routeNode(int a, int b) {
        if (path[a][b] != -1) {
            routeNode(a, path[a][b]);
            System.out.printf("v%d,", path[a][b] + 1);
            routeNode(path[a][b], b);
        }
    }
}