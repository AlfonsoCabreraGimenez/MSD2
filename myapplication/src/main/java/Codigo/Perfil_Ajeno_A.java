package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Ajeno_A extends Perfil_Ajeno_R implements View {
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	public Usuario2 _unnamed_Usuario2_;
	public Video2 _unnamed_Video2_;
	public Conf_Eliminar_Usuario Conf_Eliminar_Usuario_ = new Conf_Eliminar_Usuario();
	
	public Perfil_Ajeno_A(){
		inicializar();
		darDeBaja.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(Conf_Eliminar_Usuario_);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
				
			}
		});
		Conf_Eliminar_Usuario_.cancelar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.close();
				
			}
		});
	}
	
	void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
	}
}