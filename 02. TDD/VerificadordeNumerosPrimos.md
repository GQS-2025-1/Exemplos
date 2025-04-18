🔢 TDD – Verificador de Números Primos
Este exemplo demonstra o uso de TDD (Test-Driven Development) para implementar um método que verifica se um número é primo.

✅ Regras de negócio
- Números menores que 2 não são primos.

- Um número primo é divisível apenas por 1 e por ele mesmo.

- O método deve funcionar para qualquer número inteiro positivo.

🧪 Exemplos de entrada e saída

| Entrada | Saída esperada |
|---------|----------------|
| 2       | true           |
| 3       | true           |
| 4       | false          |
| 13      | true           |
| 20      | false          |
| 1       | false          |
| 0       | false          |

🧰 Tecnologias usadas

- Java 17+

- JUnit 5

- Maven

📂 Estrutura esperada
```
src/
├── main/
│   └── java/
│       └── com.exemplo/
│           └── VerificadorPrimo.java
├── test/
│   └── java/
│       └── com.exemplo/
│           └── VerificadorPrimoTest.java
```

📂 Estrutura do pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.exemplo</groupId>
    <artifactId>palindromo-tdd</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.jupiter.version>5.10.0</junit.jupiter.version>
    </properties>

    <dependencies>
        <!-- JUnit 5 para testes -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Plugin para rodar os testes com JUnit 5 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
            </plugin>

            <!-- Plugin para executar a classe Main via terminal -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>Main</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```
