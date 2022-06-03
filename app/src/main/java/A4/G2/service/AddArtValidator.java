package A4.G2.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class AddArtValidator {
    public boolean validateArtInputs(String title, String descriptions, String artType, String dimensions, String artist, String image) {
        if (title.isEmpty() || descriptions.isEmpty() || artType.isEmpty() || dimensions.isEmpty() || artist.isEmpty() || image.isEmpty()) {
            return false;
        } else return Files.exists(Path.of("src/main/images/" + image));


    }

}
