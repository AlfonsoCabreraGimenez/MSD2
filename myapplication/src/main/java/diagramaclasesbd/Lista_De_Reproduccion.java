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
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS_REP) {
			return ORM_videos_rep;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO_MASMEGUSTA) {
			return ORM_video_masmegusta;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS_ULTIMOS) {
			return ORM_videos_ultimos;
		}
		else if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOSREL) {
			return ORM_videosRel;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_ES_PROPIETARIO_LISTA) {
			this.es_propietario_lista = (diagramaclasesbd.Usuario) owner;
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
	@GeneratedValue(generator="DIAGRAMACLASESBD_LISTA_DE_REPRODUCCION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_LISTA_DE_REPRODUCCION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario es_propietario_lista;
	
	@Column(name="Titulo", nullable=true, length=255)	
	private String titulo;
	
	@OneToMany(mappedBy="lista_rep", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videos_rep = new java.util.HashSet();
	
	@OneToMany(mappedBy="mas_gusta", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_video_masmegusta = new java.util.HashSet();
	
	@OneToMany(mappedBy="ultimos", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videos_ultimos = new java.util.HashSet();
	
	@OneToMany(mappedBy="relacionados", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videosRel = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTitulo(String value) {
		this.titulo = value;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	private void setORM_Videos_rep(java.util.Set value) {
		this.ORM_videos_rep = value;
	}
	
	private java.util.Set getORM_Videos_rep() {
		return ORM_videos_rep;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videos_rep = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS_REP, ORMConstants.KEY_VIDEO_LISTA_REP, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Video_masmegusta(java.util.Set value) {
		this.ORM_video_masmegusta = value;
	}
	
	private java.util.Set getORM_Video_masmegusta() {
		return ORM_video_masmegusta;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection video_masmegusta = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO_MASMEGUSTA, ORMConstants.KEY_VIDEO_MAS_GUSTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Videos_ultimos(java.util.Set value) {
		this.ORM_videos_ultimos = value;
	}
	
	private java.util.Set getORM_Videos_ultimos() {
		return ORM_videos_ultimos;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videos_ultimos = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOS_ULTIMOS, ORMConstants.KEY_VIDEO_ULTIMOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_VideosRel(java.util.Set value) {
		this.ORM_videosRel = value;
	}
	
	private java.util.Set getORM_VideosRel() {
		return ORM_videosRel;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videosRel = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEOSREL, ORMConstants.KEY_VIDEO_RELACIONADOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setEs_propietario_lista(diagramaclasesbd.Usuario value) {
		if (es_propietario_lista != null) {
			es_propietario_lista.propiedad_de.remove(this);
		}
		if (value != null) {
			value.propiedad_de.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getEs_propietario_lista() {
		return es_propietario_lista;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_propietario_lista(diagramaclasesbd.Usuario value) {
		this.es_propietario_lista = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Es_propietario_lista() {
		return es_propietario_lista;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
