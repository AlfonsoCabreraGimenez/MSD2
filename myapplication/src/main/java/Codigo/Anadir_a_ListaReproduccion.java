package Codigo;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.GroupLayout.Alignment;

import org.hibernate.annotations.common.annotationfactory.AnnotationDescriptor;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.RegistradoDAO;
import diagramaclasesbd.Video;

public class Anadir_a_ListaReproduccion extends Anadir_a_ListaReproduccion_ventana{
	/*private Label _tituloL;
	private Label _seleccionaL;*/
	public Vector<Lista_De_Reproduccion2> _unnamed_Lista_De_Reproduccion2_ = new Vector<Lista_De_Reproduccion2>();
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	//Lista_De_Reproduccion2 listaRepro = new Lista_De_Reproduccion2();
	public int identVideo = -1;
	VerticalLayout verti = new VerticalLayout();
	public List<CheckBox> check = new ArrayList<CheckBox>();
	public Anadir_a_ListaReproduccion(int idVideo) {
		this.identVideo = idVideo;
		
		confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				anadirAListaRep();
			}
		});
	}

	public void anadirAListaRep() {
		int idLista = -1;
		boolean anadido = false;
		for(CheckBox c : check) {
			if(c.getValue() == true) {
				idLista = Integer.parseInt(c.getId());
			}
		}
		if(idLista == -1) {
			Notification.show("¡No se ha agregado el video! "
					+ "Debe seleccionar una lista de reproduccion", Type.WARNING_MESSAGE);
		} else {
			ur.anadirAListaRep(this.identVideo, idLista);
		}
		if(!anadido) {
			Notification.show("La lista de reproduccion "
					+ "seleccionada ya contiene este video", Type.WARNING_MESSAGE);
		}
	}
	
	public void cargarListaReproduccionPropia() {
		int cont = 0,i = 0,j = 0;
		vListasTodas.removeAllComponents();
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		List<Lista_De_Reproduccion> listPropia = new ArrayList<Lista_De_Reproduccion>();
		if(admon == null) {
			listPropia = ur.cargarListaReproduccionPropia(reg.getID());
		} else {
			listPropia = admin.cargarListaReproduccionPropia(admon.getID());
		}
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
		h.setHeight("100%");
		listaH.add(h);
		for(Lista_De_Reproduccion lista : listPropia) {
			Lista_De_Reproduccion2 listaR = new Lista_De_Reproduccion2(lista.getID());
			listaR.nombreLista.setValue(lista.getTitulo());
			listaR.vBorrar.setVisible(false);
			List<Video> v = Arrays.asList(lista.video.toArray());
			listaR.imagen.setSource(new ExternalResource(v.get(0).getMiniatura()));
			CheckBox c = new CheckBox();
			c.setId(String.valueOf(lista.getID()));
			c.addFocusListener(event -> {
	                for(CheckBox c1 : check) {
	                	if(c1.getId() != c.getId()) {
	                		c1.setValue(false);
	                	}
	                }
	            });
			check.add(c);
			listaR.vListaRep2.addComponent(check.get(j));
			listaH.get(i).addComponent(listaR.vListaRep);
			vListasTodas.addComponent(listaH.get(i));
			cont++;
			if(cont == 2) {
				HorizontalLayout h1 = new HorizontalLayout();
				h1.setWidth("100%");
				h1.setHeight("100%");
				listaH.add(h1);
				i++;
				vListasTodas.addComponent(listaH.get(i));
				cont = 0;
			}
			j++;
		}
	}
	}
