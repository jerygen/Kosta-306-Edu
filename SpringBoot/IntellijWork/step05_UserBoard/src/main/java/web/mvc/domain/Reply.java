package web.mvc.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_rno_seq")
    @SequenceGenerator(name="reply_rno_seq" , allocationSize = 1 , sequenceName = "reply_rno_seq")
	private Long rno;//댓글번호
	
	private String content;//댓글내용
	
	@CreationTimestamp
	private LocalDateTime insertDate;
	
	@ManyToOne(fetch = FetchType.LAZY) //지연로딩!!
	@JoinColumn(name = "free_bno")
	private FreeBoard freeBoard;
	
	
	
}




