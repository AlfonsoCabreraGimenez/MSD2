package Codigo;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;
import org.w3c.flute.parser.ParseException;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

public class Perfil_Propio_A extends Perfil_Propio_R implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	Window popup3 = new Window();
	VerticalLayout subContent3 = new VerticalLayout();
	
	Window crearAdmin = new Window();
	VerticalLayout subContentAdmin = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Usuario2 _unnamed_Usuario2_;
	public Crear_Categoria Crear_Categoria = new Crear_Categoria();
	public Registrarse registrarseVentana = new Registrarse();
	
	iAdministrador2 adm = new BD_Principal();
	
	public Perfil_Propio_A() {
		
		super.inicializar();
		this.inicializar();

		//POR DEFECTO SE MUESTRAN TODOS LOS USUARIOS
		hUsuarios.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarUsuarios("");
			}
		});
		//BUSCADOR EN LA LISTA DE USUARIOS
		botonBuscar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				cargarUsuarios(tBuscar.getValue());
			}
		});
		/*
		 * Funcion del boton crear Categoria
		 */
		categoria.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(Crear_Categoria);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		Crear_Categoria.confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		Crear_Categoria.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		/*Funcion del boton crear administrador
		 * 
		 */
		crearAdministrador.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				crearAdmin.setContent(subContentAdmin);
				subContentAdmin.addComponent(registrarseVentana);
				crearAdmin.center();
				crearAdmin.setWidth("900px");
				crearAdmin.setModal(true);
				UI.getCurrent().addWindow(crearAdmin);
				registrarseVentana.darAlta.setVisible(true);
				registrarseVentana.cancelar.setVisible(true);
				registrarseVentana.botonRegistrarse.setVisible(false);
				registrarseVentana.darAlta.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {		
						crearAdmin.close();
					}
				});
				registrarseVentana.cancelar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {		
						crearAdmin.close();
					}
				});
			}
		});
		
	}
	
	public void inicializar() {
		categoria.setVisible(true);
		crearAdministrador.setVisible(true);
		hUsuarios.setVisible(true);
	}
	
	public void cargarUsuarios(String apodo) {
		vPanel1.removeAllComponents();
		hBuscador.setVisible(true);
		tBuscar.setPlaceholder("Buscar usuario...");
		vPanel1.addComponent(hBuscador);
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object u : adm.buscar(apodo)) {
			Usuario us;
			us = (Usuario) u;
			Usuario2 usu = new Usuario2(us.getID());
			usu.usuario.setCaption(us.getApodo());
			usu.nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(us.suscriptores.size()));
			usu.imagen.setSource(new ExternalResource(us.getAvatar()));
			listaH.get(i).addComponent(usu);
			cont++;
			if(cont == 3) {
				HorizontalLayout h1 = new HorizontalLayout();
				h1.setWidth("-1px");
				h1.setHeight("-1px");
				listaH.add(h1);
				i++;
				vPanel1.addComponent(listaH.get(i));
				cont = 0;
			}	
		}
	}
}