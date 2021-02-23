package com.matheusrabelo.mr;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheusrabelo.mr.Repositories.CategoriaRepository;
import com.matheusrabelo.mr.Repositories.CidadeRepository;
import com.matheusrabelo.mr.Repositories.ClienteRepository;
import com.matheusrabelo.mr.Repositories.EnderecoRepository;
import com.matheusrabelo.mr.Repositories.EstadoRepository;
import com.matheusrabelo.mr.Repositories.ProdutoRepository;
import com.matheusrabelo.mr.domain.Categoria;
import com.matheusrabelo.mr.domain.Cidade;
import com.matheusrabelo.mr.domain.Cliente;
import com.matheusrabelo.mr.domain.Endereco;
import com.matheusrabelo.mr.domain.Estado;
import com.matheusrabelo.mr.domain.Produto;
import com.matheusrabelo.mr.domain.enums.TipoCliente;

@SpringBootApplication
public class CursomrsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomrsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 100.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Santos", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria", "Maria@gmail.com", "098373727272", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("061991450778", "90639925857743"));

		Endereco e1 = new Endereco(null, "rua flores", "300", "apto 303", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida matos", "105", "sala 840", "centro", "3848438", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
