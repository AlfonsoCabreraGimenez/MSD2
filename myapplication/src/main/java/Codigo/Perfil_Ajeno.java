package Codigo;

public class Perfil_Ajeno extends Perfil_Ajeno_ventana{
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
	
	public Perfil_Ajeno(){
		inicializar();
	}
	
	void inicializar(){
		hCabeceraComun.addComponent(cc);
		hCabeceraGeneral.addComponent(cnr);
	}
	
	public void cargarPerfilAjenoNR() {
		throw new UnsupportedOperationException();
	}
}