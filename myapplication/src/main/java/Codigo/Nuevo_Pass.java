package Codigo;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import diagramaclasesbd.BD_Principal;

import org.apache.log4j.lf5.PassingLogRecordFilter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

public class Nuevo_Pass extends Nuevo_Pass_ventana{
	/*private TextField _nuevoPassTF;
	private TextField _repNuevoPassTF;
	private Boton _confirmarB;
	private Boton _volverB;*/
	public Registrarse _unnamed_Registrarse_;
	public Correo _unnamed_Correo_;
	
	iUsuario_No_Registrado unr = new BD_Principal();
	public Nuevo_Pass(String email) {
		inicializar();
		
		cancelar.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				for(Window windows : UI.getCurrent().getWindows()){
					windows.close();
				}
				UI.getCurrent().getNavigator().navigateTo("Ingreso_Aplicacion");
			}
		});
		confirmar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String cod = codigo.getValue();
				String pass = contrasena.getValue();
				String repPass = repetirContrasena.getValue();
				if(cod.isEmpty() || pass.isEmpty() || repPass.isEmpty()) {
					Notification.show("¡Debe rellenar todos los campos!", Type.WARNING_MESSAGE);
					return;
				}
				if(!pass.equals(repPass)) {
					Notification.show("¡Los campos contraseña y repetición de contraseña"
							+ " deben ser iguales!", Type.WARNING_MESSAGE);
					return;
				}
				if(pass.length() < 8) {
					Notification.show("¡La contraseña debe ser "
							+ "almenos de 8 caracteres!", Type.WARNING_MESSAGE);
					return;
				}
				if(nuevaPass(email, cod, pass)) {
					Notification.show("¡Contraseña cambiada, "
							+ "ya puede iniciar sesion!", Type.WARNING_MESSAGE);
					for(Window windows : UI.getCurrent().getWindows()){
						windows.close();
					}
					UI.getCurrent().getNavigator().navigateTo("Ingreso_Aplicacion");
				} else {
					Notification.show("¡El codigo introducido "
							+ "no es correcto!", Type.WARNING_MESSAGE);
				}
			}
		});
	}
	public void inicializar() {
		Notification.show("¡Escriba el codigo que ha recibido en su correo electronico"
				+ " y la nueva contraseña!", Type.WARNING_MESSAGE);
		codigo.setPlaceholder("Escriba el codigo...");
	}
	public boolean nuevaPass(String email, String codigo, String pass) {
		return unr.nuevaPass(email, codigo, pass);
	}
}