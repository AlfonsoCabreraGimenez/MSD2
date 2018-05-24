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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USUARIO_SUSCRIPCIONES) {
			return ORM_suscripciones;
		}
		else if (key == ORMConstants.KEY_USUARIO_PROPIEDAD_VIDEO_DE) {
			return ORM_propiedad_video_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_ME_GUSTA) {
			return ORM_me_gusta;
		}
		else if (key == ORMConstants.KEY_USUARIO_PROPIEDAD_DE) {
			return ORM_propiedad_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_HISTORIAL) {
			return ORM_historial;
		}
		else if (key == ORMConstants.KEY_USUARIO_OTROS_USUARIO) {
			return ORM_otros_usuario;
		}
		else if (key == ORMConstants.KEY_USUARIO_SUSCRIPTORES) {
			return ORM_suscriptores;
		}
		else if (key == ORMConstants.KEY_USUARIO_ES_ESCRITO) {
			return ORM_es_escrito;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USUARIO_ES_SUSCRIPTOR) {
			this.es_suscriptor = (diagramaclasesbd.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_USUARIO_USUARIO) {
			this.usuario = (diagramaclasesbd.Usuario) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DIAGRAMACLASESBD_USUARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_USUARIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID2", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuario;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario es_suscriptor;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Apellido1", nullable=true, length=255)	
	private String apellido1;
	
	@Column(name="Apellido2", nullable=true, length=255)	
	private String apellido2;
	
	@Column(name="FechaN", nullable=true)	
	private date fechaN;
	
	@Column(name="Apodo", nullable=true, length=255)	
	private String apodo;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="Avatar", nullable=true, length=255)	
	private String avatar;
	
	@OneToMany(mappedBy="usuario", targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_suscripciones = new java.util.HashSet();
	
	@OneToMany(mappedBy="es_propietario", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_propiedad_video_de = new java.util.HashSet();
	
	@ManyToMany(targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Video_Usuario", joinColumns={ @JoinColumn(name="UsuarioID") }, inverseJoinColumns={ @JoinColumn(name="VideoId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_me_gusta = new java.util.HashSet();
	
	@OneToMany(mappedBy="es_propietario_de", targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_propiedad_de = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuarioHistorial", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_historial = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuario", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_otros_usuario = new java.util.HashSet();
	
	@OneToMany(mappedBy="es_suscriptor", targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_suscriptores = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuarioComentario", targetEntity=diagramaclasesbd.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_escrito = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido1(String value) {
		this.apellido1 = value;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido2(String value) {
		this.apellido2 = value;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setFechaN(date value) {
		this.fechaN = value;
	}
	
	public date getFechaN() {
		return fechaN;
	}
	
	public void setApodo(String value) {
		this.apodo = value;
	}
	
	public String getApodo() {
		return apodo;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setEs_suscriptor(diagramaclasesbd.Usuario value) {
		if (es_suscriptor != null) {
			es_suscriptor.suscriptores.remove(this);
		}
		if (value != null) {
			value.suscriptores.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getEs_suscriptor() {
		return es_suscriptor;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_suscriptor(diagramaclasesbd.Usuario value) {
		this.es_suscriptor = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Es_suscriptor() {
		return es_suscriptor;
	}
	
	private void setORM_Suscripciones(java.util.Set value) {
		this.ORM_suscripciones = value;
	}
	
	private java.util.Set getORM_Suscripciones() {
		return ORM_suscripciones;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection suscripciones = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_SUSCRIPCIONES, ORMConstants.KEY_USUARIO_USUARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Propiedad_video_de(java.util.Set value) {
		this.ORM_propiedad_video_de = value;
	}
	
	private java.util.Set getORM_Propiedad_video_de() {
		return ORM_propiedad_video_de;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection propiedad_video_de = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_PROPIEDAD_VIDEO_DE, ORMConstants.KEY_VIDEO_ES_PROPIETARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Me_gusta(java.util.Set value) {
		this.ORM_me_gusta = value;
	}
	
	private java.util.Set getORM_Me_gusta() {
		return ORM_me_gusta;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection me_gusta = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ME_GUSTA, ORMConstants.KEY_VIDEO_USUARIOS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Propiedad_de(java.util.Set value) {
		this.ORM_propiedad_de = value;
	}
	
	private java.util.Set getORM_Propiedad_de() {
		return ORM_propiedad_de;
	}
	
	@Transient	
	public final diagramaclasesbd.Lista_De_ReproduccionSetCollection propiedad_de = new diagramaclasesbd.Lista_De_ReproduccionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_PROPIEDAD_DE, ORMConstants.KEY_LISTA_DE_REPRODUCCION_ES_PROPIETARIO_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Historial(java.util.Set value) {
		this.ORM_historial = value;
	}
	
	private java.util.Set getORM_Historial() {
		return ORM_historial;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection historial = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_HISTORIAL, ORMConstants.KEY_VIDEO_USUARIOHISTORIAL, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Otros_usuario(java.util.Set value) {
		this.ORM_otros_usuario = value;
	}
	
	private java.util.Set getORM_Otros_usuario() {
		return ORM_otros_usuario;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection otros_usuario = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_OTROS_USUARIO, ORMConstants.KEY_VIDEO_USUARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Suscriptores(java.util.Set value) {
		this.ORM_suscriptores = value;
	}
	
	private java.util.Set getORM_Suscriptores() {
		return ORM_suscriptores;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection suscriptores = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_SUSCRIPTORES, ORMConstants.KEY_USUARIO_ES_SUSCRIPTOR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setUsuario(diagramaclasesbd.Usuario value) {
		if (usuario != null) {
			usuario.suscripciones.remove(this);
		}
		if (value != null) {
			value.suscripciones.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Usuario(diagramaclasesbd.Usuario value) {
		this.usuario = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Usuario() {
		return usuario;
	}
	
	private void setORM_Es_escrito(java.util.Set value) {
		this.ORM_es_escrito = value;
	}
	
	private java.util.Set getORM_Es_escrito() {
		return ORM_es_escrito;
	}
	
	@Transient	
	public final diagramaclasesbd.ComentarioSetCollection es_escrito = new diagramaclasesbd.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ES_ESCRITO, ORMConstants.KEY_COMENTARIO_USUARIOCOMENTARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
