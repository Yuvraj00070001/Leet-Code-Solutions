class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for(int i = 0; i < rows; i++){

            // Build histogram
            for(int j = 0; j < cols; j++){

                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }

            // Apply LC 84
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights){

        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){

            int currentHeight = (i == heights.length)
                                ? 0
                                : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > currentHeight){

                int height = heights[st.pop()];

                int width;

                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i - st.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}