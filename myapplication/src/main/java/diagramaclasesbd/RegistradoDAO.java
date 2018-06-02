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

public class RegistradoDAO {
	public static Registrado loadRegistradoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadRegistradoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado getRegistradoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getRegistradoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadRegistradoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado getRegistradoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getRegistradoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Registrado) session.load(diagramaclasesbd.Registrado.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado getRegistradoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Registrado) session.get(diagramaclasesbd.Registrado.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Registrado) session.load(diagramaclasesbd.Registrado.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado getRegistradoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Registrado) session.get(diagramaclasesbd.Registrado.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegistrado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryRegistrado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegistrado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryRegistrado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado[] listRegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listRegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado[] listRegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listRegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegistrado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Registrado as Registrado");
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
	
	public static List queryRegistrado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Registrado as Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Registrado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado[] listRegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRegistrado(session, condition, orderBy);
			return (Registrado[]) list.toArray(new Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado[] listRegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRegistrado(session, condition, orderBy, lockMode);
			return (Registrado[]) list.toArray(new Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadRegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadRegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Registrado[] registrados = listRegistradoByQuery(session, condition, orderBy);
		if (registrados != null && registrados.length > 0)
			return registrados[0];
		else
			return null;
	}
	
	public static Registrado loadRegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Registrado[] registrados = listRegistradoByQuery(session, condition, orderBy, lockMode);
		if (registrados != null && registrados.length > 0)
			return registrados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateRegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateRegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Registrado as Registrado");
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
	
	public static java.util.Iterator iterateRegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Registrado as Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Registrado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado createRegistrado() {
		return new diagramaclasesbd.Registrado();
	}
	
	public static boolean save(diagramaclasesbd.Registrado registrado) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().saveObject(registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(diagramaclasesbd.Registrado registrado) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().deleteObject(registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Registrado registrado)throws PersistentException {
		try {
			diagramaclasesbd.Video[] lMe_gustas = registrado.me_gusta.toArray();
			for(int i = 0; i < lMe_gustas.length; i++) {
				lMe_gustas[i].usuarios.remove(registrado);
			}
			diagramaclasesbd.Video[] lHistorials = registrado.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = registrado.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = registrado.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = registrado.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = registrado.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = registrado.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = registrado.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = registrado.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = registrado.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(registrado);
			}
			return delete(registrado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Registrado registrado, org.orm.PersistentSession session)throws PersistentException {
		try {
			diagramaclasesbd.Video[] lMe_gustas = registrado.me_gusta.toArray();
			for(int i = 0; i < lMe_gustas.length; i++) {
				lMe_gustas[i].usuarios.remove(registrado);
			}
			diagramaclasesbd.Video[] lHistorials = registrado.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = registrado.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = registrado.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = registrado.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = registrado.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = registrado.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = registrado.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = registrado.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(registrado);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = registrado.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(registrado);
			}
			try {
				session.delete(registrado);
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
	
	public static boolean refresh(diagramaclasesbd.Registrado registrado) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().refresh(registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(diagramaclasesbd.Registrado registrado) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().evict(registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Registrado loadRegistradoByCriteria(RegistradoCriteria registradoCriteria) {
		Registrado[] registrados = listRegistradoByCriteria(registradoCriteria);
		if(registrados == null || registrados.length == 0) {
			return null;
		}
		return registrados[0];
	}
	
	public static Registrado[] listRegistradoByCriteria(RegistradoCriteria registradoCriteria) {
		return registradoCriteria.listRegistrado();
	}
}
