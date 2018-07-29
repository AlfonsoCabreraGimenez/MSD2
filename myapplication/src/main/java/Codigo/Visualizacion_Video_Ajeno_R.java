package Codigo;

import java.util.Date;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Usuario;

public class Visualizacion_Video_Ajeno_R extends Visualizacion_Video_Ajeno {
	/*private Boton _darMegustaB;
	private TextArea _escribirTA;*/
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Comentario_Video_Ajeno_R _unnamed_Comentario_Video_Ajeno_R_;
	iUsuario_No_Registrado unr = new BD_Principal();
	iUsuario_Registrado ur = new BD_Principal();
	
	Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	diagramaclasesbd.Video videoA;
	public Visualizacion_Video_Ajeno_R(int idVideo) {
		cargarDatosVideo(idVideo);
		
		hCabeceraGeneral2.addComponent(cc.horizontalInicio);
		hCabeceraGeneral2.addComponent(bus.vBuscador);
		bus.vBuscador.setVisible(false);
		hCabeceraGeneral2.addComponent(visA.cr.hCabeceraR);
		hCabeceraGeneral2.setComponentAlignment(visA.cr.hCabeceraR, Alignment.TOP_RIGHT);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		propVideo.setVisible(true);
		modificarVideo.setVisible(false);
		eliminarVideo.setVisible(false);
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
				darMegusta();
			}
		});
		
		/////////////METER AÑADIR A LISTA DE REPRODUCCION
		añadirAListaRepro.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
				
			}
		});
		
	}
	public void darMegusta() {
				ur.darMegusta(videoA.getID());
	}

	public void quitarMegusta() {
		throw new UnsupportedOperationException();
	}

	public void escribirComentario() {
		throw new UnsupportedOperationException();
	}
	public void cargarDatosVideo(int idVideo) {
		videoA = unr.cargarDatosVideo(idVideo);
	}	
}