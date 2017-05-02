package chapter1;

/**
 * Created by Assulan on 4/23/2017.
 */
public class Challenge1_7 {
    public static void zero(int[][] matrix, boolean[] rows, boolean[] cols){
        for (int i = 0; i < matrix.length; i++){
            if(rows[i]){
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++){
            if(cols[i]){
                for (int j = 0; j < matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }

    }

    // O(n^3)
    public static void setMatrixRowAndCol(int [][] matrix){
        int M = matrix.length;
        int N = matrix[0].length;

        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++){
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        zero(matrix, rows, cols);
    }


    public static void print(int[][] matrix){
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++){
                sb.append(String.valueOf(matrix[i][j]));
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[][] matrix = {{0,2,3}, {4,0,6}, {7,8,9}, {1,10,3}};
        print(matrix);
        setMatrixRowAndCol(matrix);
        print(matrix);
    }
}
