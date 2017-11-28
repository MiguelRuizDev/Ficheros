import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Grupo {
	private ArrayList <Alumno> alumnos;
	private ArrayList <String> notas;
	
	public Grupo ()
	{
		alumnos = new ArrayList<Alumno>();
		notas = new ArrayList<String>();
	}
	
	
	
	public void leerDatosFichero(BufferedReader data) throws IOException
	{
		// Leer de fichero de configuración :
		//			- cómo se llama e fichero de nombres
		//			- cómo se llaman los ficheros de notas
		// Abrir ficheros de nombres y notas
		// Mientras tenga alumnos, para cada alumno
		//		Construir alumno y leer
		//		Añadir alumno al arraylist
		// Cerrar ficheros
		
		String nombresalumnos;
		String nombresnotas;
		
		nombresalumnos = data.readLine();
		
		while ((nombresnotas = data.readLine()) != null)
		{
			notas.add(nombresnotas);
		}
		
		File filealumnos = new File (nombresalumnos);
		FileReader fralumnos = new FileReader (filealumnos);
		
		
		
		File filenotas[] = new File[notas.size()];
		FileReader frnotas[] = new FileReader[notas.size()] ;
		BufferedReader br[] = new BufferedReader[notas.size()+1];
		
		br[0] = new BufferedReader (fralumnos);
		
		for (int i = 0; i < notas.size(); i++)
		{
			filenotas[i] = new File (notas.get(i));
			frnotas[i] = new FileReader (filenotas[i]);
			br[i+1] = new BufferedReader (frnotas[i]);
		}
		
		while (br[0].ready())
		{
			Alumno alumno = new Alumno (notas);
			alumno.leerDatosFichero(br);
			alumnos.add(alumno);
		}

		for (int i = 0 ; i < br.length; i++)
			br[i].close();
		
		fralumnos.close();
		for (int i = 0 ; i < frnotas.length; i++)
			frnotas[i].close();
		
		
	}
	
	public void escribirDatosFichero (PrintWriter data)throws IOException
	{
		// Recorrer arraylist de alumnos, para cada alumno
		//		Escribir alumno en fichero
		
		data.write("Nombre \t\t\t");
		for (int i = 0; i < notas.size(); i++)
		{
			int hasta = notas.get(i).length() - 4;
			String nota = notas.get(i).substring(0,hasta);
			data.write(nota + "\t\t");
		}
		data.write("\n");
		
		for (int i = 0; i < alumnos.size(); i++)
			alumnos.get(i).escribirDatosFichero(data);
		
	}

}
