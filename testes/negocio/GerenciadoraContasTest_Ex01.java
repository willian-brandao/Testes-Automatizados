package negocio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;


public class GerenciadoraContasTest_Ex01 {
	
	private GerenciadoraContas gerContas;
	
	/** Classe de teste criada para garantir o funcionamento das principais opera��es
	 * sobre contas, nesse caso o teste � feito para garantir uma transferencia entre clientes, 
	 * com a condi��o que esses clientes estejam ativos e com saldo suficiente na conta de origem 
	 * 
	 * 
	 * @author Willian Brand�o 
	 * @date 10/04/2021
	 */
	@Test
	public void testTransfereValor() {
		
		/*======================== Mensagem do Cen�rio =====================*/
		
		// criando contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 220, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo contas a lista de contas 
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/*=================== Execu��o ==================*/
		gerContas.transfereValor(idConta01,  200, idConta02);
		
		/*=================== Verifica��es ==================*/
		assertThat(conta02.getSaldo(), is(200.0));
	}
	
	/**
	 * Teste de tentativa de transfer�ncia de um valor da conta de um cliente para outro quando n�o existe
	 * saldo suficiente
	 * 
	 * @author Willian Brand�o 
	 * @date   11/04/2021
	 */
	
	@Test
	public void testTransfereValor_SaldoInsuficiente() {
		
		/*===================== Montagem de Cen�rio ======================*/
		
		// criando clientes 
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		//inserindo contas a lista de contas
		List<ContaCorrente> contasDeBanco = new ArrayList<>();
		contasDeBanco.add(conta01);
		contasDeBanco.add(conta02);
		
		//instaciando o a classe gerenciadora de contas
		gerContas = new GerenciadoraContas(contasDeBanco);
		
		/*==================== Execu��o =======================*/
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		/*================= Verifica��es =======================*/
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
		
	}

	 
}
