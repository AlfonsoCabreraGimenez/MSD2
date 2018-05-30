package Codigo;

import java.util.Vector;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import Codigo.Comentario_Video_Ajeno_A_Propio_AR;

public class Visualizacion_Video_Propio_AR extends Visualizacion_Video_Comun_Registrado {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	public Video2 _unnamed_Video2_;
	public Modificar_Video _unnamed_Modificar_Video_;
	public Vector<Comentario_Video_Ajeno_A_Propio_AR> _unnamed_Comentario_Video_Ajeno_A_Propio_AR_ = new Vector<Comentario_Video_Ajeno_A_Propio_AR>();
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;
	Modificar_Video mv = new Modificar_Video();
	
	public Visualizacion_Video_Propio_AR() {
		inicializar();
		modificarVideo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(mv);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
	}
	
	
	void inicializar() {
		meGusta.setVisible(false);
		modificarVideo.setVisible(true);
		

	}

	public void habilitarComentario() {
		throw new UnsupportedOperationException();
	}

	public void deshabilitarComentario() {
		throw new UnsupportedOperationException();
	}

	public void cargarDatos() {
		throw new UnsupportedOperationException();
	}
}