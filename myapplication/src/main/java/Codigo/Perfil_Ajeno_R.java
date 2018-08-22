package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import diagramaclasesbd.BD_Principal;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

public class Perfil_Ajeno_R extends Perfil_Ajeno implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	Window popup1 = new Window();
	VerticalLayout subContent1 = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	
	iUsuario_Registrado ur = new BD_Principal();
	
	public Perfil_Ajeno_R() {
		
	}
	
	public Perfil_Ajeno_R(int idUser){
		Conf_Suscribirse Conf_Suscribirse = new Conf_Suscribirse(idUser);
		Conf_Cancelar_Suscribirse Conf_Canc_Susc = new Conf_Cancelar_Suscribirse(idUser);
		
		inicializar();
		comprobarSuscripcion(idUser);
		cargarPerfilAjenoNR(idUser);
		cargarVideosAjenoNR(idUser);
		
		hVideos.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarVideosAjenoNR(idUser);
			}
		});
		
		hListas.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarListasAjenoNR(idUser);
			}
		});
		
		hSuscripciones.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscripcionesAjenoNR(idUser);
			}
		});
		
		hSuscriptores.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscriptoresAjenoNR(idUser);
			}
		});
		
		suscribirse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(Conf_Suscribirse);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		Conf_Suscribirse.aceptar.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		Conf_Suscribirse.cancelar.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		
		cancSuscripcion.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup1.setContent(subContent1);
				subContent1.addComponent(Conf_Canc_Susc);
				popup1.center();
				popup1.setWidth("720px");
				//popup.setClosable(false);
				popup1.setModal(true);
				UI.getCurrent().addWindow(popup1);
			}
		});
		
		Conf_Canc_Susc.aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup1.close();
			}
		});
		
		Conf_Canc_Susc.cancelar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup1.close();
			}
		});
	}
	
	public void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
		darDeBaja.setVisible(false);
	}
	
	public void comprobarSuscripcion(int idUser) {
		boolean suscrito = ur.comprobarSuscripcion(idUser);
		if(suscrito) {
			suscribirse.setVisible(false);
			cancSuscripcion.setVisible(true);
		}
	}
	
	/*public void suscribirse() {
		throw new UnsupportedOperationException();
	}*/
}