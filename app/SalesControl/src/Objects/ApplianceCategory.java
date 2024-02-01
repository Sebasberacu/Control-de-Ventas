package Objects;

import java.util.Objects;

public class ApplianceCategory {
    private String name;
    private String characteristics;
    private boolean state; // Active or Inactive

    // Constructor
    public ApplianceCategory(){
        this.name = "";
        this.characteristics = "";
        this.state = true;
    }
    
    public ApplianceCategory(String name, String characteristics) {
        this.name = name;
        this.characteristics = characteristics;
        this.state = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isActive() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ApplianceCategory other = (ApplianceCategory) obj;
        if (this.state != other.state) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.characteristics, other.characteristics);
    }
    
    
}

