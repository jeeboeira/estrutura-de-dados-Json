import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo2 {
    public static void main(String[] args) {
        try {
            String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-2.json";

            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asJson();

            //Me diz se conseguiu resposta do servidor, faixa de 200 é bom
            //Faixa de 400 é ruim
            int code = response.getStatus();
            //Mostra os dados brutos
            JsonNode json = response.getBody();

            System.out.println(code);
            System.out.println(json);

            //Métodos para trabalhar com os dados
            JSONObject obj = json.getObject();
            JSONArray array = json.getArray();

            JSONArray nome = obj.getJSONArray("employees");

            System.out.println(nome);
            //Ele até puxa aqui, mas genérico, se eu quiser salvar em váriavel, preciso atribuir
            System.out.println(nome.get(1));
            String empregado0 = nome.getString(0);
            System.out.println(empregado0);

        } catch (UnirestException e) {

        }
    }
}
