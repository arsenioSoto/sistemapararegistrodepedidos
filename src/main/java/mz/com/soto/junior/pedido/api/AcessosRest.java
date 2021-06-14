package mz.com.soto.junior.pedido.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.com.soto.junior.pedido.interceptor.InterceptadorDeAcessos;
import mz.com.soto.junior.pedido.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessosRest {

	@GetMapping
	public List<Acesso> getAcessos() {
		return InterceptadorDeAcessos.acessos;
	}
}
