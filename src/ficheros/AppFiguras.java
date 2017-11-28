package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import daw.com.Pantalla;
import daw.com.Teclado;



public class AppFiguras extends AppConMenu {
	
	private TreeMap <String,Figura> figuras;
 	
	public AppFiguras (Vector <String> opciones)
	{
		super(opciones);
		
		figuras = new TreeMap <String,Figura>();
	}

	public  static void main (String args[])
	{
		AppFiguras app;
		
		Vector <String> opciones ;
		
		opciones = new Vector();
		
		opciones.add("\n1. Insertar Figura");
		opciones.add("\n2. Eliminar Figura");
		opciones.add("\n3. Listar");
		opciones.add("\n4. Salir\n");
		
		app = new AppFiguras(opciones);
		
		
		app.leerDatosFichero();
	
		app.run ();
		
		app.escribirDatosFichero();
		
	}
	
	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub

		switch (opc)
		{
			case 1:
					insertar();
					break;
			case 2:
					eliminar ();
					break;
			case 3:
					listar ();
					break;
			default:
					salir();
		}
		
	}
	
	public void insertar ()
	{
		Figura figura;
		String tipo;
		
		tipo = Teclado.leerString("tipo de figura: (R o C)");
		
		if (tipo.equals("R"))
			figura = new Rectangulo();
		else
			figura = new Circulo ();
		
		figura.leerDatos();
		
		if (!figuras.containsKey(figura.getNombre()))
			figuras.put(figura.getNombre(), figura);
		else
			Pantalla.escribirString("\nFigura duplicada...");
		
	}
	
	public void eliminar ()
	{
		String nombre = Teclado.leerString("Figuras a eliminar");
		
		if (figuras.remove(nombre) == null)
			Pantalla.escribirString("\nFigura no existente");
		else
			Pantalla.escribirString("\nFigura eliminada correctamente");
	}
	
	public void listar ()
	{
		for (Figura figura:figuras.values())
			figura.mostrarDatos();
		
	}
	
	public void salir ()
	{
		
		Pantalla.escribirString("\nBye");
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
						/*
						if ( tipo.contains("Rectangulo"))
							figura = new Rectangulo();
						else
							figura = new Circulo ();
						*/
						
						//Construir objeto al vuelo
						figura = (Figura)Class.forName(tipo).newInstance();
						
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
