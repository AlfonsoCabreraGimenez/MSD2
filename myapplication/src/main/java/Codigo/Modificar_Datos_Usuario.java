package Codigo;

import com.vaadin.ui.Button;

import diagramaclasesbd.BD_Principal;

public class Modificar_Datos_Usuario extends Registrarse {
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	iUsuario_Registrado ur = new BD_Principal();
	Button nuevo = new Button();
	public Modificar_Datos_Usuario () {
		nuevo.setCaption("Modificar Datos Usuario");
		//botonRegistrarse.setVisible(false);
		botonRegistrarse.setVisible(false);
		hRegisModi.addComponent(nuevo);
		//modificarDatosUser.setVisible(true);
		//modificarDatos();
	}
	
	public void modificarDatos() {
		String nombre = tNombre.getValue();
		String ap1 = tApellido1.getValue();
		String ap2 = tApellido2.getValue();
		String apod = tApodo.getValue();
		String email = tEmail.getValue();
		String pass = tPass.getValue();
		String rePass = tRepPass.getValue();
		ur.modificarDatos(nombre, ap1, ap2, null, apod, email, null, pass, rePass, null);

	}
}