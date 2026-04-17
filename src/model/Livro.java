package model;

public class Livro {
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidade) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do livro não pode ser vazio.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidade;
    }

    public void reduzirEstoque() { this.quantidadeDisponivel--; }
    public void aumentarEstoque() { this.quantidadeDisponivel++; }


    public String getTitulo() { return titulo; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }

    @Override
    public String toString() {
        return String.format("model.Livro: %s | Autor: %s | Disponível: %d", titulo, autor, quantidadeDisponivel);
    }
}