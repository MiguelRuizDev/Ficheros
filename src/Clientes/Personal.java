import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Personal extends Cuenta {
	
	private boolean tarjeta;
	
	public Personal ()
	{
		super();
		tarjeta = false;
	}

	public boolean isTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(boolean tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public void leerDatos()
	{
		super.leerDatos();
		tarjeta = Teclado.leerString("Tienes tarjeta :").equalsIgnoreCase("s");
		
	}
	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirString(Boolean.toString(tarjeta));
	}

	public void leerDatosFichero(DataInputStream data) throws IOException
	{
		super.leerDatosFichero(data);
		tarjeta =  data.readBoolean();
	}
	
	public void escribirDatosFichero(DataOutputStream data) throws IOException
	{
		super.escribirDatosFichero(data);
		data.writeBoolean(tarjeta);
		
	}

}
