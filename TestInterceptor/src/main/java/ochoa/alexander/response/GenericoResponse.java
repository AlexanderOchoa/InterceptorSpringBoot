package ochoa.alexander.response;

public class GenericoResponse {

    private Object respuesta;
    private String mensaje;
    private String codigoOperacion;

    public Object getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    @Override
    public String toString() {
        return "GenericoResponse{" +
                "respuesta=" + respuesta +
                ", mensaje='" + mensaje + '\'' +
                ", codigoOperacion='" + codigoOperacion + '\'' +
                '}';
    }
}
