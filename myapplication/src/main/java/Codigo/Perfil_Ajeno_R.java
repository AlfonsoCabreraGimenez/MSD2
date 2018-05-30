package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Ajeno_R extends Perfil_Ajeno implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Conf_Suscribirse Conf_Suscribirse = new Conf_Suscribirse();

	public Perfil_Ajeno_R(){
		inicializar();
		suscribirse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(Conf_Suscribirse);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
	}
	
	void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
		darDeBaja.setVisible(false);
	}
	public void suscribirse() {
		throw new UnsupportedOperationException();
	}
}