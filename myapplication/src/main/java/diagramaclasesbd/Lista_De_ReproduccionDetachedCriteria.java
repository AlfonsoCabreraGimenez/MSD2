/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package diagramaclasesbd;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Lista_De_ReproduccionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression es_prop_listaId;
	public final AssociationExpression es_prop_lista;
	public final StringExpression titulo;
	public final CollectionExpression video;
	
	public Lista_De_ReproduccionDetachedCriteria() {
		super(diagramaclasesbd.Lista_De_Reproduccion.class, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		es_prop_listaId = new IntegerExpression("es_prop_lista.ID", this.getDetachedCriteria());
		es_prop_lista = new AssociationExpression("es_prop_lista", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
	}
	
	public Lista_De_ReproduccionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		es_prop_listaId = new IntegerExpression("es_prop_lista.ID", this.getDetachedCriteria());
		es_prop_lista = new AssociationExpression("es_prop_lista", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createEs_prop_listaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_prop_lista"));
	}
	
	public VideoDetachedCriteria createVideoCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_video"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion(PersistentSession session) {
		return (Lista_De_Reproduccion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

