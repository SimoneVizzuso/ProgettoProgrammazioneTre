package progettoprogrammazione.clients.clientThree.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailViewThree{
    private final StringProperty sender;
    private final StringProperty receiver;
    private final StringProperty cc;
    private final StringProperty ccn;
    private final StringProperty title;
    private final StringProperty body;
    private final ObjectProperty<LocalDate> date;
    private final LongProperty id;

    public MailViewThree(){
        this(null, null, null, null, null, null);
    }

    private MailViewThree(String sender, String receiver, String cc, String ccn, String title, String body){
        this.sender = new SimpleStringProperty(sender);
        this.receiver = new SimpleStringProperty(receiver);
        this.cc = new SimpleStringProperty(cc);
        this.ccn = new SimpleStringProperty(ccn);
        this.title = new SimpleStringProperty(title);
        this.body = new SimpleStringProperty(body);
        this.date = new SimpleObjectProperty<>(LocalDate.now());
        this.id = new SimpleLongProperty(System.currentTimeMillis());
    }

    // SENDER METHOD
    public String getSender() {
        return sender.get();
    }

    public void setSender(String sender) {
        this.sender.set(sender);
    }

    public StringProperty senderProperty() {
        return sender;
    }

    // RECEIVER METHOD
    public String getReceiver() {
        return receiver.get();
    }

    public void setReceiver(String receiver) {
        this.receiver.set(receiver);
    }

    public StringProperty receiverProperty() {
        return receiver;
    }

    // CC METHOD
    public String getCc() {
        return cc.get();
    }

    public void setCc(String cc) {
        this.cc.set(cc);
    }

    public StringProperty ccProperty() {
        return cc;
    }

    // CCN METHOD
    public String getCcn() {
        return ccn.get();
    }

    public void setCcn(String ccn) {
        this.ccn.set(ccn);
    }

    public StringProperty ccnProperty() {
        return ccn;
    }

    // TITLE METHOD
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    // BODY METHOD
    public String getBody() {
        return body.get();
    }

    public void setBody(String body) {
        this.body.set(body);
    }

    public StringProperty bodyProperty() {
        return body;
    }

    // ID METHOD
    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    // DATE METHOD
    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate d) {
        this.date.set(d);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    private List<String> convertToList(String users) {
        if (users == null) {
            return null;
        } else {
            return Arrays.asList(users.replace(" ", "").split(",", 0));
        }
    }

    private String convertToString(List<String> users){
        return String.join(",", users);
    }

    public String getAllReceiver(String user){
        List<String> list = new ArrayList<>();
        if (getReceiver() != null) { list.addAll(convertToList(getReceiver())); }
        if (getCc() != null) { list.addAll(convertToList(getCc())); }
        list.remove(user);
        return convertToString(list);
    }
}