

import java.util.Scanner;
import dominio.Usuario;
import exceptions.NomeIncompletoException;
import dominio.Aluno;
import dominio.Professor;

public class Tp3{
    
	private static Usuario[] usuarios;

    private static int index;
    
    private static final int QTDE = 100;
    
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        
        usuarios = new Usuario[QTDE];
        
        String opcao = null;
        
        try {
        	do{
                System.out.println("\n[1] Cadastrar Professor.");
                System.out.println("[2] Cadastrar Aluno.");
                System.out.println("[3] Consultar situação de um docente/discente.");
                System.out.println("[4] Sair.");
                
                System.out.print("\nInforme a opcao desejada: ");
                opcao = in.next();
                
                int posicao;
    			switch(opcao){
                    case "1":
                        if(index < QTDE){
                        	Professor prof = new Professor();
                        	
                        	prof.setId(index);
                        	
                            System.out.println("Informe o nome do professor: ");
                            prof.setNome(in.next());
                	
                            System.out.println("Informe a idade do professor: ");
                            prof.setIdade(in.nextInt());
                            
                            System.out.println("Informe o salario do professor: ");
                            prof.setSalario(in.nextFloat());
                            
                            usuarios[index] = prof;
                            
                            System.out.println("Codigo 0 - registrado na posicao " + index);
                            
                            index++;
                        }else{
                            System.out.println("Sistema sem memoria, impossivel cadastrar");
                        }
                        break;
                    
                    case "2":
                        if(index < QTDE){
                        	Aluno al = new Aluno();
                        	
                        	al.setId(index);
                        	
                            System.out.println("Informe o nome do aluno: ");
                            al.setNome(in.next());
                                                   
                            System.out.println("Informe a idade do aluno: ");
                            al.setIdade(in.nextInt());
                            
                            System.out.println("Informe o ano de ingresso do aluno: ");
                            al.setAnoIngresso(in.nextInt());
                            
                            usuarios[index] = al;
                            
                            System.out.println("Codigo 0 - registrado na posicao " + index);
                            
                            index++;
                        }else{
                            System.out.println("Sistema sem memoria, impossivel cadastrar");
                        }
                        break;
                        
                    case "3":
                    	try {
                    		System.out.print("Informe a posicao: ");
                    		posicao = in.nextInt();
                    		if(posicao >= 0 && posicao < index) {
        						usuarios[posicao].imprimir();
        					} else {
        						System.out.println("Usuario inexistente!!!");
        					}
                    		break;
    					}catch (NomeIncompletoException e) {
    						System.out.println("Erro: " + e.getMessage());
    					}
                    	
                        
                    case "4":
                        System.out.println("Programa finalizado");
                        
                        break;
                        
                    default:
                        System.out.println("Opcao invalida");
                        
                        break;
                    }
                
                }while (!opcao.equals("4"));
        }finally {
        	System.out.println("Processamento concluido.");
        }
        
        
            in.close();
        }
	}