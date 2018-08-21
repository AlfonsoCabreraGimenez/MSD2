package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import Codigo.Usuario2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Registrado;

public class Buscador_Usuario extends Buscador implements View{
	/*private Label _resultadoBusL;
	private ComboBox _ordenarUsuarioCB;*/
	public Vector<Usuario2> _unnamed_Usuario2_ = new Vector<Usuario2>();
	iUsuario_No_Registrado unr = new BD_Principal();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	public Buscador_Usuario(String busqueda) {
		panelBuscador.setVisible(false);
		panelBuscadorUs.setVisible(true);
		ordenarPor.setVisible(false);
		ordenarPorUs.setVisible(true);
		hCabeceraInicioBus.addComponentAsFirst(cc.inicio);
		hCabeceraInicioBus.addComponent(cnr.hIniciarSesionRegistrarse);
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		if(admon != null || registrado != null) {
			cnr.hIniciarSesionRegistrarse.setVisible(false);
			hCabeceraInicioBus.addComponent(cr.hCabeceraR);
		}
		buscar(busqueda);
	}
	public void buscar(String busqueda) {
		List<HorizontalLayout> hor = new ArrayList<HorizontalLayout>();
		hor.add(new HorizontalLayout());
		int cont = 0;
		int i = 0;
		for(diagramaclasesbd.Registrado usuario: unr.buscar(busqueda)) {
				Usuario2 usu = new Usuario2(usuario.getID());
				hor.get(i).setHeight("-1px");
				hor.get(i).setWidth("100%");
				verticalBuscadorUs.addComponent(hor.get(i));
				hor.get(i).addComponent(usu);
				usu.usuario.setCaption(usuario.getApodo());
				usu.nSuscriptores.setValue("Nº Suscriptores: " + 
						String.valueOf(usuario.suscriptores.size()));
				cont++;
				if(cont == 4) {
					hor.add(new HorizontalLayout());
					i++;
					cont = 0;
				}
		}
	}
	public void ordenarUsuario(TipoOrdenacionUsuario aTipoOrdenacionUsuario) {
		throw new UnsupportedOperationException();
	}
}