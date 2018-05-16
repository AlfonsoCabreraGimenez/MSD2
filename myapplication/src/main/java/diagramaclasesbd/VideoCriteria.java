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

public class VideoCriteria extends AbstractORMCriteria {
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
	
	public VideoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		categoriaId = new IntegerExpression("categoria.id", this);
		categoria = new AssociationExpression("categoria", this);
		usuarioId = new IntegerExpression("usuario.ID", this);
		usuario = new AssociationExpression("usuario", this);
		usuarioHistorialId = new IntegerExpression("usuarioHistorial.ID", this);
		usuarioHistorial = new AssociationExpression("usuarioHistorial", this);
		relacionadosId = new IntegerExpression("relacionados.id", this);
		relacionados = new AssociationExpression("relacionados", this);
		mas_gustaId = new IntegerExpression("mas_gusta.id", this);
		mas_gusta = new AssociationExpression("mas_gusta", this);
		ultimosId = new IntegerExpression("ultimos.id", this);
		ultimos = new AssociationExpression("ultimos", this);
		lista_repId = new IntegerExpression("lista_rep.id", this);
		lista_rep = new AssociationExpression("lista_rep", this);
		es_propietarioId = new IntegerExpression("es_propietario.ID", this);
		es_propietario = new AssociationExpression("es_propietario", this);
		titulo = new StringExpression("titulo", this);
		etiqueta = new StringExpression("etiqueta", this);
		descripcion = new StringExpression("descripcion", this);
		visualizaciones = new IntegerExpression("visualizaciones", this);
		miniatura = new StringExpression("miniatura", this);
		megusta = new IntegerExpression("megusta", this);
		comentario = new CollectionExpression("ORM_comentario", this);
		usuarios = new CollectionExpression("ORM_usuarios", this);
	}
	
	public VideoCriteria(PersistentSession session) {
		this(session.createCriteria(Video.class));
	}
	
	public VideoCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public CategoriaCriteria createCategoriaCriteria() {
		return new CategoriaCriteria(createCriteria("categoria"));
	}
	
	public UsuarioCriteria createUsuarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario"));
	}
	
	public UsuarioCriteria createUsuarioHistorialCriteria() {
		return new UsuarioCriteria(createCriteria("usuarioHistorial"));
	}
	
	public Lista_De_ReproduccionCriteria createRelacionadosCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("relacionados"));
	}
	
	public Lista_De_ReproduccionCriteria createMas_gustaCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("mas_gusta"));
	}
	
	public Lista_De_ReproduccionCriteria createUltimosCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("ultimos"));
	}
	
	public Lista_De_ReproduccionCriteria createLista_repCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("lista_rep"));
	}
	
	public UsuarioCriteria createEs_propietarioCriteria() {
		return new UsuarioCriteria(createCriteria("es_propietario"));
	}
	
	public ComentarioCriteria createComentarioCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentario"));
	}
	
	public UsuarioCriteria createUsuariosCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_usuarios"));
	}
	
	public Video uniqueVideo() {
		return (Video) super.uniqueResult();
	}
	
	public Video[] listVideo() {
		java.util.List list = super.list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}

