import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Cuenta {
	
	private String ncc;
	private float saldo;
	private ArrayList <Clientes> clientes;
	
	public Cuenta() {
		this.ncc = "";
		this.saldo = 0;
		this.clientes = new ArrayList<Clientes>();
	}

	public Cuenta(String ncc, float saldo) {
		this.ncc = ncc;
		this.saldo = saldo;
		this.clientes =  new ArrayList<Clientes>();
	}

	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}
	
	public void leerDatos()
	{
		ncc = Teclado.leerString("NCC");
		saldo = Teclado.leerFloat("Saldo: ");
		
		String seguir = "s";
		
		
		while (seguir.equalsIgnoreCase("s"))
		{
			Clientes cli = new Clientes();
			cli.leerDatos();
			clientes.add(cli);
			seguir = Teclado.leerString("Sigo...?");
		}
			
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("NCC : " + ncc + "\n");
		Pantalla.escribirString("Saldo :" + saldo + "\n");
		for (int i = 0; i < clientes.size(); i++)
			clientes.get(i).mostrarDatos();
	}
	
	public void leerDatosFichero(DataInputStream data) throws IOException
	{
		ncc = data.readLine();
		saldo = data.readFloat();
		int cuantos = data.readInt();
		for (int i = 0; i < cuantos; i++)
		{
			Clientes cli = new Clientes();
			cli.leerDatosFichero(data);
			clientes.add(cli);
		}
		
	}
	
	public void escribirDatosFichero (DataOutputStream data) throws IOException
	{
		data.writeBytes(ncc + "\n");
		data.writeFloat(saldo);
		data.writeInt(clientes.size());
		for (int i = 0; i < clientes.size(); i++)
			clientes.get(i).escrbirDatosFichero(data);
		
	}
	
}
