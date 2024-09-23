
import java.io.Serializable;
import java.util.Date;

public class MessageChat implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String message;
	private Date date;
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getMessage() {
		return message;
	}
	void setMessage(String message) {
		this.message = message;
	}
	Date getDate() {
		return date;
	}
	void setDate(Date date) {
		this.date = date;
	}

}

