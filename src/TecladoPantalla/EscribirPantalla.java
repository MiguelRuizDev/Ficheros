import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import daw.com.Teclado;

public class EscribirPantalla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String respuesta ;
				do
				{
					String linea = Teclado.leerString(">");
					System.out.println(linea);
					 respuesta = Teclado.leerString("\nDesea seguir?(S/N)");
				}while (respuesta.equals("S"));
				
				ffichero.close();  
				//porqué estamos cerrando un archivo?
		

		
	}

}
