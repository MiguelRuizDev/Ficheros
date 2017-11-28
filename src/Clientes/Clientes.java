import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Clientes {
	
	private String nif;
	private String nombre;
	private String telefono;
	private float avales;
	
	public Clientes ()
	{
		nif = "";
		nombre = "";
		telefono = "";
		avales = 0;
		
	}
	
	public Clientes (String nif, String nombre, String telefono, float avales)
	{
		this.nif = nif;
		this.nombre = nombre;
		this.telefono = telefono;
		setAvales (avales);
		
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getAvales() {
		return avales;
	}

	public void setAvales(float avales) {
		if (avales < 0)
			avales = 0;
		
		this.avales = avales;
	}
	
	public void leerDatos ()
	{
		nif = Teclado.leerString("NIF: ");
		nombre = Teclado.leerString("Nombre: ");
		telefono = Teclado.leerString("Telefono: ");
		setAvales (Teclado.leerFloat("Avales: "));
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("------------------------\n");
		Pantalla.escribirString("NIF : " + nif + "\n");
		Pantalla.escribirString("Nombre : " + nombre + "\n");
		Pantalla.escribirString("Telefono : " + telefono + "\n");
		Pantalla.escribirFloat("Avales: ", avales);
		Pantalla.escribirSaltoLinea();
	}
	
	public void leerDatosFichero (DataInputStream data) throws IOException
	{
		nif = data.readLine();
		nombre = data.readLine();
		telefono = data.readLine();
		setAvales (data.readFloat());
	
	}
	
	public void escrbirDatosFichero (DataOutputStream data) throws IOException
	{
		data.writeBytes(nif+"\n");
		data.writeBytes(nombre+"\n");
		data.writeBytes(telefono + "\n");
		data.writeFloat(avales);
	}
	

}
