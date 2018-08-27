package Codigo;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Usuario;

public class Modificar_Datos_Usuario extends Registrarse {
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	iUsuario_Registrado ur = new BD_Principal();
	public Modificar_Datos_Usuario () {
		modificarDatosUser.setVisible(true);
		cancelar.setVisible(true);
		botonRegistrarse.setVisible(false);
		cargarDatosUsuario();
		modificarDatosUser.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				modificarDatos();
			}
		});
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
	public void cargarDatosUsuario() {
		Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
		if(user == null) {
			user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
		}
		Usuario iniciado = ur.cargarDatosUsuario(user.getID());
		tNombre.setValue(iniciado.getNombre());
		tApellido1.setValue(iniciado.getApellido1());
		tApellido2.setValue(iniciado.getApellido2());
		tApodo.setValue(iniciado.getApodo());
		tEmail.setValue(iniciado.getEmail());
		tUrl.setValue(iniciado.getAvatar());
		imagen.setSource(new ExternalResource(iniciado.getAvatar()));
	}
}