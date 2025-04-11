package Medium;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int matrix[][]={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Before matrix set to zero:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        setMatrixZeroes(matrix);
        System.out.println("After matrix set to zero:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeroes(int matrix[][]) {
        boolean frow = false;
        boolean fcol = false;
        // set first row and first column to zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        frow = true;
                    if (j == 0)
                        fcol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // replace zero in inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0]==0) {
                    matrix[i][j]=0;
                }
            }
        }

        //Set first row to zeros
        if(frow){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }

        //set first column to zeroes
        if(fcol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
