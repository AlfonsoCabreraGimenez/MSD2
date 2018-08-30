package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;
import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;

public class Visualizacion_Video_Propio_AR extends Visualizacion_Video_Ajeno {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	Window popup3 = new Window();
	VerticalLayout subContent3 = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Modificar_Video _unnamed_Modificar_Video_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;

	//Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	Cabecera_R cr = new Cabecera_R();
	diagramaclasesbd.Video videoA;
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	int identVideo = -1;
	public Visualizacion_Video_Propio_AR(int idVideo) {
		Anadir_a_ListaReproduccion anl = new Anadir_a_ListaReproduccion(idVideo);
		Conf_Eliminar_Video ev = new Conf_Eliminar_Video(idVideo, "PagVis");
		/*Pasamos string con la pagina desde donde se abre el modificar video para poder recargar
		despues de modificar un video y saber en que pagina estabamos*/ 
		Modificar_Video mv = new Modificar_Video(idVideo, "PagVis");
		cargarDatosVideo(idVideo);
		this.identVideo = idVideo;
		
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(cr.hCabeceraR);
		hCabeceraGeneral2.setComponentAlignment(cr.hCabeceraR, Alignment.TOP_RIGHT);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		propVideo.setVisible(true);
		meGusta.setVisible(false);
		escribirComentario.setVisible(false);
		comentar.setVisible(false);
		htituloComentario.setVisible(true);
		vComentario.setVisible(true);
	
		vDatosUser.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null) {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				} else {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
			}
		});
		
		modificarVideo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(mv);
				popup.center();
				popup.setWidth("900px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		mv.confirmar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		mv.cancelar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				popup.close();
			}
		});
		
		//DESCARGAR VIDEO
		descargar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				descargarVideo();
			}
		});
		//ELIMINAR VIDEO
		eliminarVideo.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				popup3.setContent(subContent3);
				subContent3.addComponent(ev.vVerticalEliminarVideo);
				popup3.center();
				popup3.setWidth("720px");
				//popup.setClosable(false);
				popup3.setModal(true);
				UI.getCurrent().addWindow(popup3);
			}
		});
		//ACEPTAR DE ELIMINAR VIDEO CIERRA EL POPUP
		ev.aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup3.close();
			}
		});
		//CANCELAR DE ELIMINAR VIDEO CIERRA EL POPUP
		ev.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup3.close();
			}
		});				
		
		/////////////METER AÑADIR A LISTA DE REPRODUCCION
		añadirAListaRepro.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(anl.vVerticalAnadir);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
				anl.cargarListaReproduccionPropia();
			}
		});
		//ACEPTAR DE AGREGAR A LISTA DE REPRO
		anl.confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
				
			}
		});
		//CANCELAR LISTA REPRO
		anl.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});
		//HABILITAR/DESHABILITAR COMENTARIOS
		bloquearComentario.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(vComentario.isVisible()) {
					vComentario.setVisible(false);
				} else {
					vComentario.setVisible(true);
				}
			}
		});
		//CARGAR COMENTARIOS
		cargarListaComentarios();
	}
	
	/*public void habilitarComentario() {
		throw new UnsupportedOperationException();
	}

	public void deshabilitarComentario() {
		throw new UnsupportedOperationException();
	}*/

	public void cargarDatosVideo(int idVideo) {
		videoA = unr.cargarDatosVideo(idVideo);
		
		tituloVideo.setValue("Titulo: " + videoA.getTitulo());
		Categoria cat = videoA.getCategoria();
		categoriaEtiqueta.setValue("Categoria: " + cat.getNombre());
		descripcion.setValue("Descripcion: " + videoA.getDescripcion() + "\n\nEtiquetas: " + videoA.getEtiqueta() 
		+ "\n\nUrl: "+ videoA.getUrl());
		Usuario us = videoA.getUsuario_video();
		fotoUser.setSource(new ExternalResource(us.getAvatar()));
		apodo.setCaption(us.getApodo());
		nVisualizaciones.setValue(String.valueOf(videoA.getVisualizaciones() + " visualizaciones"));
		nGusta.setValue(String.valueOf(videoA.getMegusta() + " me gusta"));
		Date fecha = videoA.getFechaCreacion();
		fechaSubida.setValue("Fecha subida: " + fecha.toString());
		//VISUALIZAR VIDEO
		Embedded v = new Embedded(null, new ExternalResource(videoA.getUrl()));
		v.setMimeType("application/x-shockwave-flash");
		v.setParameter("allowFullScreen", "true");
		v.setWidth("1000px");
		v.setHeight("450px");
		vvideo.addComponentAsFirst(v);
	}	
	public void cargarListaComentarios() {
		vComentario.removeAllComponents();
		for(Comentario coment : ur.cargarListaComentarios(identVideo)){
			Comentario2 com = new Comentario2(coment.getID(), coment.getUsuario_comentario(), identVideo, "propio");
			vComentario.addComponent(com);
			com.areaComentario.setValue(coment.getDescripcion());
			Usuario us = (Usuario) coment.getUsuario_comentario();
			com.apodo.setCaption(us.getApodo());
			com.avatar.setSource(new ExternalResource(us.getAvatar()));
			com.bEliminarComentario1.setVisible(true);
		}
	}
	public void descargarVideo() {
		Notification not = new Notification("Copia el enlace que hay en la descripción y "
				+ "pégalo en la página que se ha abierto", Notification.Type.WARNING_MESSAGE);
		not.setDelayMsec(5000);
		not.show(Page.getCurrent());
		getUI().getPage().open("http://google.com", "_blank");
	}
}