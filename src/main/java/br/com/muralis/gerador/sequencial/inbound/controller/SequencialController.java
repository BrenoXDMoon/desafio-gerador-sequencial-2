package br.com.muralis.gerador.sequencial.inbound.controller;

import br.com.muralis.gerador.sequencial.inbound.facade.SequencialFacade;
import br.com.muralis.gerador.sequencial.inbound.facade.dto.Sequencial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerador-sequencial/v1")
@Slf4j
public record SequencialController(SequencialFacade sequencialFacade) {

	/**
	 * <p>
	 * Esta API retornará um sequencial de forma direta, contendo apenas o valor
	 * correspondente a ele e ao serviço correspondente.</br>
	 * </br>
	 * Note que caso a sequencia requisitada não exista, ela <b>será criada</b> e caso a
	 * busca seja composta apenas por espaços, será retornado <b>406</b>.</br>
	 * </br>
	 * Se houver algum erro, ou valor inserido de forma que não seja possível processar a
	 * entrada, será retornado <b>422</b>. </br>
	 * </br>
	 * Por gentileza, sempre busque pelo nome que está presente na tabela do dynamo, esse
	 * serviço é case sensitive. </b> <b>Exemplo:</br>
	 * </br>
	 * <code>/gerador-sequencial/v1/{<i>SEQUENCIA_DESEJADA</i>}</code></br>
	 * </br>
	 * </p>
	 * @param sequencia Nome da sequencia a ser buscada.
	 * @return A sequencia e o valor correspondente aquela solicitação.
	 */
	@GetMapping("/{sequencia}")
	public ResponseEntity<Sequencial> obterSequencialDireto(@PathVariable String sequencia) {
		return ResponseEntity.ok(sequencialFacade.obterSequencial(sequencia));
	}

	/**
	 * <p><b>
	 * DESAFIO: implementar esta API com a funcionalidade similar ao GET /gerador-sequencial/v1/{sequencia} abaixo, com a
	 * diferença que o sequencial a ser retornado deve ser informado e único, ou seja, caso seja solicitado novamente,
	 * deve mostrar uma mensagem de erro "O sequencial X já foi recuperado anteriormente."
	 * </br></br>*** Esta API deverá seguir a mesma arquitetura da já implementada!</br>
	 * </b></p>
	 */
	@PostMapping("/challenge")
	public ResponseEntity obterSequencialInformado() {
		return ResponseEntity.ok().build();
	}

}
