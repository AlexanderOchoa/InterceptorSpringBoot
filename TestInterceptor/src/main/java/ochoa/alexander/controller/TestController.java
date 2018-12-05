package ochoa.alexander.controller;

import ochoa.alexander.response.GenericoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping(value = "method/{id}", method = RequestMethod.GET)
    private ResponseEntity<GenericoResponse> testExposeMethod(@RequestHeader(value = "origen") String origen,
                                                    @RequestHeader(value = "key") String key,
                                                    @PathVariable(value = "id") String id) {
        System.out.print("in method, id: " + id);
        GenericoResponse response = new GenericoResponse();
        response.setMensaje("Success");
        response.setCodigoOperacion(HttpStatus.UNAUTHORIZED.toString());
        return new ResponseEntity<GenericoResponse>(response, HttpStatus.OK);
    }

}
