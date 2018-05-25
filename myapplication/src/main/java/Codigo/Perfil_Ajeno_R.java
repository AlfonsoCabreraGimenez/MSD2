package Codigo;

public class Perfil_Ajeno_R extends Perfil_Ajeno_R_ventana {
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Conf_Suscribirse _unnamed_Conf_Suscribirse_;

	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	public Perfil_Ajeno_R(){
		inicializar();
	}
	
	void inicializar(){
		hCabeceraComunInicio.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
	}
	public void suscribirse() {
		throw new UnsupportedOperationException();
	}
}