public class Funcionario extends User {
    private String cargo;
    private boolean ativo;

    public Funcionario(String nome, String codigo, String cargo, boolean ativo) {
        super(nome, codigo);
        this.cargo = cargo;
        this.ativo = ativo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public void fazerEmprestimo(Item item) {
        if (ativo) {
            System.out.println(getNome() + "fez o empréstimo do item: " + item.getTitulo());
        } else {
            System.out.println("Funcionário inativo. Não pode realizar empréstimos.");
        }
    }

}
