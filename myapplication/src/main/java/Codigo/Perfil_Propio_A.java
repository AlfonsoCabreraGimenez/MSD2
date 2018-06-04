package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Propio_A extends Perfil_Propio_R implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();

	public Video2 _unnamed_Video2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Usuario2 _unnamed_Usuario2_;
	public Crear_Categoria Crear_Categoria = new Crear_Categoria();
	
	public Perfil_Propio_A() throws PersistentException{
		
		inicializar();
		categoria.setVisible(true);

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
				
				Crear_Categoria.confirmar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						
						Crear_Categoria.crearCategoria();
						popup.close();
					}
				});
				Crear_Categoria.cancelar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						popup.close();
					}
				});
				
			}
		});
	}
}