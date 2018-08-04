package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.hibernate.annotations.common.annotationfactory.AnnotationDescriptor;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.RegistradoDAO;

public class Anadir_a_ListaReproduccion extends Anadir_a_ListaReproduccion_ventana{
	/*private Label _tituloL;
	private Label _seleccionaL;*/
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	public Vector<Lista_De_Reproduccion2> _unnamed_Lista_De_Reproduccion2_ = new Vector<Lista_De_Reproduccion2>();
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	//Lista_De_Reproduccion2 listaRepro = new Lista_De_Reproduccion2();
	public int identVideo = -1;
	VerticalLayout verti = new VerticalLayout();
	
	public Anadir_a_ListaReproduccion(int idVideo) {
		this.identVideo = idVideo;

		
		//anadirAListaRep();

	}
	@SuppressWarnings("unchecked")
	public void anadirAListaRep() {
		//HAY QUE CARGAR TODOS LAS LISTAS DEL USUARIO EN CUESTION
		/*Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		List lista = null;
		if(admon == null) {
			lista = ur.cargarListaReproduccionPropia(reg.getID());
			if(lista.get(0) == null)
			{
				Notification.show("Hola es null");
			} else {
			//verticalVideo.addComponent(lista.get(0));
			}
			/*for(int i = 0; i <=lista.size()-1; i++)
			{
				listaRepro = (Lista_De_Reproduccion2) lista.get(i);
				verticalVideo.addComponent(listaRepro);
			}*/

			//verticalVideo.addComponent(listaRepro);
			
			//CARGAR LISTAS DE REPRODUCCION
		}
	/*	else {
			//SI NO, ES ADMIN
			admin.cargarListaReproduccionPropia(identVideo);
			//CARGAR LISTAS DE REPRODUCCION
		}*/
	
	public void cargarlistaReproduccion() {
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		//Video2 vid = new Video2(video.getID());
		
		for(Lista_De_Reproduccion lista : ur.cargarListaReproduccionPropia(reg.getID())) {
			Lista_De_Reproduccion2 listaR = new Lista_De_Reproduccion2(lista.getID());
			//listaR = (Lista_De_Reproduccion2) lista;
			listaR.nombreLista.setValue(lista.getTitulo());
			//Miniatura y Falta meterlos dentro del horizontal y sus vertical
			
		}

	}
	}
