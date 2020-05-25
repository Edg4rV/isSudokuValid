import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean grid = false;
        boolean colandrow = false;
        boolean matrixelement = false;
        if (n <= 0 || n > 10) {
            System.out.println("NO");
            System.exit(0);
        }
        int size = n * n;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        if (checkMatrixElement(matrix, size)) {
            matrixelement = true;
        } else {
            matrixelement = false;
        }

//---------------------check sum--------------------------------------
        int check_sum = 0;
        for (int i = 1; i <= size; i++){
            check_sum = check_sum + i;
        }
//---------------------converting two dim to one as row------------
        int[] tmp = new int[size * size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmp[index] = matrix[i][j];
                index++;
            }
        }
 //--------------------converting two dim array to one as col----------------------
        int[] col_arr = new int[size * size];
        int col_index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                col_arr[col_index] = matrix[j][i];
                col_index++;
            }
        }
//---------------------check row and col-------------------------
        for (int i = 0; i < size * size; i += size) {
            if (check_sum == checkRow(tmp,size,i) && check_sum == checkcol(col_arr,size,i)) {
                    colandrow = true;
            } else {
                colandrow = false;
            }
        }
//---------------------checking square sum ----------------------
        for (int i = 0; i < size; i = i + n) {
        for(int j = 0; j < size; j = j + n) {
            if(check_sum == getSquare(matrix,i,j,n)) {
                    grid = true;
            } else {
                grid = false;
            }
        }
    }
//------------------------printing results----------------------
        if (grid && colandrow && matrixelement) {
            System.out.println();
            System.out.println("YES");
        } else {
            System.out.println();
            System.out.println("NO");
        }
//---------------------Check Row----------------------------------
//        for (int i = 0; i < size * size; i += size) {
//            if (check_sum == checkRow(tmp,size,i)) {
//                System.out.println(">>>>>>> checking sum of each row" + " " + "YES");
//            } else {
//                System.out.println("NO" + "row is invalid");
//            }
//        }
//------------------check column----------------------------------
//        for (int i = 0; i < size * size; i += size) {
//            if (check_sum == checkcol(col_arr,size,i)) {
//                System.out.println(">>>>>>> checking sum of each row" + " " + "YES");
//            } else {
//                System.out.println("NO" + "row is invalid");
//            }
//        }
//----------------------------------------------------------------






    } //===============================================================================
    //================= from this place is started out of from main method=============
    // --------------check matrix elemet-----------------------------------------------
    static boolean checkMatrixElement(int[][] board, int size) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0 || board[i][j] > size) {
                    return false;
                }
            }
        }
        return true;
    }

    //---------------convet two dim matrix to one dim----------------------------------
    static int[] convertMatrix(int[][] board) {
        int size = board[0].length * board[0].length;
        int[] tmp = new int[size];
        int index = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                tmp[index] = board[i][j];
                index++;
            }
        } return tmp;
    }


//-----------counting each row sum for checking  ---------------------------------------------

    static int checkRow(int[]tmp,int size ,int start_row) {
        int end_Row = start_row + size;
        int row_sum = 0;
        for (int i = start_row; i < end_Row; i++){
            row_sum = row_sum + tmp[i];
        }
        return row_sum;
    }
//-----------counting each col sum for checking  ---------------------------------------------

    static int checkcol(int[] col_arr,int size ,int start_col) {
        int end_col = start_col + size;
        int col_sum = 0;
        for (int i = start_col; i < end_col; i++){
            col_sum = col_sum + col_arr[i];
        }
        return col_sum;
    }

//-------------------counting grid and checking -------------------------------------------
    public static int getSquare(int[][] board, int rowStart, int colStart,int n) {
        int endRow = rowStart + n;
        int endCol = colStart + n;
        int[] tmp = new int[n * n];
        int square_sum = 0;
        int index = 0;
        for (int i = rowStart; i < endRow; i++) {
            for (int j = colStart; j < endCol; j++) {
                tmp[index] = board[i][j];
                index++;
            }
        }
        for (int x = 0; x < n * n; x++ ){
            square_sum = square_sum + tmp[x];
        }
        return square_sum;
    }

//-------------------------------------------------------------------------------------------
}
