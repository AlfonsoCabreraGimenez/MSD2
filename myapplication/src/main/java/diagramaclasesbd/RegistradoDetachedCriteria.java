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
	
	public RegistradoDetachedCriteria() {
		super(diagramaclasesbd.Registrado.class, diagramaclasesbd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido1 = new StringExpression("apellido1", this.getDetachedCriteria());
		apellido2 = new StringExpression("apellido2", this.getDetachedCriteria());
		fechaN = new DateExpression("fechaN", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		isAdmin = new BooleanExpression("isAdmin", this.getDetachedCriteria());
		visitas = new IntegerExpression("visitas", this.getDetachedCriteria());
		usuario_sucripciones = new CollectionExpression("ORM_usuario_sucripciones", this.getDetachedCriteria());
		suscriptores = new CollectionExpression("ORM_suscriptores", this.getDetachedCriteria());
		suscripciones = new CollectionExpression("ORM_suscripciones", this.getDetachedCriteria());
		usuario_suscriptores = new CollectionExpression("ORM_usuario_suscriptores", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this.getDetachedCriteria());
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this.getDetachedCriteria());
		historial = new CollectionExpression("ORM_historial", this.getDetachedCriteria());
		otros_usuarios = new CollectionExpression("ORM_otros_usuarios", this.getDetachedCriteria());
	}
	
	public RegistradoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.RegistradoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido1 = new StringExpression("apellido1", this.getDetachedCriteria());
		apellido2 = new StringExpression("apellido2", this.getDetachedCriteria());
		fechaN = new DateExpression("fechaN", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		isAdmin = new BooleanExpression("isAdmin", this.getDetachedCriteria());
		visitas = new IntegerExpression("visitas", this.getDetachedCriteria());
		usuario_sucripciones = new CollectionExpression("ORM_usuario_sucripciones", this.getDetachedCriteria());
		suscriptores = new CollectionExpression("ORM_suscriptores", this.getDetachedCriteria());
		suscripciones = new CollectionExpression("ORM_suscripciones", this.getDetachedCriteria());
		usuario_suscriptores = new CollectionExpression("ORM_usuario_suscriptores", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
		propiedad_de = new CollectionExpression("ORM_propiedad_de", this.getDetachedCriteria());
		propiedad_video_de = new CollectionExpression("ORM_propiedad_video_de", this.getDetachedCriteria());
		historial = new CollectionExpression("ORM_historial", this.getDetachedCriteria());
		otros_usuarios = new CollectionExpression("ORM_otros_usuarios", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria createUsuario_sucripcionesCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_usuario_sucripciones"));
	}
	
	public UsuarioDetachedCriteria createSuscriptoresCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_suscriptores"));
	}
	
	public UsuarioDetachedCriteria createSuscripcionesCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_suscripciones"));
	}
	
	public UsuarioDetachedCriteria createUsuario_suscriptoresCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_usuario_suscriptores"));
	}
	
	public ComentarioDetachedCriteria createEs_escritoCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_es_escrito"));
	}
	
	public Lista_De_ReproduccionDetachedCriteria createPropiedad_deCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ORM_propiedad_de"));
	}
	
	public VideoDetachedCriteria createPropiedad_video_deCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_propiedad_video_de"));
	}
	
	public VideoDetachedCriteria createHistorialCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_historial"));
	}
	
	public VideoDetachedCriteria createOtros_usuariosCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_otros_usuarios"));
	}
	
	public Registrado uniqueRegistrado(PersistentSession session) {
		return (Registrado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Registrado[] listRegistrado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Registrado[]) list.toArray(new Registrado[list.size()]);
	}
}

