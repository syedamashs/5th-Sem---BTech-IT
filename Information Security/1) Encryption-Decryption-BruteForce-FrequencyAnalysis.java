
import java.util.*;

class Encryption{
    
    static String alpl = "abcdefghijklmnopqrstuvwxyz";
    static String alpu = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        
        System.out.println("Choose The Options:");
        System.out.println("1) Encryption\n2) Decryption\n3) Brute Force Attack\n4) Frequency Analysis Attack\n5) Exit");
        int ch=sc.nextInt();
        sc.nextLine();
        
    while(true){
        switch(ch){
            case 1:
                Encryption();
                break;
            case 2:
                Decryption();
                break;
            case 3:
                bruteforce();
                break;
            case 4:
                frequency();
                break;
            case 5:
                return;
        }
        System.out.println("\n1) Encryption\n2) Decryption\n3) Brute Force Attack\n4) Frequency Analysis Attack\n5) Exit");
        ch=sc.nextInt();
    }    
    }
    
    public static void Encryption(){
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter the PLAIN Text:");
        String name = sc.next();
        System.out.print("Enter the Key:");
        int k = sc.nextInt();
        String enc="";

        k=k%26;
        
        for(int i=0;i<name.length();i++){
            int s;
         char c = name.charAt(i);

        if(Character.isLowerCase(c)){
            s = alpl.indexOf(c);
            s = (s + k) %26;
            enc += alpl.charAt(s);
        }
        else if(Character.isUpperCase(c)){
            s = alpu.indexOf(c);
            s = (s + k)%26;
            enc+=alpu.charAt(s);
        }
        else enc+=c;
        }
        
        System.out.println("CIPHER TEXT: "+enc);
    }
    
    public static void Decryption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the CIPHER Text: ");
        String name = sc.next();

        System.out.print("Enter the Key: ");
        int k = sc.nextInt();

        k=k%26;
        
        String dec = "";
        int s;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(Character.isLowerCase(c)){
                s=alpl.indexOf(c);
                s = (s-k+26)%26 ;
                dec += alpl.charAt(s);
            }
            else if(Character.isUpperCase(c)){
                s=alpu.indexOf(c);
                s = (s-k+26)%26;
                dec += alpu.charAt(s);
            }
            else dec +=c;
        }

        System.out.println("Plain Text: " + dec);
    }
    
    public static void bruteforce(){
        System.out.print("Enter the CIPHER Text: ");
        
        Scanner sc  = new Scanner(System.in);
        String name = sc.next();
        int s;
        String enc="";
        for(int i=0;i<26;i++){
            for(char ch : name.toCharArray()){
                    if(Character.isLowerCase(ch)){
                    s = alpl.indexOf(ch);
                    s = (s-1+26)%26;
                    enc+=alpl.charAt(s);
                }
                else{
                    s = alpu.indexOf(ch);
                    s = (s-1+26)%26;
                    enc+=alpu.charAt(s);
                }
        }
        System.out.println(enc);
        name=enc;
        enc="";
        }
    }
    
    public static void frequency(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the CIPHER Text: ");
        String name = sc.next();
        char yes='\0';
        String enc="";
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : name.toCharArray()){
            ch = Character.toLowerCase(ch);
                map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int max = Collections.max(map.values());
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                yes = entry.getKey();
            }
        }
        
        int key = (yes - 'e' +26) %26;
        System.out.println("Key is "+key);
        String ans = "";
        for(char c:name.toCharArray()){
            int s = alpl.indexOf(c);
            s = (s-key+26)%26;
            enc+=alpl.charAt(s);
        }
        
        System.out.print("PLAIN TEXT: "+enc);
    }
    
}
