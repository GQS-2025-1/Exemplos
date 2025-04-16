💡 **Validando Login com Cucumber e Java**

Você foi contratado para atuar como QA (Quality Assurance) ou Desenvolvedor de Testes em uma equipe que está desenvolvendo um sistema web simples. O primeiro módulo entregue foi a funcionalidade de login, que permite que usuários entrem no sistema informando nome de usuário e senha.

Seu papel é criar **testes de aceitação** para essa funcionalidade, garantindo que:

- Usuários com credenciais corretas consigam acessar o sistema;

- Usuários com credenciais incorretas recebam mensagens adequadas.

A equipe de Produto forneceu os critérios de aceitação em **linguagem natural** e solicitou que esses testes sejam automatizados usando **Cucumber + Java** com suporte a **Gherkin**.

📋 **Requisitos Funcionais**
1. Se o usuário digitar o nome de usuário e senha corretos, o sistema deve mostrar:
**"Login realizado com sucesso"**

2. Se o usuário digitar o nome de usuário ou senha incorretos, o sistema deve mostrar:
**"Usuário ou senha inválidos"**

🧩 **Sua missão**

1. Criar um arquivo **.feature** com os cenários de login descritos.

```gherkin
#language: pt

Funcionalidade: Login no sistema

  Cenário: Login com credenciais válidas
    Dado que o usuário esteja na tela de login
    Quando o usuário digitar o nome de usuário "joao" e a senha "1234"
    E clicar no botão de login
    Então o sistema deve mostrar a mensagem "Login realizado com sucesso"

  Cenário: Login com credenciais inválidas
    Dado que o usuário esteja na tela de login
    Quando o usuário digitar o nome de usuário "joao" e a senha "senhaerrada"
    E clicar no botão de login
    Então o sistema deve mostrar a mensagem "Usuário ou senha inválidos"
```

2. Implementar os **Steps** usando Java para simular o comportamento do sistema.

```java
package steps;

import io.cucumber.java.pt.*;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
public class LoginSteps {

    private String mensagem;
    private String usuarioInformado;
    private String senhaInformada;

    private Map<String, String> bancoUsuarios = new HashMap<>();

    @Dado("que o usuário esteja na tela de login")
    public void o_usuario_esta_na_tela_de_login() {
        System.out.println("=== STEP FOI EXECUTADO ===");
        bancoUsuarios.put("joao", "1234");
    }

    @Quando("o usuário digitar o nome de usuário {string} e a senha {string}")
    public void o_usuario_digita_o_nome_de_usuario_e_a_senha(String usuario, String senha) {
        this.usuarioInformado = usuario;
        this.senhaInformada = senha;
    }

    @Quando("clicar no botão de login")
    public void clicar_no_botao_de_login() {
        String senhaCorreta = bancoUsuarios.get(usuarioInformado);
        if (senhaCorreta != null && senhaCorreta.equals(senhaInformada)) {
            mensagem = "Login realizado com sucesso";
        } else {
            mensagem = "Usuário ou senha inválidos";
        }
    }

    @Então("o sistema deve mostrar a mensagem {string}")
    public void o_sistema_deve_mostrar_a_mensagem(String mensagemEsperada) {
        assertEquals(mensagemEsperada, mensagem);
    }
}
```

3. Configurar um projeto Maven com dependências do **Cucumber, JUnit 5 e Gherkin**.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>Ex01</groupId>
    <artifactId>LoginCucumberMaven</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <exec.mainClass>ex01.logincucumbermaven.LoginCucumberMaven</exec.mainClass>
    </properties>
    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.14.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>7.14.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.14.0</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.1</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
    </dependencies>
</project>
```

4. Criar um Runner que execute os testes usando a engine do Cucumber com JUnit 5.

```java
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "classpath:steps"
)
public class RunnerTest {
    
}
```
5. Executar os testes e garantir que ambos os cenários passem.

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
        │   │   └── LoginSteps.java
        │   └── RunnerTest.java
        └── resources
            └── features
                └── login.feature
```

🔧 **Tecnologias e Ferramentas**

- Linguagem: Java 11+
- Testes: Cucumber + JUnit 5
- Build: Maven
