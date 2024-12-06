public class SalaDeReuniao extends Salas implements Reservavel {
    private boolean videochamada;

    public SalaDeReuniao(String nome, int capacidade, boolean videochamada) {
        super(nome, capacidade);
        this.videochamada = videochamada;
    }

    public boolean getVideochamada() {
        return videochamada;
    }

    public void setVideochamada(boolean videochamada) {
        this.videochamada = videochamada;
    }

    @Override
    public String toString() {
        return super.toString() + ", SalaDeReuniao{" +
                "videochamada='" + videochamada + '\'' +
                '}';
    }

    @Override
    public void reservar(String nomeSala, String dataEvento) {
        if (isDisponivel()) {
            setDisponivel(false);
            System.out.println("Sala \"" + nomeSala + "\" reservada para " + dataEvento);
        } else {
            System.out.println("A sala " + nomeSala + " já está reservada.");
        }
    }

    @Override
    public void liberar() {
        setDisponivel(true);
        System.out.println("A sala " + getNome() + " foi liberada.");
    }
}
