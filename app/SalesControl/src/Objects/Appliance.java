package Objects;

import java.util.Objects;

public class Appliance {
    private String description;
    private ApplianceCategory category;
    private Employee employeeInCharge;
    private Branch branch;
    private boolean state; // Active or Inactive

    // Constructor
    public Appliance() {}
    
    
    public Appliance(String description, ApplianceCategory category, Employee employeeInCharge, Branch branch) {
        this.description = description;
        this.category = category;
        this.employeeInCharge = employeeInCharge;
        this.branch = branch;
        this.state = true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplianceCategory getCategory() {
        return category;
    }

    public void setCategory(ApplianceCategory category) {
        this.category = category;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public boolean isActive() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appliance other = (Appliance) obj;
        if (this.state != other.state) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.employeeInCharge, other.employeeInCharge)) {
            return false;
        }
        return Objects.equals(this.branch, other.branch);
    }
    
    
    
    
}

