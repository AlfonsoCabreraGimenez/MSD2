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

public class RegistradoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public RegistradoDetachedCriteria() {
		super(diagramaclasesbd.Registrado.class, diagramaclasesbd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		es_suscriptorId = new IntegerExpression("es_suscriptor.ID", this.getDetachedCriteria());
		es_suscriptor = new AssociationExpression("es_suscriptor", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido1 = new StringExpression("apellido1", this.getDetachedCriteria());
		apellido2 = new StringExpression("apellido2", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		suscripciones = new CollectionExpression("ORM_suscripciones", this.getDetachedCriteria());
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this.getDetachedCriteria());
		me_gusta = new CollectionExpression("ORM_me_gusta", this.getDetachedCriteria());
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this.getDetachedCriteria());
		historial = new CollectionExpression("ORM_historial", this.getDetachedCriteria());
		otros_usuario = new CollectionExpression("ORM_otros_usuario", this.getDetachedCriteria());
		suscriptores = new CollectionExpression("ORM_suscriptores", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
	}
	
	public RegistradoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		usuarioId = new IntegerExpression("usuario.ID", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		es_suscriptorId = new IntegerExpression("es_suscriptor.ID", this.getDetachedCriteria());
		es_suscriptor = new AssociationExpression("es_suscriptor", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido1 = new StringExpression("apellido1", this.getDetachedCriteria());
		apellido2 = new StringExpression("apellido2", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		suscripciones = new CollectionExpression("ORM_suscripciones", this.getDetachedCriteria());
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this.getDetachedCriteria());
		me_gusta = new CollectionExpression("ORM_me_gusta", this.getDetachedCriteria());
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this.getDetachedCriteria());
		historial = new CollectionExpression("ORM_historial", this.getDetachedCriteria());
		otros_usuario = new CollectionExpression("ORM_otros_usuario", this.getDetachedCriteria());
		suscriptores = new CollectionExpression("ORM_suscriptores", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}
	
	public UsuarioDetachedCriteria createEs_suscriptorCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("es_suscriptor"));
	}
	
	public UsuarioDetachedCriteria createSuscripcionesCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_suscripciones"));
	}
	
	public VideoDetachedCriteria createPropiedad_video_deCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_propiedad_video_de"));
	}
	
	public VideoDetachedCriteria createMe_gustaCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_me_gusta"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createPropiedad_deCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ORM_propiedad_de"));
	}
	
	public VideoDetachedCriteria createHistorialCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_historial"));
	}
	
	public VideoDetachedCriteria createOtros_usuarioCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_otros_usuario"));
	}
	
	public UsuarioDetachedCriteria createSuscriptoresCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_suscriptores"));
	}
	
	public ComentarioDetachedCriteria createEs_escritoCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_es_escrito"));
	}
	
	public Registrado uniqueRegistrado(PersistentSession session) {
		return (Registrado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Registrado[] listRegistrado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Registrado[]) list.toArray(new Registrado[list.size()]);
	}
}

