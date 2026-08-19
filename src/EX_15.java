
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class EX_15 {
    public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);

        
        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];
        boolean[] existe = new boolean[10];

        int opcao = 0;

        do {
        
            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    
                    int posicaoLivre = -1;
                    
                    
                    for (int i = 0; i < 10; i++) {
                        if (!existe[i]) {
                            posicaoLivre = i;
                            break;
                        }
                    }

                    if (posicaoLivre == -1) {
                        System.out.println("A lista de tarefas está cheia!");
                    } else {
                        System.out.print("Digite a tarefa: ");
                        String descricao = scanner.nextLine();
                        
                        tarefas[posicaoLivre] = descricao;
                        concluidas[posicaoLivre] = false;
                        existe[posicaoLivre] = true;
                        
                        System.out.println("Tarefa adicionada com sucesso!");
                    }
                    break;

                case 2:
                    
                    boolean possuiTarefas = false;
                    System.out.println("\n=== MINHAS TAREFAS ===");

                    for (int i = 0; i < 10; i++) {
                        if (existe[i]) {
                            possuiTarefas = true;
                            String status = concluidas[i] ? "[X]" : "[ ]";
                    
                            System.out.println((i + 1) + " - " + status + " " + tarefas[i]);
                        }
                    }

                    if (!possuiTarefas) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Digite o número da tarefa que deseja concluir: ");
                    int numConcluir = scanner.nextInt();
                    int idxConcluir = numConcluir - 1; // Ajusta de 1-10 para índice 0-9

                    if (idxConcluir >= 0 && idxConcluir < 10 && existe[idxConcluir]) {
                        concluidas[idxConcluir] = true;
                        System.out.println("Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 4:
                    
                    System.out.print("Digite o número da tarefa que deseja excluir: ");
                    int numExcluir = scanner.nextInt();
                    int idxExcluir = numExcluir - 1; // Ajusta de 1-10 para índice 0-9

                    if (idxExcluir >= 0 && idxExcluir < 10 && existe[idxExcluir]) {
                        existe[idxExcluir] = false;
                        tarefas[idxExcluir] = null;
                        concluidas[idxExcluir] = false;
                        System.out.println("Tarefa excluída com sucesso!");
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 5:
                    
                    System.out.println("Programa encerrado. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}

  

