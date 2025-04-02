🌐 **Contexto**


Você foi contratado para desenvolver uma funcionalidade simples em um sistema educacional que ajuda alunos a identificarem números primos.


📅 **História de Usuário**

   ```
   Como aluno,
   Quero digitar um número e saber se ele é primo,
   Para entender melhor os conceitos de matemática que estou estudando.
   ```

📄 **Critérios de aceitação**


- O sistema deve retornar "Sim" se o número digitado for primo.
   ```
   Dado que o aluno informe o número 13
   Quando o sistema verificar se o número é primo
   Então o sistema deve exibir "Sim"
  ```


- O sistema deve retornar "Não" se o número digitado não for primo.
 
   ```
   Dado que o aluno informe o número 4
   Quando o sistema verificar se o número é primo
   Então o sistema deve exibir "Não"
   ```

- Números menores que 2 não devem ser considerados primos.
 
   ```
   Dado que o aluno informe o número 1
   Quando o sistema verificar se o número é primo
   Então o sistema deve exibir "Não"
   ```

📈 **Exemplo de entradas e saídas esperadas**


| Entrada | Saída esperada |
|---------|----------------|
| 2       | sim            |
| 4       | não            |
| 13      | sim            |
| 17      | sim            |
| 1       | não            |
