package Codigo;

import java.util.Date;
import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Notification;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

public class Visualizacion_Video_Ajeno_A extends Visualizacion_Video_Ajeno_A_ventana implements View {
	//private Boton _borrarVideoAjenoB;
	public Video2 _unnamed_Video2_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	
	iUsuario_No_Registrado unr = new BD_Principal();
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	Comentario2 c2 = new Comentario2();
	diagramaclasesbd.Video videoA;
	public Visualizacion_Video_Ajeno_A(int idVideo){
		cargarDatosVideo(idVideo);
		inicializar();
	}
	
	public void inicializar(){
		hInicio.addComponent(cc.inicio);
		hCabeceraGeneral.addComponent(cr.hCabeceraR);
		vComentario.addComponent(c2);
		modificarVideo.setVisible(false);
		
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