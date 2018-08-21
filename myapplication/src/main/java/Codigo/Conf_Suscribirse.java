package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

import diagramaclasesbd.BD_Principal;

public class Conf_Suscribirse extends Conf_Suscribirse_ventana{
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Perfil_Ajeno_R _unnamed_Perfil_Ajeno_R_;
	
	iUsuario_Registrado ur = new BD_Principal();
	public Conf_Suscribirse(int aID) {
		aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				suscribirse(aID);
			}
		});
	}
	public void suscribirse(int aID) {
		ur.suscribirse(aID);
	}

	public void cancelarSuscripcion() {
		throw new UnsupportedOperationException();
	}
}