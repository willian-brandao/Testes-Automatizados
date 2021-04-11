package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
	
	/*Teste de pesquisa de um cliente que não existe
	 * 
	 * @author Willian Brandão 
	 * @date 10/04/2021
	 */
	
	@Test 
	public void testPesquiseClienteInexisteClient() {
		
		
		
		/* ================ Execução ================ */
		//invocando o metodo pesquisa clientes 
		Cliente cliente = gerClientes.pesquisaCliente(3);
		
		
		/* ================ Verificações ================ */
		assertNull(cliente);
		
		
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
	
	/**Teste de remover um cliente inexistente 
	 * 
	 * @author Willian Brandão 
	 * @date 10/04/2021
	 */
	
	@Test
	public void testRemoveClienteInexistente() {
		
	
		/* ================ Execução ================ */
		
		//invocando metodo para remover clientes
		boolean clienteRemovido = gerClientes.removeCliente(3);
		
		/* ================ Verificações ================ */
		
		//verificações de testes
		assertThat(clienteRemovido, is(false));
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		
		
				
	}
	
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido 
	 * @author Willian Brandão Ramos
	 * @throws IdadeNaoPermitidaException
	 * @date 11/04/2021
	 */
	@Test
	public void testClienteIdadeLimite_01 () throws IdadeNaoPermitidaException {
		
		/* ============= Montagem do Cenario ===============*/
		Cliente cliente = new Cliente(1,"Luiz",65, "luiz@gmail.com", 1, true);
		
		/*============= Execução ================*/
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/*============= Verificação =============*/
		assertTrue(idadeValida);
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido 
	 * @author Willian Brandão Ramos
	 * @throws IdadeNaoPermitidaException
	 * @date 11/04/2021
	 */
	@Test
	public void testClienteIdadeLimite_02 () throws IdadeNaoPermitidaException {
		
		/* ============= Montagem do Cenario ===============*/
		Cliente cliente = new Cliente(1,"Luiz",18, "luiz@gmail.com", 1, true);
		
		/*============= Execução ================*/
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/*============= Verificação =============*/
		assertTrue(idadeValida);
	}
	
	/**
	 * Validação da idade de um cliente quando a mesma está no intervalo permitido 
	 * @author Willian Brandão Ramos
	 * @throws IdadeNaoPermitidaException
	 * @date 11/04/2021
	 */
	@Test
	public void testClienteIdadeLimite_03 () throws IdadeNaoPermitidaException {
		
		/* ============= Montagem do Cenario ===============*/
		Cliente cliente = new Cliente(1,"Luiz",65, "luiz@gmail.com", 1, true);
		
		/*============= Execução ================*/
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/*============= Verificação =============*/
		assertTrue(idadeValida);
	}
	
	/**
	 * Validação da idade de um cliente quando o mesmo está abaixo do intervalo permitido 
	 * @author Willian Brandão Ramos
	 * @throws IdadeNaoPermitidaException
	 * @date 11/04/2021
	 */
	@Test
	public void testClienteIdadeLimite_04 () throws IdadeNaoPermitidaException {
		
		/* ============= Montagem do Cenario ===============*/
		Cliente cliente = new Cliente(1,"Luiz",17, "luiz@gmail.com", 1, true);
		
		/*============= Execução ================*/
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		}catch (Exception e) {
		/*============= Verificação =============*/
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}
	
	/**
	 * Validação da idade de um cliente quando o mesmo está abaixo do intervalo permitido 
	 * @author Willian Brandão Ramos
	 * @throws IdadeNaoPermitidaException
	 * @date 11/04/2021
	 */
	@Test
	public void testClienteIdadeLimite_05 () throws IdadeNaoPermitidaException {
		
		/* ============= Montagem do Cenario ===============*/
		Cliente cliente = new Cliente(1,"Luiz",66, "luiz@gmail.com", 1, true);
		
		/*============= Execução ================*/
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		}catch (Exception e) {
		/*============= Verificação =============*/
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}
	
	
}
