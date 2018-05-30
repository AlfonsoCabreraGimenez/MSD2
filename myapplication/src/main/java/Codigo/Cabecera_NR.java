package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Cabecera_NR extends Cabecera_NR_ventana implements View {
	/*private Boton _iniRegB;*/
	public Pag_Inicio_NR _unnamed_Pag_Inicio_NR_;
	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	
	public Cabecera_NR() {
		iniciarSesionRegistrarse.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("Ingreso");
			}
		});
	}
}