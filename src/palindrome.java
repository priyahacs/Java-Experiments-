import java.util.*;
import java.io.*;
public class palindrome {
	
	public static void main(String[] args){
		
		Scanner s1 = new Scanner(System.in);
		String A = s1.next();
		char[] B = A.toCharArray();
		//System.out.println(B);
		char[] C = new char[A.length()];
        int j = 0;
        for(int i=B.length-1;i>=0;i--){
            C[j]= B[i];
            j++;
        }
        String D = String.valueOf(C);
        System.out.println(B.length);
        System.out.println(C.length);
        System.out.println(D.length());
        
        if(A.equals(D)){
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        
		
	}

}
