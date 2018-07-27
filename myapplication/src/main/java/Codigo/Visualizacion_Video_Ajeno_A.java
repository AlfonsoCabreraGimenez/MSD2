package Codigo;

import java.util.Date;
import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

public class Visualizacion_Video_Ajeno_A extends Visualizacion_Video_Ajeno implements View {
	//private Boton _borrarVideoAjenoB;
	public Video2 _unnamed_Video2_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();

	diagramaclasesbd.Video videoA;
	public Visualizacion_Video_Ajeno_A(int idVideo){
		cargarDatosVideo(idVideo);
		
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
	}
	public void cargarDatosVideo(int idVideo) {
		videoA = unr.cargarDatosVideo(idVideo);
	}	
}