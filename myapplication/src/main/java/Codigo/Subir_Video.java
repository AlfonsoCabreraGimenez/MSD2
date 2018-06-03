package Codigo;

import diagramaclasesbd.BD_Principal;

public class Subir_Video extends Modificar_Video {

	public Cabecera_R _unnamed_Cabecera_R_;
	Modificar_Video mv = new Modificar_Video();

	public iUsuario_Registrado ur = new BD_Principal();
	
	public Subir_Video() {
		hURL.setVisible(true);
		
	}
	public void subirVideo() {
		//Se implementa subir video
		//int ID = /*ID del video*/ 6;
		String url = mv.url.getValue();
		//String miniatura = mv.miniatura.getValue();
		String titulo = mv.titulo.getValue();
		String categoria = null;
		String descripcion = mv.descripcion.getValue();
		String etiqueta = mv.etiqueta.getValue();
		
		//ur.subirVideo(1, null, "miniatura", titulo, categoria, etiqueta, categoria, url);

	}
}