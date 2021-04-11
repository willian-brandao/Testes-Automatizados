package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pelas classe {@link GerenciadoraClientes}
 * 
 * @author Willian Brandão 
 * @date 11/04/2021
 */

public class GerenciadorClientesTest_Ex01 {
	
	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		/* ============== Montagem do cenário ================== */
		
		//criando clientes
		Cliente cliente01 = new Cliente(idCliente01, "Maria Joana", 27, "maria@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "João Bob", 27, "joao@gmail.com", 2, true);
	
		//inserindo clientes na lista de clientes 
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		//instaciando a classe gerenciadoraClientes
		gerClientes = new GerenciadoraClientes(clientesDoBanco); 
		
	
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
		
	}
	
	
	/*Teste de pesquisa de um cliente a partir do seu Id
	 * 
	 * @author Willian Brandão 
	 * @date 10/04/2021
	 */
	
	@Test 
	public void testPesquiseClient() {
		
		
		
		/* ================ Execução ================ */
		//invocando o metodo pesquisa clientes 
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		
		/* ================ Verificações ================ */
		assertThat(cliente.getId(), is(idCliente01));
		
		
	}
	
	/*Teste de remover de um cliente a partir do seu Id
	 * 
	 * @author Willian Brandão 
	 * @date 10/04/2021
	 */
	
	@Test
	public void testRemoveCliente() {
		
	
		/* ================ Execução ================ */
		
		//invocando metodo para remover clientes
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* ================ Verificações ================ */
		
		//verificações de testes
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
				
	}
	
}
