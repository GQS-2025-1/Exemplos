#language: pt

Funcionalidade: os usuários veem os resultados de acordo com a operação desejada

  Esquema do Cenário: mostrar o resultado quando executar uma operação na calculadora
    Dado que "Maria" esteja na calculadora
    Quando pressionar o <numero1>
    E pressionar o <numero2>
    E escolher a <operacao>
    Então o sistema devera mostrar o <resultado>

    Exemplos:
      | numero1 | numero2 | operacao      | resultado |
      | 4       | 2       | soma          | 6         |
      | 4       | 2       | subtração     | 2         |
      | 4       | 2       | multiplicação | 8         |
      | 4       | 2       | divisão       | 2         |
