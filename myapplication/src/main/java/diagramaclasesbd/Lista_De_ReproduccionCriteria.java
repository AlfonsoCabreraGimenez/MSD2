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

public class Lista_De_ReproduccionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression es_propietario_listaId;
	public final AssociationExpression es_propietario_lista;
	public final StringExpression titulo;
	public final CollectionExpression videos_rep;
	public final CollectionExpression video_masmegusta;
	public final CollectionExpression videos_ultimos;
	public final CollectionExpression videos_rel;
	
	public Lista_De_ReproduccionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		es_propietario_listaId = new IntegerExpression("es_propietario_lista.ID", this);
		es_propietario_lista = new AssociationExpression("es_propietario_lista", this);
		titulo = new StringExpression("titulo", this);
		videos_rep = new CollectionExpression("ORM_videos_rep", this);
		video_masmegusta = new CollectionExpression("ORM_video_masmegusta", this);
		videos_ultimos = new CollectionExpression("ORM_videos_ultimos", this);
		videos_rel = new CollectionExpression("ORM_videos_rel", this);
	}
	
	public Lista_De_ReproduccionCriteria(PersistentSession session) {
		this(session.createCriteria(Lista_De_Reproduccion.class));
	}
	
	public Lista_De_ReproduccionCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createEs_propietario_listaCriteria() {
		return new UsuarioCriteria(createCriteria("es_propietario_lista"));
	}
	
	public VideoCriteria createVideos_repCriteria() {
		return new VideoCriteria(createCriteria("ORM_videos_rep"));
	}
	
	public VideoCriteria createVideo_masmegustaCriteria() {
		return new VideoCriteria(createCriteria("ORM_video_masmegusta"));
	}
	
	public VideoCriteria createVideos_ultimosCriteria() {
		return new VideoCriteria(createCriteria("ORM_videos_ultimos"));
	}
	
	public VideoCriteria createVideos_relCriteria() {
		return new VideoCriteria(createCriteria("ORM_videos_rel"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion() {
		return (Lista_De_Reproduccion) super.uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion() {
		java.util.List list = super.list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

