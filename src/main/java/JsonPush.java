import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonPush {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("nome", "Jesse de Oliveira Boeira");
        obj.put("nasc", "23/12/1991");
        obj.put("email", "jee_boeira@hotmail.com");
        obj.put("reside_farroupilha", false);
        obj.put("altura", 1.65);

        System.out.println(obj);
        JSONArray disciplinas = new JSONArray();
        disciplinas.put("Estruturas de Dados");
        disciplinas.put("Relações Humanas nas Organizações");
        disciplinas.put("Engenharia de Software I");
        disciplinas.put("Inglês III");
        disciplinas.put("Interação Humano Computador");
        disciplinas.put("Banco de Dados II");

        JSONObject cursoObj = new JSONObject();
        cursoObj.put("nome", "Análise e Desenvolvimento de Sistemas");
        cursoObj.put("inst", "IFRS Campus Farroupilha");
        cursoObj.put("ano_ingresso", 2023);
        cursoObj.put("disciplinas", disciplinas);


        System.out.println(disciplinas);
        obj.put("curso", cursoObj);


        String url = "https://ed-json-post-23762f735f6e.herokuapp.com/data";

        try {
            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .body(obj) //Objeto JSON com os dados a serem enviados à API
                    .asJson();

            System.out.println(response.getStatus());

        }
        catch(UnirestException e) {
            e.printStackTrace();
        }

    }
}