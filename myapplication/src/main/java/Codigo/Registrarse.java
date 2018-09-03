package Codigo;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.BD_Principal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.flute.parser.ParseException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
public class Registrarse extends Registrarse_ventana {
	
	iUsuario_No_Registrado unr = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Nuevo_Pass _unnamed_Nuevo_Pass_;

	public Registrarse() {
		modificarDatosUser.setVisible(false);
		tUrl.setPlaceholder("Url del avatar...");
		botonRegistrarse.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
					try {
						registrarse();
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
		});
		bImagen.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(tUrl.isEmpty()) {
					imagen.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez"
							+ "/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
				} else {
					imagen.setSource(new ExternalResource(tUrl.getValue()));
				}
			}
		});
		darAlta.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				registrarAdministrador();
			}
		});
	}
	public void registrarse() throws java.text.ParseException  {
		String aNombre = tNombre.getValue();
		String aApellido1 = tApellido1.getValue();
		String aApellido2 = tApellido2.getValue();
		/*Parametros de la fecha*/
		String anio = Integer.toString(fechaUsuario.getValue().getYear());
		String mes = Integer.toString(fechaUsuario.getValue().getMonthValue());
		String dia = Integer.toString(fechaUsuario.getValue().getDayOfMonth());
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fechaAlta = anio+"-"+mes+"-"+dia;
		Date fechaFinal = null;
		try {
			fechaFinal = formatoDelTexto.parse(fechaAlta);
		} catch (ParseException ex) {
			ex.printStackTrace();

		}
		String aApodo = tApodo.getValue();
		String aPass = tPass.getValue();
		String aRepPass = tRepPass.getValue();
		String aEmail = tEmail.getValue();
		String aAvatar = tUrl.getValue();
		if(aNombre.isEmpty() || aApellido1.isEmpty() || aApellido2.isEmpty() || aApodo.isEmpty() ||
				aPass.isEmpty() || aRepPass.isEmpty() || aEmail.isEmpty()) {
			Notification.show("¡Debe rellenar todos los campos!", Type.WARNING_MESSAGE);
			return;
		}
		if(!aPass.equals(aRepPass)) {
			Notification.show("¡Los campos contraseña y repetición de contraseña"
					+ " deben ser iguales!", Type.WARNING_MESSAGE);
			return;
		}
		if(aPass.length() < 8) {
			Notification.show("¡La contraseña debe ser "
					+ "almenos de 8 caracteres!", Type.WARNING_MESSAGE);
			return;
		}
		if(!aEmail.contains("@")) {
			Notification.show("¡Introduce un email válido!", Type.WARNING_MESSAGE);
			return;
		}
		if(aAvatar.isEmpty()) {
			aAvatar = "https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true";
		}
		
		
		int resReg = unr.registrarse(aNombre, aApellido1, aApellido2, fechaFinal, aApodo, aPass, aRepPass, aEmail, aAvatar);	
		
		if(resReg == -1) {
			Notification.show("¡Ya existe un usuario con ese apodo!", Type.WARNING_MESSAGE);
		}
		if(resReg == 0) {
			Notification.show("¡Ya existe un usuario con ese email!", Type.WARNING_MESSAGE);
		}
		if(resReg == 1) {
			Notification.show("¡Registro correcto!", Type.WARNING_MESSAGE);
		}
	}
	public void registrarAdministrador() {
		String aNombre = tNombre.getValue();
		String aApellido1 = tApellido1.getValue();
		String aApellido2 = tApellido2.getValue();
		/*Parametros de la fecha*/
		String anio = Integer.toString(fechaUsuario.getValue().getYear());
		String mes = Integer.toString(fechaUsuario.getValue().getMonthValue());
		String dia = Integer.toString(fechaUsuario.getValue().getDayOfMonth());
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fechaAlta = anio+"-"+mes+"-"+dia;
		Date fechaFinal = null;
		try {
			fechaFinal = formatoDelTexto.parse(fechaAlta);
		} catch (ParseException ex) {
			ex.printStackTrace();

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String aApodo = tApodo.getValue();
		String aPass = tPass.getValue();
		String aRepPass = tRepPass.getValue();
		String aEmail = tEmail.getValue();
		String aAvatar = tUrl.getValue();
		if(aNombre == "" || aApellido1 == "" || aApellido2 == "" || aApodo == "" ||
				aPass == "" || aRepPass == "" || aEmail == "") {
			Notification.show("¡Debe rellenar todos los campos!", Type.WARNING_MESSAGE);
			return;
		}
		if(!aPass.equals(aRepPass)) {
			Notification.show("¡Los campos contraseña y repetición de contraseña"
					+ " deben ser iguales!", Type.WARNING_MESSAGE);
			return;
		}
		if(aPass.length() < 8) {
			Notification.show("¡La contraseña debe ser "
					+ "almenos de 8 caracteres!", Type.WARNING_MESSAGE);
			return;
		}
		if(!aEmail.contains("@")) {
			Notification.show("¡Introduce un email válido!", Type.WARNING_MESSAGE);
			return;
		}
		if(aAvatar == "") {
			aAvatar = "https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true";
		}
		
		if(adm.cargarUsuarioAdmin().size() < 5) {
			int resCrearAd = adm.registrarAdministrador(aNombre, aApellido1, aApellido2, fechaFinal, aApodo, aPass, aRepPass, aEmail, aAvatar);		

			if(resCrearAd == -1) {
				Notification.show("¡Ya existe un usuario con ese apodo!", Type.WARNING_MESSAGE);
			}
			if(resCrearAd == 0) {
				Notification.show("¡Ya existe un usuario con ese email!", Type.WARNING_MESSAGE);
			}
			if(resCrearAd == 1) {
				Notification.show("¡Administrador creado correctamente!", Type.WARNING_MESSAGE);
			}
		} else {
			Notification.show("El límite de administradores es 5. No se ha creado el administrador!");
		}
	}
}