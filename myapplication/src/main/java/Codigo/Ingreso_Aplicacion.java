package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;

public class Ingreso_Aplicacion extends Ingreso_Aplicacion_ventana implements View{
	public Registrarse _unnamed_Registrarse_;
	public Iniciar_Sesion _unnamed_Iniciar_Sesion_;
	public Cabecera_NR _unnamed_Cabecera_NR_;
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Registrarse reg = new Registrarse();
	Iniciar_Sesion ini = new Iniciar_Sesion();
	
	public Ingreso_Aplicacion() {
		inicializar();
	}
	void inicializar() {
		hInicio.addComponent(cc.inicio);
		hingreso.addComponent(reg.vRegistrarse);
		hingreso.addComponent(ini.vIniciar);
		
		cc.inicio.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				MyUI.getCurrent().getNavigator().addView("Pag_Inicio_NR", new Pag_Inicio_NR());
				UI.getCurrent().getNavigator().navigateTo("Pag_Inicio_NR");
			}
		});
	}
}