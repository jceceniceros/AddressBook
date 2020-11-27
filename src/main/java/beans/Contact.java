package beans;

import com.opencsv.bean.CsvBindByPosition;

public class Contact {
    @CsvBindByPosition(position = 0)
    private String phone;

    @CsvBindByPosition(position = 1)
    private String name;

    public Contact() {}

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Contact[")
                .append("phone=").append(phone)
                .append(", ")
                .append("name=").append(name)
                .append("]")
                .toString();
    }

}
