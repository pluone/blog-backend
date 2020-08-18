package xyz.peilu.vblog.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.peilu.vblog.common.Result;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Assert异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public Result handler(IllegalArgumentException illegalArgumentException) {
        return Result.fail(illegalArgumentException.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public Result handler(ShiroException e) {
        log.error("Shiro异常", e);
        return Result.fail(401, e.getMessage(), null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result handler(RuntimeException e) {
        log.error("服务器内部异常", e);
        return Result.fail(e.getMessage());
    }
}
