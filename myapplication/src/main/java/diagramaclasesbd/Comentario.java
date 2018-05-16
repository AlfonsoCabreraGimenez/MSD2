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
@Table(name="Comentario")
public class Comentario implements Serializable {
	public Comentario() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMENTARIO_VIDEO) {
			this.video = (diagramaclasesbd.Video) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_USUARIOCOMENTARIO) {
			this.usuarioComentario = (diagramaclasesbd.Usuario) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DIAGRAMACLASESBD_COMENTARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_COMENTARIO_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuarioComentario;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Video.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="VideoId", referencedColumnName="Id", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Video video;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setVideo(diagramaclasesbd.Video value) {
		if (video != null) {
			video.comentario.remove(this);
		}
		if (value != null) {
			value.comentario.add(this);
		}
	}
	
	public diagramaclasesbd.Video getVideo() {
		return video;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Video(diagramaclasesbd.Video value) {
		this.video = value;
	}
	
	private diagramaclasesbd.Video getORM_Video() {
		return video;
	}
	
	public void setUsuarioComentario(diagramaclasesbd.Usuario value) {
		if (usuarioComentario != null) {
			usuarioComentario.es_escrito.remove(this);
		}
		if (value != null) {
			value.es_escrito.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getUsuarioComentario() {
		return usuarioComentario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_UsuarioComentario(diagramaclasesbd.Usuario value) {
		this.usuarioComentario = value;
	}
	
	private diagramaclasesbd.Usuario getORM_UsuarioComentario() {
		return usuarioComentario;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
