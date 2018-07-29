package diagramaclasesbd;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import diagramaclasesbd.Lista_De_Reproduccion;

public class BD_Listas_De_Reproduccion {
	public BD_Principal _bd_prin_listasrep;
	public Vector<Lista_De_Reproduccion> _contiene_listasrep = new Vector<Lista_De_Reproduccion>();

	public List cargar_Lista_Reproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public void anadirAListaRep(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
	}

	public void borrarLista(int aID) {
		throw new UnsupportedOperationException();
	}
	public void crearListaRep(String aTitulo, List aVideo) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");			
			if(admon == null)
			{
				diagramaclasesbd.Lista_De_Reproduccion lista = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
				//diagramaclasesbd.Video videos = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
				diagramaclasesbd.Registrado registrado = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(reg.getID());
				
				lista.setTitulo(aTitulo);
				lista.setEs_prop_lista(registrado);
				diagramaclasesbd.RegistradoDAO.save(registrado);
				diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
				
				t.commit();
			} 
			else 
			{
				diagramaclasesbd.Lista_De_Reproduccion lista = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
				//diagramaclasesbd.Video videos = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
				diagramaclasesbd.Administrador administrador = diagramaclasesbd.AdministradorDAO.getAdministradorByORMID(admon.getID());
				
				lista.setTitulo(aTitulo);
				lista.setEs_prop_lista(admon);
				diagramaclasesbd.AdministradorDAO.save(admon);
				diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
				
				t.commit();
			}
			
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List cargarListasReproduccionPropia(int identVideo) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Lista_De_Reproduccion> listasPropias = Lista_De_ReproduccionDAO.queryLista_De_Reproduccion(null, null);
		Administrador admon = diagramaclasesbd.AdministradorDAO.createAdministrador();
		Registrado regis = diagramaclasesbd.RegistradoDAO.createRegistrado();
		if (admon == null) {
			/////////////////////////////////////////////////////////////////////POR HACER
			regis = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			RegistradoCriteria regisC = new RegistradoCriteria();
			Lista_De_ReproduccionCriteria listaC = new Lista_De_ReproduccionCriteria();
			listaC.createCriteria(String.valueOf(regis.getID()));
			
			for(int i = 0; i<=listasPropias.size()-1;i++) 
			{
				listasPropias.get(i);
			}
		}

		
		
		return listasPropias;
	}
}