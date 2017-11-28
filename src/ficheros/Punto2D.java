package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Punto2D {
	//Estado de la clase
	private int x;
	private int y;
	
	
	// Constructores
	public Punto2D()
	{
		this.x = 0;
		this.y = 0;
	}


	public Punto2D(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public Punto2D(Punto2D original) 
	{
		this.x = original.x;
		this.y = original.y;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	
	public String toString() {
		return "(x=" + x + ", y=" + y + ")";
	}


	public boolean equals(Punto2D otro) 
	{
		boolean iguales = true;
		
		if (this.x != otro.x || this.y != otro.y)
			iguales = false;
		
		return iguales;

	}
	
	public void leerPunto()
	{
		this.x = Teclado.leerInt("x:");
		this.y = Teclado.leerInt("y:");
	}
	
	public void mostrarPunto()
	{
		Pantalla.escribirString("\n" + this.toString());
	}
	
	public void leerFichero (DataInputStream fichero) throws IOException
	{
		x = fichero.readInt();
		y = fichero.readInt();
		
	}
	
	public void escribirFichero (DataOutputStream fichero) throws IOException
	{
		fichero.writeInt(x);
		fichero.writeInt(y);
	}
	
}
