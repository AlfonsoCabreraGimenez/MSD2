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
	public final IntegerExpression ID;
	public final IntegerExpression usuario_comentarioId;
	public final AssociationExpression usuario_comentario;
	public final IntegerExpression video_comentId;
	public final AssociationExpression video_coment;
	public final StringExpression descripcion;
	
	public ComentarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		usuario_comentarioId = new IntegerExpression("usuario_comentario.ID", this);
		usuario_comentario = new AssociationExpression("usuario_comentario", this);
		video_comentId = new IntegerExpression("video_coment.ID", this);
		video_coment = new AssociationExpression("video_coment", this);
		descripcion = new StringExpression("descripcion", this);
	}
	
	public ComentarioCriteria(PersistentSession session) {
		this(session.createCriteria(Comentario.class));
	}
	
	public ComentarioCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuario_comentarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario_comentario"));
	}
	
	public VideoCriteria createVideo_comentCriteria() {
		return new VideoCriteria(createCriteria("video_coment"));
	}
	
	public Comentario uniqueComentario() {
		return (Comentario) super.uniqueResult();
	}
	
	public Comentario[] listComentario() {
		java.util.List list = super.list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

