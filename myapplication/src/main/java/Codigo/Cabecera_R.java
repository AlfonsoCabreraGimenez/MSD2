package Codigo;

import java.text.ParseException;

import org.orm.PersistentException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

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
	
	Subir_Video sv = new Subir_Video();
	
	public Cabecera_R() {
		botonSubirVideo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(sv.vModificarDatosVideo);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
				
				//Subir video con el boton aceptar
				sv.confirmar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
							sv.subirVideo();
				
						popup.close();
					}
				});
				//Cerrrar el popup cuando se da a cancelar
				sv.cancelar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						popup.close();
					}
				});
			}
		});
		avatar.addClickListener(new MouseEvents.ClickListener() {
			
			@Override
			public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
				//Si es admin o registrado a un lado u otro.
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null)
				{
					Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
					try {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
						
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				}
				else 
				{
					try {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
						
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
				
				
			}
		});
		
		botonCerrarSesion.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getSession().close();
				MyUI.getCurrent().getNavigator().addView("", new Ingreso_Aplicacion());
				UI.getCurrent().getNavigator().navigateTo("");
				
			}
		});

	}
}
