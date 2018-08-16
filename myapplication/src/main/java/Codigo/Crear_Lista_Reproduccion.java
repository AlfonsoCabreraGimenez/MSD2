package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Video;

public class Crear_Lista_Reproduccion extends Crear_Lista_Reproduccion_ventana{
	
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	public List<CheckBox> check = new ArrayList<CheckBox>();

	public Crear_Lista_Reproduccion() {
		bBuscar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				buscarVideo(tBuscar.getValue());
			}
		});
	}
	public void buscarVideo(String buscador) {
		int cont = 0,i = 0,j = 0;
		vVideosTodos.removeAllComponents();
		TipoBusqueda aTipoBusqueda = TipoBusqueda.titulo;
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		List<Video> listB = new ArrayList<Video>();
		if(admon == null) {
			listB = ur.buscar(buscador, aTipoBusqueda);
		} else {
			listB = admin.buscar(buscador, aTipoBusqueda);
		}
		List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
		HorizontalLayout h = new HorizontalLayout();
		h.setWidth("100%");
		h.setHeight("100%");
		listaH.add(h);
		for(Video v : listB) {
			Video2 videoR = new Video2(v.getID());
			videoR.vVerticalVideoGeneral.addComponentAsFirst(new Label(v.getTitulo()));
			videoR.titulo.setVisible(false);
			videoR.categoria.setVisible(false);
			videoR.vAccionesVideo.setVisible(false);
			videoR.etiqueta.setVisible(false);
			videoR.usuario.setVisible(false);
			videoR.fechasubida.setVisible(false);
			CheckBox c = new CheckBox();
			c.setId(String.valueOf(v.getID()));
			check.add(c);
			videoR.vVideoGeneral.addComponent(check.get(j));
			listaH.get(i).addComponent(videoR);
			cont++;
			if(cont == 2) {
				HorizontalLayout h1 = new HorizontalLayout();
				h1.setWidth("100%");
				h1.setHeight("100%");
				listaH.add(h1);
				i++;
				vVideosTodos.addComponent(listaH.get(i));
				cont = 0;
			}
			j++;
		}
	}

	public void crearListaRep() {
		String titulo = tTitulo.getValue();
		ur.crearListaRep(titulo, null);
	}
}