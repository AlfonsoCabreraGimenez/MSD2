package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Administradores;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Conf_Eliminar_Video extends Conf_Eliminar_Video_ventana{
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	
	private int idVideo=-1;
	
	public Conf_Eliminar_Video(int id) {
		this.idVideo = id;
		//METER AQUI LAS FUNCIONES DEL ACEPTAR Y CANCELAR
		
		
	}
	
	public void borrarVideo() {
		//Hay que ver si es admin o registrado
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null)
		{
			Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			//Si el video es propio si puede borrar si no, no
			if(ur.videoPropio(idVideo, reg.getID()) == true)
			{
				ur.borrarVideo(idVideo);
			}
		} else 
		{
			admin.borrarVideo(idVideo);
		}
		
	}
}