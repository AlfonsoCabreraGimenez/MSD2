package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Cabecera_Comun extends Cabecera_Comun_ventana implements View{

	public Cabecera_Comun() {
		inicio.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
				Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				if(admon == null && reg == null) {
					MyUI.getCurrent().getNavigator().addView("Pag_Inicio_NR", new Pag_Inicio_NR());
					UI.getCurrent().getNavigator().navigateTo("Pag_Inicio_NR");
				} else {
					MyUI.getCurrent().getNavigator().addView("Pag_Inicio_R", new Pag_Inicio_R());
					UI.getCurrent().getNavigator().navigateTo("Pag_Inicio_R");
				}
			}
		});
	}
}