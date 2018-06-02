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
	public final IntegerExpression ID;
	public final IntegerExpression usuario_comentarioId;
	public final AssociationExpression usuario_comentario;
	public final IntegerExpression video_comentId;
	public final AssociationExpression video_coment;
	public final StringExpression descripcion;
	
	public ComentarioDetachedCriteria() {
		super(diagramaclasesbd.Comentario.class, diagramaclasesbd.ComentarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuario_comentarioId = new IntegerExpression("usuario_comentario.ID", this.getDetachedCriteria());
		usuario_comentario = new AssociationExpression("usuario_comentario", this.getDetachedCriteria());
		video_comentId = new IntegerExpression("video_coment.ID", this.getDetachedCriteria());
		video_coment = new AssociationExpression("video_coment", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.ComentarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuario_comentarioId = new IntegerExpression("usuario_comentario.ID", this.getDetachedCriteria());
		usuario_comentario = new AssociationExpression("usuario_comentario", this.getDetachedCriteria());
		video_comentId = new IntegerExpression("video_coment.ID", this.getDetachedCriteria());
		video_coment = new AssociationExpression("video_coment", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuario_comentarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario_comentario"));
	}
	
	public VideoDetachedCriteria createVideo_comentCriteria() {
		return new VideoDetachedCriteria(createCriteria("video_coment"));
	}
	
	public Comentario uniqueComentario(PersistentSession session) {
		return (Comentario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comentario[] listComentario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

