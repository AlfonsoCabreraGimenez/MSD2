package Codigo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.ui.Label;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Subir_Video extends Modificar_Video_ventana {

	public Cabecera_R _unnamed_Cabecera_R_;
	Modificar_Video mv = new Modificar_Video();

	public iUsuario_Registrado ur = new BD_Principal();
	
	public Subir_Video() {
		modificarInformacion.setVisible(false);
		
		hURL.setVisible(true);
		
	}
	public void subirVideo(){

		String mini = miniatura.getValue();
		String titu = titulo.getValue();
		String cate = categoria.getValue();
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();
		String urls = url.getValue();
		java.util.Date utilDate = new java.util.Date();
		

		ur.subirVideo(1, mini, titu, cate, etique, des, urls, utilDate);
		
		

	}
}