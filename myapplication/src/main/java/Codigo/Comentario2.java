package Codigo;

import com.vaadin.event.MouseEvents;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Comentario;
import diagramaclasesbd.ComentarioDAO;
import diagramaclasesbd.PersistentException;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.RegistradoDAO;
import diagramaclasesbd.UsuarioDAO;

public class Comentario2 extends Comentario2_ventana {
	//HERENCIA CAMBIADA
	//private TextArea _cuerpoTA;
	public int idComentario=-1;
	public int idVid=-1;
	Window popup2 = new Window();
	VerticalLayout subContent2 = new VerticalLayout();
	
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	iUsuario_Registrado ur = new BD_Principal();
	
	public Comentario2(int idComent, int idVideo) {
		this.idComentario = idComent;
		this.idVid=idVideo;
		
		Conf_Eliminar_Comentario confElimi = new Conf_Eliminar_Comentario(idComent);
		avatar.addClickListener(new MouseEvents.ClickListener() {
			
			@Override
			public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
				//Si es admin o registrado a un lado u otro.
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null)
				{
					Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
				}else {
					MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
					UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
				}
			}
		});
		
		bEliminarComentario1.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.setContent(subContent2);
				subContent2.addComponent(confElimi.vGeneralEliminarComentario);
				popup2.center();
				popup2.setWidth("720px");
				popup2.setModal(true);
				UI.getCurrent().addWindow(popup2);
			}
		});
		
		confElimi.aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			//SI EL COMENTARIO ES PROPIO QUE VAYA  A VISUALIZACION VIDEO AJENO Y DIFERENCIA ENTRE ADMIN O REGIS
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				if(admon == null)
				{
					Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
					//VEMOS SI EL COMENTARIO ES SUYO O NO
					Registrado regis = RegistradoDAO.getRegistradoByORMID(registrado.getID());
					Comentario coment=null;
					try {
						coment = ComentarioDAO.loadComentarioByORMID(idComentario);
						} catch (PersistentException e) {
							e.printStackTrace();
						}
					if(regis.es_escrito.contains(coment)== true)
					{
						MyUI.getCurrent().getNavigator().addView("Visualizacion_Video_Ajeno_R", new Visualizacion_Video_Ajeno_R(idVideo));
						UI.getCurrent().getNavigator().navigateTo("Visualizacion_Video_Ajeno_R");
					} else 
					{
						MyUI.getCurrent().getNavigator().addView("Visualizacion_Video_Propio_AR", new Visualizacion_Video_Propio_AR(idVideo));
						UI.getCurrent().getNavigator().navigateTo("Visualizacion_Video_Ajeno_AR");
					}

				}
				else 
				{
					Administrador admin = (Administrador)UsuarioDAO.getUsuarioByORMID(admon.getID());
					Comentario coment = null;
					try {
						coment = ComentarioDAO.loadComentarioByORMID(idComentario);
						} catch (PersistentException e) {
							e.printStackTrace();
						}
						
					//VER SI EL COMENTARIO ES SUYO
					if(admin.es_escrito.contains(coment))
					{
						MyUI.getCurrent().getNavigator().addView("Visualizacion_Video_Ajeno_A", new Visualizacion_Video_Ajeno_A(idVideo));
						UI.getCurrent().getNavigator().navigateTo("Visualizacion_Video_Ajeno_A");
					} else 
					{
						MyUI.getCurrent().getNavigator().addView("Visualizacion_Video_Propio_AR", new Visualizacion_Video_Propio_AR(idVideo));
						UI.getCurrent().getNavigator().navigateTo("Visualizacion_Video_Ajeno_AR");
					}

				}
			}
		});
		confElimi.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});

	}
}