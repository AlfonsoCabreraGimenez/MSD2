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

public class CategoriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final IntegerExpression edad;
	public final CollectionExpression video;
	
	public CategoriaDetachedCriteria() {
		super(diagramaclasesbd.Categoria.class, diagramaclasesbd.CategoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		edad = new IntegerExpression("edad", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
	}
	
	public CategoriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.CategoriaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		edad = new IntegerExpression("edad", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
	}
	
	public VideoDetachedCriteria createVideoCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_video"));
	}
	
	public Categoria uniqueCategoria(PersistentSession session) {
		return (Categoria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Categoria[] listCategoria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Categoria[]) list.toArray(new Categoria[list.size()]);
	}
}

