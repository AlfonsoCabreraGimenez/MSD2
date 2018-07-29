package Codigo;

import java.util.List;
import java.util.Vector;

import org.hibernate.annotations.common.annotationfactory.AnnotationDescriptor;

import com.vaadin.ui.UI;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Anadir_a_ListaReproduccion extends Anadir_a_ListaReproduccion_ventana{
	/*private Label _tituloL;
	private Label _seleccionaL;*/
	public Visualizacion_Video_Comun_Registrado _unnamed_Visualizacion_Video_Comun_Registrado_;
	public Vector<Lista_De_Reproduccion2> _unnamed_Lista_De_Reproduccion2_ = new Vector<Lista_De_Reproduccion2>();
	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	
	public int identVideo = -1;
	
	public Anadir_a_ListaReproduccion(int idVideo) {
		this.identVideo = idVideo;

	}
	public void anadirAListaRep() {
		
		//HAY QUE CARGAR TODOS LAS LISTAS DEL USUARIO EN CUESTION
		diagramaclasesbd.Administrador admon = diagramaclasesbd.AdministradorDAO.createAdministrador();
		diagramaclasesbd.Registrado regis = diagramaclasesbd.RegistradoDAO.createRegistrado();
		List listasReproduccion = null;
		if(admon == null) {
			regis = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			ur.cargarListaReproduccionPropia(identVideo);
			//CARGAR LISTAS DE REPRODUCCION
		}
		else //SI NO, ES ADMIN
		{
			 admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			 admin.cargarListaReproduccionPropia(identVideo);
			 //CARGAR LISTAS DE REPRODUCCION
			 

		}
	}
}