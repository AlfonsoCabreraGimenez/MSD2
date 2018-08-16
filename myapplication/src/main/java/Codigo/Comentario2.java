package Codigo;

import com.vaadin.event.MouseEvents;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Comentario2 extends Comentario2_ventana {
	//HERENCIA CAMBIADA
	//private TextArea _cuerpoTA;
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	iUsuario_Registrado ur = new BD_Principal();
	public Comentario2() {
		avatar.addClickListener(new MouseEvents.ClickListener() {
			
			@Override
			public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
				//Si es admin o registrado a un lado u otro.
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null)
				{
					Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				}else {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
			}
		});
		
	

	}
}