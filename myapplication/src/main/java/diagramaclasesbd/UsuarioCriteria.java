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

public class UsuarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression apellido1;
	public final StringExpression apellido2;
	public final DateExpression fechaN;
	public final StringExpression apodo;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression avatar;
	public final BooleanExpression isAdmin;
	public final IntegerExpression visitas;
	public final CollectionExpression usuario_sucripciones;
	public final CollectionExpression suscriptores;
	public final CollectionExpression suscripciones;
	public final CollectionExpression usuario_suscriptores;
	public final CollectionExpression es_escrito;
	public final CollectionExpression propiedad_de;
	public final CollectionExpression propiedad_video_de;
	public final CollectionExpression historial;
	public final CollectionExpression otros_usuarios;
	
	public UsuarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		apellido1 = new StringExpression("apellido1", this);
		apellido2 = new StringExpression("apellido2", this);
		fechaN = new DateExpression("fechaN", this);
		apodo = new StringExpression("apodo", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		avatar = new StringExpression("avatar", this);
		isAdmin = new BooleanExpression("isAdmin", this);
		visitas = new IntegerExpression("visitas", this);
		usuario_sucripciones = new CollectionExpression("ORM_usuario_sucripciones", this);
		suscriptores = new CollectionExpression("ORM_suscriptores", this);
		suscripciones = new CollectionExpression("ORM_suscripciones", this);
		usuario_suscriptores = new CollectionExpression("ORM_usuario_suscriptores", this);
		es_escrito = new CollectionExpression("ORM_es_escrito", this);
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this);
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this);
		historial = new CollectionExpression("ORM_historial", this);
		otros_usuarios = new CollectionExpression("ORM_otros_usuarios", this);
	}
	
	public UsuarioCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario.class));
	}
	
	public UsuarioCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuario_sucripcionesCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_usuario_sucripciones"));
	}
	
	public UsuarioCriteria createSuscriptoresCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_suscriptores"));
	}
	
	public UsuarioCriteria createSuscripcionesCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_suscripciones"));
	}
	
	public UsuarioCriteria createUsuario_suscriptoresCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_usuario_suscriptores"));
	}
	
	public ComentarioCriteria createEs_escritoCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_es_escrito"));
	}
	
	public Lista_De_ReproduccionCriteria createPropiedad_deCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("ORM_propiedad_de"));
	}
	
	public VideoCriteria createPropiedad_video_deCriteria() {
		return new VideoCriteria(createCriteria("ORM_propiedad_video_de"));
	}
	
	public VideoCriteria createHistorialCriteria() {
		return new VideoCriteria(createCriteria("ORM_historial"));
	}
	
	public VideoCriteria createOtros_usuariosCriteria() {
		return new VideoCriteria(createCriteria("ORM_otros_usuarios"));
	}
	
	public Usuario uniqueUsuario() {
		return (Usuario) super.uniqueResult();
	}
	
	public Usuario[] listUsuario() {
		java.util.List list = super.list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

