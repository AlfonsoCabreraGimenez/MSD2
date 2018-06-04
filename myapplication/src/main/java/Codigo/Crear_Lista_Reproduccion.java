package Codigo;

import diagramaclasesbd.BD_Principal;

public class Crear_Lista_Reproduccion extends Crear_Lista_Reproduccion_ventana{
	
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	
	iUsuario_Registrado r = new BD_Principal();
	

	public Crear_Lista_Reproduccion() {
		
	}
	public void buscarVideo() {
		throw new UnsupportedOperationException();
	}

	public void crearListaRep() {
		String titulo = tTitulo.getValue();
		r.crearListaRep(titulo, null);
	}
}