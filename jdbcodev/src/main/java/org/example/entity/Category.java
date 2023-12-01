package org.example.entity;

public class Category extends BaseEntity {
    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                '}' + super.toString();
    }

    //Builder Class
    public static class CategoryBuilder {

        // required parameters
        private String name;

        // optional parameters


        public CategoryBuilder(String name) {
            this.name = name;

        }


        public Category build() {
            return new Category(this.name);
        }
    }
}
