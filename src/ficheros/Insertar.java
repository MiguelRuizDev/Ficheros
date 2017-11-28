package ficheros;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Insertar implements MenuAction {
	
	private AppFigurasBis app;
	
	public Insertar (AppFigurasBis app)
	{
		this.app = app;
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		Figura figura;
		String tipo;
		
		
		
		tipo = Teclado.leerString("tipo de figura: (R o C)");
		
		if (tipo.equals("R"))
			figura = new Rectangulo();
		else
			figura = new Circulo ();
		
		figura.leerDatos();
		
		if (!app.getFiguras().containsKey(figura.getNombre()))
			app.getFiguras().put(figura.getNombre(), figura);
		else
			Pantalla.escribirString("\nFigura duplicada...");

	}

}
