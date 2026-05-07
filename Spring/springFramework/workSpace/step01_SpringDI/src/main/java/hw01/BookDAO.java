package hw01;

public interface BookDAO {
	void save(EmailSender emailSender, MessageSender messageSender, BookDTO bookDTO, BookDTO bookDTO2);
}
