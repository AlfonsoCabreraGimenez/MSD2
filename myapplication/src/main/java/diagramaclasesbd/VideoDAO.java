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

public class VideoDAO {
	public static Video loadVideoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadVideoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video getVideoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getVideoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadVideoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video getVideoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return getVideoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Video) session.load(diagramaclasesbd.Video.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video getVideoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Video) session.get(diagramaclasesbd.Video.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Video) session.load(diagramaclasesbd.Video.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video getVideoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Video) session.get(diagramaclasesbd.Video.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryVideo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryVideo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryVideo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return queryVideo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video[] listVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listVideoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video[] listVideoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return listVideoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryVideo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Video as Video");
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
	
	public static List queryVideo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Video as Video");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Video", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video[] listVideoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryVideo(session, condition, orderBy);
			return (Video[]) list.toArray(new Video[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video[] listVideoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryVideo(session, condition, orderBy, lockMode);
			return (Video[]) list.toArray(new Video[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadVideoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return loadVideoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Video[] videos = listVideoByQuery(session, condition, orderBy);
		if (videos != null && videos.length > 0)
			return videos[0];
		else
			return null;
	}
	
	public static Video loadVideoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Video[] videos = listVideoByQuery(session, condition, orderBy, lockMode);
		if (videos != null && videos.length > 0)
			return videos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateVideoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateVideoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = Actividad11CabreraFuentesPersistentManager.instance().getSession();
			return iterateVideoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateVideoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Video as Video");
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
	
	public static java.util.Iterator iterateVideoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From diagramaclasesbd.Video as Video");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Video", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video createVideo() {
		return new diagramaclasesbd.Video();
	}
	
	public static boolean save(diagramaclasesbd.Video video) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().saveObject(video);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(diagramaclasesbd.Video video) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().deleteObject(video);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Video video)throws PersistentException {
		try {
			if (video.getCategoria() != null) {
				video.getCategoria().video.remove(video);
			}
			
			if (video.getUsuario() != null) {
				video.getUsuario().otros_usuario.remove(video);
			}
			
			if (video.getUsuarioHistorial() != null) {
				video.getUsuarioHistorial().historial.remove(video);
			}
			
			if (video.getRelacionados() != null) {
				video.getRelacionados().videos.remove(video);
			}
			
			if (video.getMas_gusta() != null) {
				video.getMas_gusta().videoMasMegusta.remove(video);
			}
			
			if (video.getUltimos() != null) {
				video.getUltimos().videoUltimos.remove(video);
			}
			
			if (video.getLista_rep() != null) {
				video.getLista_rep().video.remove(video);
			}
			
			if (video.getEs_propietario() != null) {
				video.getEs_propietario().propiedad_video_de.remove(video);
			}
			
			diagramaclasesbd.Comentario[] lComentarios = video.comentario.toArray();
			for(int i = 0; i < lComentarios.length; i++) {
				lComentarios[i].setVideo(null);
			}
			diagramaclasesbd.Usuario[] lUsuarioss = video.usuarios.toArray();
			for(int i = 0; i < lUsuarioss.length; i++) {
				lUsuarioss[i].me_gusta.remove(video);
			}
			return delete(video);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(diagramaclasesbd.Video video, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (video.getCategoria() != null) {
				video.getCategoria().video.remove(video);
			}
			
			if (video.getUsuario() != null) {
				video.getUsuario().otros_usuario.remove(video);
			}
			
			if (video.getUsuarioHistorial() != null) {
				video.getUsuarioHistorial().historial.remove(video);
			}
			
			if (video.getRelacionados() != null) {
				video.getRelacionados().videos.remove(video);
			}
			
			if (video.getMas_gusta() != null) {
				video.getMas_gusta().videoMasMegusta.remove(video);
			}
			
			if (video.getUltimos() != null) {
				video.getUltimos().videoUltimos.remove(video);
			}
			
			if (video.getLista_rep() != null) {
				video.getLista_rep().video.remove(video);
			}
			
			if (video.getEs_propietario() != null) {
				video.getEs_propietario().propiedad_video_de.remove(video);
			}
			
			diagramaclasesbd.Comentario[] lComentarios = video.comentario.toArray();
			for(int i = 0; i < lComentarios.length; i++) {
				lComentarios[i].setVideo(null);
			}
			diagramaclasesbd.Usuario[] lUsuarioss = video.usuarios.toArray();
			for(int i = 0; i < lUsuarioss.length; i++) {
				lUsuarioss[i].me_gusta.remove(video);
			}
			try {
				session.delete(video);
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
	
	public static boolean refresh(diagramaclasesbd.Video video) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().refresh(video);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(diagramaclasesbd.Video video) throws PersistentException {
		try {
			Actividad11CabreraFuentesPersistentManager.instance().getSession().evict(video);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Video loadVideoByCriteria(VideoCriteria videoCriteria) {
		Video[] videos = listVideoByCriteria(videoCriteria);
		if(videos == null || videos.length == 0) {
			return null;
		}
		return videos[0];
	}
	
	public static Video[] listVideoByCriteria(VideoCriteria videoCriteria) {
		return videoCriteria.listVideo();
	}
}
