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
	
	public VideoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		usuarioId = new IntegerExpression("usuario.ID", this);
		usuario = new AssociationExpression("usuario", this);
		es_propietarioId = new IntegerExpression("es_propietario.ID", this);
		es_propietario = new AssociationExpression("es_propietario", this);
		usuarios = new CollectionExpression("ORM_usuarios", this);
		relacionadosId = new IntegerExpression("relacionados.ID", this);
		relacionados = new AssociationExpression("relacionados", this);
		ultimosId = new IntegerExpression("ultimos.ID", this);
		ultimos = new AssociationExpression("ultimos", this);
		mas_gustaId = new IntegerExpression("mas_gusta.ID", this);
		mas_gusta = new AssociationExpression("mas_gusta", this);
		lista_repId = new IntegerExpression("lista_rep.ID", this);
		lista_rep = new AssociationExpression("lista_rep", this);
		categoriaId = new IntegerExpression("categoria.ID", this);
		categoria = new AssociationExpression("categoria", this);
		url = new StringExpression("url", this);
		titulo = new StringExpression("titulo", this);
		etiqueta = new StringExpression("etiqueta", this);
		descripcion = new StringExpression("descripcion", this);
		visualizaciones = new IntegerExpression("visualizaciones", this);
		miniatura = new StringExpression("miniatura", this);
		megusta = new IntegerExpression("megusta", this);
		usuario_historialId = new IntegerExpression("usuario_historial.ID", this);
		usuario_historial = new AssociationExpression("usuario_historial", this);
		comentarios = new CollectionExpression("ORM_comentarios", this);
	}
	
	public VideoCriteria(PersistentSession session) {
		this(session.createCriteria(Video.class));
	}
	
	public VideoCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario"));
	}
	
	public UsuarioCriteria createEs_propietarioCriteria() {
		return new UsuarioCriteria(createCriteria("es_propietario"));
	}
	
	public UsuarioCriteria createUsuariosCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_usuarios"));
	}
	
	public Lista_De_ReproduccionCriteria createRelacionadosCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("relacionados"));
	}
	
	public Lista_De_ReproduccionCriteria createUltimosCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("ultimos"));
	}
	
	public Lista_De_ReproduccionCriteria createMas_gustaCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("mas_gusta"));
	}
	
	public Lista_De_ReproduccionCriteria createLista_repCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("lista_rep"));
	}
	
	public CategoriaCriteria createCategoriaCriteria() {
		return new CategoriaCriteria(createCriteria("categoria"));
	}
	
	public UsuarioCriteria createUsuario_historialCriteria() {
		return new UsuarioCriteria(createCriteria("usuario_historial"));
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

