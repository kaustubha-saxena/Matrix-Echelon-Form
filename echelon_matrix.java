import java.util.*;



public class echelon_matrix {
    Scanner sc = new Scanner(System.in);
    int i, j, k;
    int[][] mat;
    int row, col;

    void input(int row, int col) {
        this.row = row;
       this.col = col;
        mat = new int[this.row][this.col];
        for (i = 0; i < this.row; i++) {
            // System.out.println("Enter row" + (i + 1));
            for (j = 0; j < this.col; j++) {
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
    void row_swap(int first_row_index, int second_row_index) {
        int temp;
        for (k = 0; k < col; k++) {
            temp = mat[first_row_index][k];
            mat[first_row_index][k] = mat[second_row_index][k];
            mat[second_row_index][k] = temp;
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

        int non_zero_row = row - 1;
        for (i = row - 1; i >= 0; i--) {
            if (row_pivot(i) == -1) {
                row_swap(i, non_zero_row);
                non_zero_row--;
            }
        }

        if (mat[0][0] == 0) {
            row_swap(0, 1);
        }
    }

    // Returns the pivot element position
    int row_pivot(int row_index) {
        for (int j = 0; j < col; j++) {
            if (mat[row_index][j] != 0) {
                return j;
            }
        }
        return -1;
    }

    void echelon() {

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
        ob.echelon();
        ob.zero();
        System.out.println("Echelon Form of the matrix is:");
        ob.display();
    }

}