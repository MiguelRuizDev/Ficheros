package NotasSimple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeMap;

import daw.com.Pantalla;


public class AplicacionNotas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LECTURA
		FileReader bentrada[];
		BufferedReader entrada[];
		
		//ESCRITURA
		FileWriter bresultado=null;
		BufferedWriter fresultado=null;
		PrintWriter resultado=null;
		
		Alumno alumno;
		
		TreeMap<String,Alumno> alumnos = new TreeMap();
		
		
		
		try{
			// Abrir ficheros
			FileReader bnombres = new FileReader("nombres.txt");
			FileReader bnotas = new FileReader("notas.txt");
			
			BufferedReader nombres = new BufferedReader (bnombres);
			BufferedReader notas = new BufferedReader (bnotas);
			
			
			//escribir un archivo en modo texto: sólo necesitamos estas tres líneas, y estas clases
			bresultado = new FileWriter("resultado.txt");
			fresultado = new BufferedWriter (bresultado);
			resultado = new PrintWriter (fresultado);
			
			
			while (entrada[0].ready())
			{
				alumno = new Alumno();
				alumno.leerFichero(entrada);
				Pantalla.escribirString(alumno.toString()+"\n");
				alumnos.put(alumno.getNombre(), alumno);
				
			}
			
			
			Iterator<Alumno> iterador = alumnos.values().iterator();
			
			while (iterador.hasNext())
				iterador.next().escribirFichero(resultado);
				
			Pantalla.escribirString("fin....");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		finally{
			
			//usamos finally para  cerrar todo
			
			try{
			resultado.close();
			fresultado.close();
			bresultado.close();
			
			
			nombres.close();
			notas.close();
			
			bnombres.close();
			bnotas.close();
			}
			
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
			
	}

}
