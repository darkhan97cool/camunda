package com.example.springboot;

public class OktaUser {
    private String id;
    private String status;
    private String created;
    private String activated;
    private String statusChanged;
    private String lastLogin;
    private String lastUpdated;
    private String passwordChanged = null;
    Profile ProfileObject;
    Credentials CredentialsObject;
    _links _linksObject;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated() {
        return created;
    }

    public String getActivated() {
        return activated;
    }

    public String getStatusChanged() {
        return statusChanged;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getPasswordChanged() {
        return passwordChanged;
    }

    public Profile getProfile() {
        return ProfileObject;
    }

    public Credentials getCredentials() {
        return CredentialsObject;
    }

    public _links get_links() {
        return _linksObject;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public void setStatusChanged(String statusChanged) {
        this.statusChanged = statusChanged;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setPasswordChanged(String passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public void setProfile(Profile profileObject) {
        this.ProfileObject = profileObject;
    }

    public void setCredentials(Credentials credentialsObject) {
        this.CredentialsObject = credentialsObject;
    }

    public void set_links(_links _linksObject) {
        this._linksObject = _linksObject;
    }
}




class _links {
    Self SelfObject;


    // Getter Methods

    public Self getSelf() {
        return SelfObject;
    }

    // Setter Methods

    public void setSelf(Self selfObject) {
        this.SelfObject = selfObject;
    }
}
class Self {
    private String href;


    // Getter Methods

    public String getHref() {
        return href;
    }

    // Setter Methods

    public void setHref(String href) {
        this.href = href;
    }
}
class Credentials {
    Provider ProviderObject;


    // Getter Methods

    public Provider getProvider() {
        return ProviderObject;
    }

    // Setter Methods

    public void setProvider(Provider providerObject) {
        this.ProviderObject = providerObject;
    }
}
class Provider {
    private String type;
    private String name;


    // Getter Methods

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Profile {
    private String lastName;
    private String zipCode;
    private String manager;
    private String city;
    private String displayName;
    private String nickName;
    private String secondEmail = null;
    private String managerId;
    private String title;
    private String login;
    private String employeeNumber;
    private String division;
    private String firstName;
    private String primaryPhone;
    private String postalAddress;
    private String mobilePhone;
    private String middleName;
    private String state;
    private String department;
    private String email;


    // Getter Methods

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getManager() {
        return manager;
    }

    public String getCity() {
        return city;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogin() {
        return login;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getDivision() {
        return division;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getState() {
        return state;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    // Setter Methods

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}