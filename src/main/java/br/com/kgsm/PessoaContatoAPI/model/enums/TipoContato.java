package br.com.kgsm.PessoaContatoAPI.model.enums;

public enum TipoContato {
	TELEFONE(0), // Representa um contato do tipo telefone, sendo seu valor associado = 0
    CELULAR(1); // Representa um contato do tipo telefone, sendo seu valor associado = 1

    private final int valor;

    TipoContato(int valor) {
        this.valor = valor; // Valor inteiro associado a cada tipo de contato.
    }

    /**
     * Método para obter o valor inteiro associado ao tipo de contato.
     * @return O valor inteiro associado ao tipo de contato.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Método estático para obter o enum correspondente a partir de um valor inteiro.
     * @param valor O valor inteiro a ser verificado.
     * @return O enum TipoContato correspondente ao valor informado, ou null se não encontrado.
     */
    public static TipoContato valueOf(int valor) {
        for (TipoContato tipo : TipoContato.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        return null;
    }
    
}
