package Codigo;

import com.vaadin.event.MouseEvents;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Comentario2 extends Comentario2_ventana {
	//HERENCIA CAMBIADA
	//private TextArea _cuerpoTA;
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	iUsuario_Registrado ur = new BD_Principal();
	public Comentario2(int idComent) {
		Conf_Eliminar_Comentario confElimi = new Conf_Eliminar_Comentario(idComent);
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
		
		bEliminarComentario1.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.setContent(subContent2);
				subContent2.addComponent(confElimi.vGeneralEliminarComentario);
				popup2.center();
				popup2.setWidth("720px");
				popup2.setModal(true);
				UI.getCurrent().addWindow(popup2);
			}
		});
		
		confElimi.aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
		confElimi.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});

	}
}