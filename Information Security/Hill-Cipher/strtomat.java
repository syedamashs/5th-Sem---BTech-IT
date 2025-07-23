import java.util.*;

class strtomat{

    public static int[][] strtomat(String name,int key,int mod){

        name = name.toUpperCase();

        int pad = key - (name.length()%key);

        for(int i=0;i<pad;i++){
            name+= "X";
        }

        int cols = name.length()/key;
        int[][] matrix = new int[key][cols];

        int ind=0;
        for(int col=0;col<cols;col++){
            for(int row=0;row<key;row++){
                matrix[row][col] = (name.charAt(ind++) - 'A')%26;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String to Convert to Matrix(eq): ");
        String name = sc.nextLine();
        System.out.print("Enter the Key: ");
        int key = sc.nextInt();

        int[][] matrix = strtomat(name,key,26);

        System.out.print("\nMatrix(eq) of the String: "+name+" \n"+Arrays.deepToString(matrix));

    }
}
