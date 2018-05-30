package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Propio_A extends Perfil_Propio_R {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	//private Boton _crearCategoriaB;
	public Video2 _unnamed_Video2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Usuario2 _unnamed_Usuario2_;
	public Crear_Categoria Crear_Categoria = new Crear_Categoria();
	
	public Perfil_Propio_A() {
		
		inicializar();
		///PREGUNTAR SI REPETIR POP-UPS
	}
	
	void inicializar() {
		categoria.setVisible(true);
		categoria.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(Crear_Categoria);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
	}
}