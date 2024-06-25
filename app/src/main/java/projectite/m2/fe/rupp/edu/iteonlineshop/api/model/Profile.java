package projectite.m2.fe.rupp.edu.iteonlineshop.api.model;

import com.google.gson.annotations.SerializedName;

public class Profile {


    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;

    @SerializedName("phone-number")
    private String phoneNumber;
    private String gender;
    @SerializedName("image-url")
    private String imageUrl;


    @SerializedName("birthday")
    private String birthDay;
    private String address;

    public Profile(String firstName, String lastName, String email, String phoneNumber, String gender, String imageUrl, String birthDay, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.imageUrl = imageUrl;
        this.birthDay = birthDay;
        this.address = address;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
