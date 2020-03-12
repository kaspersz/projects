package com.basicprogramming.parser;

import com.programmingbasics.exception.MyException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public abstract class JsonParser<T> {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private final String jsonFileName;

    public JsonParser(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public void toJson(final T element){
        try(FileWriter writer = new FileWriter(jsonFileName)) {
            if(element == null ){
                throw new MyException("Element is Null");
            }
            gson.toJson(element);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println("To JSON - JSON filename exception");
        }
    }

    public Optional<T> fromJson(){
        try(FileReader reader = new FileReader(jsonFileName)) {
            return Optional.of(gson.fromJson(reader, type));
        }
        catch (IOException e) {
            System.err.println("From JSON - JSON filename exception");
        }
        return Optional.empty();
    }
    /*public String toJson (T t, String jsonFileName){
        try(FileWriter writer = new FileWriter(jsonFileName)) {
            String json = gson.toJson(t);
            writer.write(json);
        return json;

        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }

    public T fromjson(String jsonFileName){
        try(FileReader reader = new FileReader(jsonFileName)) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }*/
}
