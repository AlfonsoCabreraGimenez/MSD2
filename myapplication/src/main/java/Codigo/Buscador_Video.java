package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import Codigo.Video2;
import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Registrado;

public class Buscador_Video extends Buscador implements View {
	public Vector<Video2> _unnamed_Video2_ = new Vector<Video2>();
	
	iUsuario_No_Registrado unr = new BD_Principal();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	
	public Buscador_Video (String buscador, TipoBusqueda aTipoBusqueda) {
		panelBuscador.setVisible(true);
		panelBuscadorUs.setVisible(false);
		ordenarPor.setVisible(true);
		ordenarPorUs.setVisible(false);
		hCabeceraInicioBus.addComponentAsFirst(cc.inicio);
		hCabeceraInicioBus.addComponent(cnr.hIniciarSesionRegistrarse);
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(admon != null || registrado != null) {
			cnr.hIniciarSesionRegistrarse.setVisible(false);
			hCabeceraInicioBus.addComponent(cr.hCabeceraR);
		}
		buscar(buscador, aTipoBusqueda);
	}
	public void buscar(String buscador, TipoBusqueda aTipoBusqueda) {
		List<HorizontalLayout> hor = new ArrayList<HorizontalLayout>();
		hor.add(new HorizontalLayout());
		int cont = 0;
		int i = 0;
		for(diagramaclasesbd.Video video: unr.buscar(buscador, aTipoBusqueda)) {
				Video2 vid = new Video2(video.getID());
				hor.get(i).setHeight("-1px");
				hor.get(i).setWidth("100%");
				verticalBuscador.addComponent(hor.get(i));
				hor.get(i).addComponent(vid);
				vid.titulo.setCaption(video.getTitulo());
				Registrado reg = (Registrado) video.getUsuario_video();
				vid.usuario.setCaption(reg.getNombre());
				Categoria cat = video.getCategoria();
				vid.categoria.setValue(cat.getNombre());
				vid.etiqueta.setValue(video.getEtiqueta());
				Date fecha = video.getFechaCreacion();
				vid.fechasubida.setValue(fecha.toString());
				cont++;
				if(cont == 4) {
					hor.add(new HorizontalLayout());
					i++;
					cont = 0;
				}
		}
	}
	public void ordenarVideo(TipoOrdenacionVideo aTipoOrdenacionVideo) {
		throw new UnsupportedOperationException();
	}
}