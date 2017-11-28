
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ffichero;
		
			
			ffichero = new Scanner(System.in);
			
			String linea = ffichero.nextLine();
			int n = ffichero.nextInt();
			
			System.out.println(linea);
			System.out.println(n);
			System.out.println(23.4d);
			
			
			ffichero.close();
			


		
		

	}

}
