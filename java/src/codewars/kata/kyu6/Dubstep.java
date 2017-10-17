package codewars.kata.kyu6;

public class Dubstep {

    // https://www.codewars.com/kata/551dc350bf4e526099000ae5

    public static String SongDecoder(String song) {

        song = song.replace("WUB", " ");
        song = song.trim().replaceAll("\\s{2,}", " ");
        //trim: copy of the string, with leading and trailing whitespace omitted.
        return song;
    }
}
