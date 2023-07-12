package controle;

import dados.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter<Categoria> {

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
        //converte string pra categoria
        try {
            int id = Integer.parseInt(value);
            return Categoria.findCategoria(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria value) {
        //converte categoria pra string
        if(value != null){
            return String.valueOf(value.getId());
        }
        return null;
    }

}
