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
@Table(name="Lista_De_Reproduccion")
public class Lista_De_Reproduccion implements Serializable {
	public Lista_De_Reproduccion() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO) {
			return ORM_video;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LISTA_DE_REPRODUCCION_ES_PROP_LISTA) {
			this.es_prop_lista = (diagramaclasesbd.Usuario) owner;
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
	private diagramaclasesbd.Usuario es_prop_lista;
	
	@Column(name="Titulo", nullable=true, length=255)	
	private String titulo;
	
	@ManyToMany(mappedBy="ORM_lista_de_Reproduccion", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_video = new java.util.HashSet();
	
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
	
	public void setEs_prop_lista(diagramaclasesbd.Usuario value) {
		if (es_prop_lista != null) {
			es_prop_lista.prop_de.remove(this);
		}
		if (value != null) {
			value.prop_de.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getEs_prop_lista() {
		return es_prop_lista;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_prop_lista(diagramaclasesbd.Usuario value) {
		this.es_prop_lista = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Es_prop_lista() {
		return es_prop_lista;
	}
	
	private void setORM_Video(java.util.Set value) {
		this.ORM_video = value;
	}
	
	private java.util.Set getORM_Video() {
		return ORM_video;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection video = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_LISTA_DE_REPRODUCCION_VIDEO, ORMConstants.KEY_VIDEO_LISTA_DE_REPRODUCCION, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
