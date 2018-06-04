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
		if (key == ORMConstants.KEY_USUARIO_USUARIO_SUCRIPCIONES) {
			return ORM_usuario_sucripciones;
		}
		else if (key == ORMConstants.KEY_USUARIO_SUSCRIPTORES) {
			return ORM_suscriptores;
		}
		else if (key == ORMConstants.KEY_USUARIO_SUSCRIPCIONES) {
			return ORM_suscripciones;
		}
		else if (key == ORMConstants.KEY_USUARIO_USUARIO_SUSCRIPTORES) {
			return ORM_usuario_suscriptores;
		}
		else if (key == ORMConstants.KEY_USUARIO_PROP_DE) {
			return ORM_prop_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_ES_ESCRITO) {
			return ORM_es_escrito;
		}
		else if (key == ORMConstants.KEY_USUARIO_PROP_VIDEO_DE) {
			return ORM_prop_video_de;
		}
		else if (key == ORMConstants.KEY_USUARIO_ME_GUSTA) {
			return ORM_me_gusta;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DIAGRAMACLASESBD_USUARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_USUARIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Apellido1", nullable=true, length=255)	
	private String apellido1;
	
	@Column(name="Apellido2", nullable=true, length=255)	
	private String apellido2;
	
	@Column(name="FechaN", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaN;
	
	@Column(name="Apodo", nullable=true, length=255)	
	private String apodo;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="Avatar", nullable=true, length=255)	
	private String avatar;
	
	@Column(name="IsAdmin", nullable=false, length=1)	
	private boolean isAdmin;
	
	@Column(name="Visitas", nullable=false, length=10)	
	private int visitas;
	
	@ManyToMany(targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Usuario", joinColumns={ @JoinColumn(name="UsuarioID2") }, inverseJoinColumns={ @JoinColumn(name="UsuarioID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_usuario_sucripciones = new java.util.HashSet();
	
	@ManyToMany(targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Usuario2", joinColumns={ @JoinColumn(name="UsuarioID2") }, inverseJoinColumns={ @JoinColumn(name="UsuarioID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_suscriptores = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_usuario_sucripciones", targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_suscripciones = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_suscriptores", targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_usuario_suscriptores = new java.util.HashSet();
	
	@OneToMany(mappedBy="es_prop_lista", targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_prop_de = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuario_comentario", targetEntity=diagramaclasesbd.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_es_escrito = new java.util.HashSet();
	
	@OneToMany(mappedBy="usuario_video", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_prop_video_de = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_da_megusta", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_me_gusta = new java.util.HashSet();
	
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
	
	public void setFechaN(java.util.Date value) {
		this.fechaN = value;
	}
	
	public java.util.Date getFechaN() {
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
	
	public void setIsAdmin(boolean value) {
		this.isAdmin = value;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setVisitas(int value) {
		this.visitas = value;
	}
	
	public int getVisitas() {
		return visitas;
	}
	
	private void setORM_Usuario_sucripciones(java.util.Set value) {
		this.ORM_usuario_sucripciones = value;
	}
	
	private java.util.Set getORM_Usuario_sucripciones() {
		return ORM_usuario_sucripciones;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection usuario_sucripciones = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_USUARIO_SUCRIPCIONES, ORMConstants.KEY_USUARIO_SUSCRIPCIONES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Suscriptores(java.util.Set value) {
		this.ORM_suscriptores = value;
	}
	
	private java.util.Set getORM_Suscriptores() {
		return ORM_suscriptores;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection suscriptores = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_SUSCRIPTORES, ORMConstants.KEY_USUARIO_USUARIO_SUSCRIPTORES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Suscripciones(java.util.Set value) {
		this.ORM_suscripciones = value;
	}
	
	private java.util.Set getORM_Suscripciones() {
		return ORM_suscripciones;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection suscripciones = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_SUSCRIPCIONES, ORMConstants.KEY_USUARIO_USUARIO_SUCRIPCIONES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Usuario_suscriptores(java.util.Set value) {
		this.ORM_usuario_suscriptores = value;
	}
	
	private java.util.Set getORM_Usuario_suscriptores() {
		return ORM_usuario_suscriptores;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection usuario_suscriptores = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_USUARIO_SUSCRIPTORES, ORMConstants.KEY_USUARIO_SUSCRIPTORES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Prop_de(java.util.Set value) {
		this.ORM_prop_de = value;
	}
	
	private java.util.Set getORM_Prop_de() {
		return ORM_prop_de;
	}
	
	@Transient	
	public final diagramaclasesbd.Lista_De_ReproduccionSetCollection prop_de = new diagramaclasesbd.Lista_De_ReproduccionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_PROP_DE, ORMConstants.KEY_LISTA_DE_REPRODUCCION_ES_PROP_LISTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Es_escrito(java.util.Set value) {
		this.ORM_es_escrito = value;
	}
	
	private java.util.Set getORM_Es_escrito() {
		return ORM_es_escrito;
	}
	
	@Transient	
	public final diagramaclasesbd.ComentarioSetCollection es_escrito = new diagramaclasesbd.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ES_ESCRITO, ORMConstants.KEY_COMENTARIO_USUARIO_COMENTARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Prop_video_de(java.util.Set value) {
		this.ORM_prop_video_de = value;
	}
	
	private java.util.Set getORM_Prop_video_de() {
		return ORM_prop_video_de;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection prop_video_de = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_PROP_VIDEO_DE, ORMConstants.KEY_VIDEO_USUARIO_VIDEO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Me_gusta(java.util.Set value) {
		this.ORM_me_gusta = value;
	}
	
	private java.util.Set getORM_Me_gusta() {
		return ORM_me_gusta;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection me_gusta = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_ME_GUSTA, ORMConstants.KEY_VIDEO_DA_MEGUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
