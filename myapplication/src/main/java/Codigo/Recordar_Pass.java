package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

import diagramaclasesbd.BD_Principal;

public class Recordar_Pass extends Recordar_Pass_ventana{
	/*private Label _recordarL;
	private TextField _correoTF;
	private Boton _enviarB;
	private Boton _volverB;*/
	public Correo _unnamed_Correo_;
	public Iniciar_Sesion _unnamed_Iniciar_Sesion_;
	iUsuario_No_Registrado unr = new BD_Principal();
	public Recordar_Pass() {
		enviar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				regeneracionPass();
			}
		});
	}
	public void regeneracionPass() {
		Notification.show(email.getValue());
		//unr.regeneracionPass();
	}
}