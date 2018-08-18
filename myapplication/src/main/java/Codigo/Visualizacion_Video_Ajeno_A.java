package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.List;
import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

public class Visualizacion_Video_Ajeno_A extends Visualizacion_Video_Ajeno implements View {
	//private Boton _borrarVideoAjenoB;
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	iAdministrador2 adm = new BD_Principal();
	
	diagramaclasesbd.Video videoA;
	int identVideo = -1;
	
	public Visualizacion_Video_Ajeno_A(int idVideo){
		Anadir_a_ListaReproduccion anl = new Anadir_a_ListaReproduccion(idVideo);
		cargarDatosVideo(idVideo);
		
		this.identVideo = idVideo;
		
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(visA.cr.hCabeceraR);
		hCabeceraGeneral2.setComponentAlignment(visA.cr.hCabeceraR, Alignment.TOP_RIGHT);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		propVideo.setVisible(true);
		modificarVideo.setVisible(false);
		escribirComentario.setVisible(true);
		comentar.setVisible(true);
		htituloComentario.setVisible(true);
		vComentario.setVisible(true);
		
		
		tituloVideo.setValue(videoA.getTitulo());
		Categoria cat = videoA.getCategoria();
		categoriaEtiqueta.setValue(cat.getNombre());
		descripcion.setValue(videoA.getDescripcion());
		Usuario us = videoA.getUsuario_video();
		fotoUser.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
		apodo.setCaption(us.getApodo());
		nVisualizaciones.setValue(String.valueOf(videoA.getVisualizaciones() + " visualizaciones"));
		nGusta.setValue(String.valueOf(videoA.getMegusta() + " me gusta"));
		Date fecha = videoA.getFechaCreacion();
		fechaSubida.setValue(fecha.toString());
		
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
	public void cargarDatosVideo(int idVideo) {
		videoA = adm.cargarDatosVideo(idVideo);
	}	
	public void darQuitarMegusta() {
		if(adm.darQuitarMegusta(videoA.getID())) {
			Notification.show("¡Te ha gustado el video!");
		} else {
			Notification.show("¡Ya no te gusta el video!");
		}
	}
	public void escribirComentario(String texto) {
		adm.escribirComentario(texto, identVideo);
		cargarListaComentarios();
	}
	public void cargarListaComentarios() {
		vComentario.removeAllComponents();
		for(Comentario coment : adm.cargarListaComentarios(identVideo)){
			Comentario2 com = new Comentario2(coment.getID());
			vComentario.addComponent(com);
			com.areaComentario.setValue(coment.getDescripcion());
			Usuario us = (Usuario) coment.getUsuario_comentario();
			com.apodo.setCaption(us.getApodo());
			com.avatar.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
			com.bEliminarComentario1.setVisible(true);
		}
	}
}