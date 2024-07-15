package kr.co.shortenurlservice.presentation;

import kr.co.shortenurlservice.domain.LackOfShortenUrlKeyException;
import kr.co.shortenurlservice.domain.NotFountShortenUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFountShortenUrlException.class)
    public ResponseEntity<String> handleNotFoundShortenUrlException(NotFountShortenUrlException ex) {
        return new ResponseEntity<>("단축 URL을 찾지 못했습니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LackOfShortenUrlKeyException.class)
    public ResponseEntity<String> handleLackOfShortenUrlKeyException(LackOfShortenUrlKeyException ex) {
        // 개발자에게 알려줄 수 있는 수단이 필요함
        return new ResponseEntity<>("단축 URL 자원이 부족합니다..", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
