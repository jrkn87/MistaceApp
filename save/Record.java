package app.save;

import java.time.LocalDate;

public class Record {
    private LocalDate date;
    private String docType, documentNr, name, nick, who, description;

    public Record(String docType, String documentNr, String name, String nick, String who, String description) {
        date = LocalDate.now();
        this.docType = docType;
        this.documentNr = documentNr;
        this.name = name;
        this.nick = nick;
        this.who = who;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocumentNr() {
        return documentNr;
    }

    public void setDocumentNr(String documentNr) {
        this.documentNr = documentNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
