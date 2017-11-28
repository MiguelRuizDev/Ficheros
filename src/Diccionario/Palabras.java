
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import daw.com.Pantalla;

public class Palabras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader bfichero = null;
		BufferedReader ffichero = null;
		
		TreeMap <String, Integer> palabras = new TreeMap<>();
		
		String palabraslinea[],linea;
		
		try
		{
			bfichero = new FileReader ("quijote.txt");
			ffichero = new BufferedReader(bfichero);
			
			// Leer el fichero 
			while (ffichero.ready())
			{
				linea = ffichero.readLine();
				
				palabraslinea = linea.split("[ ,.;:]+");
				
				for (String palabra:palabraslinea)
				{
					
					palabra = palabra.toLowerCase();
					
					Integer valor = new Integer(0);
					
					if (palabras.containsKey(palabra))
					{
						valor = palabras.get(palabra);
					}
					
					// valor ++
					valor++;
					
					// añadir en el treemap
					palabras.put(palabra, valor);
				
					
					//Pantalla.escribirString(palabra+"\n");
				}
			}
			//Cerrar ficheros
			ffichero.close();
			bfichero.close();
			
			// Mostrar resultados
			Iterator<String> iterador = palabras.keySet().iterator();
			
			while (iterador.hasNext())
			{
				String p = iterador.next();
				Integer v = palabras.get(p);
				
				Pantalla.escribirString("\n" + p +" ->"+ v);
			}
			
			
			
			
		}
		
		catch (FileNotFoundException e)
		{
			Pantalla.escribirString("no encuentro el quijote....");
			
		}
		
		catch (IOException e)
		{
			Pantalla.escribirString("Error de entrada de ficheros");
		}
		

	}

}
