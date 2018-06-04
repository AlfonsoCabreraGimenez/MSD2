package Codigo;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Video2 extends Video2_ventana{
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	private TipoUsuario _usuario;
	public Lista_Videos_De_Reproduccion _unnamed_Lista_Videos_De_Reproduccion_;
	public Pag_Inicio_NR _unnamed_Pag_Inicio_NR_;
	public Pag_Inicio_R _unnamed_Pag_Inicio_R_;
	public Buscador_Video _unnamed_Buscador_Video_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Perfil_Ajeno_R _unnamed_Perfil_Ajeno_R_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public Perfil_Ajeno_A _unnamed_Perfil_Ajeno_A_;
	public Visualizacion_Video_Ajeno _unnamed_Visualizacion_Video_Ajeno_;
	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	public Visualizacion_Video_Ajeno_A _unnamed_Visualizacion_Video_Ajeno_A_;
	public Visualizacion_Video_Ajeno_R _unnamed_Visualizacion_Video_Ajeno_R_;
	
	Modificar_Video mv = new Modificar_Video();
	
	public Video2() {
		//IR A VISUALIZACION DE VIDEO
		titulo.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("VisAjeno");
			}
		});
		//IR A PAGINA AJENA
		usuario.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("PAjeno");
			}
		});
		modificarVideo.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(mv);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
				
				mv.confirmar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
							mv.modificarDatosVideo();
				
						popup.close();
					}
				});
				//Cerrrar el popup cuando se da a cancelar
				mv.cancelar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						popup.close();
			}
		});
				
			}
		});
	}
}