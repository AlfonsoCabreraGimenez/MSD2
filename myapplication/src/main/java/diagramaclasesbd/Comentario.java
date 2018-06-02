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
		if (key == ORMConstants.KEY_COMENTARIO_VIDEO_COMENT) {
			this.video_coment = (diagramaclasesbd.Video) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_USUARIO_COMENTARIO) {
			this.usuario_comentario = (diagramaclasesbd.Usuario) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DIAGRAMACLASESBD_COMENTARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DIAGRAMACLASESBD_COMENTARIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UsuarioID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Usuario usuario_comentario;
	
	@ManyToOne(targetEntity=diagramaclasesbd.Video.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="VideoID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private diagramaclasesbd.Video video_coment;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setVideo_coment(diagramaclasesbd.Video value) {
		if (video_coment != null) {
			video_coment.comentarios.remove(this);
		}
		if (value != null) {
			value.comentarios.add(this);
		}
	}
	
	public diagramaclasesbd.Video getVideo_coment() {
		return video_coment;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Video_coment(diagramaclasesbd.Video value) {
		this.video_coment = value;
	}
	
	private diagramaclasesbd.Video getORM_Video_coment() {
		return video_coment;
	}
	
	public void setUsuario_comentario(diagramaclasesbd.Usuario value) {
		if (usuario_comentario != null) {
			usuario_comentario.es_escrito.remove(this);
		}
		if (value != null) {
			value.es_escrito.add(this);
		}
	}
	
	public diagramaclasesbd.Usuario getUsuario_comentario() {
		return usuario_comentario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Usuario_comentario(diagramaclasesbd.Usuario value) {
		this.usuario_comentario = value;
	}
	
	private diagramaclasesbd.Usuario getORM_Usuario_comentario() {
		return usuario_comentario;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
