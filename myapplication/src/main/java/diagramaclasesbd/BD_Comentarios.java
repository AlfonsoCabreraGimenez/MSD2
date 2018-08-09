package diagramaclasesbd;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import diagramaclasesbd.Comentario;

public class BD_Comentarios {
	public BD_Principal _bd_prin_coment;
	public Vector<Comentario> _contiene_coment = new Vector<Comentario>();

	public void eliminarComentario(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargarListaComentarios(int aID) {
		throw new UnsupportedOperationException();
	}

	public void escribirComentario(String aCadena, int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Registrado reg = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			Registrado r = RegistradoDAO.getRegistradoByORMID(reg.getID());
			Video vid = VideoDAO.getVideoByORMID(aID);
			Comentario coment = ComentarioDAO.createComentario();
			coment.setDescripcion(aCadena);
			coment.setUsuario_comentario(r);
			coment.setVideo(vid);
			ComentarioDAO.save(coment);
			
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
	}
}