package dados;

public class Categoria {

    public static final Categoria categorias[] = {
        new Categoria(1, "Tarefas de casa"),
        new Categoria(2, "Trabalhos da Universidade"),
        new Categoria(3, "Trabalho"),
        new Categoria(4, "Hobby")
    };

    private int id;
    private String descricao;

    public Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Categoria findCategoria(int id) {
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descicao) {
        this.descricao = descicao;
    }

}
