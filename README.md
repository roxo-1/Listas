# Listas
Você foi contratado como estagiário por uma empresa de tecnologia educacional que está desenvolvendo um sistema de navegação por módulos de cursos online. A equipe precisa de uma estrutura de dados eficiente para permitir que o usuário avance, retorne e também navegue circularmente entre os módulos. Para isso, decidiram usar duas versões da lista duplamente encadeada:

1.Uma lista duplamente encadeada comum, para o histórico linear de navegação do usuário.

2.Uma lista duplamente encadeada circular, para representar a navegação cíclica entre os módulos de um curso.

## Desafio:
Implemente em Java duas classes distintas:

### 1.ListaDuplamenteEncadeada:

•Permita adicionar elementos no início e no fim.

•Permita remover elementos do início e do fim.

•Implemente a navegação para frente e para trás.

•Crie um método exibir() que mostre os elementos da lista do primeiro ao último e vice-versa.

### 2.ListaCircularDuplamenteEncadeada:

•Semelhante à anterior, mas o último elemento deve apontar para o primeiro e o primeiro para o último.

•Implemente um método navegarCircular(int passos) que percorre a lista a partir do elemento atual, indo para frente ou para trás (passos positivos ou negativos), imprimindo o conteúdo do nó a cada passo.

## Regras e Requisitos:
•Você deve criar uma classe No<T> genérica, que seja usada nas duas listas.

•O código deve ser modularizado, com tratamento de exceções e sem uso de bibliotecas prontas como LinkedList.

•Crie uma classe Main para testar ambas as listas com exemplos reais de módulos como: "Introdução", "Algoritmos", "Estruturas de Dados", etc.

## Dificuldades Encontradas
• Os métodos da lista duplamente encadeada circular, adicionar e navegar, pois eram muitos mais ponteiro para relacionar do que lista duplamente encadeada simples, ou seja, mais fácil de se perder e esqeucer alguma coisa.
