public class House {

    //Member Variables
    private String owner;
    private int value;

    //Default Constructor
    public House() {
    }

    //Constructor that takes values for all member variables as parameters.
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    //Deep Copy Constructor
    public House(House other) {
        this.owner = other.owner;
        this.value = other.value; //Primitive type will copy only the value not the address.
    }


    public House deepCopy() {
        House tempHouse = new House();
        tempHouse.value = this.value; //Primitive
        tempHouse.owner = this.owner; //Immutable
        return tempHouse;

    }

    //Setter & Getters
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        House tempHouse = (House) obj;
        return this.owner.equals(tempHouse.getOwner());
    }
}
