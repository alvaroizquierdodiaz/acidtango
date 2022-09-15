package acidtango.prueba.controller;

import acidtango.prueba.controller.handler.ControllerExceptionHandler;
import acidtango.prueba.dto.ProductOutputDto;
import acidtango.prueba.exception.EntityNotFoundException;
import acidtango.prueba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * @throws EntityNotFoundException this will be captured by
	 *                                 {@link ControllerExceptionHandler}
	 */
	@GetMapping
	public ResponseEntity<ProductOutputDto> findProducts(@PathParam(value = "actualDate") String actualDate,
																											 @PathParam(value = "productId") Long productId,
																											 @PathParam(value = "brandId") Integer brandId)
	        throws EntityNotFoundException {
		return ResponseEntity.ok(productService.findProducts(actualDate, productId, brandId));
	}

}
