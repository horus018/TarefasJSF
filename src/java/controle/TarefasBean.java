package controle;

import dados.Categoria;
import dados.Tarefa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@Named(value = "tarefasBean")
@SessionScoped
public class TarefasBean implements Serializable {

    private ArrayList<Tarefa> listaTarefas;
    private ArrayList<SelectItem> itemsCategorias;
    private Tarefa atual;
    boolean editando = false;

    //cai aqui logo q a classe é chamada
    public TarefasBean() {
        listaTarefas = new ArrayList<>();
        atual = new Tarefa();
        itemsCategorias = new ArrayList<>();
        for(Categoria c : Categoria.categorias){
            itemsCategorias.add(new SelectItem(c, c.getDescricao()));
        }
    }

    public ArrayList<SelectItem> getItemsCategorias() {
        return itemsCategorias;
    }

    public void setItemsCategorias(ArrayList<SelectItem> itemsCategorias) {
        this.itemsCategorias = itemsCategorias;
    }

    public Tarefa getAtual() {
        return atual;
    }

    public void setAtual(Tarefa atual) {
        this.atual = atual;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public String incluir() {

        if (!editando) {
            listaTarefas.add(atual);
        }
        atual = new Tarefa();
        editando = false;
        return null;
    }

    //aqui é void pq qro voltar pra mesma pagina ent n precisa do return null, dava pra fzer com o incluir 
    public void excluir(Tarefa t) {
        listaTarefas.remove(t);
    }

    public void editar(Tarefa t) {
        atual = t;
        editando = true;
    }

}
