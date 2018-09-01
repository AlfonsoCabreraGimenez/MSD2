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
@Table(name="Video")
public class Video implements Serializable {
	public Video() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_VIDEO_LISTA_DE_REPRODUCCION) {
			return ORM_lista_de_Reproduccion;
		}
		else if (key == ORMConstants.KEY_VIDEO_DA_MEGUSTA) {
			return ORM_da_megusta;
		}
		else if (key == ORMConstants.KEY_VIDEO_HA_VISTO) {
			return ORM_ha_visto;
		}
		else if (key == ORMConstants.KEY_VIDEO_COMENTARIOS) {
			return ORM_comentarios;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_VIDEO_USUARIO_VIDEO) {
			this.usuario_video = (diagramaclasesbd.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_VIDEO_CATEGORIA) {
			this.categoria = (diagramaclasesbd.Categoria) owner;
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
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuario_video;
	
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
	
	@Column(name="FechaCreacion", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaCreacion;
	
	@ManyToMany(targetEntity=diagramaclasesbd.Lista_De_Reproduccion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Lista_De_Reproduccion_Video", joinColumns={ @JoinColumn(name="VideoID") }, inverseJoinColumns={ @JoinColumn(name="Lista_De_ReproduccionID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_lista_de_Reproduccion = new java.util.HashSet();
	
	@ManyToMany(targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Video", joinColumns={ @JoinColumn(name="VideoID") }, inverseJoinColumns={ @JoinColumn(name="UsuarioID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_da_megusta = new java.util.HashSet();
	
	@ManyToMany(targetEntity=diagramaclasesbd.Usuario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Video2", joinColumns={ @JoinColumn(name="VideoID") }, inverseJoinColumns={ @JoinColumn(name="UsuarioID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_ha_visto = new java.util.HashSet();
	
	@OneToMany(mappedBy="video", targetEntity=diagramaclasesbd.Comentario.class)	
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
	
	public void setFechaCreacion(java.util.Date value) {
		this.fechaCreacion = value;
	}
	
	public java.util.Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setUsuario_video(diagramaclasesbd.Usuario value) {
		if (usuario_video != null) {
			usuario_video.prop_video_de.remove(this);
		}
		if (value != null) {
			value.prop_video_de.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getUsuario_video() {
		return usuario_video;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Usuario_video(diagramaclasesbd.Usuario value) {
		this.usuario_video = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Usuario_video() {
		return usuario_video;
	}
	
	private void setORM_Lista_de_Reproduccion(java.util.Set value) {
		this.ORM_lista_de_Reproduccion = value;
	}
	
	private java.util.Set getORM_Lista_de_Reproduccion() {
		return ORM_lista_de_Reproduccion;
	}
	
	@Transient	
	public final diagramaclasesbd.Lista_De_ReproduccionSetCollection lista_de_Reproduccion = new diagramaclasesbd.Lista_De_ReproduccionSetCollection(this, _ormAdapter, ORMConstants.KEY_VIDEO_LISTA_DE_REPRODUCCION, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Da_megusta(java.util.Set value) {
		this.ORM_da_megusta = value;
	}
	
	private java.util.Set getORM_Da_megusta() {
		return ORM_da_megusta;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection da_megusta = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_VIDEO_DA_MEGUSTA, ORMConstants.KEY_USUARIO_ME_GUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Ha_visto(java.util.Set value) {
		this.ORM_ha_visto = value;
	}
	
	private java.util.Set getORM_Ha_visto() {
		return ORM_ha_visto;
	}
	
	@Transient	
	public final diagramaclasesbd.UsuarioSetCollection ha_visto = new diagramaclasesbd.UsuarioSetCollection(this, _ormAdapter, ORMConstants.KEY_VIDEO_HA_VISTO, ORMConstants.KEY_USUARIO_VISTO_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
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
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	@Transient	
	public final diagramaclasesbd.ComentarioSetCollection comentarios = new diagramaclasesbd.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_VIDEO_COMENTARIOS, ORMConstants.KEY_COMENTARIO_VIDEO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
