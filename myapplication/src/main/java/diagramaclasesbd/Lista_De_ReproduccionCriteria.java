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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Lista_De_ReproduccionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression es_prop_listaId;
	public final AssociationExpression es_prop_lista;
	public final StringExpression titulo;
	public final CollectionExpression video;
	
	public Lista_De_ReproduccionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		es_prop_listaId = new IntegerExpression("es_prop_lista.ID", this);
		es_prop_lista = new AssociationExpression("es_prop_lista", this);
		titulo = new StringExpression("titulo", this);
		video = new CollectionExpression("ORM_video", this);
	}
	
	public Lista_De_ReproduccionCriteria(PersistentSession session) {
		this(session.createCriteria(Lista_De_Reproduccion.class));
	}
	
	public Lista_De_ReproduccionCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createEs_prop_listaCriteria() {
		return new UsuarioCriteria(createCriteria("es_prop_lista"));
	}
	
	public VideoCriteria createVideoCriteria() {
		return new VideoCriteria(createCriteria("ORM_video"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion() {
		return (Lista_De_Reproduccion) super.uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion() {
		java.util.List list = super.list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

