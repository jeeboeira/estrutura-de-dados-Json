import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo1 {
    public static void main(String[] args) {
        try {
            String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-1.json";

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

            String nome = obj.getString("employee_name");
            int idade = obj.getInt("age");
            String cidade = obj.getString("city");

            System.out.println(nome +" "+idade+" "+cidade);

        } catch (UnirestException e) {

        }
    }
}