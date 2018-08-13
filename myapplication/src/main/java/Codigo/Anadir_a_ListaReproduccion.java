package Codigo;

import java.awt.Checkbox;
import java.util.ArrayList;
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
	public List<CheckBox> check = new ArrayList<CheckBox>();
	public Anadir_a_ListaReproduccion(int idVideo) {
		this.identVideo = idVideo;
	}

	public void anadirAListaRep() {
		for(CheckBox c : check) {
			if(c.getValue() == true) {
				int idLista = Integer.parseInt(c.getId());
				ur.anadirAListaRep(this.identVideo, idLista);
			}
		}
	}
	
	public void cargarListaReproduccionPropia() {
		int cont = 0,i = 0,j = 0;
		//vListasTodas.removeAllComponents();
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
			listaR.imagen.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
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
