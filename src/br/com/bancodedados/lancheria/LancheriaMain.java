package br.com.bancodedados.lancheria;

import javax.swing.JOptionPane;

public class LancheriaMain {

	public static void main(String[] args) throws Exception {

		/*
		 * Exercicio Aula Banco de Dados
		 * Sicronizando o Banco com Java 
		 * inserindo, alterando, excluindo elistando clientes
		 */

		ClienteDAO c = new ClienteDAO();
		Cliente cliente = new Cliente();
		int opcao = 0;
		boolean programaOn = true;
		String menu = "Clientes Lancheria X Tio Nelso\n\n[1] Cadastrar Cliente\n[2] Alterar Cliente\n"
				+ "[3] Excluir Cliente\n[4] Listar Clientes\n[0] Sair do Programa\n";
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {

			case 1:
				cliente.setNome(JOptionPane.showInputDialog("Nome do Cliente"));
				cliente.setCPF(JOptionPane.showInputDialog("CPF do Cliente"));
				c.inserir(cliente);
				break;

			case 2:
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ID do Cliente que deseja Alterar\n(Digite 0 para voltar ao menu)"));
				if (id == 0) {
					break;
				}
				cliente.setId(id);
				cliente.setNome(JOptionPane.showInputDialog("Novo Nome do Cliente"));
				cliente.setCPF(JOptionPane.showInputDialog("Novo CPF do Cliente"));
				c.alterar(cliente);
				break;

			case 3:
				int drop = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ID do Cliente que deseja Excluir\n(Digite 0 para voltar ao menu)"));
				if (drop == 0) {
					break;
				}
				c.excluir(drop);
				break;

			case 4:
				c.listar(cliente);
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "Voc� saiu do Programa!");
				programaOn = false;
				break;

			default:
				JOptionPane.showMessageDialog(null, "N�mero n�o encontrado!");

			}
		} while (programaOn == true);
	}
}