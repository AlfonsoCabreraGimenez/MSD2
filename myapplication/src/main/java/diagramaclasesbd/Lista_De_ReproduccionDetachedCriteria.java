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
	public final IntegerExpression ID;
	public final IntegerExpression es_propietario_listaId;
	public final AssociationExpression es_propietario_lista;
	public final StringExpression titulo;
	public final CollectionExpression videos_rep;
	public final CollectionExpression video_masmegusta;
	public final CollectionExpression videos_ultimos;
	public final CollectionExpression videosRel;
	
	public Lista_De_ReproduccionDetachedCriteria() {
		super(diagramaclasesbd.Lista_De_Reproduccion.class, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		es_propietario_listaId = new IntegerExpression("es_propietario_lista.ID", this.getDetachedCriteria());
		es_propietario_lista = new AssociationExpression("es_propietario_lista", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		videos_rep = new CollectionExpression("ORM_videos_rep", this.getDetachedCriteria());
		video_masmegusta = new CollectionExpression("ORM_video_masmegusta", this.getDetachedCriteria());
		videos_ultimos = new CollectionExpression("ORM_videos_ultimos", this.getDetachedCriteria());
		videosRel = new CollectionExpression("ORM_videosRel", this.getDetachedCriteria());
	}
	
	public Lista_De_ReproduccionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.Lista_De_ReproduccionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		es_propietario_listaId = new IntegerExpression("es_propietario_lista.ID", this.getDetachedCriteria());
		es_propietario_lista = new AssociationExpression("es_propietario_lista", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		videos_rep = new CollectionExpression("ORM_videos_rep", this.getDetachedCriteria());
		video_masmegusta = new CollectionExpression("ORM_video_masmegusta", this.getDetachedCriteria());
		videos_ultimos = new CollectionExpression("ORM_videos_ultimos", this.getDetachedCriteria());
		videosRel = new CollectionExpression("ORM_videosRel", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createEs_propietario_listaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_propietario_lista"));
	}
	
	public VideoDetachedCriteria createVideos_repCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videos_rep"));
	}
	
	public VideoDetachedCriteria createVideo_masmegustaCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_video_masmegusta"));
	}
	
	public VideoDetachedCriteria createVideos_ultimosCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videos_ultimos"));
	}
	
	public VideoDetachedCriteria createVideosRelCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_videosRel"));
	}
	
	public Lista_De_Reproduccion uniqueLista_De_Reproduccion(PersistentSession session) {
		return (Lista_De_Reproduccion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lista_De_Reproduccion[] listLista_De_Reproduccion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lista_De_Reproduccion[]) list.toArray(new Lista_De_Reproduccion[list.size()]);
	}
}

