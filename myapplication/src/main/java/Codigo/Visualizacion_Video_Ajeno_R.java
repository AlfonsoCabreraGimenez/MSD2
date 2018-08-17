package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

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
	
	public Video2 _unnamed_Video2_;
	public Comentario_Video_Ajeno_R _unnamed_Comentario_Video_Ajeno_R_;
	
	iUsuario_Registrado ur = new BD_Principal();
	
	Visualizacion_Video_Ajeno visA = new Visualizacion_Video_Ajeno();
	diagramaclasesbd.Video videoA;
	int identVideo = -1;
	
	public Visualizacion_Video_Ajeno_R(int idVideo) {
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
		eliminarVideo.setVisible(false);
		escribirComentario.setVisible(true);
		comentar.setVisible(true);
		htituloComentario.setVisible(true);
		vComentario.setVisible(true);
		
		
		
		
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
	public void cargarDatosVideo(int idVideo) {
		videoA = ur.cargarDatosVideo(idVideo);
		
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
	public void cargarListaComentarios() {
		List<Comentario> listC = new ArrayList<Comentario>();
		vComentario.removeAllComponents();
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		Comentario2 com = new Comentario2();
		for(Comentario coment : ur.cargarListaComentarios(identVideo)){
			//Hay que ver si es comentario propio y añadir el boton de eliminar
			if(registrado.es_escrito.contains(coment) == true)
			{
				//Comentario2 com = new Comentario2();
				vComentario.addComponent(com);
				com.areaComentario.setValue(coment.getDescripcion());
				Usuario us = (Usuario) coment.getUsuario_comentario();
				com.apodo.setCaption(us.getApodo());
				com.avatar.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
				com.bEliminarComentario1.setVisible(true);
			} 
			else 
			{
				//Comentario2 com = new Comentario2();
				vComentario.addComponent(com);
				com.areaComentario.setValue(coment.getDescripcion());
				Usuario us = (Usuario) coment.getUsuario_comentario();
				com.apodo.setCaption(us.getApodo());
				com.avatar.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
				com.bEliminarComentario1.setVisible(false);
			}
		}
		
	}
}