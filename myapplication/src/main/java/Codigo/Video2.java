package Codigo;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Video2 extends Video2_ventana{
	/*private Label _tituloL;
	private Boton _tituloB;
	private Label _usuarioPropL;
	private Boton _usuarioPropB;
	private Label _categoriaL;
	private Label _etiquetaL;
	private Label _fechaSuL;
	private Imagen _minuaturaI;
	private Boton _miniaturaB;*/
	private TipoUsuario _usuario;
	public Lista_Videos_De_Reproduccion _unnamed_Lista_Videos_De_Reproduccion_;
	public Pag_Inicio_NR _unnamed_Pag_Inicio_NR_;
	public Pag_Inicio_R _unnamed_Pag_Inicio_R_;
	public Buscador_Video _unnamed_Buscador_Video_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Perfil_Ajeno_R _unnamed_Perfil_Ajeno_R_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public Perfil_Ajeno_A _unnamed_Perfil_Ajeno_A_;
	public Visualizacion_Video_Ajeno _unnamed_Visualizacion_Video_Ajeno_;
	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	public Visualizacion_Video_Ajeno_A _unnamed_Visualizacion_Video_Ajeno_A_;
	public Visualizacion_Video_Ajeno_R _unnamed_Visualizacion_Video_Ajeno_R_;
	
	public Video2() {
		titulo.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("VisAjeno");
			}
		});
		usuario.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("PAjeno");
			}
		});
	}
}