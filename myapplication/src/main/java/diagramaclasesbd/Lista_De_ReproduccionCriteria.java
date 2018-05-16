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
	public final IntegerExpression id;
	public final IntegerExpression es_propietario_deId;
	public final AssociationExpression es_propietario_de;
	public final StringExpression titulo;
	public final CollectionExpression video;
	public final CollectionExpression videoMasMegusta;
	public final CollectionExpression videoUltimos;
	public final CollectionExpression videos;
	
	public Lista_De_ReproduccionCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		es_propietario_deId = new IntegerExpression("es_propietario_de.ID", this);
		es_propietario_de = new AssociationExpression("es_propietario_de", this);
		titulo = new StringExpression("titulo", this);
		video = new CollectionExpression("ORM_video", this);
		videoMasMegusta = new CollectionExpression("ORM_videoMasMegusta", this);
		videoUltimos = new CollectionExpression("ORM_videoUltimos", this);
		videos = new CollectionExpression("ORM_videos", this);
	}
	
	public Lista_De_ReproduccionCriteria(PersistentSession session) {
		this(session.createCriteria(Lista_De_Reproduccion.class));
	}
	
	public Lista_De_ReproduccionCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createEs_propietario_deCriteria() {
		return new UsuarioCriteria(createCriteria("es_propietario_de"));
	}
	
	public VideoCriteria createVideoCriteria() {
		return new VideoCriteria(createCriteria("ORM_video"));
	}
	
	public VideoCriteria createVideoMasMegustaCriteria() {
		return new VideoCriteria(createCriteria("ORM_videoMasMegusta"));
	}
	
	public VideoCriteria createVideoUltimosCriteria() {
		return new VideoCriteria(createCriteria("ORM_videoUltimos"));
	}
	
	public VideoCriteria createVideosCriteria() {
		return new VideoCriteria(createCriteria("ORM_videos"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion() {
		return (Lista_De_Reproduccion) super.uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion() {
		java.util.List list = super.list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

