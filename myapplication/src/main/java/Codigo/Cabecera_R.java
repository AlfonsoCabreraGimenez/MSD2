package Codigo;

import java.text.ParseException;

import org.orm.PersistentException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;

import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;

public class Cabecera_R extends Cabecera_R_ventana{
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	public Pag_Inicio_R _unnamed_Pag_Inicio_R_;
	public Subir_Video _unnamed_Subir_Video_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	
	public Cabecera_R() {
		cargarAvatar();
		Subir_Video sv = new Subir_Video();
		botonSubirVideo.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(sv.vModificarDatosVideo);
				popup.center();
				popup.setWidth("900px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		//Cerrar el popup cuando se da a confirmar
		sv.confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		//Cerrar el popup cuando se da a cancelar
		sv.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		avatar.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
				//Si es admin o registrado a un lado u otro.
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				}else {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
			}
		});
		
		botonCerrarSesion.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getSession().close();
				MyUI.getCurrent().getNavigator().addView("", new Pag_Inicio_NR());
				UI.getCurrent().getNavigator().navigateTo("");
				
			}
		});

	}
	public void cargarAvatar() {
		Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
		if(user == null) {
			user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
		}
		avatar.setSource(new ExternalResource(user.getAvatar()));
	}
}
