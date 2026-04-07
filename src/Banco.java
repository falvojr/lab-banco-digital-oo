import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Banco {

    private String nome;
    private List<Conta> contas;

}