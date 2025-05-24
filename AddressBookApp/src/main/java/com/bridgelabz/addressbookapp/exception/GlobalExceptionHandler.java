import org.springframework.web.bind.MethodArgumentNotValidException;

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
    String errorMsg = ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .findFirst()
                        .orElse("Validation failed");

    ErrorResponse response = new ErrorResponse(
            LocalDateTime.now(),
            "Validation Error",
            errorMsg
    );
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
}
