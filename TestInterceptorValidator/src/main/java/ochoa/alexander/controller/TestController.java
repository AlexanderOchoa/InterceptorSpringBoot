package ochoa.alexander.controller;

import ochoa.alexander.response.GenericoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping(value = "validator/{id}/{ruc}", method = RequestMethod.GET)
    private ResponseEntity<GenericoResponse> testExposeMethod(@PathVariable(value = "id") String id,
                                                              @PathVariable(value = "ruc") String ruc) {
        System.out.print("in method, id: " + id);
        GenericoResponse response = new GenericoResponse();

        if (id.equals("1") && ruc.equals("123")) {
            response.setRespuesta(true);
            response.setMensaje("ok");
            response.setCodigoOperacion("200");
        } else {
            response.setRespuesta(false);
            response.setMensaje("error");
            response.setCodigoOperacion("500");
        }

        return new ResponseEntity<GenericoResponse>(response, HttpStatus.OK);
    }

}
