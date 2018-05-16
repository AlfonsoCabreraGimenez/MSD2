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

public class VideoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression categoriaId;
	public final AssociationExpression categoria;
	public final IntegerExpression usuarioId;
	public final AssociationExpression usuario;
	public final IntegerExpression usuarioHistorialId;
	public final AssociationExpression usuarioHistorial;
	public final IntegerExpression relacionadosId;
	public final AssociationExpression relacionados;
	public final IntegerExpression mas_gustaId;
	public final AssociationExpression mas_gusta;
	public final IntegerExpression ultimosId;
	public final AssociationExpression ultimos;
	public final IntegerExpression lista_repId;
	public final AssociationExpression lista_rep;
	public final IntegerExpression es_propietarioId;
	public final AssociationExpression es_propietario;
	public final StringExpression titulo;
	public final StringExpression etiqueta;
	public final StringExpression descripcion;
	public final IntegerExpression visualizaciones;
	public final StringExpression miniatura;
	public final IntegerExpression megusta;
	public final CollectionExpression comentario;
	public final CollectionExpression usuarios;
	
	public VideoDetachedCriteria() {
		super(diagramaclasesbd.Video.class, diagramaclasesbd.VideoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.id", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		usuarioHistorialId = new IntegerExpression("usuarioHistorial.ID", this.getDetachedCriteria());
		usuarioHistorial = new AssociationExpression("usuarioHistorial", this.getDetachedCriteria());
		relacionadosId = new IntegerExpression("relacionados.id", this.getDetachedCriteria());
		relacionados = new AssociationExpression("relacionados", this.getDetachedCriteria());
		mas_gustaId = new IntegerExpression("mas_gusta.id", this.getDetachedCriteria());
		mas_gusta = new AssociationExpression("mas_gusta", this.getDetachedCriteria());
		ultimosId = new IntegerExpression("ultimos.id", this.getDetachedCriteria());
		ultimos = new AssociationExpression("ultimos", this.getDetachedCriteria());
		lista_repId = new IntegerExpression("lista_rep.id", this.getDetachedCriteria());
		lista_rep = new AssociationExpression("lista_rep", this.getDetachedCriteria());
		es_propietarioId = new IntegerExpression("es_propietario.ID", this.getDetachedCriteria());
		es_propietario = new AssociationExpression("es_propietario", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		comentario = new CollectionExpression("ORM_comentario", this.getDetachedCriteria());
		usuarios = new CollectionExpression("ORM_usuarios", this.getDetachedCriteria());
	}
	
	public VideoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.VideoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.id", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		usuarioHistorialId = new IntegerExpression("usuarioHistorial.ID", this.getDetachedCriteria());
		usuarioHistorial = new AssociationExpression("usuarioHistorial", this.getDetachedCriteria());
		relacionadosId = new IntegerExpression("relacionados.id", this.getDetachedCriteria());
		relacionados = new AssociationExpression("relacionados", this.getDetachedCriteria());
		mas_gustaId = new IntegerExpression("mas_gusta.id", this.getDetachedCriteria());
		mas_gusta = new AssociationExpression("mas_gusta", this.getDetachedCriteria());
		ultimosId = new IntegerExpression("ultimos.id", this.getDetachedCriteria());
		ultimos = new AssociationExpression("ultimos", this.getDetachedCriteria());
		lista_repId = new IntegerExpression("lista_rep.id", this.getDetachedCriteria());
		lista_rep = new AssociationExpression("lista_rep", this.getDetachedCriteria());
		es_propietarioId = new IntegerExpression("es_propietario.ID", this.getDetachedCriteria());
		es_propietario = new AssociationExpression("es_propietario", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		comentario = new CollectionExpression("ORM_comentario", this.getDetachedCriteria());
		usuarios = new CollectionExpression("ORM_usuarios", this.getDetachedCriteria());
	}
	
	public CategoriaDetachedCriteria createCategoriaCriteria() {
		return new CategoriaDetachedCriteria(createCriteria("categoria"));
	}
	
	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}
	
	public UsuarioDetachedCriteria createUsuarioHistorialCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuarioHistorial"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createRelacionadosCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("relacionados"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createMas_gustaCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("mas_gusta"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createUltimosCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ultimos"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createLista_repCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("lista_rep"));
	}
	
	public UsuarioDetachedCriteria createEs_propietarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_propietario"));
	}
	
	public ComentarioDetachedCriteria createComentarioCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentario"));
	}
	
	public UsuarioDetachedCriteria createUsuariosCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_usuarios"));
	}
	
	public Video uniqueVideo(PersistentSession session) {
		return (Video) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Video[] listVideo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

