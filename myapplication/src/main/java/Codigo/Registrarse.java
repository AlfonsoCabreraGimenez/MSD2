package Codigo;

import com.vaadin.ui.UI;

import diagramaclasesbd.BD_Principal;

import java.util.Date;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
public class Registrarse extends Registrarse_ventana {
	iUsuario_No_Registrado unr = new BD_Principal();
	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Nuevo_Pass _unnamed_Nuevo_Pass_;
	
	public Registrarse() {
		modificarDatosUser.setVisible(false);
		botonRegistrarse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
					UI.getCurrent().getNavigator().navigateTo("PagIR");
					//registrarse();
				}	
		});
	}
	public void registrarse()  {
		String aNombre = tNombre.getValue();
		String aApellido1 = tApellido1.getValue();
		String aApellido2 = tApellido2.getValue();
		Date aFechaN = null;
		String aApodo = tApodo.getValue();
		String aPass = tPass.getValue();
		String aRepPass = tRepPass.getValue();
		String aEmail = tEmail.getValue();
		String aAvatar = "as";
		unr.registrarse(aNombre, aApellido1, aApellido2, aFechaN, aApodo, aPass, aRepPass, aEmail, aAvatar);
	}
}