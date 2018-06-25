package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

public class Pag_Inicio_R extends Pag_Inicio_NR implements View {

	public Cabecera_R _unnamed_Cabecera_R_;
	public Video2 _unnamed_Video2_ = new Video2();
	
	//Pag_Inicio_R_ventana pgr = new Pag_Inicio_R_ventana();
	//Cabecera_Comun cc = new Cabecera_Comun();
	//Cabecera_R cr = new Cabecera_R();
	Buscador bus = new Buscador();
	Pag_Inicio_NR pnr = new Pag_Inicio_NR();
	Iniciar_Sesion is = new Iniciar_Sesion();
	public int id = is.datosUser.getID();
	
	public Pag_Inicio_R(){
		
		
		String numero = String.valueOf(id);
		Notification.show(numero);
		
		
		
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
				
				UI.getCurrent().getNavigator().navigateTo("PPropioR");
			}
		});
	}
	public void cargar_Videos_Inicio_R() {
		prv.hPanelVideosVreciente.addComponent(_unnamed_Video2_.vVerticalVideoGeneral);
		
	}
}