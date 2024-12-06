public abstract class User {
    private String nome;
    private String codigo;

    public User(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public abstract void fazerEmprestimo(Item item);


}