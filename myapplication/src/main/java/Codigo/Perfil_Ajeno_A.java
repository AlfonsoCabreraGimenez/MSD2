package Codigo;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Usuario;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

public class Perfil_Ajeno_A extends Perfil_Ajeno_R implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	Window popup1 = new Window();
	VerticalLayout subContent1 = new VerticalLayout();
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	Usuario user;
	iAdministrador2 admin = new BD_Principal();
	
	public Usuario2 _unnamed_Usuario2_;
	public Video2 _unnamed_Video2_;
	

	
	public Perfil_Ajeno_A(int idUser){
		Conf_Suscribirse Conf_Suscribirse = new Conf_Suscribirse(idUser);
		Conf_Cancelar_Suscribirse Conf_Canc_Susc = new Conf_Cancelar_Suscribirse(idUser);
		Conf_Eliminar_Usuario Conf_Eliminar_Usuario_ = new Conf_Eliminar_Usuario(idUser);
		
		inicializar();
		aumentarVisitas(idUser);
		cargarDatosUsuario(idUser);
		comprobarSuscripcion(idUser);
		cargarPerfilAjenoNR(user);
		cargarVideosAjenoNR(user);
		
		hVideos.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarVideosAjenoNR(user);
			}
		});
		
		hListas.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarListasAjenoNR(user);
			}
		});
		
		hSuscripciones.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscripcionesAjenoNR(user);
			}
		});
		
		hSuscriptores.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscriptoresAjenoNR(user);
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
		
		darDeBaja.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.setContent(subContent2);
				subContent2.addComponent(Conf_Eliminar_Usuario_);
				popup2.center();
				popup2.setWidth("720px");
				//popup.setClosable(false);
				popup2.setModal(true);
				UI.getCurrent().addWindow(popup2);
				
			}
		});
		Conf_Eliminar_Usuario_.aceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
		
		Conf_Eliminar_Usuario_.cancelar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
	}
	
	public void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
		darDeBaja.setVisible(true);
	}
	public void cargarDatosUsuario(int idUser) {
		user = admin.cargarDatosUsuario(idUser);
	}
}