package sample08;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookDTO {
	private String subject;
	private String Writer;
	private int price;
	private String date;
}
