package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
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
				if(email.isEmpty()) {
					Notification.show("¡Debe escribir su correo electronico!", Type.WARNING_MESSAGE);
				} else {
					if(regeneracionPass(email.getValue())) {
						Window a=new Window();
						a.setContent(new Nuevo_Pass(email.getValue()));
						a.center();		
						a.setModal(true);
						a.setWidth("720px");
						UI.getCurrent().addWindow(a);
					} else {
						Notification.show("¡No existe ningun usuario con el email indicado!", Type.WARNING_MESSAGE);
					}
				}
			}
		});
	}
	public boolean regeneracionPass(String correo) {
		return unr.regeneracionPass(correo);
	}
}