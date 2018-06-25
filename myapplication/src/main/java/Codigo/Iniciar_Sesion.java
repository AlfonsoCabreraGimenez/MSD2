package Codigo;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.BD_Principal;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana {

	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	public Recordar_Pass _unnamed_Recordar_Pass_;
	static int idUser = -1;
	iAdministrador2 admin = new BD_Principal();
	iUsuario_Registrado ur = new BD_Principal();
	

	public Iniciar_Sesion() {
		List<diagramaclasesbd.Administrador> listaAdmin = admin.cargarUsuarioAdmin();
		DatosUsuario datosUser = new DatosUsuario();

		
		botonIniciar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				String nombre = tUsuario.getValue();
				String pass = tPass.getValue();
			if(cbAdmin.getValue() == true) {
				diagramaclasesbd.Administrador administrador = diagramaclasesbd.AdministradorDAO.createAdministrador();
					for(int i = 0; i< listaAdmin.size()-1; i++) {
						administrador = listaAdmin.get(i);
						if(nombre.equals(administrador.getNombre()) && pass.equals(administrador.getPassword())) {
							datosUser.setID(administrador.getID());
							
							UI.getCurrent().getNavigator().navigateTo("PagIR");
							
						}
				
					}

			} else {
				Notification.show("NO ERES ADMIN");
				
			}
			
			}
		});
		this.idUser = datosUser.getID();
	}
	
}