package prime.com.example.spring_rlukyanov.dto;

public class MessageDTO {
    private String message;
    private String sender;

    // Геттеры и сеттеры
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
