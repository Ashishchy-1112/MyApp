package com.ashish.myapp.entity;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 255)
    private String email;

    @Column(nullable = true, length = 255)
    private String name;

    @Column(nullable = true, length = 255)
    private String password;

    @Column(nullable = true)
    private String phone;

	public String getPassword() {
		return password;
	
	}
	public void setPassword(String password)
	{
		password = this.password;
		
	}
    
    

}
