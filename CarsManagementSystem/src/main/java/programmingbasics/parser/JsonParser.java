package programmingbasics.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import programmingbasics.exception.MyException;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonParser<T> {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Class<T> type;

    public JsonParser(Class<T> type) {
        this.type = type;
    }

    public String toJson (T t,String jsonFileName){
        try(FileWriter writer = new FileWriter(jsonFileName)) {
            String json = gson.toJson(t);
            writer.write(json);
            return json;

        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }

    public T fromJson(String jsonFileName){
        try(FileReader reader = new FileReader(jsonFileName)) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }
}
