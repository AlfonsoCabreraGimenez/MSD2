package Codigo;

import com.vaadin.ui.HorizontalLayout;
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
				
				Crear_Categoria.confirmar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						
						Crear_Categoria.crearCategoria();
						popup.close();
					}
				});
				Crear_Categoria.cancelar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						popup.close();
					}
				});
				
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
				crearAdmin.setWidth("720px");
				crearAdmin.setModal(true);
				UI.getCurrent().addWindow(crearAdmin);
				registrarseVentana.botonRegistrarse.setCaption("Dar de Alta");
				registrarseVentana.botonRegistrarse.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						/*
						 * REGISTRAR UN ADMINISTRADOR
						 * 
						 */						
						String aNombre = registrarseVentana.tNombre.getValue();
						String aApellido1 = registrarseVentana.tApellido1.getValue();
						String aApellido2 = registrarseVentana.tApellido2.getValue();
						/*Parametros de la fecha*/
						String anio = Integer.toString(registrarseVentana.fechaUsuario.getValue().getYear());
						String mes = Integer.toString(registrarseVentana.fechaUsuario.getValue().getMonthValue());
						String dia = Integer.toString(registrarseVentana.fechaUsuario.getValue().getDayOfMonth());
							
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String fechaAlta = anio+"-"+mes+"-"+dia;
						Date fechaFinal = null;
						try {
							try {
								fechaFinal = formatoDelTexto.parse(fechaAlta);
							} catch (java.text.ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (ParseException ex) {
							ex.printStackTrace();
						}
						
						String aApodo = registrarseVentana.tApodo.getValue();
						String aPass = registrarseVentana.tPass.getValue();
						String aRepPass = registrarseVentana.tRepPass.getValue();
						String aEmail = registrarseVentana.tEmail.getValue();
						String aAvatar = "as";
						try {
							adm.registrarAdministrador(aNombre, aApellido1, aApellido2, fechaFinal, aApodo, aPass, aRepPass, aEmail, aAvatar);
						} catch (PersistentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
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
			Registrado us;
			us = (Registrado) u;
			Usuario2 usu = new Usuario2(us.getID());
			usu.usuario.setCaption(us.getApodo());
			usu.nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(us.suscriptores.size()));
			usu.imagen.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
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