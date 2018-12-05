package ochoa.alexander.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import ochoa.alexander.response.GenericoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean resultadoValidacion = validate(request.getHeader("origen"), request.getHeader("key"));

        if (resultadoValidacion) {
            return true;
        } else {
            response.sendRedirect("/test/error");
            return false;
        }

        //return super.preHandle(request, response, handler);
    }

    private boolean validate(final String id, final String ruc) {
        try {
            final StringBuilder uri = new StringBuilder();
            uri.append("http://localhost:8081/test/validator/").append(id).append("/").append(ruc);
            ObjectMapper objectMapper =  new ObjectMapper();
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri.toString(), String.class);
            GenericoResponse response = new GenericoResponse();
            response = objectMapper.readValue(result, GenericoResponse.class);

            if (response.getRespuesta() != null && ((boolean) response.getRespuesta())) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

}
