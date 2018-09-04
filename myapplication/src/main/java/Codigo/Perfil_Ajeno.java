package Codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.event.MouseEvents.DoubleClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

public class Perfil_Ajeno extends Perfil_Ajeno_ventana implements View{
	/*private Label _suscriptoresL;
	private Label _visitasL;
	private Label _apodoL;
	private Imagen _avatarI;
	private Boton _videosB;
	private Boton _listaReproduccionB;
	private Boton _suscripcionesB;
	private Boton _suscriptoresB;
	private Boton _suscribirseB;*/
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Registrarse _unnamed_Registrarse_;

	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_NR cnr = new Cabecera_NR();
	Usuario user;
	iUsuario_No_Registrado unr = new BD_Principal();
	
	public Perfil_Ajeno() {
		
	}
	
	public Perfil_Ajeno(int idUser){
		inicializar();
		aumentarVisitas(idUser);
		cargarDatosUsuario(idUser);
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
	}
	
	void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cnr);
		suscribirse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				MyUI.getCurrent().getNavigator().addView("Ingreso_Aplicacion", new Ingreso_Aplicacion());
				UI.getCurrent().getNavigator().navigateTo("Ingreso_Aplicacion");
			}
		});
		darDeBaja.setVisible(false);
	}
	
	public void aumentarVisitas(int idUser) {
		unr.aumentarVisitas(idUser);
	}
	
	public void cargarDatosUsuario(int idUser) {
		user = unr.cargarDatosUsuario(idUser);
	}
	public void cargarPerfilAjenoNR(Usuario user) {
		nSuscriptores.setValue("Nº Suscriptores: " + String.valueOf(user.suscriptores.size()));
		apodo.setCaption(user.getApodo());
		nVisitas.setValue("Visitas: "+ String.valueOf(user.getVisitas()));
		imagen.setSource(new ExternalResource(user.getAvatar()));
	}
	
	public void cargarVideosAjenoNR(Usuario user) {
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object v : user.prop_video_de.getCollection())
		{
			Video vid;
			vid = (Video) v;
			Video2 video = new Video2(vid.getID());
			video.categoria.setValue(vid.getCategoria().getNombre());
			video.titulo.setCaption(vid.getTitulo());
			Date fecha = vid.getFechaCreacion();
			video.fechasubida.setValue(fecha.toString());
			video.usuario.setCaption(user.getApodo());
			video.etiqueta.setValue(vid.getEtiqueta());
			video.miniatura.setSource(new ExternalResource(vid.getMiniatura()));
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			if(admon == null) {
				video.vAccionesVideo.setVisible(false);
			} else {
				video.modificarVideo.setVisible(false);
			}
			listaH.get(i).addComponent(video);
			cont++;
			if(cont == 4) {
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
	
	public void cargarListasAjenoNR(Usuario user) {
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
		h.setHeight("-1px");
		listaH.add(h);
		vPanel1.addComponent(listaH.get(i));
		for(Object l : user.prop_de.getCollection())
		{
			Lista_De_Reproduccion lis;
			lis = (Lista_De_Reproduccion) l;
			Lista_De_Reproduccion2 lista = new Lista_De_Reproduccion2(lis.getID());
			lista.nombreLista.setValue(lis.getTitulo());
			lista.vBorrar.setVisible(false);
			List<Video> v = Arrays.asList(lis.video.toArray());
			lista.imagen.setSource(new ExternalResource(v.get(0).getMiniatura()));
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
				h1.setWidth("100%");
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
		for(Video vid : unr.cargar_Videos_ListaReproduccion(idLista)) {
			Video2 video = new Video2(vid.getID());
			video.categoria.setValue(vid.getCategoria().getNombre());
			video.titulo.setCaption(vid.getTitulo());
			Date fecha = vid.getFechaCreacion();
			video.fechasubida.setValue(fecha.toString());
			video.usuario.setCaption(vid.getUsuario_video().getNombre());
			video.etiqueta.setValue(vid.getEtiqueta());
			video.miniatura.setSource(new ExternalResource(vid.getMiniatura()));
			video.vAccionesVideo.setVisible(false);
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
	
	public void cargarSuscripcionesAjenoNR(Usuario user) {
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
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
				h1.setWidth("100%");
				h1.setHeight("-1px");
				listaH.add(h1);
				i++;
				vPanel1.addComponent(listaH.get(i));
				cont = 0;
			}	
		}
	}
	
	public void cargarSuscriptoresAjenoNR(Usuario user) {
		vPanel1.removeAllComponents();
		int cont = 0, i = 0;
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
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
			usu.setWidth("100%");
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
}