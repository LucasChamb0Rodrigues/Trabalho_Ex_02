package model;

public class Emprestimo {
    private Aluno aluno;
    private Livro livro;

    public Emprestimo(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
    }

    public Aluno getAluno() { return aluno; }
    public Livro getLivro() { return livro; }

    @Override
    public String toString() {
        return "model.Aluno: " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ") -> model.Livro: " + livro.getTitulo();
    }
}