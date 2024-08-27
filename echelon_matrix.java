import java.util.*;

import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

public class echelon_matrix {
    Scanner sc = new Scanner(System.in);
    int i, j, k;
    int[][] mat;
    int row, col;

    void input(int r, int c) {
        row = r;
        col = c;
        mat = new int[r][c];
        for (i = 0; i < row; i++) {
            // System.out.println("Enter row" + (i + 1));
            for (j = 0; j < col; j++) {
                System.out.print("Enter (" + i + "," + j + ") : ");
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // Display the matrix
    void display() {
        for (i = 0; i < row; i++) {

            for (j = 0; j < col; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Swaps the row a with b
    void row_swap(int a, int b) {
        int temp;
        for (k = 0; k < col; k++) {
            temp = mat[a][k];
            mat[a][k] = mat[b][k];
            mat[b][k] = temp;
        }
    }

    // Makes the elements zero by elementary row operations
    void make_zero(int cons1, int r1, int cons2, int r2) {

        for (k = 0; k < col; k++) {
            mat[r2][k] = (cons2 * mat[r2][k] - cons1 * mat[r1][k]);
        }

    }

    // Moves the zero row to bottom
    void zero() {

        int x = row - 1;
        for (i = row - 1; i >= 0; i--) {
            if (pivot(i) == -1) {
                row_swap(i, x);
                x--;
            }
        }

        if (mat[0][0] == 0) {
            row_swap(0, 1);
        }
    }

    // Returns the pivot element position
    int pivot(int r) {
        for (int j = 0; j < col; j++) {
            if (mat[r][j] != 0) {
                return j;
            }
        }
        return -1;
    }

    void calculate() {

        for (j = 0; j < col; j++) {

            for (i = row - 1; i > j; i--) {

                if (mat[i][j] != 0) {
                    make_zero(mat[i][j], j, mat[j][j], i);
                }
            }

        }
    }

    public void main(String[] args) {
        echelon_matrix ob = new echelon_matrix();
        System.out.println("Enter number of rows");
        int a = sc.nextInt();
        System.out.println("Enter number of columns");
        int b = sc.nextInt();
        ob.input(a, b);
        System.out.println("Original Matrix");
        ob.display();
        ob.zero();
        ob.calculate();
        ob.zero();
        System.out.println("Echelon Form of the matrix is:");
        ob.display();
    }

}
