package gov.cbp.air.config;

import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by ramchalasani on 3/30/17.
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @RequestMapping
    @ExceptionHandler({MissingServletRequestParameterException.class,
            UnsatisfiedServletRequestParameterException.class,
            HttpRequestMethodNotSupportedException.class,
            ServletRequestBindingException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Map<String, Object> handleRequestException(Exception ex) {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Request Error");
        map.put("cause", ex.getMessage());
        return map;
    }

    @RequestMapping
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleValidationException(ConstraintViolationException ex) throws IOException {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Validation Failure");
        map.put("violations", convertConstraintViolation(ex.getConstraintViolations()));
        return map;
    }

    @RequestMapping
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleValidationException(MethodArgumentNotValidException ex) throws IOException {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Validation Failure");
        map.put("violations", convertConstraintViolation(ex));
        return map;
    }


    @RequestMapping
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public @ResponseBody Map<String, Object> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex) throws IOException {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Unsupported Media Type");
        map.put("cause", ex.getLocalizedMessage());
        map.put("supported", ex.getSupportedMediaTypes());
        return map;
    }

    @RequestMapping
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody Map<String, Object> handleUncaughtException(Exception ex) throws IOException {
        Map<String, Object>  map = Maps.newHashMap();
        map.put("error", "Unknown Error");
        if (ex.getCause() != null) {
            map.put("cause", ex.getCause().getMessage());
        } else {
            map.put("cause", ex.getMessage());
        }
        return map;
    }

    private Map<String, Map<String, Object> > convertConstraintViolation(Set<ConstraintViolation<?>> constraintViolations) {
        Map<String, Map<String, Object> > result = Maps.newHashMap();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            Map<String, Object>  violationMap = Maps.newHashMap();
            violationMap.put("value", constraintViolation.getInvalidValue());
            violationMap.put("type", constraintViolation.getRootBeanClass());
            violationMap.put("message", constraintViolation.getMessage());
            result.put(constraintViolation.getPropertyPath().toString(), violationMap);
        }
        return result;
    }

    private Map<String, Map<String, Object> > convertConstraintViolation(MethodArgumentNotValidException ex) {
        Map<String, Map<String, Object> > result = Maps.newHashMap();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            Map<String, Object>  violationMap = Maps.newHashMap();
            //violationMap.put("target", ex.getBindingResult().getTarget());
            violationMap.put("type", ex.getBindingResult().getTarget().getClass());
            violationMap.put("message", error.getDefaultMessage());
            result.put(((FieldError) error).getField(), violationMap);
        }
        return result;
    }

}