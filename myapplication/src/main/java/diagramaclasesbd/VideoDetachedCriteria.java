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

public class VideoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression usuario_videoId;
	public final AssociationExpression usuario_video;
	public final IntegerExpression categoriaId;
	public final AssociationExpression categoria;
	public final StringExpression url;
	public final StringExpression titulo;
	public final StringExpression etiqueta;
	public final StringExpression descripcion;
	public final IntegerExpression visualizaciones;
	public final StringExpression miniatura;
	public final IntegerExpression megusta;
	public final DateExpression fechaCreacion;
	public final CollectionExpression lista_de_Reproduccion;
	public final CollectionExpression da_megusta;
	public final CollectionExpression comentarios;
	
	public VideoDetachedCriteria() {
		super(diagramaclasesbd.Video.class, diagramaclasesbd.VideoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuario_videoId = new IntegerExpression("usuario_video.ID", this.getDetachedCriteria());
		usuario_video = new AssociationExpression("usuario_video", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.ID", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		fechaCreacion = new DateExpression("fechaCreacion", this.getDetachedCriteria());
		lista_de_Reproduccion = new CollectionExpression("ORM_lista_de_Reproduccion", this.getDetachedCriteria());
		da_megusta = new CollectionExpression("ORM_da_megusta", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public VideoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.VideoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuario_videoId = new IntegerExpression("usuario_video.ID", this.getDetachedCriteria());
		usuario_video = new AssociationExpression("usuario_video", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.ID", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		fechaCreacion = new DateExpression("fechaCreacion", this.getDetachedCriteria());
		lista_de_Reproduccion = new CollectionExpression("ORM_lista_de_Reproduccion", this.getDetachedCriteria());
		da_megusta = new CollectionExpression("ORM_da_megusta", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuario_videoCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario_video"));
	}
	
	public CategoriaDetachedCriteria createCategoriaCriteria() {
		return new CategoriaDetachedCriteria(createCriteria("categoria"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createLista_de_ReproduccionCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ORM_lista_de_Reproduccion"));
	}
	
	public UsuarioDetachedCriteria createDa_megustaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_da_megusta"));
	}
	
	public ComentarioDetachedCriteria createComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentarios"));
	}
	
	public Video uniqueVideo(PersistentSession session) {
		return (Video) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Video[] listVideo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

