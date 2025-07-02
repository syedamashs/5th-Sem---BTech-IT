import java.util.*;

class Encryption{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose The Options:");
        System.out.println("1) Encryption\n2) Decryption\n3) Exit");
        int ch=sc.nextInt();
        
    while(true){
        switch(ch){
            case 1:
                Encryption();
                break;
            case 2:
                Decryption();
                break;
            case 3:
                return;
        }
        System.out.println("\n1) Encryption\n2) Decryption\n3) Exit");
        ch=sc.nextInt();
    }    
    }
    
    public static void Encryption(){
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter the Word To be Encrypted:");
        String name = sc.next();
        System.out.print("Enter the Key:");
        int k = sc.nextInt();
        String enc="";
        
        while(k<1 || k>125){
            System.out.print("Key range is 1 - 125");
            System.out.print("\nEnter the Key:");
            k=sc.nextInt();
        }
        
        k=k%26;
        
        for(int i=0;i<name.length();i++){
            
        char c = name.charAt(i);

        if(Character.isLowerCase(c)) enc+=(char) ('a'+((c-'a'+k)%26));
        else if(Character.isUpperCase(c)) enc+=(char) ('A'+((c-'A'+k)%26));
        else enc+=c;
        }
        
        System.out.println("Encrypted Word: "+enc);
    }
    
    public static void Decryption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Encrypted Word: ");
        String name = sc.next();

        System.out.print("Enter the Key: ");
        int k = sc.nextInt();
        
        while(k<1 || k>125){
            System.out.print("Key range is 1 - 125");
            System.out.print("\nEnter the Key:");
            k=sc.nextInt();
        }
        
        k=k%26;

        String dec = "";

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(Character.isLowerCase(c)) dec += (char) ('a' + (c - 'a' - k + 26) % 26);
            else if(Character.isUpperCase(c)) dec+=(char) ('A'+(c - 'A' -k +26)%26);
            else dec +=c;
        }

        System.out.println("Real Decrypted Word: " + dec);
    }
    
}







