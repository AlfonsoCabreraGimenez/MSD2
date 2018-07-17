package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import diagramaclasesbd.BD_Principal;

public class Modificar_Video extends Modificar_Video_ventana{

	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	Subir_Video_ventana svv = new Subir_Video_ventana();

	iUsuario_Registrado ur = new BD_Principal();
	
	public Modificar_Video() {
		//Subir_Video_ventana svv = new Subir_Video_ventana();
		inicializar();
	}
	public void inicializar() {
		hURL.setVisible(false);
		List <String> nombresCat = new ArrayList<String>();
		for(diagramaclasesbd.Categoria cat :  ur.cargarCategorias()) {
			nombresCat.add(cat.getNombre());
		}
		categoria.setItems(nombresCat);
	}
	public void modificarDatosVideo() {
		String mini = miniatura.getValue();
		String titu = titulo.getValue();
		Optional<String> seleccion = categoria.getSelectedItem();
		String cate = seleccion.get();
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();

		ur.modificarDatosVideo(titu, cate, etique, des, mini);
	}

	public void cargarModificarVideo() {
		throw new UnsupportedOperationException();
	}
}