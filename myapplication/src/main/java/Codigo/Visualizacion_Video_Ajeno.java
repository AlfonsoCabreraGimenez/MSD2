package Codigo;

import java.util.Date;

import org.hibernate.engine.HibernateIterator;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Usuario;

public class Visualizacion_Video_Ajeno extends Visualizacion_Video_Ajeno_ventana implements View{
	
	public Video2 _unnamed_Video2_;
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	//Cabecera_R cr = new Cabecera_R();
	Buscador bus = new Buscador();
	iUsuario_No_Registrado unr = new BD_Principal();
	diagramaclasesbd.Video videoA;
	public Visualizacion_Video_Ajeno() {
		
		
	}
	public Visualizacion_Video_Ajeno(int idVideo) {
		aumentarVisualizaciones(idVideo);
		cargarDatosVideo(idVideo);
		inicializar();

	}
	void inicializar() {
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(cnr.hIniciarSesionRegistrarse);
		hCabeceraGeneral2.setComponentAlignment(cnr.hIniciarSesionRegistrarse, Alignment.TOP_RIGHT);
		propVideo.setVisible(false);
		escribirComentario.setVisible(false);
		comentar.setVisible(false);
		htituloComentario.setVisible(false);
		vComentario.setVisible(false);
		propVideo.setVisible(false);
		
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
		//VISUALIZAR VIDEO
				Embedded v = new Embedded(null, new ExternalResource(videoA.getUrl()));
				 v.setMimeType("application/x-shockwave-flash");
				 v.setParameter("allowFullScreen", "true");
				 v.setWidth("1000px");
				 v.setHeight("450px");
				vvideo.addComponentAsFirst(v);
		
	}
	
	public void aumentarVisualizaciones(int idVideo) {
		unr.aumentarVisualizaciones(idVideo);
	}
	
	public void cargarDatosVideo(int idVideo) {
		videoA = unr.cargarDatosVideo(idVideo);
	}	
}