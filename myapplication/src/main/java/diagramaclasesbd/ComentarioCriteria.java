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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComentarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression usuarioComentarioId;
	public final AssociationExpression usuarioComentario;
	public final IntegerExpression videoId;
	public final AssociationExpression video;
	public final StringExpression descripcion;
	
	public ComentarioCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		usuarioComentarioId = new IntegerExpression("usuarioComentario.ID", this);
		usuarioComentario = new AssociationExpression("usuarioComentario", this);
		videoId = new IntegerExpression("video.id", this);
		video = new AssociationExpression("video", this);
		descripcion = new StringExpression("descripcion", this);
	}
	
	public ComentarioCriteria(PersistentSession session) {
		this(session.createCriteria(Comentario.class));
	}
	
	public ComentarioCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuarioComentarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuarioComentario"));
	}
	
	public VideoCriteria createVideoCriteria() {
		return new VideoCriteria(createCriteria("video"));
	}
	
	public Comentario uniqueComentario() {
		return (Comentario) super.uniqueResult();
	}
	
	public Comentario[] listComentario() {
		java.util.List list = super.list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

