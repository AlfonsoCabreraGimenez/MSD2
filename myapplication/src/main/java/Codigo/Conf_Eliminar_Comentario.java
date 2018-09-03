package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

import diagramaclasesbd.BD_Principal;

public class Conf_Eliminar_Comentario extends Conf_Eliminar_Comentario_ventana{

	
	iUsuario_Registrado ur = new BD_Principal();
	
	public Conf_Eliminar_Comentario(int idComent) {
		aceptar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				eliminarComentario(idComent);
			}
		});
	}
	public void eliminarComentario(int idComent) {
		ur.eliminarComentario(idComent);
	}
}