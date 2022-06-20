package model;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MovieParse {
    public static String parse (String json) {
        Movie movie = new Movie();
        JsonElement element = JsonParser.parseString(json);
        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            movie.title = object.get("Title").getAsString();
            movie.director = object.get("Director").getAsString();
            movie.year = object.get("Year").getAsString();
            movie.plot = object.get("Plot").getAsString();
            movie.poster = object.get("Poster").getAsString();
            return movie.title + ";" + movie.director + ";" + movie.year + ";" + movie.plot + ";" + movie.poster;
        }
        return "Não foi possível obter as informações do filme.";
    }
}