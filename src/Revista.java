public class Revista extends Item implements Emprestavel {
    private String edicao;
    private boolean rara;
    private boolean disponivel;

    public Revista(String titulo, int anoPublicado, String edicao, boolean rara) {
        super(titulo, anoPublicado);
        this.edicao = edicao;
        this.rara = rara;
        this.disponivel = true;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format(
                        "           Detalhes da Revista     \n" +
                        "Título: %s\n" +
                        "Ano de Publicação: %d\n" +
                        "Edição: %s\n" +
                        "Rara: %s\n" +
                        "Disponível: %s\n" +
                        "-----------------------------------",
                getTitulo(), getAnoPublicado(), edicao, (rara ? "Sim" : "Não"), (disponivel ? "Sim" : "Não"));
    }


    @Override
    public void verDetalhes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de Publicação: " + getAnoPublicado());
        System.out.println("Edição: " + edicao);
        System.out.println("Rara: " + (rara ? "Sim" : "Não"));
        System.out.println("Disponível para empréstimo: " + (disponivel ? "Sim" : "Não"));
    }

    @Override
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Revista indisponível para empréstimo.");
        }
    }

    @Override
    public void devolver() {
        disponivel = true;
        System.out.println("Revista devolvida com sucesso!");
    }
}
