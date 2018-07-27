package Codigo;

import org.orm.PersistentException;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Video2 extends Video2_ventana{
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	private TipoUsuario _usuario;
	/*public Lista_Videos_De_Reproduccion _unnamed_Lista_Videos_De_Reproduccion_;
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
	public Visualizacion_Video_Ajeno_R _unnamed_Visualizacion_Video_Ajeno_R_;*/
	
	iUsuario_Registrado ur = new BD_Principal();
	Modificar_Video mv = new Modificar_Video();
	boolean videoPropio = false;
	private int idVideo = -1;
	Boolean esVideoPropio = false;
	public Video2(int id) {
		this.idVideo = id;
		//IR A VISUALIZACION DE VIDEO
		//DIFERENCIAR SI ES ADMIN O USER Y SI ES VIDEO PROPIO O NO
		/*CREADO Metodo para ver si el video es propio o no*/
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		
		esVideoPropio = videoPropio();
		
		/*if(idVideo != -1)
		{
			videoPropio = ur.videoPropio(id);
			
		}*/
		
		titulo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(esVideoPropio == true)
				{
					//IR A PAG VIDEO PROPIO
					MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Video_Propio_AR", new Visualizacion_Video_Propio_AR(id));
					UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Video_Propio_AR");
					
				} else {
					//IR A PAG VIDEO AJENO ---- DIFERENCIAR ADMIN DE REGISTRADO
					if(reg != null && admon == null) {
						MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Ajeno_R", new Visualizacion_Video_Ajeno_R(id));
						UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Ajeno_R");

					} 
					if(admon != null && reg == null) {
						MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Ajeno_A", new Visualizacion_Video_Ajeno_A(id));
						UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Ajeno_A");
					} 
					else {
						MyUI.getCurrent().getNavigator().addView("Visualizacion_Video_Ajeno", new Visualizacion_Video_Ajeno(id));
						UI.getCurrent().getNavigator().navigateTo("Visualizacion_Video_Ajeno");
					}
				}
			}
		});
		//IR A PAGINA AJENA
		usuario.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				if(esVideoPropio == false)
				{
					if(admon == null)
					{
						MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_R", new Perfil_Ajeno_R());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_R");
					
					} else if (reg == null) {
						MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno_A", new Perfil_Ajeno_A());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno_A");
					
					} else {
						//IR A PAG Perfil Ajeno
						MyUI.getCurrent().getNavigator().addView("Perfil_Ajeno", new Perfil_Ajeno());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Ajeno");
					}
				
				} 
				else 
				{
					//IR A PAG PERFIL PROPIO ---- DIFERENCIAR ADMIN DE REGISTRADO
					if(admon == null)
					{
						try {
							MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
						} catch (PersistentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
					} 
					else 
					{
						try {
							MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
						} catch (PersistentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
					}
				}
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

	public boolean videoPropio() {
		return videoPropio = ur.videoPropio(idVideo);
	}
}