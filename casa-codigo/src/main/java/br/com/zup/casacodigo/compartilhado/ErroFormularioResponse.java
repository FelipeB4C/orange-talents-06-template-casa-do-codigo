package br.com.zup.casacodigo.compartilhado;

public class ErroFormularioResponse {
	private String campo;
	private String erro;

	public ErroFormularioResponse(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
