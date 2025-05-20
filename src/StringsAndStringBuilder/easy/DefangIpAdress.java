package StringsAndStringBuilder.easy;

public class DefangIpAdress {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
