# 📚 Estruturas de Dados — Filas e Pilhas

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Exercícios-15_ao_21-blue?style=for-the-badge"/>
</p>

<p align="center">
  Implementação de <strong>filas</strong> e <strong>pilhas</strong> em Java puro, cobrindo estruturas estáticas e dinâmicas (encadeadas), desenvolvida como atividade prática de Estruturas de Dados.
</p>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Estruturas Implementadas](#-estruturas-implementadas)
- [Exercícios](#-exercícios)
- [Como Executar](#-como-executar)
- [Saída Esperada](#-saída-esperada)
- [Complexidade dos Métodos](#-complexidade-dos-métodos)

---

## 💡 Sobre o Projeto

Todo o código está concentrado em um único arquivo `Exercicios.java`, organizado em classes internas estáticas. Cada estrutura de dados é implementada do zero, sem uso de bibliotecas como `java.util.Stack` ou `java.util.Queue`.

---

## 🏗️ Estruturas Implementadas

### 🔵 Fila Circular Estática
Array de tamanho fixo com dois ponteiros (`inicio` e `fim`) que avançam com `% capacidade`, permitindo reutilizar posições liberadas por remoções.

### 🟢 Fila Linear Dinâmica (Encadeada)
Lista encadeada com ponteiros para `cabeca` (frente) e `cauda` (fim), sem limite de tamanho em memória.

### 🔴 Pilha Encadeada
Lista encadeada onde cada novo nó aponta para o anterior. O topo é sempre o nó mais recente.

---

## 🧩 Exercícios

<details>
<summary><strong>Exercício 15 — Verificar elemento em Fila Circular Estática</strong></summary>

**Método:** `contem(int elemento)`

Percorre as posições da fila usando aritmética modular, sem depender da posição absoluta de `inicio` no array.

```java
FilaCircularEstatica fc = new FilaCircularEstatica(5);
fc.enfileirar(10);
fc.enfileirar(20);
fc.enfileirar(30);

fc.contem(20); // true
fc.contem(99); // false
```
</details>

<details>
<summary><strong>Exercício 16 — Posição de um valor na Fila Dinâmica</strong></summary>

**Método:** `posicaoDe(int valor)`

Percorre os nós da lista encadeada e retorna o índice (base 0). Retorna `-1` se o valor não existir.

```java
FilaLinearDinamica fld = new FilaLinearDinamica();
fld.enfileirar(10);
fld.enfileirar(20);
fld.enfileirar(30);

fld.posicaoDe(20); // 1
fld.posicaoDe(99); // -1
```
</details>

<details>
<summary><strong>Exercício 17 — Último elemento da Fila</strong></summary>

**Método:** `ultimoElemento()`

Retorna o valor da `cauda` sem removê-la. Exibe aviso se a fila estiver vazia.

```java
fld.ultimoElemento(); // 30
```
</details>

<details>
<summary><strong>Exercício 18 — Quantidade de elementos da Fila</strong></summary>

**Método:** `quantidade()`

Retorna o contador `tamanho`, atualizado automaticamente a cada inserção ou remoção — sem necessidade de percorrer a lista.

```java
fld.quantidade(); // 3
```
</details>

<details>
<summary><strong>Exercício 19 — Converter Decimal para Base 2–8 usando Pilha</strong></summary>

**Método estático:** `converterBase(int decimal, int base)`

Empilha os restos das divisões sucessivas e desempilha na ordem correta para montar a representação na base desejada.

```java
converterBase(10,  2); // "1010"
converterBase(255, 8); // "377"
converterBase(100, 5); // "400"
converterBase(-7,  2); // "-111"
```

> ⚠️ Lança `IllegalArgumentException` se a base for menor que 2 ou maior que 8.
</details>

<details>
<summary><strong>Exercício 20 — Verificar Ordem Crescente na Fila Encadeada</strong></summary>

**Método:** `estaEmOrdemCrescente()`

Compara cada nó com o seu sucessor. Retorna `true` se todos estiverem em ordem não-decrescente.

```java
// Fila: 1 → 3 → 5 → 7 → 9
filaCrescente.estaEmOrdemCrescente();   // true

// Fila: 1 → 3 → 2 → 7 → 9
filaDesordenada.estaEmOrdemCrescente(); // false
```
</details>

<details>
<summary><strong>Exercício 21 — Topo da Pilha Encadeada</strong></summary>

**Método:** `verTopo()`

Retorna o valor do nó no topo sem removê-lo. Exibe aviso se a pilha estiver vazia.

```java
Pilha pilha = new Pilha();
pilha.empilhar(100);
pilha.empilhar(200);
pilha.empilhar(300);

pilha.verTopo(); // 300
```
</details>

---

## ▶️ Como Executar

**Pré-requisito:** JDK 8 ou superior instalado.

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

# 2. Compile
javac Exercicios.java

# 3. Execute
java Exercicios
```

---

## 📤 Saída Esperada

```
========== EXERCÍCIO 15 ==========
Contém 20? true
Contém 10? false
Contém 40? true
Contém 99? false

========== EXERCÍCIO 16 ==========
Posição de 20: 1
Posição de 40: 3
Posição de 99: -1

========== EXERCÍCIO 17 ==========
Último elemento: 40
Fila vazia, não há último elemento.

========== EXERCÍCIO 18 ==========
Quantidade de elementos: 4
Após inserir 50: 5
Após remover um: 4

========== EXERCÍCIO 19 ==========
10  em base 2: 1010
255 em base 8: 377
100 em base 5: 400
0   em base 2: 0
-7  em base 2: -111

========== EXERCÍCIO 20 ==========
Fila [1,3,5,7,9] crescente? true
Fila [1,3,2,7,9] crescente? false
Fila [42] crescente?        true

========== EXERCÍCIO 21 ==========
Topo da pilha: 300
Após desempilhar, topo: 200
Pilha vazia, não há topo.
```

---

## 📊 Complexidade dos Métodos

| Estrutura | Método | Complexidade |
|-----------|--------|:------------:|
| Fila Circular | `enfileirar` / `desenfileirar` | O(1) |
| Fila Circular | `contem` | O(n) |
| Fila Dinâmica | `enfileirar` / `desenfileirar` | O(1) |
| Fila Dinâmica | `posicaoDe` | O(n) |
| Fila Dinâmica | `ultimoElemento` / `quantidade` | O(1) |
| Fila Dinâmica | `estaEmOrdemCrescente` | O(n) |
| Pilha | `empilhar` / `desempilhar` / `verTopo` | O(1) |

---

<p align="center">
  Feito para a disciplina de <strong>Estruturas de Dados</strong>
</p>
