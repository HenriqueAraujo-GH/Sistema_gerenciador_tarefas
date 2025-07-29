public class Tarefa {
	private String descricao;
	private String status;
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.status = "Não iniciada";
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		String retorno;
		switch (status) {
			case "Concluída":
				retorno = "[C]";
				break;
			case "Em progresso":
				retorno = "[P]";
				break;
			default:
				retorno = "[ ]";
	}
	return retorno + " " + descricao + " (" + status + ")";
	}
}

