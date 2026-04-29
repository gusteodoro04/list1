public class Exercicios {
    //  NÓ GENÉRICO — usado pela fila dinâmica e pilh
    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor   = valor;
            this.proximo = null;
        }
    }


    //  EXERCÍCIO 15
    static class FilaCircularEstatica {
        private int[] dados;
        private int inicio;
        private int fim;
        private int tamanho;
        private int capacidade;

        FilaCircularEstatica(int capacidade) {
            this.capacidade = capacidade;
            this.dados      = new int[capacidade];
            this.inicio     = 0;
            this.fim        = 0;
            this.tamanho    = 0;
        }

        boolean estaVazia() { return tamanho == 0; }
        boolean estaCheia() { return tamanho == capacidade; }

        boolean enfileirar(int valor) {
            if (estaCheia()) {
                System.out.println("Fila circular cheia!");
                return false;
            }
            dados[fim] = valor;
            fim        = (fim + 1) % capacidade;   
            tamanho++;
            return true;
        }

        int desenfileirar() {
            if (estaVazia()) {
                System.out.println("Fila circular vazia!");
                return -1;
            }
            int valor = dados[inicio];
            inicio    = (inicio + 1) % capacidade;
            tamanho--;
            return valor;
        }

       
         //Verifica se um elemento existe na fila circular estática.
       
        boolean contem(int elemento) {
            if (estaVazia()) return false;

            for (int i = 0; i < tamanho; i++) {
                int indice = (inicio + i) % capacidade;
                if (dados[indice] == elemento) return true;
            }
            return false;
        }
    }



    //  EXERCÍCIOS 16, 17, 18 e 20
    static class FilaLinearDinamica {
        private No cabeca;  // frente da fila
        private No cauda;   // fim da fila
        private int tamanho;

        FilaLinearDinamica() {
            cabeca  = null;
            cauda   = null;
            tamanho = 0;
        }

        boolean estaVazia() { return cabeca == null; }

        void enfileirar(int valor) {
            No novoNo = new No(valor);
            if (estaVazia()) {
                cabeca = novoNo;
                cauda  = novoNo;
            } else {
                cauda.proximo = novoNo;
                cauda         = novoNo;
            }
            tamanho++;
        }

        int desenfileirar() {
            if (estaVazia()) return -1;
            int valor = cabeca.valor;
            cabeca    = cabeca.proximo;
            if (cabeca == null) cauda = null;
            tamanho--;
            return valor;
        }

        //Exercício 16 — Retorna a posição (base 0) do valor na fila dinâmica.

        int posicaoDe(int valor) {
            No  atual   = cabeca;
            int posicao = 0;

            while (atual != null) {
                if (atual.valor == valor) return posicao;
                atual = atual.proximo;
                posicao++;
            }
            return -1;
        }

        // Exercício 17 — Retorna o último elemento da fila.

        int ultimoElemento() {
            if (estaVazia()) {
                System.out.println("Fila vazia, não há último elemento.");
                return -1;
            }
            return cauda.valor;
        }

        // Exercício 18 — Retorna a quantidade de elementos da fila.
     
        int quantidade() {
            return tamanho;
        }

        // Exercício 20 — Verifica se a fila encadeada de inteiros está em ordem crescente.
         
        boolean estaEmOrdemCrescente() {
            if (estaVazia() || tamanho == 1) return true;

            No atual = cabeca;
            while (atual.proximo != null) {
                if (atual.valor > atual.proximo.valor) return false;
                atual = atual.proximo;
            }
            return true;
        }
    }


    //  EXERCÍCIOS 19 e 21 
    static class Pilha {
        private No topo;
        private int tamanho;

        Pilha() {
            topo    = null;
            tamanho = 0;
        }

        boolean estaVazia() { return topo == null; }

        void empilhar(int valor) {
            No novoNo    = new No(valor);
            novoNo.proximo = topo;
            topo           = novoNo;
            tamanho++;
        }

        int desempilhar() {
            if (estaVazia()) return -1;
            int valor = topo.valor;
            topo      = topo.proximo;
            tamanho--;
            return valor;
        }

        
         // Exercício 21 — Retorna o elemento no topo da pilha encadeada.
    
        int verTopo() {
            if (estaVazia()) {
                System.out.println("Pilha vazia, não há topo.");
                return -1;
            }
            return topo.valor;
        }
    }


    //  EXERCÍCIO 19

    static String converterBase(int decimal, int base) {
        if (base < 2 || base > 8)
            throw new IllegalArgumentException("Base inválida! Informe um valor entre 2 e 8.");
        if (decimal == 0) return "0";

        Pilha pilha  = new Pilha();
        int numero   = Math.abs(decimal);

        while (numero > 0) {
            pilha.empilhar(numero % base);
            numero /= base;
        }

        StringBuilder resultado = new StringBuilder();
        if (decimal < 0) resultado.append('-');

        while (!pilha.estaVazia()) {
            resultado.append(pilha.desempilhar());
        }
        return resultado.toString();
    }


    //  MAIN — Testes de todos os exercícios
    public static void main(String[] args) {

        // ----- Exercício 15 -----
        System.out.println("========== EXERCÍCIO 15 ==========");
        FilaCircularEstatica fc = new FilaCircularEstatica(5);
        fc.enfileirar(10);
        fc.enfileirar(20);
        fc.enfileirar(30);
        fc.desenfileirar();       // remove 10, abre espaço
        fc.enfileirar(40);        // ocupa posição circular
        System.out.println("Contém 20? " + fc.contem(20)); // true
        System.out.println("Contém 10? " + fc.contem(10)); // false (removido)
        System.out.println("Contém 40? " + fc.contem(40)); // true
        System.out.println("Contém 99? " + fc.contem(99)); // false

        // ----- Exercício 16 -----
        System.out.println("\n========== EXERCÍCIO 16 ==========");
        FilaLinearDinamica fld = new FilaLinearDinamica();
        fld.enfileirar(10);
        fld.enfileirar(20);
        fld.enfileirar(30);
        fld.enfileirar(40);
        System.out.println("Posição de 20: "  + fld.posicaoDe(20));  // 1
        System.out.println("Posição de 40: "  + fld.posicaoDe(40));  // 3
        System.out.println("Posição de 99: "  + fld.posicaoDe(99));  // -1

        // ----- Exercício 17 -----
        System.out.println("\n========== EXERCÍCIO 17 ==========");
        System.out.println("Último elemento: " + fld.ultimoElemento()); // 40
        FilaLinearDinamica filaVazia = new FilaLinearDinamica();
        filaVazia.ultimoElemento();  // mensagem de fila vazia

        // ----- Exercício 18 -----
        System.out.println("\n========== EXERCÍCIO 18 ==========");
        System.out.println("Quantidade de elementos: " + fld.quantidade()); // 4
        fld.enfileirar(50);
        System.out.println("Após inserir 50: "         + fld.quantidade()); // 5
        fld.desenfileirar();
        System.out.println("Após remover um: "         + fld.quantidade()); // 4

        // ----- Exercício 19 -----
        System.out.println("\n========== EXERCÍCIO 19 ==========");
        System.out.println("10  em base 2: " + converterBase(10,  2)); // 1010
        System.out.println("255 em base 8: " + converterBase(255, 8)); // 377
        System.out.println("100 em base 5: " + converterBase(100, 5)); // 400
        System.out.println("0   em base 2: " + converterBase(0,   2)); // 0
        System.out.println("-7  em base 2: " + converterBase(-7,  2)); // -111

        // ----- Exercício 20 -----
        System.out.println("\n========== EXERCÍCIO 20 ==========");
        FilaLinearDinamica filaCrescente = new FilaLinearDinamica();
        int[] valoresCrescentes = {1, 3, 5, 7, 9};
        for (int v : valoresCrescentes) filaCrescente.enfileirar(v);
        System.out.println("Fila [1,3,5,7,9] crescente? " + filaCrescente.estaEmOrdemCrescente()); // true

        FilaLinearDinamica filaDesordenada = new FilaLinearDinamica();
        int[] valoresDesordenados = {1, 3, 2, 7, 9};
        for (int v : valoresDesordenados) filaDesordenada.enfileirar(v);
        System.out.println("Fila [1,3,2,7,9] crescente? " + filaDesordenada.estaEmOrdemCrescente()); // false

        FilaLinearDinamica filaUm = new FilaLinearDinamica();
        filaUm.enfileirar(42);
        System.out.println("Fila [42] crescente?       " + filaUm.estaEmOrdemCrescente()); // true

        // ----- Exercício 21 -----
        System.out.println("\n========== EXERCÍCIO 21 ==========");
        Pilha pilha = new Pilha();
        pilha.empilhar(100);
        pilha.empilhar(200);
        pilha.empilhar(300);
        System.out.println("Topo da pilha: "         + pilha.verTopo()); // 300
        pilha.desempilhar();
        System.out.println("Após desempilhar, topo: " + pilha.verTopo()); // 200

        Pilha pilhaVazia = new Pilha();
        pilhaVazia.verTopo(); // mensagem de pilha vazia
    }
}
