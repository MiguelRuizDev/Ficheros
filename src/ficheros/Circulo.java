package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Circulo extends Figura{
	private int radio;

	
	public Circulo ()
	{
		super();
		radio = 0;

	}

	public Circulo(int radio) {
		super();
		this.radio = radio;
	}
	

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		if (radio < 0)
			radio = 0;
		this.radio = radio;
	}
	
	public void leerDatos()
	{
		super.leerDatos();
		setRadio (Teclado.leerInt("radio"));
	}
	
	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirInt("\nradio = ",radio);
	}
	
	public float getArea()
	{
		float area;
		
		area = (float) (radio * radio * Math.PI);
		
		return radio;
	}
	
	public float getPerimetro()
	{
		float perimetro;
		
		perimetro = (float) (radio * 2 * Math.PI);
		
		return perimetro;
	}

	public void leerFichero (DataInputStream fichero) throws IOException
	{
		super.leerFichero(fichero);
		setRadio (fichero.readInt());
	}
	
	public void escribirFichero (DataOutputStream fichero) throws IOException
	{
		super.escribirFichero(fichero);
		fichero.writeInt(radio);
		
	}

}
