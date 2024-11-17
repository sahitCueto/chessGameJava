package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class PGNReader {
    public List<String> parsePGN(String filePath) throws IOException {
        List<String> moves = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("[") && !line.isBlank()) {
                    String[] tokens = line.split("\\s+");
                    for (String token : tokens) {
                        if (!token.matches("\\d+\\.")) {
                            moves.add(token);
                        }
                    }
                }
            }
        }
        return moves;
    }
}
