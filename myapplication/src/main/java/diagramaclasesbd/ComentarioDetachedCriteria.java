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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComentarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression usuarioComentarioId;
	public final AssociationExpression usuarioComentario;
	public final IntegerExpression videoId;
	public final AssociationExpression video;
	public final StringExpression descripcion;
	
	public ComentarioDetachedCriteria() {
		super(diagramaclasesbd.Comentario.class, diagramaclasesbd.ComentarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		usuarioComentarioId = new IntegerExpression("usuarioComentario.ID", this.getDetachedCriteria());
		usuarioComentario = new AssociationExpression("usuarioComentario", this.getDetachedCriteria());
		videoId = new IntegerExpression("video.id", this.getDetachedCriteria());
		video = new AssociationExpression("video", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.ComentarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		usuarioComentarioId = new IntegerExpression("usuarioComentario.ID", this.getDetachedCriteria());
		usuarioComentario = new AssociationExpression("usuarioComentario", this.getDetachedCriteria());
		videoId = new IntegerExpression("video.id", this.getDetachedCriteria());
		video = new AssociationExpression("video", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuarioComentarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuarioComentario"));
	}
	
	public VideoDetachedCriteria createVideoCriteria() {
		return new VideoDetachedCriteria(createCriteria("video"));
	}
	
	public Comentario uniqueComentario(PersistentSession session) {
		return (Comentario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comentario[] listComentario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

