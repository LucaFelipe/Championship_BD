package projetoBD_POO.cadrasto.partida;

public class Partida {
	private int idPartida;
	private int participante_IdParticpante1;
    private int participante_IdParticpante2;
    private int organizador_IdOrganizador;
    
    public int getOrganizador_IdOrganizador() {
		return organizador_IdOrganizador;
	}

	public void setOrganizador_IdOrganizador(int organizador_IdOrganizador) {
		this.organizador_IdOrganizador = organizador_IdOrganizador;
	}

	public int getParticipante_IdParticpante1() {
        return participante_IdParticpante1;
    }

    public void setParticipante_IdParticpant1(int participante_IdParticpante1) {
        this.participante_IdParticpante1 = participante_IdParticpante1;
    }

    public int getParticipante_IdParticpante2() {
        return participante_IdParticpante2;
    }

    public void setParticipante_IdParticpante2(int participante_IdParticpante2) {
        this.participante_IdParticpante2 = participante_IdParticpante2;
    }
    
    public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

}
