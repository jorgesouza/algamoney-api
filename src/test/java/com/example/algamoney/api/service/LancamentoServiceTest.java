package com.example.algamoney.api.service;

import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Endereco;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.TipoLancamento;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;

@RunWith(SpringRunner.class)
public class LancamentoServiceTest {

	@MockBean
	private PessoaRepository pessoaRepository;

	@MockBean
	private LancamentoRepository lancamentoRepository;
	
	private LancamentoService lancamentoService;
	
	private Lancamento lancamento;
	
	private Pessoa pessoa;

	@Before
	public void setUp() {
		lancamentoService = new LancamentoService();
		criarLancamento();
	}
	
	@Test
	public void salvarLancamentoSucesso() {
		lancamentoService.salvar(lancamento);
		
		// Verifica se o metodo do mock foi chamado
		verify(pessoaRepository).findById(lancamento.getPessoa().getCodigo());
		verify(lancamentoRepository).save(lancamento);
	}

	private void criarLancamento() {
		lancamento = new Lancamento();
		lancamento.setCategoria(criarCategoria());
		lancamento.setCodigo(1L); 
		lancamento.setDataPagamento(LocalDate.now());
		lancamento.setDataVencimento(LocalDate.now());
		lancamento.setDescricao("Lançamento de despesa de lazer");
		lancamento.setObservacao("Nenhuma observação");
		lancamento.setPessoa(criarPessoa());
		lancamento.setTipo(TipoLancamento.DESPESA);
		lancamento.setValor(new BigDecimal(100));
	}

	private Categoria criarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setCodigo(1L);
		categoria.setNome("Lazer");
		return categoria;
	}

	private Pessoa criarPessoa() {
		pessoa = new Pessoa();
		pessoa.setAtivo(true);
		pessoa.setNome("Jorge Souza");
		pessoa.setCodigo(1L);
		pessoa.setEndereco(criarEndereco());		
		return pessoa;
	}

	private Endereco criarEndereco() {
		Endereco endereco = new Endereco();
		endereco.setBairro("Vila Santa Isabel");
		endereco.setCep("00000-00");
		endereco.setCidade("Curitiba");
		endereco.setComplemento("B");
		endereco.setEstado("PR");
		endereco.setLogradouro("Rua das belezas");
		endereco.setNumero("13");
		return endereco;
	}
}