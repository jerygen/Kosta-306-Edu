
package kosta.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded //클래스위에 @Embeddable 선언된 객체만 가져도 사용할 수 있다. 
    private ContactInfo contactInfo;
    
    @ElementCollection
    @CollectionTable(name = "member_hobby", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "hobby")
    private List<String> hobbies = new ArrayList(); //회원 한 명이 여러 개의 취미를 가질 수 있음
    
    //주소
    @ElementCollection //테이블 생성되고 1 : 다 관계
    @CollectionTable(name = "member_address", joinColumns = @JoinColumn(name = "member_id"))
    private List<Address> addressHistory;
    
}
