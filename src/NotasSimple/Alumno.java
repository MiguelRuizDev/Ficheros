package NotasSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Alumno {
	
	private String nombre;
	private int nota[];
	
	public Alumno() {
		nombre = "";
		nota = null;
	}

	public Alumno(String nombre) {
		this.nombre = nombre;
		
		nota= null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota(int cual) {
		
		if (cual < 0)
			cual = 0;
		if (cual >= nota.length)
			cual = nota.length - 1;
		
		return nota[cual];
	}

	public void setNota(int valor, int cual) {
		
		if (cual < 0)
			cual = 0;
		if (cual >= nota.length)
			cual = nota.length - 1;
		
		if (valor <0)
			valor = 0;
		else if (valor > 10)
			valor = 10;
		
		this.nota[cual] = valor;
	}
	
	//para evitar excepcion si nos meten la nota como un String
	public void setNota (String nota, int cual) 
	{
	
		try{
			setNota(Integer.parseInt(nota),cual); //aquí parseamos, y llamamos al otro método
		}
		catch (NumberFormatException e)
		{
			setNota (0, cual);
		}
	}
	
	public void leerFichero (BufferedReader fichero[]) throws IOException //leemos con BufferedReader
	{
		nombre = fichero[0].readLine();
		
		nota = new int[fichero.length - 1];
		
		for (int i = 1; i < fichero.length; i++)
			setNota (fichero[i].readLine(), i-1);
	}
	
	
	public void escribirFichero (PrintWriter fichero) //escribimos con PrintWriter
	{
		fichero.println(toString());
	}
	
	public String toString() {
	
	//estrategia: concatenar todo en una única linea, para facilitar el proceso de escritura
	
		String alumno = new String();
		
		alumno += nombre;
		
		
		for (int i = 0; i < nota.length; i++)
			alumno += "\t\t" + String.valueOf(nota[i]);
		
		return alumno;
	}

}
