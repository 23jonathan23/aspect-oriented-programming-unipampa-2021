import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.sales.online.games.salesonlinegames.Model.Support.Address;
import com.sales.online.games.salesonlinegames.Model.Support.Genders;
import com.sales.online.games.salesonlinegames.Model.Support.Platforms;

public class Customer{

    private UUID id;

    private String name;
    private String email;
    private String password;
    private LocalDate dob;
    private List<Platforms> platforms;
    private List<Genders> gendersPref;
    private Address address;

    public Customer(String name, String email, String password, LocalDate dob, Address address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Platforms> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(List<Platforms> platforms) {
        this.platforms = platforms;
    }

    public List<Genders> getGendersPref() {
        return this.gendersPref;
    }

    public void setGendersPref(List<Genders> gendersPref) {
        this.gendersPref = gendersPref;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean removePlatform(Platforms platform) {
        return platforms.remove(platform);
    }

    public boolean addPlatform(Platforms platform) {
        boolean contains = platforms.contains(platform);

        if (contains) {
            return false;
        }

        return platforms.remove(platform);
    }

    public boolean removeGenders(Genders gender) {
        return gendersPref.remove(gender);
    }

    public boolean addGenders(Genders gender) {
        boolean contains = gendersPref.contains(gender);

        if (contains) {
            return false;
        }

        return gendersPref.remove(gender);
    }



}