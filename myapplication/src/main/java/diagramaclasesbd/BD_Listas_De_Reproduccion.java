package diagramaclasesbd;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import diagramaclasesbd.Lista_De_Reproduccion;

public class BD_Listas_De_Reproduccion {
	public BD_Principal _bd_prin_listasrep;
	public Vector<Lista_De_Reproduccion> _contiene_listasrep = new Vector<Lista_De_Reproduccion>();

	public List cargar_Lista_Reproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public void anadirAListaRep(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarLista(int aID) {
		throw new UnsupportedOperationException();
	}
	public void crearListaRep(String aTitulo, List aVideo) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Lista_De_Reproduccion lista = diagramaclasesbd.Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
			//diagramaclasesbd.Video videos = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
			diagramaclasesbd.Registrado registrado = diagramaclasesbd.RegistradoDAO.getRegistradoByORMID(1);
			
			lista.setTitulo(aTitulo);
			lista.setEs_prop_lista(registrado);
			diagramaclasesbd.RegistradoDAO.save(registrado);
			diagramaclasesbd.Lista_De_ReproduccionDAO.save(lista);
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}
}