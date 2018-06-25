package Codigo;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.BD_Principal;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana {

	public int idUser;
	iAdministrador2 admin = new BD_Principal();
	iUsuario_Registrado ur = new BD_Principal();
	DatosUsuario datosUser = new DatosUsuario();

	public Iniciar_Sesion() {
		List<diagramaclasesbd.Administrador> listaAdmin = admin.cargarUsuarioAdmin();
		List<diagramaclasesbd.Registrado> listaRegis = ur.cargarUsuariosRegis();
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
							//String numero = String.valueOf(datosUser.getID());
							//Notification.show(numero);
							idUser = datosUser.getID();
							UI.getCurrent().getNavigator().navigateTo("PagIR");
							
						}
				
					}

			} else { 
				diagramaclasesbd.Registrado registrado = diagramaclasesbd.RegistradoDAO.createRegistrado();
				for(int i = 0; i < listaRegis.size()-1;i++) {
					registrado = listaRegis.get(i);
					if(nombre.equals(registrado.getNombre()) && pass.equals(registrado.getPassword())) {
						datosUser.setID(registrado.getID());
						String numero = String.valueOf(datosUser.getID());
						Notification.show(numero);
						UI.getCurrent().getNavigator().navigateTo("PagIR");
					}
				}
				
			}
			
			}
		});
		
	}
	
}