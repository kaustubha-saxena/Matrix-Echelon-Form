import java.util.*;

public class echelon_matrix {
    Scanner sc = new Scanner(System.in);
    int i, j, k;
    float[][] mat;
    int row, col;

    void input(int r, int c) {
        row = r;
        col = c;
        mat = new float[r][c];
        for (i = 0; i < row; i++) {
            System.out.println("Enter row" + (i + 1));
            for (j = 0; j < col; j++) {
                mat[i][j] = sc.nextFloat();
            }
        }
    }

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
        float temp;
        for (k = 0; k < col; k++) {
            temp = mat[a][k];
            mat[a][k] = mat[b][k];
            mat[b][k] = temp;
        }
    }

    void make_zero(float fac, int r1, int r2) {

        for (k = 0; k < col; k++) {
            mat[r2][k] = (mat[r2][k] - fac * mat[r1][k]);
        }

    }

    void zero() {

        int x = row - 1;
        for (i = row - 1; i >= 0; i--) {
            if (pivot(i) == -1) {
                row_swap(i, x);
                x--;
            }
        }
    }

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

                    // System.out.print(mat[i][j] + "    ");
                    float factor = mat[i][j] / mat[j][j];
                    make_zero(factor, j, i);
                    // System.out.println(factor);
                }
                else{
                    // row_swap(i, i);
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
        ob.zero();
        ob.display();
        ob.calculate();
        ob.zero();
        ob.display();
    }

}
