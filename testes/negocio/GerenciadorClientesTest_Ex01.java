package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;

/**Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pelas classe {@link GerenciadoraClientes}
 * 
 * @author Willian Brand�o 
 * @date 11/04/2021
 */

public class GerenciadorClientesTest_Ex01 {
	
	/*Teste de pesquisa de um cliente a partir do seu Id
	 * 
	 * @author Willian Brand�o 
	 * @date 10/04/2021
	 */
	
	@Test 
	public void testPesquiseClient() {
		
		/* ======================= Montagem do cen�rio ======================= */
		
		//criando clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente01 = new Cliente(idCliente01, "Maria Joana", 27, "maria@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Jo�o Bob", 27, "joao@gmail.com", 2, true);
	
		//inserindo clientes na lista de clientes 
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		//instaciando a classe gerenciadoraClientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco); 
		
		/* ================ Execu��o ================ */
		//invocando o metodo pesquisa clientes 
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		
		/* ================ Verifica��es ================ */
		assertThat(cliente.getId(), is(idCliente01));
		
		
	}
	
	/*Teste de remover de um cliente a partir do seu Id
	 * 
	 * @author Willian Brand�o 
	 * @date 10/04/2021
	 */
	
	@Test
	public void testRemoveCliente() {
		
		/* ======================= Montagem do cen�rio ======================= */
		
		//criando clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente01 = new Cliente(idCliente01, "Maria Joana", 27, "maria@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Jo�o Bob", 27, "joao@gmail.com", 1, true);
			
		//inserindo clientes na lista
		List<Cliente> clientesDeBanco = new ArrayList<>();
		clientesDeBanco.add(cliente01);
		clientesDeBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDeBanco);
		
		/* ================ Execu��o ================ */
		//invocando metodo para remover clientes
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* ================ Verifica��es ================ */
		//verifica��es de testes
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(idCliente02));
		assertNull(gerClientes.pesquisaCliente(2));
		
				
	}
	
}
