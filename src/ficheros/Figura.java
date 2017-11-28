package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

abstract public class Figura {
	
	private String nombre;
	private int color;

	private Punto2D centro;
	
	public Figura() {
		nombre ="";
		color = 0;
		
		centro = new Punto2D();
	}





	public Figura (Figura original)
	{
		this.nombre = original.nombre;
		this.color = original.color;
		
		this.centro = new Punto2D (original.centro);
		
	}


	public int getColor() {
		return color;
	}



	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public void setColor(int color) {
		if (color < 0)
			color = 0;
		else
			if (color > 254)
				color = 254;
		this.color = color;
	}



	

	public Punto2D getCentro() {
		return centro;
	}



	public void setCentro(Punto2D centro) {
		this.centro = new Punto2D(centro);
	}
	
	public void leerDatos ()
	{
		nombre = Teclado.leerString("nombre:");
		setColor (Teclado.leerInt("color:"));
			
		
	
		// leer el centro del teclado
		centro.leerPunto();
		
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("\nnombre :", nombre);
		Pantalla.escribirInt("\nbgcolor :" , color);
		
		
		centro.mostrarPunto();
	}
	
	public void leerFichero (DataInputStream fichero) throws IOException
	{
		nombre = fichero.readLine();
		setColor (fichero.readInt());

		centro.leerFichero(fichero);
	}
	
	public void escribirFichero (DataOutputStream fichero) throws IOException
	{
		fichero.writeBytes(nombre + "\n");
		fichero.writeInt(color);
		
		centro.escribirFichero(fichero);
		
	}
	
	abstract public float getArea();
	


}
