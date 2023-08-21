package modulos.produto;

import dataFactory.ComponenteDataFactory;
import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo de produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach() {

        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080;
        basePath = "/lojinha";

        // Obter o token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.obterTokenComUsuarioAdministrador())
                .when()
                    .post("/v2/login")
                .then()
                    .extract()
                        .path("data.token");
    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 0.00 não é permitido")
    public void test001_ValidarLimiteZeradoProibidosValorProduto() {

        // Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada
        // e o status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
                .when()
                    .post("/v2/produtos")
                .then()
                    .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);

    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 7000.01 não é permitido")
    public void test002_ValidarLimiteMaisQueSeteMilProibidosValorProduto() {

        // Tentar inserir um produto com valor 7000.01 e validar que a mensagem de erro foi apresentada
        // e o status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7000.01))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);

    }

    @Test
    @DisplayName("Validar que a quantidade mínima de componentes não pode ser inferior a 1")
    public void test003_ValidarQueQuantidadeDeComponentesNãoPodeSerMenorQueUm() {

        // Tentar inserir um componente em um produto já existente com quantidade inferior a 1 e validar
        // que a mensagem de erro foi apresentada e o status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ComponenteDataFactory.registrarComponenteQuantidadeIgualA(0))
            .when()
                .post("/v2/produtos/239507/componentes")
            .then()
                .assertThat()
                .body("error", equalTo("A quantidade mínima para o componente não deve ser inferior a 1"))
                .statusCode(422);
    }

    // "A quantidade mínima para os componentes não devem ser inferiores a 1"
}
