/*
* UserType.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * UserType.<br>
 *
 * <pre>
 * Class mô tả đối tượng UserType
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . getId.
 * . setId.
 * . getName
 * . setName
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class UserType {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store name.
     */
    private String name;

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
     * get name <br>
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.<br>
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
