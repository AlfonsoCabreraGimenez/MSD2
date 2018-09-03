package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;

import com.vaadin.ui.Embedded;
import java.lang.Thread;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;

public class Visualizacion_Video_Ajeno_R extends Visualizacion_Video_Ajeno {
	/*private Boton _darMegustaB;
	private TextArea _escribirTA;*/
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	
	iUsuario_Registrado ur = new BD_Principal();
	
	//Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	diagramaclasesbd.Video videoA;
	Cabecera_R cr = new Cabecera_R();
	int identVideo = -1;
	
	public Visualizacion_Video_Ajeno_R(int idVideo) {
	
		Anadir_a_ListaReproduccion anl = new Anadir_a_ListaReproduccion(idVideo);
		aumentarVisualizaciones(idVideo);
		cargarDatosVideo(idVideo);
		anadirHistorial(idVideo);
		this.identVideo = idVideo;
		
		
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(cr.hCabeceraR);
		hCabeceraGeneral2.setComponentAlignment(cr.hCabeceraR, Alignment.TOP_RIGHT);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		propVideo.setVisible(true);
		modificarVideo.setVisible(false);
		eliminarVideo.setVisible(false);
		escribirComentario.setVisible(true);
		escribirComentario.setPlaceholder("Escribir comentario...");
		comentar.setVisible(true);
		bloquearComentario.setVisible(false);
		vComentario.setVisible(true);
		
		vDatosUser.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub
				MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_R", new Perfil_Ajeno_R(videoA.getUsuario_video().getID()));
				UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_R");
			}
		});

		descargar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				descargarVideo();
			}
		});
		
		meGusta.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				darQuitarMegusta();
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
		
		//ESCRIBIR COMENTARIO
		comentar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				escribirComentario(escribirComentario.getValue());
			}
		});

		//CARGAR COMENTARIOS
		cargarListaComentarios();
		
	}
	public void darQuitarMegusta() {
		if(ur.darQuitarMegusta(videoA.getID())) {
			Notification.show("¡Te ha gustado el video!");
		} else {
			Notification.show("¡Ya no te gusta el video!");
		}
	}
	public void escribirComentario(String texto) {
		ur.escribirComentario(texto, identVideo);
		cargarListaComentarios();
	}
	
	public void aumentarVisualizaciones(int idVideo) {
		ur.aumentarVisualizaciones(idVideo);
	}
	
	public void cargarDatosVideo(int idVideo) {
		videoA = ur.cargarDatosVideo(idVideo);
		
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
		 v.setHeight("350px");
		 creadoVideo.addComponent(v);
	}	
	public void cargarListaComentarios() {
		vComentario.removeAllComponents();
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		Usuario regis = ur.cargarDatosUsuario(registrado.getID());
		for(Comentario coment : ur.cargarListaComentarios(identVideo)){
			Comentario2 com = new Comentario2(coment.getID(),coment.getUsuario_comentario(), identVideo, "ajenoR");
			vComentario.addComponent(com);
			com.areaComentario.setValue(coment.getDescripcion());
			Usuario us = (Usuario) coment.getUsuario_comentario();
			com.apodo.setCaption(us.getApodo());
			com.avatar.setSource(new ExternalResource(us.getAvatar()));
			if(regis.es_escrito.contains(coment)){
				com.bEliminarComentario1.setVisible(true);
			} else {
				com.bEliminarComentario1.setVisible(false);
			}
		}
	}
	public void descargarVideo() {
		Notification not = new Notification("Copia el enlace que hay en la descripción y "
				+ "pégalo en la página que se ha abierto", Notification.Type.WARNING_MESSAGE);
		not.setDelayMsec(5000);
		not.show(Page.getCurrent());
		getUI().getPage().open("http://google.com", "_blank");
	}
	public void anadirHistorial(int idVideo) {
		ur.anadirHistorial(idVideo);
	}
}