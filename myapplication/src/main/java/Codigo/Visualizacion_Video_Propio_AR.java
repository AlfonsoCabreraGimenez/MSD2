package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.Usuario;

public class Visualizacion_Video_Propio_AR extends Visualizacion_Video_Comun_Registrado {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Modificar_Video _unnamed_Modificar_Video_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;
	Modificar_Video mv = new Modificar_Video();
	Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	diagramaclasesbd.Video videoA;
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	int identVideo = -1;
	public Visualizacion_Video_Propio_AR(int idVideo) {
		Anadir_a_ListaReproduccion anl = new Anadir_a_ListaReproduccion(idVideo);
		cargarDatosVideo(idVideo);
		this.identVideo = idVideo;
	
		modificarVideo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(mv);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(visA.cr.hCabeceraR);
		hCabeceraGeneral2.setComponentAlignment(visA.cr.hCabeceraR, Alignment.TOP_RIGHT);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		propVideo.setVisible(true);
		meGusta.setVisible(false);
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
				anl.anadirAListaRep();
				popup.close();
				
			}
		});
		//CANCELAR LISTA REPRO
		anl.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
			}
		});

		//CARGAR COMENTARIOS
		cargarListaComentarios();
	}
	
	public void habilitarComentario() {
		throw new UnsupportedOperationException();
	}

	public void deshabilitarComentario() {
		throw new UnsupportedOperationException();
	}

	public void cargarDatosVideo(int idVideo) {
		videoA = unr.cargarDatosVideo(idVideo);
	}	
	public void cargarListaComentarios() {
		List<Comentario> listC = new ArrayList<Comentario>();
		vComentario.removeAllComponents();
		for(Comentario coment : ur.cargarListaComentarios(identVideo)){
			Comentario2 com = new Comentario2();
			vComentario.addComponent(com);
			com.areaComentario.setValue(coment.getDescripcion());
			Usuario us = (Usuario) coment.getUsuario_comentario();
			com.apodo.setCaption(us.getApodo());
			com.avatar.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
			com.bComentario.setVisible(false);
		}
	}
}