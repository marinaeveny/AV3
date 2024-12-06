import java.util.Arrays;

public class Biblioteca {
    private Item[] acervo;
    private Salas[] salas;
    private int contadorItens;

    public Biblioteca() {
        acervo = new Item[10];
        salas = new Salas[5];
        contadorItens = 0;
    }

    public Biblioteca(Item[] acervo, Salas[] salas, int contadorItens) {
        this.acervo = acervo;
        this.salas = salas;
        this.contadorItens = contadorItens;
    }

    public Item[] getAcervo() {
        return acervo;
    }

    public void setAcervo(Item[] acervo) {
        this.acervo = acervo;
    }

    public Salas[] getSalas() {
        return salas;
    }

    public void setSalas(Salas[] salas) {
        this.salas = salas;
    }

    public int getContadorItens() {
        return contadorItens;
    }

    public void setContadorItens(int contadorItens) {
        this.contadorItens = contadorItens;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "acervo=" + Arrays.toString(acervo) +
                ", salas=" + Arrays.toString(salas) +
                ", contadorItens=" + contadorItens +
                '}';
    }

          public void adicionarItem(Item item) {
            for (int i = 0; i < acervo.length; i++) {
                if (acervo[i] == null) {
                    acervo[i] = item;
                    System.out.println("Item adicionado ao acervo: " + item.getTitulo());
                    return;
                }
            }
            System.out.println("Acervo cheio! Não é possível adicionar mais itens.");
        }

    public void adicionarSala(Salas sala) {
        for (int i = 0; i < salas.length; i++) {
            if (salas[i] == null) {  // Verifica se há espaço para adicionar a sala
                salas[i] = sala;
                System.out.println("Sala adicionada: " + sala.getNome());
                return;
            }
        }
        System.out.println("Não há espaço para adicionar mais salas.");
    }

    public void listarAcervo() {
        boolean temItens = false;
        for (Item item : acervo) {
            if (item != null) {
                temItens = true;
                System.out.println(item);  // Chama o método toString() da classe Item (ou das suas subclasses)
            }
        }
        if (!temItens) {
            System.out.println("O acervo está vazio.");
        }
    }


}
