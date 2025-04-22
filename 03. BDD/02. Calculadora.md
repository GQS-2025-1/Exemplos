# 🧪 Projeto Calculadora com Cucumber em Java

Este projeto demonstra como usar Java com Cucumber para automatizar testes de aceitação com base em um cenário de operações matemáticas em uma calculadora.

## 📋 Pré-requisitos

- Apache NetBeans 18
- Java 21 instalado e configurado
- Maven instalado
- Plugin Cucumber for Java (já incluído via dependências Maven)

## 📁 Estrutura do Projeto
📁 Dica de estrutura de diretórios
```pgsql
projeto-cucumber
├── pom.xml
└── src
    ├── main
    │   └── java
    └── test
        ├── java
        │   ├── steps
        │   │   └── CalculadoraSteps.java
        │   └── RunnerTest.java
        └── resources
            └── features
                └── calculadora.feature
```


## 📝 Feature (calculadora.feature)

```gherkin
#language: pt

Funcionalidade: os usuários veem os resultados de acordo com a operação desejada

  Esquema do Cenário: mostrar o resultado quando executar uma operação na calculadora
    Dado que "Maria" esteja na calculadora
    Quando pressionar o <numero1>
    E pressionar o <numero2>
    E escolher a "<operacao>"
    Então o sistema devera mostrar o <resultado>

    Exemplos:
      | numero1 | numero2 | operacao      | resultado |
      | 4       | 2       | soma          | 6         |
      | 4       | 2       | subtração     | 2         |
      | 4       | 2       | multiplicação | 8         |
      | 4       | 2       | divisão       | 2         |

🔧 Implementação da Classe Calculadora

```java
package calculadora;

public class Calculadora {
    public int calcular(int numero1, int numero2, String operacao) {
        return switch (operacao) {
            case "soma" -> numero1 + numero2;
            case "subtração" -> numero1 - numero2;
            case "multiplicação" -> numero1 * numero2;
            case "divisão" -> numero1 / numero2;
            default -> throw new IllegalArgumentException("Operação inválida: " + operacao);
        };
    }
}
```
🧩 Steps Definitions (CalculadoraSteps.java)
```java
package steps;

import calculadora.Calculadora;
import io.cucumber.java.pt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraSteps {

    private int numero1;
    private int numero2;
    private String operacao;
    private int resultado;
    private Calculadora calculadora;

    @Dado("que {string} esteja na calculadora")
    public void que_esteja_na_calculadora(String usuario) {
        calculadora = new Calculadora();
    }

    @Quando("pressionar o {int}")
    public void pressionar_o_numero1(int num) {
        if (numero1 == 0) {
            numero1 = num;
        } else {
            numero2 = num;
        }
    }

    @E("escolher a {string}")
    public void escolher_a_operacao(String op) {
        this.operacao = op;
    }

    @Então("o sistema devera mostrar o {int}")
    public void o_sistema_devera_mostrar_o_resultado(int esperado) {
        resultado = calculadora.calcular(numero1, numero2, operacao);
        assertEquals(esperado, resultado);
    }
}
```
⚙️ Configuração do pom.xml
```xml
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.16.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.16.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```