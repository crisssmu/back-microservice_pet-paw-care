package cris.PawPetCare.microservicios.customers.DTO;

public class CustomerLogDTO {
    String email;
    String password;

    public CustomerLogDTO() {
    }

    public CustomerLogDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}


