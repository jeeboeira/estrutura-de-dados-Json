import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo3 {
    public static void main(String[] args) {
        try {
            String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-3.json";

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

            //Minha implementação
            System.out.println("Minha implementação");
            JSONArray employees = obj.getJSONArray("employees");
            System.out.println(employees.getJSONObject(1));
            System.out.println(employees.getJSONObject(1).getString("name"));
            System.out.println("Ex. Professor");
            //Ex. Professor

            JSONArray empregados = obj.getJSONArray("employees");
            for (int i = 0; i < empregados.length(); i++) {
                JSONObject empregado = empregados.getJSONObject(i);
                String nome = empregado.getString("name");
                int idade = empregado.getInt("age");
                String cidade = empregado.getString("city");
                System.out.println(nome +" "+idade+" "+cidade);
            }

        } catch (UnirestException e) {

        }
    }
}
