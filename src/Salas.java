

public abstract class Salas {
    private String nome;
    private int capacidade;
    private boolean disponivel;
    private String dataReserva;

    public Salas(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public abstract void reservar(String nomeSala, String dataEvento);

    public void liberar() {
        this.disponivel = true;
        this.dataReserva = null;
        System.out.println("A sala " + nome + " foi liberada.");
    }

    @Override
    public String toString() {
        return "Salas{" +
                "nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                ", disponivel=" + disponivel +
                '}';
    }
}
