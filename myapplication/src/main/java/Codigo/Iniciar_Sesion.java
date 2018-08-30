package Codigo;

import java.util.List;

import org.orm.PersistentException;

import Codigo.Pag_Inicio_R;
import GY.MyUI;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//import GY.SettingReadingSessionAttributesUI;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Usuario;

public class Iniciar_Sesion extends Iniciar_Sesion_ventana implements View{

	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	iUsuario_No_Registrado unr = new BD_Principal();
	
	Navigator navigator;
	public Iniciar_Sesion() {
		Recordar_Pass rp = new Recordar_Pass();
		botonIniciar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(tUsuario.isEmpty() || tPass.isEmpty()) {
					Notification.show("¡Introduzca usuario y contraseña!", Type.WARNING_MESSAGE);
				} else {
					iniciarSesion(tUsuario.getValue(),tPass.getValue());
				}
			}
		});
		
		hRec.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				popup.setContent(subContent);
				subContent.addComponent(rp);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		
		rp.enviar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		
		rp.volver.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		
	}
	public void iniciarSesion(String aUser, String aPass) {
		int inicioOk = unr.iniciarSesion(aUser, aPass);
		if(inicioOk == 0 || inicioOk == 1) {
			MyUI.getCurrent().getNavigator().addView("Pagina_Inicio_R", new Pag_Inicio_R());
			UI.getCurrent().getNavigator().navigateTo("Pagina_Inicio_R");
		}
		if(inicioOk == -1) {
			Notification.show("¡Usuario y contraseña incorrectos!", Type.WARNING_MESSAGE);
		}
	}
}