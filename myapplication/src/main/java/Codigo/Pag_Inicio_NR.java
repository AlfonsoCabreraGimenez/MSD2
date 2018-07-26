package Codigo;

import java.util.Date;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Categoria;
import diagramaclasesbd.Registrado;

public class Pag_Inicio_NR extends Pag_Inicio_NR_ventana implements View{
	/*private Label _lista_Video_Mas_Megusta;
	private Label _lista_Ultimos_Videos;*/
	public Cabecera_NR _unnamed_Cabecera_NR_;
	public Buscador _unnamed_Buscador_;
	public Video2 _unnamed_Video2_;
	Navigator navigator;
	Cabecera_Comun cc = new Cabecera_Comun();
	Buscador bus = new Buscador();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_R cr = new Cabecera_R();
	Pag_Inicio_R_ventana prv = new Pag_Inicio_R_ventana();
	iUsuario_No_Registrado unr = new BD_Principal();
	public Pag_Inicio_NR() {
		inicializar();
		cargar_Videos_Inicio_NR();
	}
	void inicializar() {
		hCabeceraInicioBus.addComponent(cc.inicio);
		hCabeceraInicioBus.addComponent(bus.vBuscador);
		hCabeceraInicioBus.addComponent(cnr.iniciarSesionRegistrarse);
	}
	public void cargar_Videos_Inicio_NR() {
		cargar_Videos_Masmegusta();
		cargar_Videos_Ultimos();
	}
	public void cargar_Videos_Masmegusta() {
		int cont = 0;
		for(diagramaclasesbd.Video video: unr.cargar_Videos_Masmegusta()) {
				Video2 vid = new Video2(video.getID());
				hPanelVideosMasMeGusta.addComponent(vid);
				vid.titulo.setCaption(video.getTitulo());
				Registrado reg = (Registrado) video.getUsuario_video();
				vid.usuario.setCaption(reg.getNombre());
				Categoria cat = video.getCategoria();
				vid.categoria.setValue(cat.getNombre());
				vid.etiqueta.setValue(video.getEtiqueta());
				Date fecha = video.getFechaCreacion();
				vid.fechasubida.setValue(fecha.toString());
				cont++;
				if(cont == 10) {
					break;
				}
		}
	}
	public void cargar_Videos_Ultimos() {
		int cont = 0;
		for(diagramaclasesbd.Video video: unr.cargar_Videos_Ultimos()) {
				Video2 vid = new Video2(video.getID());
				hPanelUltimosVideosSubidos.addComponent(vid);
				vid.titulo.setCaption(video.getTitulo());
				Registrado reg = (Registrado) video.getUsuario_video();
				vid.usuario.setCaption(reg.getNombre());
				Categoria cat = video.getCategoria();
				vid.categoria.setValue(cat.getNombre());
				vid.etiqueta.setValue(video.getEtiqueta());
				Date fecha = video.getFechaCreacion();
				vid.fechasubida.setValue(fecha.toString());
				cont++;
				if(cont == 10) {
					break;
				}
		}
	}
}