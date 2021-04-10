package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;

public class GerenciadorClientesTest_Ex1 {
	
	@Test 
	public void testPesquiseClient() {
		
		//criando clientes
		Cliente cliente01 = new Cliente(1, "Maria Joana", 27, "maria@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(1, "João Bob", 27, "joao@gmail.com", 1, true);
	
		//inserindo clientes na lista de clientes 
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		//instaciando a classe gerenciadoraClientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco); 
		
		//invocando o metodo pesquisa clientes 
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("maria@gmail.com"));
		
	}

	


	
}
