/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudsqlite.view;

import crudsqlite.controller.EstudanteController;
import crudsqlite.model.Estudante;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rolas
 */
public class EstudanteView {
    private EstudanteController estudanteController;
    private Scanner scanner;

    public EstudanteView() {
        estudanteController = new EstudanteController();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Estudante");
            System.out.println("2. Listar Todos os Estudantes");
            System.out.println("3. Buscar Estudante por ID");
            System.out.println("4. Buscar Estudantes por Nome");
            System.out.println("5. Atualizar Estudante");
            System.out.println("6. Excluir Estudante");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    adicionarEstudante();
                    break;
                case 2:
                    listarTodosEstudantes();
                    break;
                case 3:
                    buscarEstudantePorId();
                    break;
                case 4:
                    buscarEstudantesPorNome();
                    break;
                case 5:
                    atualizarEstudante();
                    break;
                case 6:
                    excluirEstudante();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 0);
    }

    private void adicionarEstudante() {
        System.out.print("Nome do estudante: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do estudante: ");
        int idade = scanner.nextInt();
        estudanteController.adicionarEstudante(nome, idade);
        System.out.println("Estudante adicionado com sucesso!");
    }

    private void listarTodosEstudantes() {
        List<Estudante> estudantes = estudanteController.buscarTodosEstudantes();
        exibirListaEstudantes(estudantes);
    }

    private void buscarEstudantePorId() {
        System.out.print("ID do estudante a ser buscado: ");
        int id = scanner.nextInt();
        Estudante estudante = estudanteController.buscarEstudantePorId(id);
        if (estudante != null) {
            System.out.println("Estudante encontrado:");
            exibirEstudante(estudante);
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }
    
    private void buscarEstudantesPorNome() {
        System.out.print("Nome do estudante a ser buscado: ");
        scanner.nextLine(); // Consumir a quebra de linha
        String nome = scanner.nextLine();
        List<Estudante> estudantes = estudanteController.buscarEstudantesPorNome(nome);

        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante encontrado com o nome '" + nome + "'.");
        } else {
            exibirListaEstudantes(estudantes);
        }
    }

    private void atualizarEstudante() {
        System.out.print("ID do estudante a ser atualizado: ");
        int id = scanner.nextInt();
        System.out.print("Novo nome do estudante: ");
        scanner.nextLine(); // Consumir a quebra de linha
        String novoNome = scanner.nextLine();
        System.out.print("Nova idade do estudante: ");
        int novaIdade = scanner.nextInt();
        estudanteController.atualizarEstudante(id, novoNome, novaIdade);
        System.out.println("Estudante atualizado com sucesso!");
    }

    private void excluirEstudante() {
        System.out.print("ID do estudante a ser excluído: ");
        int id = scanner.nextInt();
        estudanteController.excluirEstudante(id);
        System.out.println("Estudante excluído com sucesso!");
    }

    private void exibirListaEstudantes(List<Estudante> estudantes) {
        System.out.println("Lista de estudantes:");
        for (Estudante estudante : estudantes) {
            exibirEstudante(estudante);
        }
    }

    private void exibirEstudante(Estudante estudante) {
        System.out.println("ID: " + estudante.getId());
        System.out.println("Nome: " + estudante.getNome());
        System.out.println("Idade: " + estudante.getIdade());
        System.out.println("-----");
    }

    public static void main(String[] args) {
        EstudanteView estudanteView = new EstudanteView();
        estudanteView.exibirMenu();
    }
}