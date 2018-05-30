package Codigo;

public class Visualizacion_Video_Ajeno_R extends Visualizacion_Video_Comun_Registrado {
	/*private Boton _darMegustaB;
	private TextArea _escribirTA;*/
	public Video2 _unnamed_Video2_;
	public Comentario_Video_Ajeno_R _unnamed_Comentario_Video_Ajeno_R_;

	public Visualizacion_Video_Ajeno_R() {
		inicializar();
	}
	
	void inicializar() {
		eliminarVideo.setVisible(false);
		modificarVideo.setVisible(false);
	}
	public void darMegusta() {
		throw new UnsupportedOperationException();
	}

	public void quitarMegusta() {
		throw new UnsupportedOperationException();
	}

	public void escribirComentario() {
		throw new UnsupportedOperationException();
	}
}