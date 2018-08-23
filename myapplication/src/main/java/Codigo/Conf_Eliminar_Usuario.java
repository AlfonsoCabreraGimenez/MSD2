package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import diagramaclasesbd.BD_Principal;

public class Conf_Eliminar_Usuario extends Conf_Eliminar_Usuario_ventana {
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Perfil_Ajeno_A _unnamed_Perfil_Ajeno_A_;
	iAdministrador2 admin = new BD_Principal();
	
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	
	public Conf_Eliminar_Usuario(int idUser) {
	//Meter la creacion del popup
		aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				eliminarUsuario(idUser);
				
			}
		});
	}
	
	public void eliminarUsuario(int id) {
		Notification.show("HOLA");
		admin.eliminarUsuario(id);
	}
}