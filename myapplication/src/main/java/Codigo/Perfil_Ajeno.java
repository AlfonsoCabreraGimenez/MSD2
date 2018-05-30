package Codigo;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Ajeno extends Perfil_Ajeno_ventana implements View{
	/*private Label _suscriptoresL;
	private Label _visitasL;
	private Label _apodoL;
	private Imagen _avatarI;
	private Boton _videosB;
	private Boton _listaReproduccionB;
	private Boton _suscripcionesB;
	private Boton _suscriptoresB;
	private Boton _suscribirseB;*/
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Registrarse _unnamed_Registrarse_;

	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_NR cnr = new Cabecera_NR();
	Cabecera_R cr = new Cabecera_R();
	
	public Perfil_Ajeno(){
		inicializar();
	}
	
	void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cnr);
		suscribirse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("Ingreso");
			}
		});
		darDeBaja.setVisible(false);
	}
	
	public void cargarPerfilAjenoNR() {
		throw new UnsupportedOperationException();
	}
}