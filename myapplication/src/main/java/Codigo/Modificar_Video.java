package Codigo;

import java.util.Date;

import diagramaclasesbd.BD_Principal;

public class Modificar_Video extends Modificar_Video_ventana{

	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	Subir_Video_ventana svv = new Subir_Video_ventana();

	iUsuario_Registrado ur = new BD_Principal();
	
	public Modificar_Video() {
		//Subir_Video_ventana svv = new Subir_Video_ventana();
		hURL.setVisible(false);
		modificarDatosVideo();
	
	}
	public void modificarDatosVideo() {
		String mini = miniatura.getValue();
		String titu = titulo.getValue();
		String cate = categoria.getValue();
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();

		ur.modificarDatosVideo(titu, cate, etique, des, mini);
		
	}

	public void cargarModificarVideo() {
		throw new UnsupportedOperationException();
	}
}