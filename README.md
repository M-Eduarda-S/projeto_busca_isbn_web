# Projeto de busca em páginas Web utilizando um Autômato Finito Determinístico para o ISBN-13

O **projeto-base** utilizado neste trabalho está disponível em: `https://github.com/alexrese/BuscaPadraoWeb/tree/main`

## Descrição
Projeto desenvolvido a partir do código-base BuscaPadraoWeb, utilizando um Autômato Finito Determinístico (AFD) para buscar, em páginas da Web definidas no código, sequências que seguem a estrutura do ISBN-13.

O programa acessa o código HTML das páginas informadas, percorre seus caracteres e utiliza uma tabela de transição para verificar os padrões definidos pelo autômato.

O **objetivo** é adaptar o projeto original de busca de padrões na Web para trabalhar com a estrutura do ISBN-13, aplicando os conceitos de Linguagens Formais e Autômatos.

## Disciplina:
Linguagens Formais e Autômatos

## Acadêmicas:
- Beatriz Pimentel Bagesteiro Alves
- Maria Eduarda Santos
- Yasmin Tarnovski Faccin

## Tecnologias
- Linguagem Java

## Requisitos de Execução
- Java JDK compatível com o projeto;
- Uma IDE ou ambiente que permita executar projetos Java.

O projeto pode ser executado localmente em uma IDE, como o Apache NetBeans, IntelliJ IDEA ou Eclipse, ou em ambientes online que ofereçam suporte à execução de projetos Java.

### Como executar
O projeto pode ser executado de diferentes formas. <br> 

#### Utilizando uma IDE

O projeto pode ser aberto em uma IDE com suporte a Java, como o Apache NetBeans, IntelliJ IDEA ou Eclipse.

Após abrir o projeto, execute a classe `Main`. <br> 

#### Utilizando um ambiente online

Também é possível utilizar um **ambiente online** que ofereça suporte à execução de projetos Java. Nesse caso, os arquivos do projeto devem ser adicionados ao ambiente e a classe `Main` deve ser executada.


---
## Funcionamento

O programa é dividido em duas partes principais:

### Captura de páginas Web

A classe `CapturaRecursosWeb` é responsável por:

- receber as URLs que serão pesquisadas;
- abrir uma conexão com cada página;
- obter o código HTML;
- armazenar o conteúdo para ser analisado pelo programa.

### Reconhecimento do padrão

A classe `Main` é responsável pela implementação do AFD.

O autômato possui:
- um alfabeto formado pelos símbolos utilizados na estrutura do ISBN;
- estados que representam as posições do padrão;
- um estado inicial;
- estado(s) final(is);
- uma matriz de transição;
- funções para localizar símbolos e estados na tabela.

O programa percorre o código HTML caractere por caractere e utiliza o AFD para identificar as sequências que correspondem ao padrão definido.

## Autômato Finito Determinístico

O código-base utilizava um AFD para reconhecer números de dois dígitos.

Neste trabalho, o autômato foi adaptado para reconhecer a estrutura definida para o ISBN-13.

De forma simplificada, os estados representam as posições dos caracteres que precisam ser lidos:

q0 → q1 → q2 → ... → q17 <br><br> 
● `q0`: estado inicial; <br> 
● `q1 até q16`: leitura dos primeiros caracteres; <br> 
● `q17`: estado final, após a leitura dos 13 caracteres esperados. 

As transições são determinadas pela tabela de transição do AFD.
---

## Estrutura:
```bash
src/
  buscapadraoweb/
  │
  └── Main.java                  # implementação do AFD + lógica principal do programa
  buscaweb/
  │
  └── CapturaRecursosWeb.java   # realiza a captura do conteúdo HTML das páginas Web
README.md                       # explicação do projeto
.gitignore
```

### Observação
- Projeto com **foco didático** para compreensão de Autômato Finito Determinístico (AFD);
- Foi desenvolvido a partir do código-base `BuscaPadraoWeb` fornecido pelo professor e adaptado para o trabalho com ISBN-13;
- A validação do ISBN-13, como o cálculo e a verificação do dígito de controle, **não** faz parte deste trabalho, pois não foi solicitada na atividade.
