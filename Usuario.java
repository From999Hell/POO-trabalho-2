public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String perfil; // Coordenador, Professor, etc.

    public Usuario(String nome, String email, String senha, String perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    // getters e setters
}
