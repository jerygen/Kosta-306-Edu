package sample07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class BoardDTO {
	@Value("100")
	private int no;
	@Value("Spring")
	private String subject;
	@Value("하루 끝!")
	private String content;
}
