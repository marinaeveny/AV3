    public class Cliente extends User {

    private String plano;

    public Cliente(String nome, String matricula, String plano) {
            super(nome, matricula);
            this.plano = plano;
        }

        public String getPlano() {
            return plano;
        }

        public void setPlano(String plano) {
            this.plano = plano;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "plano='" + plano + '\'' +
                    '}';
        }

        @Override
        public void fazerEmprestimo(Item item) {
            System.out.println(getNome() + " realizou empréstimo de: " + item.getTitulo());
        }


    }

