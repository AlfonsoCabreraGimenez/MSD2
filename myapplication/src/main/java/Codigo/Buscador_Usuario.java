package Codigo;

import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import Codigo.Usuario2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Buscador_Usuario extends Buscador implements View{
	/*private Label _resultadoBusL;
	private ComboBox _ordenarUsuarioCB;*/
	public Vector<Usuario2> _unnamed_Usuario2_ = new Vector<Usuario2>();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	public Buscador_Usuario() {
		hCabeceraInicioBus.addComponentAsFirst(cc.inicio);
		hCabeceraInicioBus.addComponent(cnr.hIniciarSesionRegistrarse);
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(admon != null || registrado != null) {
			cnr.hIniciarSesionRegistrarse.setVisible(false);
			hCabeceraInicioBus.addComponent(cr.hCabeceraR);
		}
	}
	public void ordenarUsuario(TipoOrdenacionUsuario aTipoOrdenacionUsuario) {
		throw new UnsupportedOperationException();
	}
}