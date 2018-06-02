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
@Table(name="Categoria")
public class Categoria implements Serializable {
	public Categoria() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CATEGORIA_VIDEOS) {
			return ORM_videos;
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
	@GeneratedValue(generator="DIAGRAMACLASESBD_CATEGORIA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_CATEGORIA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Edad", nullable=false, length=10)	
	private int edad;
	
	@OneToMany(mappedBy="categoria", targetEntity=diagramaclasesbd.Video.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_videos = new java.util.HashSet();
	
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
	
	public void setEdad(int value) {
		this.edad = value;
	}
	
	public int getEdad() {
		return edad;
	}
	
	private void setORM_Videos(java.util.Set value) {
		this.ORM_videos = value;
	}
	
	private java.util.Set getORM_Videos() {
		return ORM_videos;
	}
	
	@Transient	
	public final diagramaclasesbd.VideoSetCollection videos = new diagramaclasesbd.VideoSetCollection(this, _ormAdapter, ORMConstants.KEY_CATEGORIA_VIDEOS, ORMConstants.KEY_VIDEO_CATEGORIA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
