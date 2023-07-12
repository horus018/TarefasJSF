package controle;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "dataFuturaValidator")
public class ValidadorDataFutura implements Validator<Date> {
//quando vc implementa um validator com um tipo ele preenche o metodo override pra vc, dentro dele vc verifica se o objeto é valido do seu jeito
    @Override
    public void validate(FacesContext context, UIComponent component, Date value) throws ValidatorException { //esse Data value q é a sua data, os outros argumentos o framework coloca sozinho
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        if (value == null || value.before(cal.getTime())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data deve ser futura", "A data deve ser definida para um dia futuro"));
        }
    }

}
