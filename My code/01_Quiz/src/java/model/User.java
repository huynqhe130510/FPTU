/*
* User.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * User.<br>
 *
 * <pre>
 * Class mô tả đối tượng User
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . getId.
 * . setId.
 * . getUsername
 * . setUsername
 * . getPassword
 * . setPassword
 * . getType
 * . setType
 * . getEmail
 * . setEmail
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class User {

    
    /**
     * Store id.
     */
    private int id;
    /**
     * Store username.
     */
    private String username;
    /**
     * Store password.
     */
    private String password;
    /**
     * Store type.
     */
    private UserType type;
    /**
     * Store email.
     */
    private String email;

    /**
     * get id <br>
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get username <br>
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username.<br>
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get password <br>
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password.<br>
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get type <br>
     *
     * @return the type
     */
    public UserType getType() {
        return type;
    }

    /**
     * Set type.<br>
     *
     * @param type the type
     */
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     * get email <br>
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email.<br>
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
