# Lojinha API Automação
Esse é um repositório que contém a automação de alguns testes de API Rest de um software chamado Lojinha. Os tópicos abaixo descrevem algumas informações relacionadas à estruturação do projeto.

## Tecnologias Utilizadas

- Java - 
  https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

- JUnit - 
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0

- RestAssured - 
  https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0

- Maven - 
  https://maven.apache.org/

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, baseados na regra de negócio que diz que o valor do produto deve estar entre R$0,01 e R$7.000,00.

## Notas Gerais

- Sempre utilizo a anotação BeforeEach para capturar o token que será utilizado posteriormente nos testes.
- Sempre utilizo a anotação DisplayName para dar descrições para meus testes
- Armazenei os dados que serão enviados para a Api através do uso de classes POJO.
- Criei dados iniciais através do uso de classe Data Factory para facilitar a criação e controle dos mesmos.

