package dataFactory;

import pojo.ComponentePojo;

public class ComponenteDataFactory {

    public static ComponentePojo registrarComponenteQuantidadeIgualA(int quantidade) {
        ComponentePojo componente = new ComponentePojo();

        componente.setComponenteNome("Queijo");
        componente.setComponenteQuantidade(quantidade);

        return componente;
    }

}
