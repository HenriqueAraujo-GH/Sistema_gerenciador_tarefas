public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		GerenciadorTarefas gerenciador = new GerenciadorTarefas(menu);
		
		try {
			gerenciador.executar();
		} finally {
			menu.fechar();
		}
	}
}
