package Codigo;

import java.util.Optional;

import com.vaadin.ui.Notification;
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
		Optional<String> seleccion = comboEdad.getSelectedItem();
		int numeroEdad = Integer.parseInt(seleccion.get());
		//Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		admin.crearCategoria(nombreCategoria,numeroEdad);	
	}
}