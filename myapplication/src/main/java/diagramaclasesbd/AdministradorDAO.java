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

public class AdministradorDAO {
	public static Administrador loadAdministradorByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadAdministradorByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getAdministradorByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadAdministradorByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getAdministradorByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Administrador) session.load(diagramaclasesbd.Administrador.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Administrador) session.get(diagramaclasesbd.Administrador.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administrador) session.load(diagramaclasesbd.Administrador.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador getAdministradorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administrador) session.get(diagramaclasesbd.Administrador.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryAdministrador(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryAdministrador(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministrador(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Administrador as Administrador");
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
	
	public static List queryAdministrador(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administrador", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAdministrador(session, condition, orderBy);
			return (Administrador[]) list.toArray(new Administrador[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador[] listAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAdministrador(session, condition, orderBy, lockMode);
			return (Administrador[]) list.toArray(new Administrador[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Administrador[] administradors = listAdministradorByQuery(session, condition, orderBy);
		if (administradors != null && administradors.length > 0)
			return administradors[0];
		else
			return null;
	}
	
	public static Administrador loadAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Administrador[] administradors = listAdministradorByQuery(session, condition, orderBy, lockMode);
		if (administradors != null && administradors.length > 0)
			return administradors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateAdministradorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateAdministradorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministradorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Administrador as Administrador");
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
	
	public static java.util.Iterator iterateAdministradorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Administrador as Administrador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administrador", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador createAdministrador() {
		return new diagramaclasesbd.Administrador();
	}
	
	public static boolean save(diagramaclasesbd.Administrador administrador) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().saveObject(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(diagramaclasesbd.Administrador administrador) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().deleteObject(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Administrador administrador)throws PersistentException {
		try {
			diagramaclasesbd.Video[] lMe_gustas = administrador.me_gusta.toArray();
			for(int i = 0; i < lMe_gustas.length; i++) {
				lMe_gustas[i].usuarios.remove(administrador);
			}
			diagramaclasesbd.Video[] lHistorials = administrador.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = administrador.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = administrador.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = administrador.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = administrador.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = administrador.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = administrador.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = administrador.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = administrador.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(administrador);
			}
			return delete(administrador);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Administrador administrador, org.orm.PersistentSession session)throws PersistentException {
		try {
			diagramaclasesbd.Video[] lMe_gustas = administrador.me_gusta.toArray();
			for(int i = 0; i < lMe_gustas.length; i++) {
				lMe_gustas[i].usuarios.remove(administrador);
			}
			diagramaclasesbd.Video[] lHistorials = administrador.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = administrador.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = administrador.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = administrador.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = administrador.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = administrador.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = administrador.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = administrador.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(administrador);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = administrador.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(administrador);
			}
			try {
				session.delete(administrador);
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
	
	public static boolean refresh(diagramaclasesbd.Administrador administrador) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().refresh(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(diagramaclasesbd.Administrador administrador) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().evict(administrador);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Administrador loadAdministradorByCriteria(AdministradorCriteria administradorCriteria) {
		Administrador[] administradors = listAdministradorByCriteria(administradorCriteria);
		if(administradors == null || administradors.length == 0) {
			return null;
		}
		return administradors[0];
	}
	
	public static Administrador[] listAdministradorByCriteria(AdministradorCriteria administradorCriteria) {
		return administradorCriteria.listAdministrador();
	}
}
