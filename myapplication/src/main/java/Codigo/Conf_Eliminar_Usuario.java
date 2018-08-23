package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.BD_Principal;

public class Conf_Eliminar_Usuario extends Conf_Eliminar_Usuario_ventana {
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Perfil_Ajeno_A _unnamed_Perfil_Ajeno_A_;
	iAdministrador2 admin = new BD_Principal();
	
	
	public Conf_Eliminar_Usuario() {
	
	}
	
	public void eliminarUsuario(int id) {
		admin.eliminarUsuario(id);
	}
}