package zb.mall.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zb.mall.base.resp.R;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler({BindException.class})
    public R handleBindException(BindException e){
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return R.error(defaultMessage);
    }
}
