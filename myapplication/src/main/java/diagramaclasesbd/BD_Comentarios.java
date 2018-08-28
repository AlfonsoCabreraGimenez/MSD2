package diagramaclasesbd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.Comentario;

public class BD_Comentarios {
	public BD_Principal _bd_prin_coment;
	public Vector<Comentario> _contiene_coment = new Vector<Comentario>();

	public void eliminarComentario(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try	{
			Comentario coment = ComentarioDAO.getComentarioByORMID(aID);
			Video video = coment.getVideo();
			Usuario user = coment.getUsuario_comentario();
			video.comentarios.remove(coment);
			user.es_escrito.remove(coment);
			ComentarioDAO.delete(coment);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List cargarListaComentarios(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Comentario> listC = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<Comentario> resultado = new ArrayList<Comentario>();
		try {
			listC = new ArrayList<Comentario>(Arrays.asList(VideoDAO.getVideoByORMID(aID).comentarios.toArray()));
			for(Comentario c : listC){
				ids.add(c.getID());
			}
			while(!ids.isEmpty()) {
				int  min = 1000;
				int pos = -1;
				for(int i = 0 ; i < ids.size();i++) {
					int actual=ids.get(i);
					if(actual < min) {
						min = actual;
						pos=i;
					}
				}
				resultado.add(listC.get(pos));
				listC.remove(pos);
				ids.remove(pos);
			}
			t.commit();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resultado;
	}

	public void escribirComentario(String aCadena, int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			Video vid = VideoDAO.getVideoByORMID(aID);
			Comentario coment = ComentarioDAO.createComentario();
			coment.setDescripcion(aCadena);
			coment.setVideo(vid);
			if(admon == null) {
				Registrado r = RegistradoDAO.getRegistradoByORMID(reg.getID());
				coment.setUsuario_comentario(r);
			} else {
				Administrador a = AdministradorDAO.getAdministradorByORMID(admon.getID());
				coment.setUsuario_comentario(a);
			}
			ComentarioDAO.save(coment);
			
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
	}
}