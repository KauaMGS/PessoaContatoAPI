package br.com.kgsm.PessoaContatoAPI.model.enums;

public enum TipoContato {
	TELEFONE(0),
    CELULAR(1);

    private final int valor;

    TipoContato(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoContato valueOf(int valor) {
        for (TipoContato tipo : TipoContato.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        return null;
    }
}
