package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;


public class GerenciadoraContasTest_Ex01 {
	
	private GerenciadoraContas gerContas;
	
	/** Classe de teste criada para garantir o funcionamento das principais operações
	 * sobre contas, nesse caso o teste é feito para garantir uma transferencia entre clientes, 
	 * com a condição que esses clientes estejam ativos e com saldo suficiente na conta de origem 
	 * 
	 * 
	 * @author Willian Brandão 
	 * @date 10/04/2021
	 */
	@Test
	public void testTransfereValor() {
		
		/*======================== Mensagem do Cenário =====================*/
		
		// criando contas
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 220, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 10, true);
		
		//inserindo contas a lista de contas 
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/*=================== Execução ==================*/
		gerContas.transfereValor(idConta01,  200, idConta02);
		
		/*=================== Verificações ==================*/
		assertThat(conta02.getSaldo(), is(210.0));
	}
}
