package Codigo;

import org.orm.PersistentException;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Buscador extends Buscador_ventana{
	/*private RadioButton _tituloRB;
	private RadioButton _categoriaRB;
	private RadioButton _etiquetaRB;
	private RadioButton _apodoRB;
	private TextField _buscarTF;*/
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_R cr = new Cabecera_R();
	public Pag_Inicio_NR _unnamed_Pag_Inicio_NR_;
	public Buscador() {
		botonBuscar.addClickListener(new ClickListener() {	
			@Override
			public void buttonClick(ClickEvent event) {
				if(rButons.isSelected("Usuarios")) {
						MyUI.getCurrent().getNavigator().addView("Buscador_usuario", new Buscador_Usuario());
						UI.getCurrent().getNavigator().navigateTo("Buscador_usuario");
				} else {
					MyUI.getCurrent().getNavigator().addView("Buscador_video", new Buscador_Video());
					UI.getCurrent().getNavigator().navigateTo("Buscador_video");
				}
			}
		});
	}
	public void buscar(TipoBusqueda aTipoBusqueda) {
		throw new UnsupportedOperationException();
	}

	public void buscar() {
		throw new UnsupportedOperationException();
	}
}