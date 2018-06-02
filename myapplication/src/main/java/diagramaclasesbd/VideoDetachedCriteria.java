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
	public final IntegerExpression ID;
	public final IntegerExpression usuarioId;
	public final AssociationExpression usuario;
	public final IntegerExpression es_propietarioId;
	public final AssociationExpression es_propietario;
	public final CollectionExpression usuarios;
	public final IntegerExpression relacionadosId;
	public final AssociationExpression relacionados;
	public final IntegerExpression ultimosId;
	public final AssociationExpression ultimos;
	public final IntegerExpression mas_gustaId;
	public final AssociationExpression mas_gusta;
	public final IntegerExpression lista_repId;
	public final AssociationExpression lista_rep;
	public final IntegerExpression categoriaId;
	public final AssociationExpression categoria;
	public final StringExpression url;
	public final StringExpression titulo;
	public final StringExpression etiqueta;
	public final StringExpression descripcion;
	public final IntegerExpression visualizaciones;
	public final StringExpression miniatura;
	public final IntegerExpression megusta;
	public final IntegerExpression usuario_historialId;
	public final AssociationExpression usuario_historial;
	public final CollectionExpression comentarios;
	
	public VideoDetachedCriteria() {
		super(diagramaclasesbd.Video.class, diagramaclasesbd.VideoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		es_propietarioId = new IntegerExpression("es_propietario.ID", this.getDetachedCriteria());
		es_propietario = new AssociationExpression("es_propietario", this.getDetachedCriteria());
		usuarios = new CollectionExpression("ORM_usuarios", this.getDetachedCriteria());
		relacionadosId = new IntegerExpression("relacionados.ID", this.getDetachedCriteria());
		relacionados = new AssociationExpression("relacionados", this.getDetachedCriteria());
		ultimosId = new IntegerExpression("ultimos.ID", this.getDetachedCriteria());
		ultimos = new AssociationExpression("ultimos", this.getDetachedCriteria());
		mas_gustaId = new IntegerExpression("mas_gusta.ID", this.getDetachedCriteria());
		mas_gusta = new AssociationExpression("mas_gusta", this.getDetachedCriteria());
		lista_repId = new IntegerExpression("lista_rep.ID", this.getDetachedCriteria());
		lista_rep = new AssociationExpression("lista_rep", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.ID", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		usuario_historialId = new IntegerExpression("usuario_historial.ID", this.getDetachedCriteria());
		usuario_historial = new AssociationExpression("usuario_historial", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public VideoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.VideoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		es_propietarioId = new IntegerExpression("es_propietario.ID", this.getDetachedCriteria());
		es_propietario = new AssociationExpression("es_propietario", this.getDetachedCriteria());
		usuarios = new CollectionExpression("ORM_usuarios", this.getDetachedCriteria());
		relacionadosId = new IntegerExpression("relacionados.ID", this.getDetachedCriteria());
		relacionados = new AssociationExpression("relacionados", this.getDetachedCriteria());
		ultimosId = new IntegerExpression("ultimos.ID", this.getDetachedCriteria());
		ultimos = new AssociationExpression("ultimos", this.getDetachedCriteria());
		mas_gustaId = new IntegerExpression("mas_gusta.ID", this.getDetachedCriteria());
		mas_gusta = new AssociationExpression("mas_gusta", this.getDetachedCriteria());
		lista_repId = new IntegerExpression("lista_rep.ID", this.getDetachedCriteria());
		lista_rep = new AssociationExpression("lista_rep", this.getDetachedCriteria());
		categoriaId = new IntegerExpression("categoria.ID", this.getDetachedCriteria());
		categoria = new AssociationExpression("categoria", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		etiqueta = new StringExpression("etiqueta", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		visualizaciones = new IntegerExpression("visualizaciones", this.getDetachedCriteria());
		miniatura = new StringExpression("miniatura", this.getDetachedCriteria());
		megusta = new IntegerExpression("megusta", this.getDetachedCriteria());
		usuario_historialId = new IntegerExpression("usuario_historial.ID", this.getDetachedCriteria());
		usuario_historial = new AssociationExpression("usuario_historial", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}
	
	public UsuarioDetachedCriteria createEs_propietarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_propietario"));
	}
	
	public UsuarioDetachedCriteria createUsuariosCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_usuarios"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createRelacionadosCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("relacionados"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createUltimosCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ultimos"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createMas_gustaCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("mas_gusta"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createLista_repCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("lista_rep"));
	}
	
	public CategoriaDetachedCriteria createCategoriaCriteria() {
		return new CategoriaDetachedCriteria(createCriteria("categoria"));
	}
	
	public UsuarioDetachedCriteria createUsuario_historialCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario_historial"));
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

