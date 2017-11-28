package Notas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Alumno {
	private String nombre;
	private ArrayList <Asignatura> asignaturas;
	
	
	public Alumno() {
		this.nombre = "";
		this.asignaturas = new ArrayList<Asignatura>();
	}
	
	public Alumno(ArrayList<String> as) {
		this.nombre = "";
		this.asignaturas = new ArrayList<Asignatura>();
		
		for (int i = 0; i < as.size(); i++)
			asignaturas.add(new Asignatura (as.get(i)));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	public void leerDatosFichero (BufferedReader []data) throws IOException
	{
		nombre = data[0].readLine();
		
		for (int i = 1; i < data.length; i++)
			asignaturas.get(i-1).setNota(data[i].readLine());
		
	}
	
	public void escribirDatosFichero(PrintWriter data) throws IOException
	{
		data.print(nombre + "\t\t\t");
		for (int i = 0; i < asignaturas.size(); i++)
			data.print(asignaturas.get(i).getNota()+"\t\t");
		data.println();
	}
	

}
