package br.com.bancodedados.lancheria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {
	
	public void inserir(Cliente cliente) {
		String inserir = "INSERT INTO Cliente (CPF, Nome) VALUES (?, ?)";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConexaoBancoDeDados.conexao();
			prepared = con.prepareStatement(inserir);
			prepared.setString(1, cliente.getCPF());
			prepared.setString(2, cliente.getNome());
			prepared.execute();
			JOptionPane.showMessageDialog(null, "Cliente Adcionado!");
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void listar(Cliente cliente) {
		String listar = "SELECT * FROM cliente";
		Connection con = null;
		PreparedStatement prepared = null;
		//ArrayList<Cliente> listaClientes = new ArrayList();
		
		try {
			con = ConexaoBancoDeDados.conexao();
			prepared = con.prepareStatement(listar);
			ResultSet resultado = prepared.executeQuery();
			StringBuffer listaCliente = new StringBuffer();
			while (resultado.next()) {
				String id = resultado.getString("Id");
				String cpf = resultado.getString("CPF");
				String nome = resultado.getString("Nome");
				listaCliente.append("ID ["+id+"]  CPF: "+cpf+"\n");
				listaCliente.append("Nome: "+nome+"\n\n");
			}
			
			JOptionPane.showMessageDialog(null, listaCliente, "Clientes Cadastrados", JOptionPane.PLAIN_MESSAGE);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void excluir(int id) {
		String excluir = "DELETE FROM Cliente WHERE Id = ?";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConexaoBancoDeDados.conexao();
			prepared = con.prepareStatement(excluir);
			prepared.setInt(1, id);
			prepared.execute();
			JOptionPane.showMessageDialog(null, "Cliente Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Cliente cliente) {
		String alter = "UPDATE Cliente SET CPF = ?, Nome = ? "+"WHERE Id = ?";
		Connection conexao = null;
		PreparedStatement Prepared = null;
		
		try {
			conexao = ConexaoBancoDeDados.conexao();
			Prepared = conexao.prepareStatement(alter);
			
			Prepared.setString(1, cliente.getCPF());
			Prepared.setString(2, cliente.getNome());
			Prepared.setInt(3, cliente.getId());
			
			Prepared.execute();
			JOptionPane.showMessageDialog(null, "Cliente Id: "+cliente.getId()+" Alterado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
