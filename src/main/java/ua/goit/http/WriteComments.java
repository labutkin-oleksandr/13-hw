package ua.goit.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteComments {
    private static final String PATCH_WRITE_FILE = "src/main/resources";

    public void writeComments(int userId, int postNumber, List<Comment> comments) {
        File newFile = new File(PATCH_WRITE_FILE, "user-" + userId + "-post-" + postNumber + "-comments.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder wroteCommentsFile = new StringBuilder();

        try(FileWriter writer = new FileWriter(newFile)) {
            for(Comment comment: comments) {
                String commentToJson = gson.toJson(comment);
                wroteCommentsFile.append(commentToJson + ",\n");
            }
            String json = wroteCommentsFile.toString().trim();
            writer.write(json.substring(0, json.length() - 1));
            writer.flush();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
