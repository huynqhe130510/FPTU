/*
* Article.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

/**
 * Article.<br>
 *
 * <pre>
 * Class mô tả đối tượng Article
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . GetId.
 * . SetId.
 * . GetTitle.
 * . SetTile.
 * . GetImgLink.
 * . SetImgLink.
 * . GetContent.
 * . SetContent.
 * . GetFullContent.
 * . SetFullContent.
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class Article {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store title.
     */
    private String title;
    /**
     * Store imgLink.
     */
    private String imgLink;
    /**
     * Store content.
     */
    private String content;
    /**
     * Store fullContent.
     */
    private String fullContent;

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
     * get title <br>
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get title <br>
     *
     * @return the title
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * Set imgLink.<br>
     *
     * @param imgLink the imgLink
     */
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    /**
     * get content <br>
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content.<br>
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get fullContent <br>
     *
     * @return the fullContent
     */
    public String getFullContent() {
        return fullContent;
    }

    /**
     * Set id.<br>
     *
     * @param fullContent the fullContent
     */
    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }
}
