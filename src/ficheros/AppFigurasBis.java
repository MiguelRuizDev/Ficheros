package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

public class AppFigurasBis extends AppMenu {

	private TreeMap <String,Figura> figuras;
	
	public AppFigurasBis()
	{
		super();
		
		figuras = new TreeMap <String,Figura>();
		
		addOpcion (new MenuItem ("Insertar", 1, new Insertar(this)));
		addOpcion (new MenuItem ("Eliminar", 2, new Borrar(this)));
		addOpcion (new MenuItem ("Listar", 3, new Listar(this)));
		addOpcion (new Salir());
		
		
	}
	
	
	
	public TreeMap<String, Figura> getFiguras() {
		return figuras;
	}



	public void setFiguras(TreeMap<String, Figura> figuras) {
		this.figuras = figuras;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppFigurasBis app;
		
		
		
		app = new AppFigurasBis();
		
		app.leerDatosFichero();
	
		app.run ();	
		
		app.escribirDatosFichero();

	}
	
	
	
	public void escribirDatosFichero ()
	{
		Figura figura;
		
		try (DataOutputStream filtro = new DataOutputStream (new FileOutputStream ("figuras.dat"));)
		{
			Iterator<Figura> todas = figuras.values().iterator();
			
			while (todas.hasNext())
			{
				figura = todas.next();
				//figura.mostrarDatos();
				//filtro.writeBytes(figura.getClass().getSimpleName()+"\n");
				filtro.writeBytes(figura.getClass().getName()+"\n");
				figura.escribirFichero(filtro);
			}
 		}
		catch (IOException e)
		{
			System.err.println("Error en escritura de fichero...");
		}
		
	}
	
	public void leerDatosFichero ()
	{
		FileInputStream bruto = null; 
		DataInputStream filtro = null;
				
		
		try
		{
				String tipo ;
				bruto = new FileInputStream ("figuras.dat");
				filtro = new DataInputStream (bruto);
				Figura figura;
				
				while (filtro.available()>0)
				{
					tipo = filtro.readLine();
					if (tipo != null)
					{
						
						if ( tipo.contains("Rectangulo"))
							figura = new Rectangulo();
						else
							figura = new Circulo ();
						
						
						//Construir objeto al vuelo
						//figura = (Figura)Class.forName(tipo).newInstance();
						
						figura.leerFichero(filtro);
						
						figuras.put(figura.getNombre(), figura);
					}
				}
				
		}
		catch (IOException e)
		{
			System.err.println("No hay datos para cargar...");
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
				if (filtro!= null)
					filtro.close();
				if (bruto != null)
					bruto.close();
			}
			catch (IOException e)
			{
				System.err.println("error cerrando ficheros...");
				
			}
		}
		

		
	}

}
