package Codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

public class Perfil_Propio_R extends Perfil_Propio_R_ventana implements View{
	Window popup = new Window();
	Window popup2 = new Window();
	
	VerticalLayout subContent = new VerticalLayout();
	VerticalLayout subContent2 = new VerticalLayout();
	
	/*public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Crear_Lista_Reproduccion _unnamed_Crear_Lista_Reproduccion_;
	public Modificar_Datos_Usuario _unnamed_Modificar_Datos_Usuario_;
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;
	Registrarse registro = new Registrarse();*/
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	
	Modificar_Datos_Usuario mdu = new Modificar_Datos_Usuario();
	Crear_Lista_Reproduccion clr = new Crear_Lista_Reproduccion();
	iUsuario_Registrado ur = new BD_Principal();	

	public Perfil_Propio_R(){
		

		inicializar();
		cargarPerfilPropioR();
		cargarVideosPropiosR();
		
		hVideos.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarVideosPropiosR();
			}
		});
		
		hListas.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarListasPropiasR();
			}
		});
		
		hSuscripciones.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscripcionesPropiasR();
			}
		});
		
		hSuscriptores.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				cargarSuscriptoresPropiosR();
			}
		});
		
		modificarDatos.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(mdu);
				popup.center();
				popup.setWidth("900px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		
		mdu.modificarDatosUser.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		
		mdu.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		
		crearListaReproduccion.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup2.setContent(subContent2);
				subContent2.addComponent(clr);
				popup2.center();
				popup2.setWidth("720px");
				//popup.setClosable(false);
				popup2.setModal(true);
				UI.getCurrent().addWindow(popup2);
			}
		});
		
		clr.cancelar.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
		
		clr.confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
		
	}
	
	void inicializar(){
		hCabeceraInicio.addComponent(cc.inicio);
		hCabeceraRegistrado.addComponent(cr.avatar);
		hCabeceraRegistrado.addComponent(cr.botonSubirVideo);
		hCabeceraRegistrado.addComponent(cr.botonCerrarSesion);
		crearAdministrador.setVisible(false);
		categoria.setVisible(false);
		hBuscador.setVisible(false);
	}
	public void borrarVideo() {
		throw new UnsupportedOperationException();
	}

	public void cargarPerfilPropioR() {
		Usuario user;
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(registrado == null) {
			Usuario admin = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			user = ur.cargarDatosUsuario(admin.getID());
		} else {
			user = ur.cargarDatosUsuario(registrado.getID());
		}
		nVisitas.setValue(String.valueOf(user.getVisitas()));
		apodo.setCaption(user.getApodo());
		nombre.setValue(user.getNombre());
		apellidos.setValue(user.getApellido1()+" "+user.getApellido2());
		email.setValue(user.getEmail());
		fNacimiento.setValue(String.valueOf(user.getFechaN()));
		imagen.setSource(new ExternalResource(user.getAvatar()));
		nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(user.suscriptores.size()));
	} 	
	
	public void cargarVideosPropiosR() {
		Usuario user;
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(registrado == null) {
			Usuario admin = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			user = ur.cargarDatosUsuario(admin.getID());
		} else {
			user = ur.cargarDatosUsuario(registrado.getID());
		}
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object v : user.prop_video_de.getCollection())
		{
			Video vid;
			vid = (Video) v;
			Video2 video = new Video2(vid.getID());
			video.categoria.setValue(String.valueOf(vid.getCategoria()));
			video.titulo.setCaption(vid.getTitulo());
			Date fecha = vid.getFechaCreacion();
			video.fechasubida.setValue(fecha.toString());
			video.usuario.setCaption(user.getNombre());
			video.etiqueta.setValue(vid.getEtiqueta());
			video.miniatura.setSource(new ExternalResource(vid.getMiniatura()));
			listaH.get(i).addComponent(video);
			cont++;
			if(cont == 4) {
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
	
	public void cargarListasPropiasR() {
		Usuario user;
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(registrado == null) {
			Usuario admin = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			user = ur.cargarDatosUsuario(admin.getID());
		} else {
			user = ur.cargarDatosUsuario(registrado.getID());
		}
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object l : user.prop_de.getCollection())
		{
			Lista_De_Reproduccion lis;
			lis = (Lista_De_Reproduccion) l;
			Lista_De_Reproduccion2 lista = new Lista_De_Reproduccion2(lis.getID());
			lista.nombreLista.setValue(lis.getTitulo());
			lista.vBorrar.setVisible(true);
			lista.imagen.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
			lista.setWidth("270px");
			lista.setHeight("270px");
			lista.vImagen.addLayoutClickListener(new LayoutClickListener() {
				@Override
				public void layoutClick(LayoutClickEvent event) {
					// TODO Auto-generated method stub
					cargarVideosLista(lis.getID());
				}
			});
			listaH.get(i).addComponent(lista);
			cont++;
			if(cont == 5) {
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
	
	public void cargarVideosLista(int idLista) {
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Video vid : ur.cargar_Videos_ListaReproduccion(idLista)) {
			Video2 video = new Video2(vid.getID());
			video.categoria.setValue(String.valueOf(vid.getCategoria()));
			video.titulo.setCaption(vid.getTitulo());
			Date fecha = vid.getFechaCreacion();
			video.fechasubida.setValue(fecha.toString());
			video.usuario.setCaption(vid.getUsuario_video().getNombre());
			video.etiqueta.setValue(vid.getEtiqueta());
			video.miniatura.setSource(new ExternalResource(vid.getMiniatura()));
			video.modificarVideo.setVisible(false);
			video.eliminarVideo.setVisible(false);
			video.borrarDeLista.setVisible(true);
			video.borrarDeLista.addClickListener(new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					eliminarVideoListaReproduccion(idLista, vid.getID());
				}
			});
			listaH.get(i).addComponent(video);
			cont++;
			if(cont == 4) {
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
	
	public void cargarSuscripcionesPropiasR() {
		Usuario user;
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(registrado == null) {
			Usuario admin = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			user = ur.cargarDatosUsuario(admin.getID());
		} else {
			user = ur.cargarDatosUsuario(registrado.getID());
		}
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object u : user.suscripciones.getCollection()) {
			Usuario us;
			us = (Usuario) u;
			Usuario2 usu = new Usuario2(us.getID());
			usu.usuario.setCaption(us.getApodo());
			usu.nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(us.suscriptores.size()));
			usu.imagen.setSource(new ExternalResource(us.getAvatar()));
			usu.setHeight("-1px");
			usu.setWidth("100%");
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
	
	public void cargarSuscriptoresPropiosR() {
		Usuario user;
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(registrado == null) {
			Usuario admin = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			user = ur.cargarDatosUsuario(admin.getID());
		} else {
			user = ur.cargarDatosUsuario(registrado.getID());
		}
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("-1px");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object u : user.suscriptores.getCollection()) {
			Usuario us;
			us = (Usuario) u;
			Usuario2 usu = new Usuario2(us.getID());
			usu.usuario.setCaption(us.getApodo());
			usu.nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(us.suscriptores.size()));
			usu.imagen.setSource(new ExternalResource(us.getAvatar()));
			usu.setHeight("-1px");
			usu.setWidth("-1px");
			listaH.get(i).addComponent(usu);
			cont++;
			if(cont == 3) {
				HorizontalLayout h1 = new HorizontalLayout();
				h1.setWidth("100%");
				h1.setHeight("-1px");
				listaH.add(h1);
				i++;
				vPanel1.addComponent(listaH.get(i));
				cont = 0;
			}	
		}
	}
	public void eliminarVideoListaReproduccion(int idLista, int idVideo) {
		if(ur.eliminarVideoListaReproduccion(idLista, idVideo)) {
			Notification.show("¡Video eliminado de la lista de reproduccion!", Type.WARNING_MESSAGE);
		}
		
	}
}