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
		aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				borrarVideo(id);
			}
		});
		
	}
	
	public void borrarVideo(int id) {
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null) {
			ur.borrarVideo(id);
		} else {
			admin.borrarVideo(id);
		}

	}
}