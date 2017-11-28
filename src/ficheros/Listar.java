package ficheros;

public class Listar implements MenuAction {
	
	private AppFigurasBis app;
	
	public Listar (AppFigurasBis app)
	{
		this.app = app;
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		for (Figura figura:app.getFiguras().values())
			figura.mostrarDatos();

	}

}
