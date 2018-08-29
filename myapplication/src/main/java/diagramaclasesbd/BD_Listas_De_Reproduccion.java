package diagramaclasesbd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.print.DocFlavor.READER;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import Codigo.Lista_De_Reproduccion2;
import diagramaclasesbd.Lista_De_Reproduccion;

public class BD_Listas_De_Reproduccion {
	public BD_Principal _bd_prin_listasrep;
	public Vector<Lista_De_Reproduccion> _contiene_listasrep = new Vector<Lista_De_Reproduccion>();

	public List cargar_Lista_Reproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public boolean anadirAListaRep(int aID, int idLista) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		boolean anadido = false;
		try {
			Lista_De_Reproduccion lista = Lista_De_ReproduccionDAO.getLista_De_ReproduccionByORMID(idLista);
			Video video = VideoDAO.getVideoByORMID(aID);
			if(!lista.video.contains(video)) {
				lista.video.add(video);
				anadido = true;
			}
			Lista_De_ReproduccionDAO.save(lista);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return anadido;
	}

	public void borrarLista(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		Lista_De_Reproduccion listaR = Lista_De_ReproduccionDAO.getLista_De_ReproduccionByORMID(aID);
		try {
			Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(user == null) {
				user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
			}
			Usuario usuario = UsuarioDAO.getUsuarioByORMID(user.getID());
			usuario.prop_de.remove(listaR);
			UsuarioDAO.save(usuario);
			Lista_De_ReproduccionDAO.deleteAndDissociate(listaR);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
	
	
	public void crearListaRep(String aTitulo, List<Video> aVideo) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Usuario user = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(user == null) {
				user = (Usuario) UI.getCurrent().getSession().getAttribute("usuario");
			}
			Usuario usuario = UsuarioDAO.getUsuarioByORMID(user.getID());
			Lista_De_Reproduccion lista = Lista_De_ReproduccionDAO.createLista_De_Reproduccion();
			lista.setTitulo(aTitulo);
			lista.setEs_prop_lista(usuario);
			for(Video v : aVideo) {
				lista.video.add(v);
			}
			usuario.prop_de.add(lista);
			UsuarioDAO.save(usuario);
			Lista_De_ReproduccionDAO.save(lista);
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List<Lista_De_Reproduccion> cargarListasReproduccionPropia(int idUsuario) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Lista_De_Reproduccion> listaRes = new ArrayList<Lista_De_Reproduccion>();
		try {
			for(Object lista : UsuarioDAO.getUsuarioByORMID(idUsuario).prop_de.getCollection()) {
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
	public boolean eliminarVideoListaReproduccion(int idLista, int idVideo) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		boolean borrado = false;
		try {
			Lista_De_Reproduccion lista = Lista_De_ReproduccionDAO.getLista_De_ReproduccionByORMID(idLista);
			Video video = VideoDAO.getVideoByORMID(idVideo);
			lista.video.remove(video);
			Lista_De_ReproduccionDAO.save(lista);
			borrado = true;
			t.commit();
		} catch(Exception e) {
			t.rollback();
		}
		return borrado;
	}

}