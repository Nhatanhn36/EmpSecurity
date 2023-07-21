package anhnnth.codelean.empsecurity.rest;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Integer id) {
        super("Không tìm thấy nhân viên có id: " + id);
    }
}