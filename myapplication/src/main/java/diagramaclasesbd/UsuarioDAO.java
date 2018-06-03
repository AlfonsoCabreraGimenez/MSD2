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

public class UsuarioDAO {
	public static Usuario loadUsuarioByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Usuario) session.load(diagramaclasesbd.Usuario.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Usuario) session.get(diagramaclasesbd.Usuario.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.load(diagramaclasesbd.Usuario.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario getUsuarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario) session.get(diagramaclasesbd.Usuario.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Usuario as Usuario");
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
	
	public static List queryUsuario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy, lockMode);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy, lockMode);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Usuario as Usuario");
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
	
	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario createUsuario() {
		return new diagramaclasesbd.Usuario();
	}
	
	public static boolean save(diagramaclasesbd.Usuario usuario) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().saveObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(diagramaclasesbd.Usuario usuario) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().deleteObject(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Usuario usuario)throws PersistentException {
		if (usuario instanceof diagramaclasesbd.Registrado) {
			return diagramaclasesbd.RegistradoDAO.deleteAndDissociate((diagramaclasesbd.Registrado) usuario);
		}
		
		if (usuario instanceof diagramaclasesbd.Administrador) {
			return diagramaclasesbd.AdministradorDAO.deleteAndDissociate((diagramaclasesbd.Administrador) usuario);
		}
		
		try {
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = usuario.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = usuario.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = usuario.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = usuario.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(usuario);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = usuario.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = usuario.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = usuario.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lHistorials = usuario.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = usuario.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			return delete(usuario);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Usuario usuario, org.orm.PersistentSession session)throws PersistentException {
		if (usuario instanceof diagramaclasesbd.Registrado) {
			return diagramaclasesbd.RegistradoDAO.deleteAndDissociate((diagramaclasesbd.Registrado) usuario, session);
		}
		
		if (usuario instanceof diagramaclasesbd.Administrador) {
			return diagramaclasesbd.AdministradorDAO.deleteAndDissociate((diagramaclasesbd.Administrador) usuario, session);
		}
		
		try {
			diagramaclasesbd.Usuario[] lUsuario_sucripcioness = usuario.usuario_sucripciones.toArray();
			for(int i = 0; i < lUsuario_sucripcioness.length; i++) {
				lUsuario_sucripcioness[i].suscripciones.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lSuscriptoress = usuario.suscriptores.toArray();
			for(int i = 0; i < lSuscriptoress.length; i++) {
				lSuscriptoress[i].usuario_suscriptores.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lSuscripcioness = usuario.suscripciones.toArray();
			for(int i = 0; i < lSuscripcioness.length; i++) {
				lSuscripcioness[i].usuario_sucripciones.remove(usuario);
			}
			diagramaclasesbd.Usuario[] lUsuario_suscriptoress = usuario.usuario_suscriptores.toArray();
			for(int i = 0; i < lUsuario_suscriptoress.length; i++) {
				lUsuario_suscriptoress[i].suscriptores.remove(usuario);
			}
			diagramaclasesbd.Comentario[] lEs_escritos = usuario.es_escrito.toArray();
			for(int i = 0; i < lEs_escritos.length; i++) {
				lEs_escritos[i].setUsuario_comentario(null);
			}
			diagramaclasesbd.Lista_De_Reproduccion[] lPropiedad_des = usuario.propiedad_de.toArray();
			for(int i = 0; i < lPropiedad_des.length; i++) {
				lPropiedad_des[i].setEs_propietario_lista(null);
			}
			diagramaclasesbd.Video[] lPropiedad_video_des = usuario.propiedad_video_de.toArray();
			for(int i = 0; i < lPropiedad_video_des.length; i++) {
				lPropiedad_video_des[i].setEs_propietario(null);
			}
			diagramaclasesbd.Video[] lHistorials = usuario.historial.toArray();
			for(int i = 0; i < lHistorials.length; i++) {
				lHistorials[i].setUsuario_historial(null);
			}
			diagramaclasesbd.Video[] lOtros_usuarioss = usuario.otros_usuarios.toArray();
			for(int i = 0; i < lOtros_usuarioss.length; i++) {
				lOtros_usuarioss[i].setUsuario(null);
			}
			try {
				session.delete(usuario);
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
	
	public static boolean refresh(diagramaclasesbd.Usuario usuario) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().refresh(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(diagramaclasesbd.Usuario usuario) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().evict(usuario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario loadUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		Usuario[] usuarios = listUsuarioByCriteria(usuarioCriteria);
		if(usuarios == null || usuarios.length == 0) {
			return null;
		}
		return usuarios[0];
	}
	
	public static Usuario[] listUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		return usuarioCriteria.listUsuario();
	}
}
