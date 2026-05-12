package kosta.web.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final을 기반으로 자동 주입
@Getter
public class BasicException extends RuntimeException {
	private final ErrorInfo errorInfo;
}

