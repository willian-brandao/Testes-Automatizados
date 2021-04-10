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
	
	@Test
	public void testTransfereValor() {
		
		/*======================== Mensagem do Cenário =====================*/
		
		// criando contas
		ContaCorrente conta01 = new ContaCorrente(1, 220, true);
		ContaCorrente conta02 = new ContaCorrente(2, 10, true);
		
		//inserindo contas a lista de contas 
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/*=================== Execução ==================*/
		gerContas.transfereValor(1,  200, 2);
		
		/*=================== Verificações ==================*/
		assertThat(conta02.getSaldo(), is(210.0));
	}
}
