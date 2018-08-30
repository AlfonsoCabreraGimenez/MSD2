package Codigo;

import java.util.Date;

import org.hibernate.cfg.AvailableSettings;
import org.orm.PersistentException;

import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Administradores;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

import com.vaadin.ui.Notification;

public class Pag_Inicio_R extends Pag_Inicio_NR implements View {

	public Cabecera_R _unnamed_Cabecera_R_;
//	public Video2 _unnamed_Video2_ = new Video2();
	iUsuario_Registrado ur = new BD_Principal();
	iUsuario_No_Registrado unr = new BD_Principal();
	iAdministrador2 admon = new BD_Principal();
	
	//Pag_Inicio_R_ventana pgr = new Pag_Inicio_R_ventana();
	//Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	//Buscador bus = new Buscador();

	//Navigator navigator;
	int idUser = -1;
	public Pag_Inicio_R(){

		hCabeceraInicioBus.addComponent(cr.hCabeceraR);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		vListasR.setVisible(true);
		
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null) {
			Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			idUser = reg.getID();
		} else {
			idUser = admon.getID();
		}
		cargar_Videos_Inicio_R();
	}
	public void cargar_Videos_Inicio_R() {
		cargar_Videos_Suscriptores();
	}
	public void cargar_Videos_Suscriptores() {
		int cont = 0;
		for(Video video: ur.cargar_Videos_Suscriptores(idUser)) {
				Video2 vid = new Video2(video.getID());
				hPanelVideosOtrosUser.addComponent(vid);
				vid.titulo.setCaption(video.getTitulo());
				Usuario us = (Usuario) video.getUsuario_video();
				vid.usuario.setCaption(us.getApodo());
				Categoria cat = video.getCategoria();
				vid.categoria.setValue(cat.getNombre());
				vid.miniatura.setSource(new ExternalResource(video.getMiniatura()));
				vid.etiqueta.setValue(video.getEtiqueta());
				Date fecha = video.getFechaCreacion();
				vid.fechasubida.setValue(fecha.toString());
				vid.vAccionesVideo.setVisible(false);
				cont++;
				if(cont == 10) {
					break;
				}
		}
	}
}