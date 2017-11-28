package ficheros;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Borrar implements MenuAction {
	
	private AppFigurasBis app;
	
	public Borrar (AppFigurasBis app)
	{
		this.app = app;
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		String nombre = Teclado.leerString("Figuras a eliminar");
		
		if (app.getFiguras().remove(nombre) == null)
			Pantalla.escribirString("\nFigura no existente");
		else
			Pantalla.escribirString("\nFigura eliminada correctamente");

	}

}
