public abstract class Item {
    private String titulo;
    private int anoPublicado;

    public Item(String titulo, int anoPublicado) {
        this.titulo = titulo;
        this.anoPublicado = anoPublicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    @Override
    public String toString() {
        return "Item{" +
                "titulo='" + titulo + '\'' +
                ", anoPublicado=" + anoPublicado +
                '}';
    }

    public abstract void verDetalhes();
}
