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

public class AdministradorDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final CollectionExpression prop_de;
	public final CollectionExpression es_escrito;
	public final CollectionExpression prop_video_de;
	public final CollectionExpression me_gusta;
	public final CollectionExpression visto_por;
	
	public AdministradorDetachedCriteria() {
		super(diagramaclasesbd.Administrador.class, diagramaclasesbd.AdministradorCriteria.class);
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
		prop_de = new CollectionExpression("ORM_prop_de", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
		prop_video_de = new CollectionExpression("ORM_prop_video_de", this.getDetachedCriteria());
		me_gusta = new CollectionExpression("ORM_me_gusta", this.getDetachedCriteria());
		visto_por = new CollectionExpression("ORM_visto_por", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, diagramaclasesbd.AdministradorCriteria.class);
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
		prop_de = new CollectionExpression("ORM_prop_de", this.getDetachedCriteria());
		es_escrito = new CollectionExpression("ORM_es_escrito", this.getDetachedCriteria());
		prop_video_de = new CollectionExpression("ORM_prop_video_de", this.getDetachedCriteria());
		me_gusta = new CollectionExpression("ORM_me_gusta", this.getDetachedCriteria());
		visto_por = new CollectionExpression("ORM_visto_por", this.getDetachedCriteria());
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
	
	public Lista_De_ReproduccionDetachedCriteria createProp_deCriteria() {
		return new Lista_De_ReproduccionDetachedCriteria(createCriteria("ORM_prop_de"));
	}
	
	public ComentarioDetachedCriteria createEs_escritoCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_es_escrito"));
	}
	
	public VideoDetachedCriteria createProp_video_deCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_prop_video_de"));
	}
	
	public VideoDetachedCriteria createMe_gustaCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_me_gusta"));
	}
	
	public VideoDetachedCriteria createVisto_porCriteria() {
		return new VideoDetachedCriteria(createCriteria("ORM_visto_por"));
	}
	
	public Administrador uniqueAdministrador(PersistentSession session) {
		return (Administrador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Administrador[] listAdministrador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

