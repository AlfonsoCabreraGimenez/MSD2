package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Cabecera_Comun extends Cabecera_Comun_ventana implements View{
	//private Boton _incioB;
	public Cabecera_Comun() {
		inicio.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("inicioNR");
			}
		});
	}
}