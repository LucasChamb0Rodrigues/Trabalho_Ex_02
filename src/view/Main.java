package view;

import controller.GerenciadorBiblioteca;

import model.Aluno;
import model.Livro;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorBiblioteca biblioteca = new GerenciadorBiblioteca();

        List<Aluno> alunos = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();

        int opcao = -1;

        do {
            System.out.println("\n=== BIBLIOTECA ESCOLAR ===");
            System.out.println("1. Cadastrar model.Livro");
            System.out.println("2. Cadastrar model.Aluno");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Registrar Devolução");
            System.out.println("5. Consultar Empréstimos Ativos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Título: ");
                        String tit = scanner.nextLine();
                        System.out.print("Autor: ");
                        String aut = scanner.nextLine();
                        System.out.print("Qtd inicial: ");
                        int qtd = Integer.parseInt(scanner.nextLine());
                        livros.add(new Livro(tit, aut, qtd));
                        break;

                    case 2:
                        System.out.print("Nome do model.Aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Matrícula: ");
                        String mat = scanner.nextLine();
                        alunos.add(new Aluno(nome, mat));
                        break;

                    case 3:
                        exibirLivros(livros);
                        int idxL = Integer.parseInt(scanner.nextLine());
                        exibirAlunos(alunos);
                        int idxA = Integer.parseInt(scanner.nextLine());
                        biblioteca.realizarEmprestimo(alunos.get(idxA), livros.get(idxL));
                        break;

                    case 4:
                        biblioteca.listarEmprestimos();
                        exibirAlunos(alunos);
                        int dAlu = Integer.parseInt(scanner.nextLine());
                        exibirLivros(livros);
                        int dLiv = Integer.parseInt(scanner.nextLine());
                        biblioteca.registrarDevolucao(alunos.get(dAlu), livros.get(dLiv));
                        break;

                    case 5:
                        biblioteca.listarEmprestimos();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Atenção: Erro na entrada de dados. " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void exibirLivros(List<Livro> livros) {
        System.out.println("\nSelecione o model.Livro:");
        for(int i=0; i<livros.size(); i++) System.out.println(i + " - " + livros.get(i));
    }

    private static void exibirAlunos(List<Aluno> alunos) {
        System.out.println("\nSelecione o model.Aluno:");
        for(int i=0; i<alunos.size(); i++) System.out.println(i + " - " + alunos.get(i).getNome());
    }
}