import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    private List<Emprestimo> emprestimosAtivos = new ArrayList<>();

    public void realizarEmprestimo(Aluno aluno, Livro livro) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            System.out.println("ERRO: O livro '" + livro.getTitulo() + "' não possui estoque disponível.");
            return;
        }

        Emprestimo novoEmprestimo = new Emprestimo(aluno, livro);
        emprestimosAtivos.add(novoEmprestimo);
        livro.reduzirEstoque();
        System.out.println("Empréstimo registrado: " + livro.getTitulo() + " para " + aluno.getNome());
    }

    public void registrarDevolucao(Aluno aluno, Livro livro) {
        Emprestimo alvo = null;
        for (Emprestimo e : emprestimosAtivos) {
            if (e.getAluno().equals(aluno) && e.getLivro().equals(livro)) {
                alvo = e;
                break;
            }
        }

        if (alvo != null) {
            emprestimosAtivos.remove(alvo);
            livro.aumentarEstoque();
            System.out.println("Devolução concluída com sucesso!");
        } else {
            System.out.println("ERRO: Registro de empréstimo não encontrado.");
        }
    }

    public void listarEmprestimos() {
        if (emprestimosAtivos.isEmpty()) {
            System.out.println("Não há empréstimos ativos no momento.");
        } else {
            System.out.println("\n--- RELATÓRIO DE EMPRÉSTIMOS ATIVOS ---");
            emprestimosAtivos.forEach(System.out::println);
        }
    }
}