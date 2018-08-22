package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Conf_Eliminar_Lista extends Conf_Eliminar_Lista_ventana{
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;
	public Lista_Lista_De_Reproducci�n_Propia _unnamed_Lista_Lista_De_Reproducci�n_Propia_;*/
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	

	
	public void borrarLista(int id) {
		//Iteraciones con la bbdd
		//Solo debe de ser borrada por el usuario que inicia sesion
		//Que en teoria es el usuario que se mete en su perfil
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null ) {
			ur.borrarLista(id);
		}
		else 
		{
			admin.borrarLista(id);
		}
	}
}