package Codigo;

import java.util.List;

import org.orm.PersistentException;

import Codigo.Pag_Inicio_R;
import GY.MyUI;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

//import GY.SettingReadingSessionAttributesUI;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Usuario;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana implements View{

	iAdministrador2 admin = new BD_Principal();
	iUsuario_Registrado ur = new BD_Principal();
	
	Navigator navigator;
	public Iniciar_Sesion() {
		List<diagramaclasesbd.Administrador> listaAdmin = admin.cargarUsuarioAdmin();
		List<diagramaclasesbd.Registrado> listaRegis = ur.cargarUsuariosRegis();
		botonIniciar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				String nombre = tUsuario.getValue();
				String pass = tPass.getValue();
			if(cbAdmin.getValue() == true) 
			{
				diagramaclasesbd.Administrador administrador = diagramaclasesbd.AdministradorDAO.createAdministrador();
					for(int i = 0; i< listaAdmin.size(); i++) 
					{
						administrador = listaAdmin.get(i);
						if(nombre.equals(administrador.getNombre()) && pass.equals(administrador.getPassword())) 
						{
							UI.getCurrent().getSession().setAttribute("admin", administrador);
							//Cambiar a pagina de Inicio A o R
							MyUI.getCurrent().getNavigator().addView("Pagina_Inicio_R", new Pag_Inicio_R());
							UI.getCurrent().getNavigator().navigateTo("Pagina_Inicio_R");
						}
				
					}
					
			} else 
				{ 
					diagramaclasesbd.Registrado registrado = diagramaclasesbd.RegistradoDAO.createRegistrado();
					for(int i = 0; i < listaRegis.size();i++) 
					{
						registrado = listaRegis.get(i);
						if(nombre.equals(registrado.getNombre()) && pass.equals(registrado.getPassword()))
						{
							UI.getCurrent().getSession().setAttribute("usuario", registrado);
							MyUI.getCurrent().getNavigator().addView("Pagina_Inicio_R", new Pag_Inicio_R());
							UI.getCurrent().getNavigator().navigateTo("Pagina_Inicio_R");
						}
					}
					
				}
				
			}
		});

	}
	
}