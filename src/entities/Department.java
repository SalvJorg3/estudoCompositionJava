package entities;

/* Criação da classe Departamento */
public class Department {
    
    private String name;

    /* Contrutor padrão (vazio) */
    public Department() {
    }
    
    /* Contrutor com argumentos  */

    public Department(String name) {
        this.name = name;
    }

    /*Getters e setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
