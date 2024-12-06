public class Livro extends Item implements Emprestavel {
    private String genero;
    private boolean disponivel;

    public Livro(String titulo, int anoPublicado, String genero) {
        super(titulo, anoPublicado);
        this.genero = genero;
        this.disponivel = true;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return String.format(
                        "           Detalhes do Livro       \n" +
                        "Título: %s\n" +
                        "Ano de Publicação: %d\n" +
                        "Gênero: %s\n" +
                        "Disponível: %s\n" +
                        "-----------------------------------",
                getTitulo(), getAnoPublicado(), genero, (disponivel ? "Sim" : "Não"));
    }


    @Override
    public void verDetalhes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de Publicação: " + getAnoPublicado());
        System.out.println("Gênero: " + genero);
        System.out.println("Disponível para empréstimo: " + (disponivel ? "Sim" : "Não"));
    }

    @Override
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    @Override
    public void devolver() {
        disponivel = true;
        System.out.println("Livro devolvido com sucesso!");
    }
}
