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

public class RegistradoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression usuarioId;
	public final AssociationExpression usuario;
	public final IntegerExpression es_suscriptorId;
	public final AssociationExpression es_suscriptor;
	public final StringExpression nombre;
	public final StringExpression apellido1;
	public final StringExpression apellido2;
	public final StringExpression apodo;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression avatar;
	public final CollectionExpression suscripciones;
	public final CollectionExpression propiedad_video_de;
	public final CollectionExpression me_gusta;
	public final CollectionExpression propiedad_de;
	public final CollectionExpression historial;
	public final CollectionExpression otros_usuario;
	public final CollectionExpression suscriptores;
	public final CollectionExpression es_escrito;
	
	public RegistradoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		usuarioId = new IntegerExpression("usuario.ID", this);
		usuario = new AssociationExpression("usuario", this);
		es_suscriptorId = new IntegerExpression("es_suscriptor.ID", this);
		es_suscriptor = new AssociationExpression("es_suscriptor", this);
		nombre = new StringExpression("nombre", this);
		apellido1 = new StringExpression("apellido1", this);
		apellido2 = new StringExpression("apellido2", this);
		apodo = new StringExpression("apodo", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		avatar = new StringExpression("avatar", this);
		suscripciones = new CollectionExpression("ORM_suscripciones", this);
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this);
		me_gusta = new CollectionExpression("ORM_me_gusta", this);
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this);
		historial = new CollectionExpression("ORM_historial", this);
		otros_usuario = new CollectionExpression("ORM_otros_usuario", this);
		suscriptores = new CollectionExpression("ORM_suscriptores", this);
		es_escrito = new CollectionExpression("ORM_es_escrito", this);
	}
	
	public RegistradoCriteria(PersistentSession session) {
		this(session.createCriteria(Registrado.class));
	}
	
	public RegistradoCriteria() throws PersistentException {
		this(Actividad11CabreraFuentesPersistentManager.instance().getSession());
	}
	
	public UsuarioCriteria createUsuarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario"));
	}
	
	public UsuarioCriteria createEs_suscriptorCriteria() {
		return new UsuarioCriteria(createCriteria("es_suscriptor"));
	}
	
	public UsuarioCriteria createSuscripcionesCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_suscripciones"));
	}
	
	public VideoCriteria createPropiedad_video_deCriteria() {
		return new VideoCriteria(createCriteria("ORM_propiedad_video_de"));
	}
	
	public VideoCriteria createMe_gustaCriteria() {
		return new VideoCriteria(createCriteria("ORM_me_gusta"));
	}
	
	public Lista_De_ReproduccionCriteria createPropiedad_deCriteria() {
		return new Lista_De_ReproduccionCriteria(createCriteria("ORM_propiedad_de"));
	}
	
	public VideoCriteria createHistorialCriteria() {
		return new VideoCriteria(createCriteria("ORM_historial"));
	}
	
	public VideoCriteria createOtros_usuarioCriteria() {
		return new VideoCriteria(createCriteria("ORM_otros_usuario"));
	}
	
	public UsuarioCriteria createSuscriptoresCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_suscriptores"));
	}
	
	public ComentarioCriteria createEs_escritoCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_es_escrito"));
	}
	
	public Registrado uniqueRegistrado() {
		return (Registrado) super.uniqueResult();
	}
	
	public Registrado[] listRegistrado() {
		java.util.List list = super.list();
		return (Registrado[]) list.toArray(new Registrado[list.size()]);
	}
}

