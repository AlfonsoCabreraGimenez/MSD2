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

public class Lista_De_ReproduccionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression es_propietario_deId;
	public final AssociationExpression es_propietario_de;
	public final StringExpression titulo;
	public final CollectionExpression video;
	public final CollectionExpression videoMasMegusta;
	public final CollectionExpression videoUltimos;
	public final CollectionExpression videos;
	
	public Lista_De_ReproduccionDetachedCriteria() {
		super(diagramaclasesbd.Lista_De_Reproduccion.class, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		es_propietario_deId = new IntegerExpression("es_propietario_de.ID", this.getDetachedCriteria());
		es_propietario_de = new AssociationExpression("es_propietario_de", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
		videoMasMegusta = new CollectionExpression("ORM_videoMasMegusta", this.getDetachedCriteria());
		videoUltimos = new CollectionExpression("ORM_videoUltimos", this.getDetachedCriteria());
		videos = new CollectionExpression("ORM_videos", this.getDetachedCriteria());
	}
	
	public Lista_De_ReproduccionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		es_propietario_deId = new IntegerExpression("es_propietario_de.ID", this.getDetachedCriteria());
		es_propietario_de = new AssociationExpression("es_propietario_de", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		video = new CollectionExpression("ORM_video", this.getDetachedCriteria());
		videoMasMegusta = new CollectionExpression("ORM_videoMasMegusta", this.getDetachedCriteria());
		videoUltimos = new CollectionExpression("ORM_videoUltimos", this.getDetachedCriteria());
		videos = new CollectionExpression("ORM_videos", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createEs_propietario_deCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_propietario_de"));
	}
	
	public VideoDetachedCriteria createVideoCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_video"));
	}
	
	public VideoDetachedCriteria createVideoMasMegustaCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videoMasMegusta"));
	}
	
	public VideoDetachedCriteria createVideoUltimosCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videoUltimos"));
	}
	
	public VideoDetachedCriteria createVideosCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videos"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion(PersistentSession session) {
		return (Lista_De_Reproduccion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

