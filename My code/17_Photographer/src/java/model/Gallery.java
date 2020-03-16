/*
* Gallery.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * Gallery.<br>
 *
 * <pre>
 * Class mô tả đối tượng Gallery
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . GetId.
 * . SetId.
 * . getName.
 * . setName.
 * . getPictureCover.
 * . setPictureCover.
 * . getDescription.
 * . setDescription.
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class Gallery {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store name.
     */
    private String name;
    /**
     * Store pictureCover.
     */
    private String pictureCover;
    /**
     * Store description.
     */
    private String description;

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

    /**
     * get pictureCover <br>
     *
     * @return the pictureCover
     */
    public String getPictureCover() {
        return pictureCover;
    }

    /**
     * Set pictureCover.<br>
     *
     * @param pictureCover the pictureCover
     */
    public void setPictureCover(String pictureCover) {
        this.pictureCover = pictureCover;
    }

    /**
     * get description <br>
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.<br>
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
