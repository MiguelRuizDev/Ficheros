
public class Asignatura {
	
	private String nombre;
	private int nota;
	
	public Asignatura ()
	{
		nombre = "";
		nota = 0;
	}
	
	public Asignatura (String nombre)
	{
		this.nombre = nombre;
		nota = 0;
	}

	public Asignatura(String nombre, int nota) {
		this.nombre = nombre;
		setNota (nota);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}
	
	public void setNota (String nota)
	{
		
		try
		{
			setNota(Integer.parseInt(nota));
		}
		catch (NumberFormatException e)
		{
			this.nota = 0;
		}
		
	}
	
	public void setNota(int nota) {
		if (nota < 0)
			nota = 0;
		if (nota > 10)
			nota = 10;
		this.nota = nota;
	}
}
