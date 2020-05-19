package com.yu.pojo;

public class Course {
    private Integer id;

    private String name;

    private String type;
    private Integer shenhe;
    
    //排课用
    private Teacher teacher;
    
    // 排课用
     private String classes;
     

    public Integer getShenhe() {
		return shenhe;
	}

	public void setShenhe(Integer shenhe) {
		this.shenhe = shenhe;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
    
    
    
}