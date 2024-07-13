package com.oracle.pojo;


/*+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int(11)      | NO   | PRI | NULL    | auto_increment |
| title_name  | varchar(50)  | NO   |     | NULL    |                |
| description | varchar(200) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
*/
public class ProfessionalTitle {
    private Integer id;
    private String titleName;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfessionalTitle() {
    }

    public ProfessionalTitle(Integer id, String titleName, String description) {
        this.id = id;
        this.titleName = titleName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProfessionalTitle{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
