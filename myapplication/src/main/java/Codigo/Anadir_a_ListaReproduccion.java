package Codigo;

import java.util.Vector;

import com.vaadin.ui.UI;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Anadir_a_ListaReproduccion {
	/*private Label _tituloL;
	private Label _seleccionaL;*/
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	public Vector<Lista_De_Reproduccion2> _unnamed_Lista_De_Reproduccion2_ = new Vector<Lista_De_Reproduccion2>();

	
	public Anadir_a_ListaReproduccion(int idVideo) {
		//HAY QUE CARGAR TODOS LAS LISTAS DEL USUARIO EN CUESTION
		diagramaclasesbd.Administrador admon = diagramaclasesbd.AdministradorDAO.createAdministrador();
		diagramaclasesbd.Registrado regis = diagramaclasesbd.RegistradoDAO.createRegistrado();
		if(admon == null) {
			regis = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");			
			//CARGAR LISTAS DE REPRODUCCION
		}
		else //SI NO, ES ADMIN
		{
			 admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			 //CARGAR LISTAS DE REPRODUCCION
			 

		}
	}
	public void anadirAListaRep() {
		
		throw new UnsupportedOperationException();
	}
}