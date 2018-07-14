package Codigo;

import com.vaadin.ui.UI;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;

public class Crear_Categoria extends Crear_Categoria_ventana{

	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public iAdministrador2 admin = new BD_Principal();
	
	public Crear_Categoria() {
		tCategoria.setValue("");
	}
	public void crearCategoria() {
		
		String nombreCategoria = tCategoria.getValue();
		String numeroEdad = comboEdad.getValue();
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		admin.crearCategoria(nombreCategoria,admon.getID());
		
	}
}