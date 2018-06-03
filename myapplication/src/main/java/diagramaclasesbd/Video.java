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
@Table(name="Video")
public class Video implements Serializable {
	public Video() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_VIDEO_COMENTARIOS) {
			return ORM_comentarios;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_VIDEO_CATEGORIA) {
			this.categoria = (diagramaclasesbd.Categoria) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_LISTA_REP) {
			this.lista_rep = (diagramaclasesbd.Lista_De_Reproduccion) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_MAS_GUSTA) {
			this.mas_gusta = (diagramaclasesbd.Lista_De_Reproduccion) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_ULTIMOS) {
			this.ultimos = (diagramaclasesbd.Lista_De_Reproduccion) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_RELACIONADOS) {
			this.relacionados = (diagramaclasesbd.Lista_De_Reproduccion) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_ES_PROPIETARIO) {
			this.es_propietario = (diagramaclasesbd.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_USUARIO_HISTORIAL) {
			this.usuario_historial = (diagramaclasesbd.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_USUARIO) {
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
	@GeneratedValue(generator="DIAGRAMACLASESBD_VIDEO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_VIDEO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID3", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuario;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID2", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuario_historial;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario es_propietario;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Lista_De_ReproduccionID4", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Lista_De_Reproduccion relacionados;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Lista_De_ReproduccionID3", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Lista_De_Reproduccion ultimos;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Lista_De_ReproduccionID2", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Lista_De_Reproduccion mas_gusta;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Lista_De_ReproduccionID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Lista_De_Reproduccion lista_rep;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Categoria.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="CategoriaID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Categoria categoria;
	
	@Column(name="Url", nullable=true, length=255)	
	private String url;
	
	@Column(name="Titulo", nullable=true, length=255)	
	private String titulo;
	
	@Column(name="Etiqueta", nullable=true, length=255)	
	private String etiqueta;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Visualizaciones", nullable=false, length=10)	
	private int visualizaciones;
	
	@Column(name="Miniatura", nullable=true, length=255)	
	private String miniatura;
	
	@Column(name="Megusta", nullable=false, length=10)	
	private int megusta;
	
	@OneToMany(mappedBy="video_coment", targetEntity=diagramaclasesbd.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comentarios = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setEtiqueta(String value) {
		this.etiqueta = value;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setVisualizaciones(int value) {
		this.visualizaciones = value;
	}
	
	public int getVisualizaciones() {
		return visualizaciones;
	}
	
	public void setMiniatura(String value) {
		this.miniatura = value;
	}
	
	public String getMiniatura() {
		return miniatura;
	}
	
	public void setMegusta(int value) {
		this.megusta = value;
	}
	
	public int getMegusta() {
		return megusta;
	}
	
	public void setCategoria(diagramaclasesbd.Categoria value) {
		if (categoria != null) {
			categoria.videos.remove(this);
		}
		if (value != null) {
			value.videos.add(this);
		}
	}
	
	public diagramaclasesbd.Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Categoria(diagramaclasesbd.Categoria value) {
		this.categoria = value;
	}
	
	private diagramaclasesbd.Categoria getORM_Categoria() {
		return categoria;
	}
	
	public void setLista_rep(diagramaclasesbd.Lista_De_Reproduccion value) {
		if (lista_rep != null) {
			lista_rep.videos_rep.remove(this);
		}
		if (value != null) {
			value.videos_rep.add(this);
		}
	}
	
	public diagramaclasesbd.Lista_De_Reproduccion getLista_rep() {
		return lista_rep;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Lista_rep(diagramaclasesbd.Lista_De_Reproduccion value) {
		this.lista_rep = value;
	}
	
	private diagramaclasesbd.Lista_De_Reproduccion getORM_Lista_rep() {
		return lista_rep;
	}
	
	public void setMas_gusta(diagramaclasesbd.Lista_De_Reproduccion value) {
		if (mas_gusta != null) {
			mas_gusta.video_masmegusta.remove(this);
		}
		if (value != null) {
			value.video_masmegusta.add(this);
		}
	}
	
	public diagramaclasesbd.Lista_De_Reproduccion getMas_gusta() {
		return mas_gusta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Mas_gusta(diagramaclasesbd.Lista_De_Reproduccion value) {
		this.mas_gusta = value;
	}
	
	private diagramaclasesbd.Lista_De_Reproduccion getORM_Mas_gusta() {
		return mas_gusta;
	}
	
	public void setUltimos(diagramaclasesbd.Lista_De_Reproduccion value) {
		if (ultimos != null) {
			ultimos.videos_ultimos.remove(this);
		}
		if (value != null) {
			value.videos_ultimos.add(this);
		}
	}
	
	public diagramaclasesbd.Lista_De_Reproduccion getUltimos() {
		return ultimos;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Ultimos(diagramaclasesbd.Lista_De_Reproduccion value) {
		this.ultimos = value;
	}
	
	private diagramaclasesbd.Lista_De_Reproduccion getORM_Ultimos() {
		return ultimos;
	}
	
	public void setRelacionados(diagramaclasesbd.Lista_De_Reproduccion value) {
		if (relacionados != null) {
			relacionados.videos_rel.remove(this);
		}
		if (value != null) {
			value.videos_rel.add(this);
		}
	}
	
	public diagramaclasesbd.Lista_De_Reproduccion getRelacionados() {
		return relacionados;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Relacionados(diagramaclasesbd.Lista_De_Reproduccion value) {
		this.relacionados = value;
	}
	
	private diagramaclasesbd.Lista_De_Reproduccion getORM_Relacionados() {
		return relacionados;
	}
	
	public void setEs_propietario(diagramaclasesbd.Usuario value) {
		if (es_propietario != null) {
			es_propietario.propiedad_video_de.remove(this);
		}
		if (value != null) {
			value.propiedad_video_de.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getEs_propietario() {
		return es_propietario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_propietario(diagramaclasesbd.Usuario value) {
		this.es_propietario = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Es_propietario() {
		return es_propietario;
	}
	
	public void setUsuario_historial(diagramaclasesbd.Usuario value) {
		if (usuario_historial != null) {
			usuario_historial.historial.remove(this);
		}
		if (value != null) {
			value.historial.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getUsuario_historial() {
		return usuario_historial;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Usuario_historial(diagramaclasesbd.Usuario value) {
		this.usuario_historial = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Usuario_historial() {
		return usuario_historial;
	}
	
	public void setUsuario(diagramaclasesbd.Usuario value) {
		if (usuario != null) {
			usuario.otros_usuarios.remove(this);
		}
		if (value != null) {
			value.otros_usuarios.add(this);
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
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	@Transient	
	public final diagramaclasesbd.ComentarioSetCollection comentarios = new diagramaclasesbd.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_VIDEO_COMENTARIOS, ORMConstants.KEY_COMENTARIO_VIDEO_COMENT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
