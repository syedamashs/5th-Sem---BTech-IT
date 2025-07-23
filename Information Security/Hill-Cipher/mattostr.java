import java.util.*;

class mattostr{

    public static String mattostr(int[][] matrix,int key,int mod){

        int cols = matrix[0].length;
        StringBuilder result = new StringBuilder();

        for(int col=0;col<cols;col++){
            for(int row=0;row<key;row++){
                int element = (matrix[row][col])%mod;
                if(element<0) element = element+ mod;
                result.append((char)(element+'A'));
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Key: ");
        int key = sc.nextInt();

        System.out.print("Enter total number of elements in matrix: ");
        int totalElements = sc.nextInt();

        int cols = totalElements/key;
        if(totalElements%key!=0){
            System.out.println("Error the Matrix is not Correct");
            return;
        }

        int matrix[][] = new int[key][cols];

        System.out.print("Enter matrix elements (" + totalElements + " values):\n");
        for(int i=0;i<key;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        

        String name = mattostr(matrix,key,26);

        System.out.print("\nString of the Matrix: "+name);

    }
}
