import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import daw.com.Teclado;


public class PruebaCuenta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file;
		FileOutputStream out;
		DataOutputStream data;
		
		FileInputStream in;
		DataInputStream datain;
		
		ArrayList <Cuenta> cuentas = new ArrayList<Cuenta> ();
		
		try{
			file = new File ("cuentas.dat");
			out = new FileOutputStream (file);
			data = new DataOutputStream (out);
			
			leerCuentas (cuentas);
			
			escrbirCuentasFichero (cuentas, data);
		
			data.close();
			out.close();
			
			in = new FileInputStream (file);
			datain = new DataInputStream (in);
			
			cuentas.clear();
			leerCuentasFichero(cuentas,datain);
			mostrarCuentas(cuentas);
			
			datain.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public static void leerCuentas (ArrayList <Cuenta> cuentas)
	{
		String seguir = "s";
		String tipo ="";
		
		while (seguir.equalsIgnoreCase("s"))
		{
			tipo = Teclado.leerString("Tipo de cuenta (P/E)");
			
			Cuenta cuenta = null;
			
			if (tipo.equalsIgnoreCase("p"))
				cuenta = new Personal();
			/*
			 else
				cuenta = new Empresa();
			*/
			cuenta.leerDatos();
			cuentas.add(cuenta);
		
			seguir = Teclado.leerString("desea seguir?");
		}
	}
	
	public static void mostrarCuentas (ArrayList <Cuenta> cuentas)
	{
		for (int i = 0; i < cuentas.size(); i++)
			cuentas.get(i).mostrarDatos();
		
	}
	
	public static void escrbirCuentasFichero (ArrayList <Cuenta> cuentas, 
					DataOutputStream data) throws IOException
	{
		data.writeInt(cuentas.size());
		
		for (int i = 0; i < cuentas.size(); i++)
		{
			Cuenta cuenta = cuentas.get(i);
			
			
			
			/*if  (cuenta instanceof Personal)
				data.writeBytes("Personal\n");		
			 else
			  	data.writeBytes("Empresa\n");
			 */
			
			
			data.writeBytes(cuenta.getClass().getName()+"\n");
			
			cuenta.escribirDatosFichero(data);
		}
		
	}

	public static void leerCuentasFichero (ArrayList <Cuenta> cuentas, 
			DataInputStream data) 
					throws IOException, ClassNotFoundException, 
					InstantiationException, IllegalAccessException
	{
		int cuantos = data.readInt();
		Cuenta cuenta = null;
		
		for (int i=0; i < cuantos; i++)
		{
			String tipo = data.readLine();
			
			/*
			if (tipo.equals("Personal"))
				cuenta = new Personal();
			
			else
			  	cuenta = new Empresa();
			*/
			
			Class clase = Class.forName(tipo);
			cuenta = (Cuenta) clase.newInstance();
			
			cuenta.leerDatosFichero(data);
			cuentas.add(cuenta);
		}
		
	}
}
