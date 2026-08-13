/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class JavaApplication1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        final int TAMANHO_MAX = 10;

        
        String[] descricoes = new String[TAMANHO_MAX];
        boolean[] concluidas = new boolean[TAMANHO_MAX];
        boolean[] ocupadas = new boolean[TAMANHO_MAX]; 

        int opcao = 0;

        do {
            
            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

           
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opção inválida! Por favor, digite um número.");
                scanner.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    
                    int posicaoLivre = -1;

                    
                    for (int i = 0; i < TAMANHO_MAX; i++) {
                        if (!ocupadas[i]) {
                            posicaoLivre = i;
                            break;
                        }
                    }

                    if (posicaoLivre != -1) {
                        System.out.print("Digite a tarefa: ");
                        String tarefa = scanner.nextLine();

                        descricoes[posicaoLivre] = tarefa;
                        concluidas[posicaoLivre] = false;
                        ocupadas[posicaoLivre] = true;

                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("A lista de tarefas está cheia!");
                    }
                    break;

                case 2:
                    
                    boolean temTarefa = false;

                    
                    
                    for (int i = 0; i < TAMANHO_MAX; i++) {
                        if (ocupadas[i]) {
                            temTarefa = true;
                            break;
                        }
                    }

                    if (!temTarefa) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n=== MINHAS TAREFAS ===");
                        for (int i = 0; i < TAMANHO_MAX; i++) {
                            if (ocupadas[i]) {
                                String status = concluidas[i] ? "[X]" : "[ ]";
                                
                                System.out.println((i + 1) + " - " + status + " " + descricoes[i]);
                            }
                        }
                    }
                    break;

                case 3:
                    
                    System.out.print("Digite o número da tarefa que deseja concluir: ");
                    if (scanner.hasNextInt()) {
                        int numConcluir = scanner.nextInt();
                        scanner.nextLine();

                        int indice = numConcluir - 1; 

                        if (indice >= 0 && indice < TAMANHO_MAX && ocupadas[indice]) {
                            concluidas[indice] = true;
                            System.out.println("Tarefa concluída com sucesso!");
                        } else {
                            System.out.println("Tarefa inválida!");
                        }
                    } else {
                        System.out.println("Tarefa inválida!");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                   
                    System.out.print("Digite o número da tarefa que deseja excluir: ");
                    if (scanner.hasNextInt()) {
                        int numExcluir = scanner.nextInt();
                        scanner.nextLine();

                        int indice = numExcluir - 1; 

                        if (indice >= 0 && indice < TAMANHO_MAX && ocupadas[indice]) {
                            ocupadas[indice] = false;
                            descricoes[indice] = null;
                            concluidas[indice] = false;

                            System.out.println("Tarefa excluída com sucesso!");
                        } else {
                            System.out.println("Tarefa inválida!");
                        }
                    } else {
                        System.out.println("Tarefa inválida!");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    
                    System.out.println("Programa encerrado. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número entre 1 e 5.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
    
}
