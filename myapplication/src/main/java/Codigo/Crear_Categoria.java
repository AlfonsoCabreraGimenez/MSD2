package Codigo;

import diagramaclasesbd.BD_Principal;

public class Crear_Categoria extends Crear_Categoria_ventana{

	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public iAdministrador2 admin = new BD_Principal();
	
	public Crear_Categoria() {
	
	}
	public void crearCategoria() {
		tCategoria.setValue("");
		String nombreCategoria = tCategoria.getValue();
		String numeroEdad = comboEdad.getValue();
		//int numEntero = Integer.parseInt(numeroEdad);
		
		admin.crearCategoria(nombreCategoria,15);
		
	}
}