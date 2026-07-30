import java.util.*;

class Solution {

    // Nearest Smaller to Left
    public static int[] NSL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(i);
        }
        return ans;
    }

    // Nearest Smaller to Right
    public static int[] NSR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();

            st.push(i);
        }
        return ans;
    }

    // Largest Rectangle in Histogram
    public static int largestRectangle(int[] arr) {
        int n = arr.length;

        int[] left = NSL(arr);
        int[] right = NSR(arr);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Maximal Rectangle in Matrix
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] histogram = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            // Build histogram
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j] += 1;
                } else {
                    histogram[j] = 0;
                }
            }

            // Solve histogram
            maxArea = Math.max(maxArea, largestRectangle(histogram));
        }

        return maxArea;
    }
}