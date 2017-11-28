import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grupo grupo = new Grupo ();
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		File fsalida = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter salida = null;
		
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("config.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			// Lectura de los datos de los ficheros
			grupo.leerDatosFichero(br);
			
			
			fsalida = new File ("notas.txt");
			fw = new FileWriter(archivo);
			bw = new BufferedWriter(fw);
			salida = new PrintWriter(bw);
			
			// Escibir datos en fichero salida
			grupo.escribirDatosFichero(salida);
			}		
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally{
			try{
				br.close();
				fr.close();
				salida.close();
				bw.close();
				fw.close();
			}
			catch (Exception e2){
				e2.printStackTrace();
			}
		}
		

	}

}
