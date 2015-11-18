package br.com.cadocruz.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class HelloSwaggerResource {

	private final AtomicLong counter = new AtomicLong();
	
	@ApiOperation(value="echo service", notes="Loren Ipsun dolor. Retorna a própria mensagem enviada para o serviço, como um echo.")
	@RequestMapping(path="/echo/{message}", method = RequestMethod.GET)
	public @ResponseBody ResponseMessages echo(@PathVariable final String message) {
		return new ResponseMessages(message, counter.incrementAndGet());
	}
}
