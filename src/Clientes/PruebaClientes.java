import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class PruebaClientes {

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
		
		
		try{
			file = new File ("clientes.dat");
			out = new FileOutputStream (file);
			data = new DataOutputStream (out);
			
			Clientes cliente1 = new Clientes ();
			Clientes cliente2 = new Clientes ();
			
			cliente1.leerDatos();
			cliente2.leerDatos();
			
			cliente1.escrbirDatosFichero(data);
			cliente2.escrbirDatosFichero(data);

			data.close();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
			file = new File ("clientes.dat");
			in = new FileInputStream (file);
			datain = new DataInputStream (in);
			
			Clientes cliente1 = new Clientes ();
			Clientes cliente2 = new Clientes ();
			
			cliente1.leerDatosFichero(datain);
			cliente2.leerDatosFichero(datain);
			
			cliente1.mostrarDatos();
			cliente2.mostrarDatos();
			
			datain.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
