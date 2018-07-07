package Codigo;

import org.orm.PersistentException;

import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Administradores;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;

import com.vaadin.ui.Notification;

public class Pag_Inicio_R extends Pag_Inicio_NR implements View {

	public Cabecera_R _unnamed_Cabecera_R_;
	public Video2 _unnamed_Video2_ = new Video2();
	iUsuario_Registrado ur = new BD_Principal();
	iUsuario_No_Registrado unr = new BD_Principal();
	iAdministrador2 admon = new BD_Principal();
	
	//Pag_Inicio_R_ventana pgr = new Pag_Inicio_R_ventana();
	//Cabecera_Comun cc = new Cabecera_Comun();
	//Cabecera_R cr = new Cabecera_R();
	Buscador bus = new Buscador();
	Pag_Inicio_NR pnr = new Pag_Inicio_NR();
	Navigator navigator;
	 	
	public Pag_Inicio_R(){


		hCabeceraInicioBus.addComponent(pnr.cr.hCabeceraR);
		cnr.iniciarSesionRegistrarse.setVisible(false);
		addComponent(prv.videosRelacionados);
		addComponent(prv.panelVR);//aqui añadimos los videos que cargamos
		addComponent(prv.videosOtrosUser);
		addComponent(prv.panelVideosOtrosUser);
		addComponent(prv.videosVreciente);
		addComponent(prv.panelVideosVreciente);
		
		cargar_Videos_Inicio_R();
		cc.inicio.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				
				try {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public void cargar_Videos_Inicio_R() {
		prv.hPanelVideosVreciente.addComponent(_unnamed_Video2_.vVerticalVideoGeneral);
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null)
		{
			Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			Notification.show(String.valueOf(registrado.getID()));
			//CARGAR VIDEOS DE REGISTRADO
			/*
			//Mas me gusta
			unr.cargar_Videos_Masmegusta();
			//Ultimos videos subido
			unr.cargar_Videos_Ultimos();
			//videos relacionados (ID DEL USUARIO)
			ur.cargar_Videos_Relacionados(registrado.getID());
			//videos de otros usuarios (ID DEL USUARIO)
			ur.cargar_Videos_Suscriptores(registrado.getID());
			//videos vistos recientemente (ID DEL USUARIO)
			ur.cargar_Videos_Historial(registrado.getID());
			
			*/
			
		}
		else 
		{
			//CARGAR VIDEOS DE ADMINISTRADOR
			Notification.show(String.valueOf(admon.getID()));
			
		}
	}
}