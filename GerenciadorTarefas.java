import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
	private List<Tarefa> tarefas;
	private Menu menu;
	
	public GerenciadorTarefas(Menu menu) {
		tarefas = new ArrayList<>();
		this.menu = menu;
	}
	
	public void adicionarTarefa(String descricao) {
		String descricao1 = menu.lerTexto("Digite a descrição da tarefa: ");
        LocalDate data = menu.lerData("Digite a data (dd/MM/aaaa): ");
        String local = menu.lerTexto("Digite o local: ");
        
        tarefas.add(new Tarefa(descricao1, data));
        menu.mostrarMensagem("Tarefa adicionada com sucesso!");
	}
	
	public void listaTarefas() {
		if (tarefas.isEmpty()) {
			menu.mostrarMensagem("Nenhuma tarefa cadastrada");
			return;
		}
		
		menu.mostrarMensagem("\n=== LISTA DE TAREFAS ===");
		for (int i = 0; i < tarefas.size(); i++) {
            menu.mostrarMensagem((i + 1) + ". " + tarefas.get(i));
		}
	}
	
	public void alterarStatusTarefa() {
        listaTarefas();
        if (tarefas.isEmpty()) return;
        
        int indice = menu.lerIndice("Digite o número da tarefa: ", tarefas.size());
        Tarefa tarefa = tarefas.get(indice);
        
        menu.mostrarMensagem("\nStatus atual: " + tarefa.getStatus());
        menu.mostrarMensagem("1. Não iniciada");
        menu.mostrarMensagem("2. Em progresso");
        menu.mostrarMensagem("3. Concluída");
        
        int opcao = menu.lerIndice("Escolha o novo status: ", 3);
        
        switch (opcao + 1) {
            case 1: tarefa.setStatus("Não iniciada"); break;
            case 2: tarefa.setStatus("Em progresso"); break;
            case 3: tarefa.setStatus("Concluída"); break;
        }
        menu.mostrarMensagem("Status atualizado com sucesso!");
    }
	
	public void editarTarefa() {
        listaTarefas();
        if (tarefas.isEmpty()) return;
        
        int indice = menu.lerIndice("Digite o número da tarefa: ", tarefas.size());
        Tarefa tarefa = tarefas.get(indice);
        
        menu.mostrarMensagem("\nEditando tarefa:");
        menu.mostrarMensagem("1. Descrição: " + tarefa.getDescricao());
        menu.mostrarMensagem("2. Data: " + tarefa.getData());
        menu.mostrarMensagem("0. Cancelar");
        
        int opcao = menu.lerIndice("O que deseja editar? ", 3);
        
        switch (opcao + 1) {
            case 1:
                String novaDescricao = menu.lerTexto("Nova descrição: ");
                tarefa.setDescricao(novaDescricao);
                break;
            case 2:
                LocalDate novaData = menu.lerData("Nova data (dd/MM/aaaa): ");
                tarefa.setData(novaData);
                break;
            case 0:
                return;
        }
        menu.mostrarMensagem("Tarefa atualizada com sucesso!");
    }
	
	public void removerTarefa() {
        listaTarefas();
        if (tarefas.isEmpty()) return;
        
        int indice = menu.lerIndice("Digite o número da tarefa a remover: ", tarefas.size());
        tarefas.remove(indice);
        menu.mostrarMensagem("Tarefa removida com sucesso!");
    }
	
	 public void executar() {
	        int opcao;
	        do {
	            menu.exibirMenuPrincipal();
	            opcao = menu.lerOpcao();
	            
	            switch (opcao) {
	                case 1: 
	                	adicionarTarefa(null); 
	                	break;
	                case 2: 
	                	listaTarefas(); 
	                	break;
	                case 3: 
	                	alterarStatusTarefa(); 
	                	break;
	                case 4: 
	                	editarTarefa(); 
	                	break;
	                case 5: 
	                	removerTarefa(); 
	                	break;
	                case 6: 
	                	menu.mostrarMensagem("Saindo do sistema..."); 
	                	break;
	                default: 
	                	menu.mostrarMensagem("Opção inválida!");
	            }
	        } while (opcao != 6);
	    }
}
