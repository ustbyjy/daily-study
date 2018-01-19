package com.ustbyjy.bean;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String school;
    private Date birthday;

    private Student(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        school = builder.school;
        birthday = builder.birthday;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private Integer age;
        private String school;
        private Date birthday;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder school(String val) {
            school = val;
            return this;
        }

        public Builder birthday(Date val) {
            birthday = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", school='").append(school).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
