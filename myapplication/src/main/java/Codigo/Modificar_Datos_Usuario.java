package Codigo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

import GY.MyUI;

import com.vaadin.ui.Notification;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Usuario;

public class Modificar_Datos_Usuario extends Registrarse {
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	iUsuario_Registrado ur = new BD_Principal();
	public Modificar_Datos_Usuario () {
		modificarDatosUser.setVisible(true);
		vFechaN.setVisible(false);
		cancelar.setVisible(true);
		botonRegistrarse.setVisible(false);
		cargarDatosUsuario();
		
		modificarDatosUser.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
				if(user == null) {
					user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
				}
				modificarDatos(user.getID());
			}
		});
	}
	
	public void modificarDatos(int idUser) {
		String aNombre = tNombre.getValue();
		String aApellido1 = tApellido1.getValue();
		String aApellido2 = tApellido2.getValue();
		String aApodo = tApodo.getValue();
		String aEmail = tEmail.getValue();
		String aAvatar = tUrl.getValue();
		if(aNombre == "" || aApellido1 == "" || aApellido2 == "" || aApodo == "" || aEmail == "") {
			Notification.show("¡Debe rellenar todos los campos!", Type.WARNING_MESSAGE);
			return;
		}
		if(!aEmail.contains("@")) {
			Notification.show("¡Introduce un email válido!", Type.WARNING_MESSAGE);
			return;
		}
		if(aAvatar == "") {
			aAvatar = "https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true";
		}
		int resMod = ur.modificarDatos(idUser, aNombre, aApellido1, aApellido2, aApodo, aEmail, aAvatar);
		if(resMod == -1) {
			Notification.show("¡Ya existe un usuario con ese apodo!", Type.WARNING_MESSAGE);
		}
		if(resMod == 0) {
			Notification.show("¡Ya existe un usuario con ese email!", Type.WARNING_MESSAGE);
		}
		if(resMod == 1) {
			Notification.show("¡Modificación correcta!", Type.WARNING_MESSAGE);
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			if(admon == null) {
				MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
				UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
			}else {
				MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
				UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
			}
		}
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