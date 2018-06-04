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

public class VideoCriteria extends AbstractORMCriteria {
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
	
	public VideoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		usuario_videoId = new IntegerExpression("usuario_video.ID", this);
		usuario_video = new AssociationExpression("usuario_video", this);
		categoriaId = new IntegerExpression("categoria.ID", this);
		categoria = new AssociationExpression("categoria", this);
		url = new StringExpression("url", this);
		titulo = new StringExpression("titulo", this);
		etiqueta = new StringExpression("etiqueta", this);
		descripcion = new StringExpression("descripcion", this);
		visualizaciones = new IntegerExpression("visualizaciones", this);
		miniatura = new StringExpression("miniatura", this);
		megusta = new IntegerExpression("megusta", this);
		fechaCreacion = new DateExpression("fechaCreacion", this);
		lista_de_Reproduccion = new CollectionExpression("ORM_lista_de_Reproduccion", this);
		da_megusta = new CollectionExpression("ORM_da_megusta", this);
		comentarios = new CollectionExpression("ORM_comentarios", this);
	}
	
	public VideoCriteria(PersistentSession session) {
		this(session.createCriteria(Video.class));
	}
	
	public VideoCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuario_videoCriteria() {
		return new UsuarioCriteria(createCriteria("usuario_video"));
	}
	
	public CategoriaCriteria createCategoriaCriteria() {
		return new CategoriaCriteria(createCriteria("categoria"));
	}
	
	public Lista_De_ReproduccionCriteria createLista_de_ReproduccionCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("ORM_lista_de_Reproduccion"));
	}
	
	public UsuarioCriteria createDa_megustaCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_da_megusta"));
	}
	
	public ComentarioCriteria createComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentarios"));
	}
	
	public Video uniqueVideo() {
		return (Video) super.uniqueResult();
	}
	
	public Video[] listVideo() {
		java.util.List list = super.list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

