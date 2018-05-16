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
@Table(name="Lista_De_Reproduccion")
public class Lista_De_Reproduccion implements Serializable {
	public Lista_De_Reproduccion() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO) {
			return ORM_video;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOMASMEGUSTA) {
			return ORM_videoMasMegusta;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOULTIMOS) {
			return ORM_videoUltimos;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS) {
			return ORM_videos;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_ES_PROPIETARIO_DE) {
			this.es_propietario_de = (diagramaclasesbd.Usuario) owner;
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
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DIAGRAMACLASESBD_LISTA_DE_REPRODUCCION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_LISTA_DE_REPRODUCCION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario es_propietario_de;
	
	@Column(name="Titulo", nullable=true, length=255)	
	private String titulo;
	
	@OneToMany(mappedBy="lista_rep", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_video = new java.util.HashSet();
	
	@OneToMany(mappedBy="mas_gusta", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videoMasMegusta = new java.util.HashSet();
	
	@OneToMany(mappedBy="ultimos", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videoUltimos = new java.util.HashSet();
	
	@OneToMany(mappedBy="relacionados", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videos = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	private void setORM_Video(java.util.Set value) {
		this.ORM_video = value;
	}
	
	private java.util.Set getORM_Video() {
		return ORM_video;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection video = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO, ORMConstants.KEY_VIDEO_LISTA_REP, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_VideoMasMegusta(java.util.Set value) {
		this.ORM_videoMasMegusta = value;
	}
	
	private java.util.Set getORM_VideoMasMegusta() {
		return ORM_videoMasMegusta;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videoMasMegusta = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOMASMEGUSTA, ORMConstants.KEY_VIDEO_MAS_GUSTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_VideoUltimos(java.util.Set value) {
		this.ORM_videoUltimos = value;
	}
	
	private java.util.Set getORM_VideoUltimos() {
		return ORM_videoUltimos;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videoUltimos = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOULTIMOS, ORMConstants.KEY_VIDEO_ULTIMOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Videos(java.util.Set value) {
		this.ORM_videos = value;
	}
	
	private java.util.Set getORM_Videos() {
		return ORM_videos;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videos = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS, ORMConstants.KEY_VIDEO_RELACIONADOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setEs_propietario_de(diagramaclasesbd.Usuario value) {
		if (es_propietario_de != null) {
			es_propietario_de.propiedad_de.remove(this);
		}
		if (value != null) {
			value.propiedad_de.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getEs_propietario_de() {
		return es_propietario_de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_propietario_de(diagramaclasesbd.Usuario value) {
		this.es_propietario_de = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Es_propietario_de() {
		return es_propietario_de;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
