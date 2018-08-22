package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;

public class Conf_Cancelar_Suscribirse extends Conf_Cancelar_Suscribirse_ventana{
	
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	
	public Conf_Cancelar_Suscribirse(int aID) {
		aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				cancelarSuscripcion(aID);
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
	public void cancelarSuscripcion(int aID) {
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null ) {
			ur.cancelarSuscripcion(aID);
		} else {
			adm.cancelarSuscripcion(aID);
		}
	}
}
