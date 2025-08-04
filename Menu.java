import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
	private Scanner  scanner;
	private DateTimeFormatter dateFormatter;
	
	public Menu() {
		this.scanner = new Scanner(System.in);
		this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	public void exibirMenuPrincipal() {
        System.out.println("\n=== Gerenciador de Tarefas ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Alterar Status da Tarefa");
        System.out.println("4. Editar Tarefa");
        System.out.println("5. Remover Tarefa");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
	}
	
	public int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
    
    public LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return LocalDate.parse(scanner.nextLine(), dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Use dd/MM/aaaa.");
            }
        }
    }
    
    public int lerIndice(String mensagem, int max) {
        while (true) {
            System.out.print(mensagem);
            try {
                int indice = Integer.parseInt(scanner.nextLine()) - 1;
                if (indice >= 0 && indice < max) return indice;
                System.out.println("Digite um número entre 1 e " + max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }
    
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    
    public void fechar() {
        scanner.close();
    }
}
