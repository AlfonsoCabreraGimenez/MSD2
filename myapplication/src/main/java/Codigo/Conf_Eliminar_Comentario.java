package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

import diagramaclasesbd.BD_Principal;

public class Conf_Eliminar_Comentario extends Conf_Eliminar_Comentario_ventana{
	/*private Label _confirmarL;
	private Boton _aceptarB;
	private Boton _cancelarB;*/
	public Comentario_Video_Ajeno_R _unnamed_Comentario_Video_Ajeno_R_;
	public Comentario_Video_Ajeno_A_Propio_AR _unnamed_Comentario_Video_Ajeno_A_Propio_AR_;
	
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