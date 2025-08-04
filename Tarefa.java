import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tarefa {
	private String descricao;
	private String status;
	private LocalDate data;
	
	public Tarefa(String descricao, LocalDate data) {
		this.descricao = descricao;
		this.status = "Não iniciada";
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data =  data;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s %s | Data: %s | Local: %s | Status: %s", descricao, data.format(formatter), status);
	}
}
