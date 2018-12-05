package ochoa.alexander.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import ochoa.alexander.response.GenericoResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/test/error")
@Controller
public class ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<GenericoResponse> procesarError() throws Exception {
        GenericoResponse response = new GenericoResponse();
        response.setRespuesta(new ObjectMapper().readTree("{}"));
        response.setMensaje("Error de crendenciales");
        response.setCodigoOperacion(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        return new ResponseEntity<GenericoResponse>(response, HttpStatus.OK);
    }

}
