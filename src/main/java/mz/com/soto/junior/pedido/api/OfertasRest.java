package mz.com.soto.junior.pedido.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.com.soto.junior.pedido.dto.RequisicaoNovaOferta;
import mz.com.soto.junior.pedido.model.Oferta;
import mz.com.soto.junior.pedido.model.Pedido;
import mz.com.soto.junior.pedido.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido);
		
		return nova;
	}
}
