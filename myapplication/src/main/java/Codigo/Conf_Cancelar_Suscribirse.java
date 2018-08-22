package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;

public class Conf_Cancelar_Suscribirse extends Conf_Cancelar_Suscribirse_ventana{
	
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	
	public Conf_Cancelar_Suscribirse(int ID) {
		aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				cancelarSuscripcion(ID);
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
