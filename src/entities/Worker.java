package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entitiesEnums.WorkerLevel;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    /*Associações com a classe Worker */
    private Department department;

    /* Trabalhador tem vários contratos
     representação da lista (composição de 
     objetos) */

     private List<HourContract> contracts = new ArrayList<>();

    

     /* Contrutor padrão */
     
    public Worker() {
    }
    
    /* Construtor com argumentos (sem a lista)*/

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    /* Getters e Setters */

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

     /* Métodos responsáveis por fazer ou desfazer a associação 
    de um trabalhador com um contrato */
    public List<HourContract> getContract() {
    return contracts;
    }
    
    public void addContract(HourContract contract) {
        contracts.add(contract);
     }

     public void removeContract(HourContract contract) {
        contracts.remove(contract);          
     }

     public double income(int year, int month) {
        double soma = baseSalary;
       
        Calendar cal = Calendar.getInstance();

        for(HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                soma += c.totalValue();
            }
        }
        return soma;
     }


}
