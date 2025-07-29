import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {
	private List<Tarefa> tarefas;
	private Scanner scanner;
	
	public GerenciadorTarefas() {
		tarefas = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public void adicionarTarefa(String descricao) {
		tarefas.add(new Tarefa(descricao));
		System.out.println("tarefa Adicionada");
	}
	
	public void listaTarefas() {
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa cadastrada");
			return;
		}
		
		System.out.println("\nLista de tarefas:");
		for (int i = 0; i < tarefas.size(); i++) {
			System.out.println((i + 1) + ". " + tarefas.get(i));
		}
	}
	
	public void marcarComoConcluida(int indice) {
		if (indice >= 0 && indice < tarefas.size()) {
			tarefas.get(indice).setStatus(toString());
			System.out.println("Tarefa marcada como concluida");
		} else {
			System.out.println("Índice inválido");
		}
	}
	
	public void removerTarefa(int indice) {
		if (indice >= 0 && indice < tarefas.size()) {
			tarefas.remove(indice);
			System.out.println("Tarefa removida da lista");
		} else {
			System.out.println("Índice inválido");
		}
	}

	public void alterarStatustarefa() {
		listatarefas():
		if (tarefas.isEmpty()) return;

		System.out.println("Digite o número da tarefa para alternar status: ");
		int indice = scanner.nextInt() -1;
		scanner.nextLine();

		if (indice >= 0  && indice < tarefas.size()) {
			Tarefa tarefa = tarefas.get(indice);
			System.out.println("\nStatus atual: " + tarefa.getStatus());
			System.out.println("1. Não iniciada");
			System.out.println("2. Em progresso");
			System.out.println("3. Concluída");
			System.out.println("Escolha o novo status: ");

			int opcaoStatus = scanner.nextInt();
			scanner.nextLine();

			switch (opcaoStatus) {
				case 1:
					tarefa.setStatus("Não iniciada");
					break;
				case 2:
					tarefa.setStatus("Em progresso");
					break;
				case 3:
					tarefa.setStatus("Concluída");
					break;
				default:
					System.out.println("Opção inválida. Insira uma das opções disponiveis para alternar o Status da tarefa");

					return;
			}
			System.out.println("Status da tarefa alterado");
		} else {
			System.out.println("Erro: Índice inválido");
		}
	}
	
	public void exibirMenu() {
		System.out.println("\n=== Gerenciador de Tarefas ===");
		System.out.println("1. Adicionar Tarefa");
		System.out.println("2. Lista de Tarefas");
		System.out.println("3. Alternar Status da tarefa");
		System.out.println("4. Remover Tarefa");
		System.out.println("5. Sair");
		System.out.println("Escolha uma opção: ");
	}
	
	public void executar() {
		int opcao;
		do {
			exibirMenu();
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a descrição da tarefa: ");
				String descricao = scanner.nextLine();
				adicionarTarefa(descricao);
				break;
			case 2:
				listaTarefas();
				break;
			case 3:
				alternarStatusTarefa();
				break;
			case 4:
				listaTarefas();
				System.out.println("Digite o número da tarefa a remover: ");
				int indiceRemover = scanner.nextInt() - 1;
				removerTarefa(indiceRemover);
				break;
			case 5:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção inválida");
			}
		} while (opcao != 5);
	}
	
	public static void main(String[] args) {
		GerenciadorTarefas gerenciador = new GerenciadorTarefas();
		gerenciador.executar();
	}
}
