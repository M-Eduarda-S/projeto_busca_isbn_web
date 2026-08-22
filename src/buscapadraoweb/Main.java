/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }

    

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();

        crw.getListaRecursos().add("https://www.univali.br/"); // nesse site funciona a busca 
        // crw.getListaRecursos().add("https://en.wikipedia.org/wiki/ISBN");
        //crw.getListaRecursos().add("https://en.wikipedia.org/wiki/List_of_ISBN_registration_groups");
        //crw.getListaRecursos().add("https://search.scielo.org/?q=%28isbn%29&lang=pt&count=50&from=0&output=site&sort=&format=summary&fb=&page=1&filter%5Bin%5D%5B%5D=scl&filter%5Bla%5D%5B%5D=pt");

        ArrayList<String> listaCodigos = crw.carregarRecursos();

        //verifica se carregou a página
        if (listaCodigos.isEmpty()) {
            System.out.println("Nenhuma pagina foi carregada.");
            return;
        }

        String codigoHTML = "abc 978-85-35902-70-0 xyz"; //utilzado para teste [APAGAR DEPOIS]
        //String codigoHTML = listaCodigos.get(0);

        //mapa do alfabeto
        char[] alfabeto = new char[11];
        alfabeto[0] = '0';
        alfabeto[1] = '1';
        alfabeto[2] = '2';
        alfabeto[3] = '3';
        alfabeto[4] = '4';
        alfabeto[5] = '5';
        alfabeto[6] = '6';
        alfabeto[7] = '7';
        alfabeto[8] = '8';
        alfabeto[9] = '9';
        alfabeto[10] = '-';

        //mapa de estados
        String[] estados = new String[18];
        estados[0] = "q0";
        estados[1] = "q1";
        estados[2] = "q2";
        estados[3] = "q3";
        estados[4] = "q4";
        estados[5] = "q5";
        estados[6] = "q6";
        estados[7] = "q7";
        estados[8] = "q8";
        estados[9] = "q9";
        estados[10] = "q10";
        estados[11] = "q11";
        estados[12] = "q12";
        estados[13] = "q13";
        estados[14] = "q14";
        estados[15] = "q15";
        estados[16] = "q16";
        estados[17] = "q17";

        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = new String[1];
        estados_finais[0] = "q17";

        //tabela de transição de AFD para reconhecimento da estrutura do ISBN-13
        int[][] matriz = new int[18][11];


        // inicializa toda a matriz com -1, que seria o ∅ [ESSA PARTE NÃO TINHA NO CÓDIGO DO PROFESSOR!]
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = -1;
            }
        }
        
        // transições de q0
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q1");
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q1");
        
        // transições de q1
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q2");
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q2");
        
        //transições de q2
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q3");
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q3");
        
        // transições de q3
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q4");
        
        // transições de q4
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q5");
        
        // transições de q5
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q6");
        
        // transições de q6
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q7");
        
        // transições de q7
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q8");
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q8");
        
        // transições de q8
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q9");
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q9");
        
        // transições de q9
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q10");
        matriz[get_string_ref(estados, "q9")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q10");
        
        // transições de q10
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q11");
        matriz[get_string_ref(estados, "q10")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q11");
        
        // transições de q11
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q12");
        matriz[get_string_ref(estados, "q11")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q12");
        
        // transições de q12
        matriz[get_string_ref(estados, "q12")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q13");
        
        // transições de q13
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q14");
        matriz[get_string_ref(estados, "q13")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q14");
        
        // transições de q14
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q15");
        matriz[get_string_ref(estados, "q14")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q15");
        
        // transições de q15
        matriz[get_string_ref(estados, "q15")][get_char_ref(alfabeto, '-')] = get_string_ref(estados, "q16");
        
        // transições de q16
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q17");
        matriz[get_string_ref(estados, "q16")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q17");
        
        // transições de q17
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "q17")][get_char_ref(alfabeto, '9')] = -1;
        
        int estado = get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();


        String palavra = "";

        //varre o código-fonte de um código
        for (int i=0; i<codigoHTML.length(); i++){

            estado_anterior = estado;
            estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
            //se o não há transição
            if (estado == -1){
                //pega estado inicial
                estado = get_string_ref(estados, estado_inicial);
                // se o estado anterior foi um estado final
                if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                    //se a palavra não é vazia adiciona palavra reconhecida
                    if ( ! palavra.equals("")){
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                //zera palavra
                palavra = "";
                
            }else{
                //se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }

        //verifica se o texto terminou em um estado final [ISSO NÃO ESTAVA NO CÓDIGO DO PROFESSOR!]
        if (get_string_ref(estados_finais, estados[estado]) != -1 && !palavra.equals("")) {
            palavras_reconhecidas.add(palavra);
        }

        //foreach no Java para exibir todas as palavras reconhecidas
        for (String p: palavras_reconhecidas){
            System.out.println (p);
        }


    }


}
