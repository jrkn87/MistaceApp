package app.save;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveToFile {

    private final String line = "---------------------------------------------------------------------";

    private FileWriter file = new FileWriter("Mistake.doc", true);
    private PrintWriter printWriter;

    public SaveToFile() throws IOException {
    }

    public void saveFile(Record rec) {
        printWriter = new PrintWriter(file);

        printWriter.println(
                rec.getDate() + "\t"
                + (rec.getDocType().equals("BRAK") ? "Brak numeru dokumentu." : rec.getDocType() + " " + rec.getDocumentNr() + "/STO")
                + "\n\n\t" + "- Nazwa__:" + rec.getName().toUpperCase()
                + "\n\t" + "- Nick___:" + rec.getNick().toUpperCase()
                + "\n\t" + "- Kto____:" + rec.getWho().toUpperCase()
                + "\n\t" + "- Opis___:" + rec.getDescription().toUpperCase()
                + "\n\n" + line + "\n"
        );

        printWriter.close();
    }
}
