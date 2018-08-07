package diagramaclasesbd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.print.DocFlavor.READER;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Lista_De_Reproduccion;

public class BD_Listas_De_Reproduccion {
	public BD_Principal _bd_prin_listasrep;
	public Vector<Lista_De_Reproduccion> _contiene_listasrep = new Vector<Lista_De_Reproduccion>();

	public List cargar_Lista_Reproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public void anadirAListaRep(int aID, int idLista) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Lista_De_Reproduccion lista = Lista_De_ReproduccionDAO.getLista_De_ReproduccionByORMID(idLista);
			Video video = VideoDAO.getVideoByORMID(aID);
			lista.video.add(video);
			Lista_De_ReproduccionDAO.save(lista);
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
			diagramaclasesbd.Lista_De_Reproduccion lista = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
			lista.setTitulo(aTitulo);
			if(admon == null)
			{
				diagramaclasesbd.Registrado registrado = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(reg.getID());
			
				lista.setEs_prop_lista(registrado);
				registrado.prop_de.add(lista);
				diagramaclasesbd.RegistradoDAO.save(registrado);
				diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
				//diagramaclasesbd.RegistradoDAO.save(registrado);
			} else {
				diagramaclasesbd.Administrador administrador = diagramaclasesbd.AdministradorDAO.getAdministradorByORMID(admon.getID());
				lista.setEs_prop_lista(administrador);
				administrador.prop_de.add(lista);
				//diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
				diagramaclasesbd.AdministradorDAO.save(administrador);	
				diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
			}

			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List<Lista_De_Reproduccion> cargarListasReproduccionPropia(int idUsuario) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Lista_De_Reproduccion> listaRes = new ArrayList<Lista_De_Reproduccion>();
		try {
			for(Object lista : RegistradoDAO.getRegistradoByORMID(idUsuario).prop_de.getCollection()) {
				Lista_De_Reproduccion listaR;
				listaR = (Lista_De_Reproduccion) lista;
				listaRes.add(listaR);
			}
			t.commit();
		} catch(Exception e) {
			t.rollback();
		}
		return listaRes;
	}
}