package Codigo;

import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import Codigo.Video2;
import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Buscador_Video extends Buscador implements View {
	public Vector<Video2> _unnamed_Video2_ = new Vector<Video2>();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	public Buscador_Video (TipoBusqueda busqueda) {
		hCabeceraInicioBus.addComponentAsFirst(cc.inicio);
		hCabeceraInicioBus.addComponent(cnr.hIniciarSesionRegistrarse);
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(admon != null || registrado != null) {
			cnr.hIniciarSesionRegistrarse.setVisible(false);
			hCabeceraInicioBus.addComponent(cr.hCabeceraR);
		}
		Notification.show(busqueda.toString());
	}
	public void ordenarVideo(TipoOrdenacionVideo aTipoOrdenacionVideo) {
		throw new UnsupportedOperationException();
	}
}