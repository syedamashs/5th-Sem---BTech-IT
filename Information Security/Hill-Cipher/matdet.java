import java.util.Arrays;
import java.util.Scanner;

public class matdet{

public static int matdet(int[][] matrix, int key, int mod) {
    int determinant = 0;

    if (key == 2) {
        // For 2x2: ad - bc
        determinant = matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
    } else if (key == 3) {
        // For 3x3: A(EI − FH) − B(DI − FG) + C(DH − EG)
        int a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        int d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        int g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];

        determinant = a * (e*i - f*h)
                    - b * (d*i - f*g)
                    + c * (d*h - e*g);
    } else {
        // For larger matrices (n x n), recursion or Laplace expansion is possible.
        throw new UnsupportedOperationException("Determinant not implemented for key > 3");
    }

    // Ensure positive mod result
    determinant %= mod;
    if (determinant < 0) determinant += mod;

    return determinant;
}

public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Key: ");
        int key = sc.nextInt();

        int matrix[][] = new int[key][key];

        System.out.print("Enter matrix elements (" + (key*key) + " values):\n");
        for(int i=0;i<key;i++){
            for(int j=0;j<key;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        

        int det = matdet(matrix,key,26);

        System.out.print("\nDeterminant of the Matrix: "+det);

    }

}
