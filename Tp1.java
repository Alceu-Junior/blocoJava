package testes;

import java.util.Scanner;

public class Tp1{
    
    private static String[] nomes;
    private static float[] notas1;
    private static float[] notas2;
    
    private static int index;
    
    private static final int QTDE = 2;
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        nomes = new String[QTDE];
        notas1 = new float[QTDE];
        notas2 = new float[QTDE];
        
        String opcao = null;
        
        do{
            System.out.println("\n[1] Registrar as notas de um novo aluno.");
            System.out.println("[2] Consultar boletim de um aluno.");
            System.out.println("[3] Consultar notas da turma.");
            System.out.println("[4] Sair.");
            
            System.out.print("\nInforme a opcao desejada: ");
            opcao = in.next();
            
            switch(opcao){
                case "1":
                    if(index < QTDE){
                        System.out.println("Informe o seu nome: ");
                        nomes[index] = in.next();
                        
                        System.out.println("Informe a nota da primeira prova: ");
                        notas1[index] = in.nextFloat();
                        
                        System.out.println("Informe a nota da segunda prova: ");
                        notas2[index] = in.nextFloat();
                        
                        System.out.println("Codigo 0 - registro na posicao " + index);
                        
                        index++;
                    }else{
                        System.out.println("Sistema sem memoria, impossivel cadastrar");
                    }
                    break;
                
                case "2":
                    System.out.print("Informe a posicao: ");
                    int pos = in.nextInt();
                    
                    if(pos >= 0 && pos < index) {
                        imprimir(pos);
                    }else{
                        System.out.println("Aluno nao encontrado");
                    }
                    break;
                    
                case "3":
                    imprimir();
                    
                    break;
                    
                case "4":
                    System.out.println("Programa finalizado");
                    
                    break;
                    
                default:
                    System.out.println("Opcao invalida");
                    
                    break;
                }
            
            }while (!opcao.equals("4"));
        
            in.close();
        }
    
        private static void imprimir(){
            System.out.println("Listagem de Alunos");
            for(int i = 0; i < index; i++){
                imprimir(i);
        }
    }
        
        private static void imprimir(int posicao){
            float notaTotal = calcularNota(posicao);
            String situacao = getSituacao(notaTotal);
            
            System.out.printf("[%d] %s - %.2f - %.2f - %.2f - (%s) \n",
                    posicao + 1,
                    nomes[posicao],
                    notas1[posicao],
                    notas2[posicao],
                    notaTotal,
                    situacao
            );
        }
        
        private static float calcularNota(int n){
            return (notas1[n] + notas2[n]) / 2;
        }
        
        private static String getSituacao(float nota){
            if(nota < 4){
                return "Reprovado";
            }else if(nota > 7){
                return "Aprovado";                
            }else{
                return "Recuperacao";
            }
        }
}