package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;

public class Conf_Suscribirse extends Conf_Suscribirse_ventana{
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Perfil_Ajeno_R _unnamed_Perfil_Ajeno_R_;
	
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	public Conf_Suscribirse(int aID) {
		aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				suscribirse(aID);
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_R", new Perfil_Ajeno_R(aID));
					UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_R");
				} else {
					MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_A", new Perfil_Ajeno_A(aID));
					UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_A");
				}
			}
		});
	}
	public void suscribirse(int aID) {
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null ) {
			ur.suscribirse(aID);
		} else {
			adm.suscribirse(aID);
		}
	}

	/*public void cancelarSuscripcion() {
		throw new UnsupportedOperationException();
	}*/
}