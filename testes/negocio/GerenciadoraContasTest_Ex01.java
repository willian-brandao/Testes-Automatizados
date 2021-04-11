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
		ContaCorrente conta01 = new ContaCorrente(1, 220, true);
		ContaCorrente conta02 = new ContaCorrente(2, 10, true);
		
		//inserindo contas a lista de contas 
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/*=================== Execu��o ==================*/
		gerContas.transfereValor(1,  200, 2);
		
		/*=================== Verifica��es ==================*/
		assertThat(conta02.getSaldo(), is(110.0));
	}
}
