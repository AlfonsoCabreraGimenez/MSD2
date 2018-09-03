package Codigo;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.ComentarioDAO;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.RegistradoDAO;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.UsuarioDAO;

public class Comentario2 extends Comentario2_ventana {
	//HERENCIA CAMBIADA
	//private TextArea _cuerpoTA;

	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	

	iUsuario_Registrado ur = new BD_Principal();
	
	public Comentario2(int idComent, Usuario user , int idVideo, String pag) {
		
		Conf_Eliminar_Comentario confElimi = new Conf_Eliminar_Comentario(idComent);
		hApodoFoto.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				if(admon != null) {
					if(admon.getID() == user.getID()) {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_R());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
					} else {
						MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_A", new Perfil_Ajeno_A(user.getID()));
						UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_A");
					}
				} else {
					if(reg.getID() == user.getID()) {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
					} else {
						MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_R", new Perfil_Ajeno_R(user.getID()));
						UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_R");
					}
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
				if(pag == "ajenoR") {
					MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Ajeno_R", new Visualizacion_Video_Ajeno_R(idVideo));
					UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Ajeno_R");
				}
				if(pag == "ajenoA") {
					MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Ajeno_A", new Visualizacion_Video_Ajeno_A(idVideo));
					UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Ajeno_A");
				}
				if(pag == "propio") {
					MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Video_Propio_AR", new Visualizacion_Video_Propio_AR(idVideo));
					UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Video_Propio_AR");
				}
			}
		});
		confElimi.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});

	}
}