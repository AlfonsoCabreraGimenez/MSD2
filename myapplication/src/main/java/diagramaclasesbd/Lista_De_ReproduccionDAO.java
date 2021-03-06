/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package diagramaclasesbd;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Lista_De_ReproduccionDAO {
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadLista_De_ReproduccionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion getLista_De_ReproduccionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getLista_De_ReproduccionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadLista_De_ReproduccionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion getLista_De_ReproduccionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getLista_De_ReproduccionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Lista_De_Reproduccion) session.load(diagramaclasesbd.Lista_De_Reproduccion.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion getLista_De_ReproduccionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Lista_De_Reproduccion) session.get(diagramaclasesbd.Lista_De_Reproduccion.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Lista_De_Reproduccion) session.load(diagramaclasesbd.Lista_De_Reproduccion.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion getLista_De_ReproduccionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Lista_De_Reproduccion) session.get(diagramaclasesbd.Lista_De_Reproduccion.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLista_De_Reproduccion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryLista_De_Reproduccion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLista_De_Reproduccion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryLista_De_Reproduccion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion[] listLista_De_ReproduccionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listLista_De_ReproduccionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion[] listLista_De_ReproduccionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listLista_De_ReproduccionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLista_De_Reproduccion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Lista_De_Reproduccion as Lista_De_Reproduccion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLista_De_Reproduccion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Lista_De_Reproduccion as Lista_De_Reproduccion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lista_De_Reproduccion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion[] listLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLista_De_Reproduccion(session, condition, orderBy);
			return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion[] listLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLista_De_Reproduccion(session, condition, orderBy, lockMode);
			return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadLista_De_ReproduccionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadLista_De_ReproduccionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Lista_De_Reproduccion[] lista_De_Reproduccions = listLista_De_ReproduccionByQuery(session, condition, orderBy);
		if (lista_De_Reproduccions != null && lista_De_Reproduccions.length > 0)
			return lista_De_Reproduccions[0];
		else
			return null;
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Lista_De_Reproduccion[] lista_De_Reproduccions = listLista_De_ReproduccionByQuery(session, condition, orderBy, lockMode);
		if (lista_De_Reproduccions != null && lista_De_Reproduccions.length > 0)
			return lista_De_Reproduccions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLista_De_ReproduccionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateLista_De_ReproduccionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLista_De_ReproduccionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateLista_De_ReproduccionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Lista_De_Reproduccion as Lista_De_Reproduccion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLista_De_ReproduccionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Lista_De_Reproduccion as Lista_De_Reproduccion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lista_De_Reproduccion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion createLista_De_Reproduccion() {
		return new diagramaclasesbd.Lista_De_Reproduccion();
	}
	
	public static boolean save(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().saveObject(lista_De_Reproduccion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().deleteObject(lista_De_Reproduccion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion)throws PersistentException {
		try {
			if (lista_De_Reproduccion.getEs_propietario_lista() != null) {
				lista_De_Reproduccion.getEs_propietario_lista().propiedad_de.remove(lista_De_Reproduccion);
			}
			
			diagramaclasesbd.Video[] lVideos_reps = lista_De_Reproduccion.videos_rep.toArray();
			for(int i = 0; i < lVideos_reps.length; i++) {
				lVideos_reps[i].setLista_rep(null);
			}
			diagramaclasesbd.Video[] lVideo_masmegustas = lista_De_Reproduccion.video_masmegusta.toArray();
			for(int i = 0; i < lVideo_masmegustas.length; i++) {
				lVideo_masmegustas[i].setMas_gusta(null);
			}
			diagramaclasesbd.Video[] lVideos_ultimoss = lista_De_Reproduccion.videos_ultimos.toArray();
			for(int i = 0; i < lVideos_ultimoss.length; i++) {
				lVideos_ultimoss[i].setUltimos(null);
			}
			diagramaclasesbd.Video[] lVideos_rels = lista_De_Reproduccion.videos_rel.toArray();
			for(int i = 0; i < lVideos_rels.length; i++) {
				lVideos_rels[i].setRelacionados(null);
			}
			return delete(lista_De_Reproduccion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (lista_De_Reproduccion.getEs_propietario_lista() != null) {
				lista_De_Reproduccion.getEs_propietario_lista().propiedad_de.remove(lista_De_Reproduccion);
			}
			
			diagramaclasesbd.Video[] lVideos_reps = lista_De_Reproduccion.videos_rep.toArray();
			for(int i = 0; i < lVideos_reps.length; i++) {
				lVideos_reps[i].setLista_rep(null);
			}
			diagramaclasesbd.Video[] lVideo_masmegustas = lista_De_Reproduccion.video_masmegusta.toArray();
			for(int i = 0; i < lVideo_masmegustas.length; i++) {
				lVideo_masmegustas[i].setMas_gusta(null);
			}
			diagramaclasesbd.Video[] lVideos_ultimoss = lista_De_Reproduccion.videos_ultimos.toArray();
			for(int i = 0; i < lVideos_ultimoss.length; i++) {
				lVideos_ultimoss[i].setUltimos(null);
			}
			diagramaclasesbd.Video[] lVideos_rels = lista_De_Reproduccion.videos_rel.toArray();
			for(int i = 0; i < lVideos_rels.length; i++) {
				lVideos_rels[i].setRelacionados(null);
			}
			try {
				session.delete(lista_De_Reproduccion);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().refresh(lista_De_Reproduccion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(diagramaclasesbd.Lista_De_Reproduccion lista_De_Reproduccion) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().evict(lista_De_Reproduccion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lista_De_Reproduccion loadLista_De_ReproduccionByCriteria(Lista_De_ReproduccionCriteria lista_De_ReproduccionCriteria) {
		Lista_De_Reproduccion[] lista_De_Reproduccions = listLista_De_ReproduccionByCriteria(lista_De_ReproduccionCriteria);
		if(lista_De_Reproduccions == null || lista_De_Reproduccions.length == 0) {
			return null;
		}
		return lista_De_Reproduccions[0];
	}
	
	public static Lista_De_Reproduccion[] listLista_De_ReproduccionByCriteria(Lista_De_ReproduccionCriteria lista_De_ReproduccionCriteria) {
		return lista_De_ReproduccionCriteria.listLista_De_Reproduccion();
	}
}
